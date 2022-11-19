package uiframework.DataBaseUtillity;



import java.sql.*;

import static uiframework.DataBaseUtillity.DBConnection.connect;



public class DB_get_payload {
    static String PayLoadData;
    public static String Password;
    //    static Connection connect = null;
    DBConnection dbConnect;

    public DB_get_payload(String emailId) {
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


}


