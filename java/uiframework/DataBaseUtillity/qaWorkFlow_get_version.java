package uiframework.DataBaseUtillity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

import static uiframework.DataBaseUtillity.DBConnection.connect;


public class qaWorkFlow_get_version {

    static DBConnection dbConnect;
    public static int version;
    public static String description;
    public static String status;
    public static Date initiateDate;
    public static Timestamp initiateToDate;
    public static ResultSet rs;
    public static Statement st;

//        public static void main(String[] args) {
//            getVersion("1002","T002");
//    }

    public static int getVersion(String corpid, String tenentID) {
        dbConnect = new DBConnection();
        try {

            st = connect.createStatement();
            // execute the quesry on database
            String AppName = "1002";
            String varName = "T002";
            rs = st.executeQuery("SELECT version FROM autoworkflowmanagement.apz_db_workflow_master_b WHERE corporate_id = '" + corpid + "' AND tenant_id='" + tenentID + "' ");
            System.out.println("Data retrieved from the PostgreSQL database ");

            System.out.println("------------------------------------------------------------------------");
            while (rs.next()) {
                version = rs.getInt("version");
                System.out.println("user created timestamp: " + rs.getInt("version"));

            }
            System.out.println("------------------------------------------------------------------------");
            System.out.println(version);
            st.close();
            connect.close();
            Thread.sleep(2);

        } catch (SQLException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return version;

    }
    public static String getDescription(String corpid, String tenentID) {
        dbConnect = new DBConnection();
        try {

            st = connect.createStatement();
            // execute the quesry on database
            String AppName = "1002";
            String varName = "T002";
            rs = st.executeQuery("SELECT description FROM autoworkflowmanagement.apz_db_workflow_master_b WHERE corporate_id = '" + corpid + "' AND tenant_id='" + tenentID + "' ");
            System.out.println("Data retrieved from the PostgreSQL database ");

            System.out.println("------------------------------------------------------------------------");
            while (rs.next()) {
                description = rs.getString("description");
                System.out.println("user created timestamp: " + rs.getString("description"));

            }
            System.out.println("------------------------------------------------------------------------");
            System.out.println(description);
            st.close();
            connect.close();
            Thread.sleep(2);

        } catch (SQLException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return description;

    }

    public static String get_Status(String corpid, String tenentID) {
        dbConnect = new DBConnection();
        try {

            st = connect.createStatement();
            // execute the quesry on database
            String AppName = "1002";
            String varName = "T002";
            rs = st.executeQuery("SELECT status FROM autoworkflowmanagement.apz_db_workflow_master_b WHERE corporate_id = '" + corpid + "' AND tenant_id='" + tenentID + "' ");
            System.out.println("Data retrieved from the PostgreSQL database ");

            System.out.println("------------------------------------------------------------------------");
            while (rs.next()) {
                status = rs.getString("status");
                System.out.println("user created timestamp: " + rs.getString("status"));

            }
            System.out.println("------------------------------------------------------------------------");
            System.out.println(status);
            st.close();
            connect.close();
            Thread.sleep(2);

        } catch (SQLException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return status;

    }

    public static Date get_fromdate(String corpid, String tenentID) {
        dbConnect = new DBConnection();
        try {

            st = connect.createStatement();
            // execute the quesry on database
            String AppName = "1002";
            String varName = "T002";
            rs = st.executeQuery("SELECT init_txn_dt FROM autoworkflowmanagement.apz_db_workflow_master_b WHERE corporate_id = '" + corpid + "' AND tenant_id='" + tenentID + "' ");
            System.out.println("Data retrieved from the PostgreSQL database ");

            System.out.println("------------------------------------------------------------------------");
            while (rs.next()) {
                initiateDate = rs.getDate("init_txn_dt");
                System.out.println("user created timestamp: " + rs.getDate("init_txn_dt"));

            }
            System.out.println("------------------------------------------------------------------------");
            System.out.println(initiateDate);
            st.close();
            connect.close();
            Thread.sleep(2);

        } catch (SQLException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return initiateDate;
    }
    public static Timestamp get_InitiatedTodate(String corpid, String tenentID) {
        dbConnect = new DBConnection();
        try {

            st = connect.createStatement();
            // execute the quesry on database
            String AppName = "1002";
            String varName = "T002";
            rs = st.executeQuery("SELECT init_txn_ts FROM autoworkflowmanagement.apz_db_workflow_master_b WHERE corporate_id = '" + corpid + "' AND tenant_id='" + tenentID + "' ");
            System.out.println("Data retrieved from the PostgreSQL database ");

            System.out.println("------------------------------------------------------------------------");
            while (rs.next()) {
                initiateToDate = rs.getTimestamp("init_txn_ts");
                System.out.println("user created timestamp: " + rs.getTimestamp("init_txn_ts"));

            }
            System.out.println("------------------------------------------------------------------------");
            System.out.println(initiateToDate);
            st.close();
            connect.close();
            Thread.sleep(2);

        } catch (SQLException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return initiateToDate;
    }
    public static Timestamp get_AuthorizeTodate(String corpid, String tenentID) {
        dbConnect = new DBConnection();
        try {

            st = connect.createStatement();
            // execute the quesry on database
            String AppName = "1002";
            String varName = "T002";
            rs = st.executeQuery("SELECT init_txn_ts FROM autoworkflowmanagement.apz_db_workflow_master_b WHERE corporate_id = '" + corpid + "' AND tenant_id='" + tenentID + "' ");
            System.out.println("Data retrieved from the PostgreSQL database ");

            System.out.println("------------------------------------------------------------------------");
            while (rs.next()) {
                initiateToDate = rs.getTimestamp("init_txn_ts");
                System.out.println("user created timestamp: " + rs.getTimestamp("init_txn_ts"));

            }
            System.out.println("------------------------------------------------------------------------");
            System.out.println(initiateToDate);
            st.close();
            connect.close();
            Thread.sleep(2);

        } catch (SQLException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return initiateToDate;
    }

    public static Date get_Authdate(String corpid, String tenentID) {
        dbConnect = new DBConnection();
        try {

            st = connect.createStatement();
            // execute the quesry on database
            String AppName = "1002";
            String varName = "T002";
            rs = st.executeQuery("SELECT init_txn_dt FROM autoworkflowmanagement.apz_db_workflow_master_b WHERE corporate_id = '" + corpid + "' AND tenant_id='" + tenentID + "' ");
            System.out.println("Data retrieved from the PostgreSQL database ");

            System.out.println("------------------------------------------------------------------------");
            while (rs.next()) {
                initiateDate = rs.getDate("init_txn_dt");
                System.out.println("user created timestamp: " + rs.getDate("init_txn_dt"));

            }
            System.out.println("------------------------------------------------------------------------");
            System.out.println(initiateDate);
            st.close();
            connect.close();
            Thread.sleep(2);

        } catch (SQLException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return initiateDate;
    }



}
