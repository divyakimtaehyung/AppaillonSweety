package uiframework.DataBaseUtillity;

import com.iexceed.uiframework.core.TestBase;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;


@Test

public class DBConnection extends TestBase {


    static Connection connect = null;

    public DBConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            connect = DriverManager.getConnection(props.getProperty("postGreURL"), props.getProperty("DBuserName"), props.getProperty("DBpassword"));
            System.out.println("Connection done successfully");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
