package uiframework.DataBaseUtillity;

import org.apache.commons.lang.time.DateUtils;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static uiframework.DataBaseUtillity.DBConnection.connect;

public class DB_Common_Utils {

    public static int NofailCount;
    public static ResultSet rs;
    static DBConnection dbConnect;
    static String PayLoadData;
    public static String Password;
    public static int FailCount;
    public static Timestamp pinChnageDate;
    public static ResultSet rs1;
    public static Statement st;
    public static int passwrd_frequency;
    public static String t1 = null;



    public DB_Common_Utils(){
        Get_retriveCount("bfpapp");
        Get_payload("div1@gmail.com");
        Get_failedCount("div1@gmail.com");
        Get_DateExpiry("div1@gmail.com");
    }



    
    public static int Get_retriveCount(String app) {
        dbConnect = new DBConnection();
//    String temp="bfpapp";
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



    
    public static void Get_payload(String emailId) {
        dbConnect = new DBConnection();


        try {
            Statement st = connect.createStatement();
            // execute the quesry on database
            String varName = emailId;
            ResultSet rs = st.executeQuery("SELECT payload FROM apzautoonboard.apztb_user_mail WHERE user_id = '" + varName + "' ");
            System.out.println("Data retrieved from the PostgreSQL database ");

            System.out.println("------------------------------------------------------------------------");
            while (rs.next()) {
                PayLoadData = rs.getString("payload");
                System.out.println(rs.getString("payload"));
            }
            System.out.println("------------------------------------------------------------------------");
            String[] splitString = PayLoadData.split("and password");

//            for (String s : splitString) {
//                System.out.println("spilled array:"+s);
//            }
            System.out.println("splliting password:" + splitString[1]);
            String temp = splitString[1];
            System.out.println("temp password" + temp);
            String[] temp1 = temp.split(" ");
            Password = temp1[1];
            System.out.println("System generated password is " + Password);


            rs.close();
            st.close();

            connect.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



    
    public static void Get_failedCount(String emailId) {
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
                System.out.println("failed user count " + rs.getString("fail_count"));
            }
            System.out.println("------------------------------------------------------------------------");

            st.close();
            connect.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    
    public static void Get_DateExpiry(String emailId) {
        dbConnect = new DBConnection();
        try {

            st = connect.createStatement();
            // execute the quesry on database
            String varName = emailId;
            rs = st.executeQuery("SELECT pin_change_ts FROM apzautoonboard.tb_asmi_user WHERE user_id = '" + varName + "' ");
            System.out.println("Data retrieved from the PostgreSQL database ");

            System.out.println("------------------------------------------------------------------------");
            while (rs.next()) {
                pinChnageDate = rs.getTimestamp("pin_change_ts");
                System.out.println("user created timestamp: " + rs.getTimestamp("pin_change_ts"));
                t1 = rs.getString("pin_change_ts");
            }
            System.out.println("------------------------------------------------------------------------");


            //password_change_expired date retrieve from security tble

            rs = st.executeQuery("SELECT pass_change_freq FROM apzautoonboard.tb_asmi_security_parameters WHERE app_id ='bfpapp' ");
            System.out.println("password change pin column retrieve from Database ");

            System.out.println("------------------------------------------------------------------------");
            while (rs.next()) {
                passwrd_frequency = rs.getInt("pass_change_freq");
                System.out.println("password change pin frequency : " + rs.getString("pass_change_freq"));

            }
            System.out.println("------------------------------------------------------------------------");


            String[] t2 = t1.split(" ");
            System.out.println("date value:" + t2[0]);
            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(t2[0]);
            Date dateBefore30Days = DateUtils.addDays(date1, -passwrd_frequency);
            System.out.println("subtracted date:" + dateBefore30Days);
            String newstring = new SimpleDateFormat("yyyy-MM-dd").format(dateBefore30Days);
            System.out.println(newstring);
            String expiredDate = newstring + " " + t2[1];
            System.out.println("Expired date value :" + expiredDate);

//            Timestamp datetime = new Timestamp(new Date().getTime());
            int temp = st.executeUpdate("UPDATE apzautoonboard.tb_asmi_user SET pin_change_ts ='" + expiredDate + "' WHERE user_id = '" + varName + "' ");
            rs1 = st.getGeneratedKeys();
            if (rs1 != null && rs1.next()) {
                System.out.println(rs.getLong(1));
            }

            st.close();
            connect.close();
            Thread.sleep(2);

        } catch (SQLException | ParseException | InterruptedException e) {
            System.out.println(e.getMessage());
        }


    }


}


