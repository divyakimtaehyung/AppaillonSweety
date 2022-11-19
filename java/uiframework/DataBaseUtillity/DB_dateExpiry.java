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



public class DB_dateExpiry {

    static DBConnection dbConnect;
    public static Timestamp pinChnageDate;
    public ResultSet rs;
    public ResultSet rs1;
    public static Statement st;
    public static int passwrd_frequency;
    String t1 = null;

    public DB_dateExpiry(String appName , String emailId) {
        dbConnect = new DBConnection();
        try {

            st = connect.createStatement();
            // execute the quesry on database
            String AppName="bfpapp";
            String varName = "laddu@gmail.com";
            rs = st.executeQuery("SELECT pin_change_ts FROM apzautoonboard.tb_asmi_user WHERE user_id = '" + emailId + "' ");
            System.out.println("Data retrieved from the PostgreSQL database ");

            System.out.println("------------------------------------------------------------------------");
            while (rs.next()) {
                pinChnageDate = rs.getTimestamp("pin_change_ts");
                System.out.println("user created timestamp: " + rs.getTimestamp("pin_change_ts"));
                t1 = rs.getString("pin_change_ts");
            }
            System.out.println("------------------------------------------------------------------------");


            //password_change_expired date retrieve from security tble

            rs = st.executeQuery("SELECT pass_change_freq FROM apzautoonboard.tb_asmi_security_parameters WHERE app_id ='" + appName + "' ");
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
            String expiredDate=newstring+" "+t2[1];
            System.out.println("Expired date value :"+expiredDate);

//            Timestamp datetime = new Timestamp(new Date().getTime());
            int temp = st.executeUpdate("UPDATE apzautoonboard.tb_asmi_user SET pin_change_ts ='" + expiredDate + "' WHERE user_id = '" + emailId + "' ");
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
