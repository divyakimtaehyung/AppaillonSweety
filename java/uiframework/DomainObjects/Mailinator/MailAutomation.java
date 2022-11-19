package uiframework.DomainObjects.Mailinator;

import com.iexceed.uiframework.core.TestBase;
import com.iexceed.uiframework.utilites.Mailinator.MailAutomator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MailAutomation extends TestBase {

    WebDriver driver = TestBase.getDriver();


    MailAutomator mailAutomator;
    public MailAutomation(){
        PageFactory.initElements(driver,this);
        mailAutomator = new MailAutomator();
    }

    public static void main(String[] args) throws Exception {
        TestBase tn = new TestBase();
        TestBase.initialization("chrome");
        TestBase.getDriver().get("https://www.google.co.in/");
        MailAutomation gm = new MailAutomation();
        System.out.println(gm.readOTP("abc@mailinator.com"));
    }


    public StringBuffer readOTP(String receiver) throws Exception {
        String message = mailAutomator.getEmailBody(receiver,"Generated OTP");
        System.out.println(message);
        String[] temp= message.split(" ");
        System.out.println(temp[4]);
        StringBuffer OTP= new StringBuffer(temp[4]);
        OTP.deleteCharAt(OTP.length()-1);
        System.out.println(OTP);
        return OTP;
    }

    public String readPassWord(String receiver) throws Exception {
        String message = mailAutomator.getEmailBody(receiver,"User Created Successfully");
        System.out.println(message);
        String[] temp= message.split("password is");
        System.out.println(temp[1]);
        String[] Password = temp[1].split(" ");
        System.out.println(Password[1]);
        return Password[1];
    }


    public void verifyPasswordChangedMailReceived(String receiver) throws Exception {
        String message = mailAutomator.getEmailBody(receiver,"Password Changed Successfully.");
        System.out.println(message);
    }

    public void verifyPasswordChangedMailReceivedMobileAutomation(String receiver) throws Exception {
        String message = mailAutomator.getEmailBodyMobileAutomation(receiver,"Password Changed Successfully.");
        System.out.println(message);
    }

    public StringBuffer readOTPMobileAutomation(String receiver) throws Exception {
        String message = mailAutomator.getEmailBodyMobileAutomation(receiver,"Generated OTP");
        System.out.println(message);
        String[] temp= message.split(" ");
        System.out.println(temp[4]);
        StringBuffer OTP= new StringBuffer(temp[4]);
        OTP.deleteCharAt(OTP.length()-1);
        System.out.println(OTP);
        return OTP;
    }

    public String readPassWordMobileAutomation(String receiver) throws Exception {
        String message = mailAutomator.getEmailBodyMobileAutomation(receiver,"User Created Successfully");
        System.out.println(message);
        String[] temp= message.split("password is");
        System.out.println(temp[1]);
        String[] Password = temp[1].split(" ");
        System.out.println(Password[1]);
        return Password[1];
    }

}
