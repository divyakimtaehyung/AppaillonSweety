package uiframework.DataBaseUtillity;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static uiframework.DataBaseUtillity.DBConnection.connect;

public class DB_update2FAFalse {

    public static ResultSet rs;
    static DBConnection dbConnect;
    public static String FactorStaus;

//    public static void main(String[] args) {
//        update2FA("bankadmn05082022105130@mailinator.com");
//    }


    public static void update2FA(String emailID) {

        String varName = emailID;

        dbConnect = new DBConnection();
        try {
            Statement st = connect.createStatement();
            // execute the quesry on database


            rs = st.executeQuery("SELECT is_2fa_enabled FROM apzautoonboard.tb_asmi_user_information WHERE user_id = '" + varName + "' ");
            System.out.println("Data retrieved from the PostgreSQL database ");
            System.out.println("------------------------------------------------------------------------");
            while (rs.next()) {
                FactorStaus = rs.getString("is_2fa_enabled");
                System.out.println("2FA status: " + rs.getString("is_2fa_enabled"));
            }

            String temp = String.valueOf(st.executeUpdate("UPDATE apzautoonboard.tb_asmi_user_information SET is_2fa_enabled ='N' WHERE user_id = '" + varName + "' "));
            rs = st.getGeneratedKeys();
            while (rs.next()) {
                System.out.println("2FA status: " + rs.getString("is_2fa_enabled"));
            }
            System.out.println("------------------------------------------------------------------------");
            st.close();
            connect.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
