package uiframework.DataBaseUtillity;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static uiframework.DataBaseUtillity.DBConnection.connect;


public class DB_get_RetriveCount {

    public static int NofailCount;
    public static ResultSet rs;
    static DBConnection dbConnect;

    public DB_get_RetriveCount() {
        retriveCount("bfpapp");
    }
    
    public static int retriveCount(String app) {
        dbConnect = new DBConnection();
        String temp = "bfpapp";
        try {
            Statement st = connect.createStatement();
            // execute the quesry on database

            rs = st.executeQuery("SELECT nooffailedcounts FROM apzautoonboard.tb_asmi_security_parameters WHERE app_id ='" + app + "' ");
            System.out.println("Data retrieved from the PostgreSQL database ");

            System.out.println("------------------------------------------------------------------------");
            while (rs.next()) {
                NofailCount = rs.getInt("nooffailedcounts");
                System.out.println("System default user count " + rs.getString("nooffailedcounts"));
            }
            System.out.println("------------------------------------------------------------------------");
            st.close();
            connect.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return NofailCount;


    }


}


