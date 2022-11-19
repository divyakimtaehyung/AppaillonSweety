package uiframework.DomainObjects.Mailinator;

import org.openqa.selenium.*;
import uiframework.DomainObjects.Utility;
import com.iexceed.uiframework.core.TestBase;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;


public class EmailVerification extends TestBase {

    WebDriver driver = TestBase.getDriver(); //
    public static String[] Password;
    public static StringBuffer OTP;
    @FindBy(xpath = "//input[@id='search']")
    WebElement searchField;
    @FindBy(xpath = "//button[@value='Search for public inbox for free']")
    WebElement searchGo;
    @FindBy(xpath = "//table[@class='table-striped jambo_table']/tbody/tr/td[2]")
    List<WebElement> senderList;
    @FindBy(xpath = "//a[@onclick='deleteEmail();']")
    WebElement deleteMail;
    @FindBy(xpath = "//td[contains(text(),'Generated OTP')]")
    WebElement otpMsg;
    @FindBy(xpath = "//td[contains(text(),'User Created Successfully')]")
    WebElement passWordMsg;
    @FindBy(xpath = "//div[@id='inbox_pane']")
    List<WebElement> otpMsgSubject;

    @FindBy(xpath = "//body")
    WebElement message;

    Utility utility;

    public EmailVerification() throws Exception {
        PageFactory.initElements(driver, this);
        utility = new Utility();
    }


    public StringBuffer readOTP(String receiver,String device) throws Exception {
        if (device.equalsIgnoreCase("Android") || device.equalsIgnoreCase("IOS")) {
            readOTPForAppium(receiver);
        }else {
            ((JavascriptExecutor) driver).executeScript("window.open()");
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            driver.get("https://www.mailinator.com/index.jsp");
            setMailID(receiver);
            Thread.sleep(10000);
            utility.click(otpMsg);
            driver.switchTo().frame("html_msg_body");
            waitForMessageDisplay();
            utility.waitForSeconds(3);
            String message = driver.findElement(By.xpath("html/body")).getText();
            System.out.println(message);
            String[] temp = message.split(" ");
            System.out.println(temp[4]);
            OTP = new StringBuffer(temp[4]);
            OTP.deleteCharAt(OTP.length() - 1);
            System.out.println(OTP);
            driver.switchTo().defaultContent();
            driver.switchTo().window(tabs.get(0));
        }
        return OTP;
    }

    public StringBuffer readOTPForAppium(String receiver) throws Exception {
        driver = TestBase.pcloudyInitialization("https://www.mailinator.com");
        System.out.println(receiver);
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(receiver);
        driver.findElement(By.xpath("//button[@value='Search for public inbox for free']")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//td[contains(text(),'Generated OTP')]")).click();
        Thread.sleep(1000);
        driver.switchTo().frame("html_msg_body");
        waitForMessageDisplay();
        Thread.sleep(3000);
        String message = driver.findElement(By.xpath("html/body")).getText();
        System.out.println(message);
        String[] temp = message.split(" ");
        System.out.println(temp[4]);
        OTP = new StringBuffer(temp[4]);
        OTP.deleteCharAt(OTP.length() - 1);
        System.out.println(OTP);
        driver.close();
        return OTP;
    }

    public String readPassWordforAppium(String receiver) throws Exception {
        driver = TestBase.pcloudyInitialization("https://www.mailinator.com");
        System.out.println(receiver);
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(receiver);
        driver.findElement(By.xpath("//button[@value='Search for public inbox for free']")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//td[contains(text(),'User Created Successfully')]")).click();
        driver.switchTo().frame("html_msg_body");
        waitForMessageDisplay();
        Thread.sleep(3000);
        String message = driver.findElement(By.xpath("html/body")).getText();
        System.out.println(message);
        String[] temp = message.split("password is");
        System.out.println(temp[1]);
        Password = temp[1].split(" ");
        System.out.println(Password[1]);
        driver.close();
        return Password[1];
    }


    public String readPassWord(String receiver, String device) throws Exception {
        if (device.equalsIgnoreCase("Android") || device.equalsIgnoreCase("IOS")) {
            readPassWordforAppium(receiver);
        } else {
            ((JavascriptExecutor) driver).executeScript("window.open()");
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            driver.get("https://www.mailinator.com/index.jsp");
            setMailID(receiver);
            Thread.sleep(4000);
            utility.click(passWordMsg);
            driver.switchTo().frame("html_msg_body");
            waitForMessageDisplay();
            utility.waitForSeconds(3);
            String message = driver.findElement(By.xpath("html/body")).getText();
            System.out.println(message);
            String[] temp = message.split("password is");
            System.out.println(temp[1]);
            Password = temp[1].split(" ");
            System.out.println(Password[1]);
            driver.switchTo().defaultContent();
            driver.switchTo().window(tabs.get(0));
        }
        return Password[1];
    }


    public void waitForMessageDisplay() throws Exception {
        for (int i = 0; i < 30; i++) {
            if (driver.findElement(By.xpath("html/body")).getText().length() > 10) {
                break;
            }
            utility.waitForSeconds(1);
        }
    }

    private void selectMail(String from) throws Exception {
        selectLastMail(senderList, from);
    }

    private void setMailID(String receiver) throws Exception {
        System.out.println(receiver);
        utility.sendKeys(searchField, receiver);
        utility.click(searchGo);
    }

    private void openUrl() throws Exception {
        TestBase.getDriver().get("https://www.mailinator.com");
        TestBase.getDriver().manage().deleteAllCookies();
        TestBase.getDriver().manage().window().maximize();
    }


    public void selectLastMail(List<WebElement> elementList, String value) throws Exception {
        WebElement target = null;
        utility.waitForFirstElement(elementList);
        for (WebElement elm : elementList) {
            System.out.println(elm.getText() + " = " + value);
            if (elm.getText().equals(value)) {
                target = elm;
                break;
            }
        }
        if (target != null) {
            utility.click(target);
        }
    }
}