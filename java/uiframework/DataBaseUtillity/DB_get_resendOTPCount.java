package uiframework.DataBaseUtillity;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static uiframework.DataBaseUtillity.DBConnection.connect;

public class DB_get_resendOTPCount {
    public static int NofailCount;
    public static ResultSet rs;
    static DBConnection dbConnect;
    
    public static int retriveCount(String app) {
        dbConnect = new DBConnection();
        try {
            Statement st = connect.createStatement();
            // execute the quesry on database

            rs = st.executeQuery("SELECT otp_resend_count FROM apzautoonboard.tb_asmi_security_parameters WHERE app_id ='" + app + "' ");
            System.out.println("Data retrieved from the PostgreSQL database ");

            System.out.println("------------------------------------------------------------------------");
            while (rs.next()) {
                NofailCount = rs.getInt("otp_resend_count");
                System.out.println("OTP resend count " + rs.getString("otp_resend_count"));
            }
            System.out.println("------------------------------------------------------------------------");
            st.close();
            connect.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return NofailCount;
    }

    public static void main(String[] args) {
//        retriveCount("bfpapp");
        retriveCount("cfpapp");
        System.out.println(NofailCount);
    }
}
