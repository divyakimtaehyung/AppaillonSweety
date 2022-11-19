package uiframework.DataBaseUtillity;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static uiframework.DataBaseUtillity.DBConnection.connect;



public class DB_get_failedCount {
    public static int FailCount;
    public static int NofailCount;
    public static String Password;
    //    static Connection connect = null;
    static DBConnection dbConnect;

    public DB_get_failedCount(String emailId) {
        dbConnect = new DBConnection();

        try {
            Statement st = connect.createStatement();
            // execute the quesry on database
            String varName = emailId;
            ResultSet rs = st.executeQuery("SELECT fail_count FROM apzautoonboard.tb_asmi_user WHERE user_id = '" + varName + "' ");
            System.out.println("Data retrieved from the PostgreSQL database ");

            System.out.println("------------------------------------------------------------------------");
            while (rs.next()) {
                FailCount = rs.getInt("fail_count");
                System.out.println("failed user count "+rs.getString("fail_count"));
            }
            System.out.println("------------------------------------------------------------------------");

            st.close();
            connect.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }





}


