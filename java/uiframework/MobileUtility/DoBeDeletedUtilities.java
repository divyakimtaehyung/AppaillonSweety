package uiframework.MobileUtility;


import com.iexceed.uiframework.core.TestBase;
import com.iexceed.uiframework.utilites.WaitUtility;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;

import static com.iexceed.uiframework.appium.PcloudyConnection.appiumDriver;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;

public class DoBeDeletedUtilities extends TestBase {

    private AndroidDriver aDriver;
    private IOSDriver iDriver;
    public static String platform;
    //IOS Keyboard
    public static By keyboardDone = By.xpath("//*[@label='Done']");

    private WaitUtility waitUtility;
    private List<WebElement> list;
    private String target;
    private TouchAction tc;
    private WebDriverWait wait;

    public DoBeDeletedUtilities(){
            if (platform.equalsIgnoreCase("ios")){
                iDriver = (IOSDriver) appiumDriver;
                tc = new TouchAction(iDriver);
            }else {
                aDriver = (AndroidDriver) appiumDriver;
                tc = new TouchAction(aDriver);
            }
            waitUtility = new WaitUtility();
    }
    public void sendKeys(WebElement elm , String text) throws InterruptedException {
        //waitForVisibility(elm);
        scrollToElement(elm);
        elm.sendKeys(text);
    }

    public void click(WebElement elm) throws InterruptedException {
        scrollToElement(elm);
        elm.click();
    }

    public void waitForClickable(WebElement targetElement,long time) {
        if (platform.equalsIgnoreCase("ios")){
            WebDriverWait wait = new WebDriverWait(iDriver, time);
            wait.until(ExpectedConditions.elementToBeClickable(targetElement));
        }else {
            WebDriverWait wait = new WebDriverWait(aDriver, time);
            wait.until(ExpectedConditions.elementToBeClickable(targetElement));
        }
    }

    public void waitForVisibility(WebElement targetElement,long time) {
        if (platform.equalsIgnoreCase("ios")){
            WebDriverWait wait = new WebDriverWait(iDriver, time);
            wait.until(ExpectedConditions.visibilityOf(targetElement));
        }else {
            try {
                WebDriverWait wait = new WebDriverWait(aDriver, time);
                wait.until(ExpectedConditions.visibilityOf(targetElement));
            }catch (Exception e){
                singleScroll();
                WebDriverWait wait = new WebDriverWait(aDriver, time);
                wait.until(ExpectedConditions.visibilityOf(targetElement));
            }
        }
    }

    public void waitForSeconds(int timeoutInSeconds) throws Exception {
        Thread.sleep((long)(timeoutInSeconds * 1000));
    }

    public  void scroll(String text) throws InterruptedException {
        if (platform.equalsIgnoreCase("ios")){
            hideKeyboard();
            RemoteWebElement element = (RemoteWebElement) iDriver.findElement(By.xpath("//*[@name='" + text + "']"));
            String elementID = element.getId();
            HashMap<String, String> scrollObject = new HashMap<String, String>();
            scrollObject.put("element", elementID);
            scrollObject.put("toVisible", "not an empty string");
            iDriver.executeScript("mobile:scroll", scrollObject);
            Thread.sleep(3000);
        }else {
            aDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))");
            Thread.sleep(2000);
        }
    }


    public void hideKeyboard()  {
        try {
            List<WebElement> done = iDriver.findElements(keyboardDone);
            done.get(0).click();
        }catch (Exception e){
        }
    }

    public void clickTAB() {
        if (platform.equalsIgnoreCase("ios")){
            hideKeyboard();
        }else {
            aDriver.pressKeyCode(AndroidKeyCode.KEYCODE_TAB);
        }
    }

    public void clickEnter() {
        if (platform.equalsIgnoreCase("ios")){
            hideKeyboard();
        }else {
            aDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
        }
    }

    public void waitForSelectedItem(WebElement elm) throws Exception {
        while (!elm.isSelected()){
            click(elm);
            System.out.println("Clicking Bene Tab ponga da deii");
            waitForSeconds(2);
        }
    }




    public boolean selectDropDown(List<WebElement> list, String key){
        for (WebElement target : list) {
            try {
                if (target.getText().contains(key)) {
                    target.click();
                    return true;
                }
            } catch (Exception e) {
            }
        }
        return false;
    }

    public void scrollToElementText(WebElement elm, String text){
        int scroll = 80;
        while (0 != scroll--) {
            try {
                elm.isDisplayed();
                System.out.println(" Screen "+elm.getText());
                if (!elm.getText().equals(text)){
                    throw new Exception("check");
                }
                break;
            } catch (Exception e) {
                tc.press(PointOption.point(50, 400)).waitAction(waitOptions(ofMillis(10))).moveTo(PointOption.point(50, 50)).perform();
            }
            System.out.println(" Found Text "+text);
        }
    }


    public void scrollToElement(WebElement elm) throws InterruptedException {
            int scroll = 30;
            while (0 != scroll--) {
                try {
                    elm.isDisplayed();
                    break;
                } catch (Exception e) {
                    tc.press(PointOption.point(50, 400)).waitAction(waitOptions(ofMillis(10))).moveTo(PointOption.point(50, 50)).perform();
                }
            }
    }

    public void singleScroll(){
            tc.press(PointOption.point(50, 600)).waitAction(waitOptions(ofMillis(10))).moveTo(PointOption.point(50, 50)).perform();
    }

    public void waitForVisibility(WebElement elm){
        waitUtility.waitTillElementVisible(appiumDriver,elm,30);
    }

    public void scrollUp() {
            tc.press(PointOption.point(50, 50)).waitAction(waitOptions(ofMillis(10))).moveTo(PointOption.point(50, 500)).perform();
    }


    public void tap(WebElement elm){
        System.out.println(elm.getLocation().x +" "+ elm.getLocation().y);
        tc.tap(PointOption.point(elm.getLocation().x,elm.getLocation().y)).perform();
    }

    public void submitText(WebElement elm) {
        elm.submit();
    }

    public void clickTab() {
        TouchAction t=new TouchAction(aDriver);
        t.tap(PointOption.point(50,50)).perform();
    }

    public String getText(WebElement element) throws InterruptedException {
        scrollToElement(element);
        return element.getText();
    }


    public void assertEquals(WebElement elm, String fromAcc) throws InterruptedException {
        scrollToElement(elm);
        Assert.assertEquals(elm.getText(),fromAcc);
    }

    public void assertEqualsText(String elm, String fromAcc) throws InterruptedException {
        Assert.assertEquals(elm,fromAcc);
    }
}
