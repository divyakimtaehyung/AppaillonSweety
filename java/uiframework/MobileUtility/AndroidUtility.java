package uiframework.MobileUtility;


import com.iexceed.uiframework.implementations.CommonElements;

import com.iexceed.uiframework.implementations.TextBoxControls;
import com.iexceed.uiframework.utilites.WaitUtility;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Keys;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import uiframework.DomainObjects.RandomGeneratorUtility;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import static com.iexceed.uiframework.appium.PcloudyConnection.appiumDriver;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;


public class AndroidUtility {
    AndroidDriver driver;
    TextBoxControls textBoxControls;
    CommonElements commonElements;
    WaitUtility waitUtility;
    TouchAction touch;

    @FindBy(xpath = "//android.webkit.WebView/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View/android.view.View")
    WebElement popMessage;
    @FindBy(xpath = "//android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View/android.view.View[1]/android.widget.TextView")
    WebElement popMessage1;
    @FindBy(xpath = "//android.widget.TextView")
    List<WebElement> popMessage2;

    @FindBy(xpath = "//android.widget.Button[@text='OK']")
    WebElement popOk2;
    @FindBy(xpath = "//android.widget.Button[@text='Ok']")
    WebElement popOk1;

    RandomGeneratorUtility rg = new RandomGeneratorUtility();


    public AndroidUtility(){
        driver = (AndroidDriver) appiumDriver;
        PageFactory.initElements(driver, this);
        textBoxControls = new TextBoxControls();
        commonElements = new CommonElements();
        waitUtility = new WaitUtility();
        touch = new TouchAction(driver);
    }

    public void waitForElement(WebElement element){
        waitUtility.waitTillElementVisible(driver,element,100);
    }

    public void sendKeys(WebElement element, String value) throws Exception {
//        textBoxControls.clearText(element);
        textBoxControls.setText(element,value);
    }
    public void clearText(WebElement element) throws Exception {
        textBoxControls.clearText(element);
    }

    public void enterTab(WebElement element) throws Exception {
        element.sendKeys(Keys.ENTER);
    }

    public void click(WebElement element) throws Exception {
            scrollToElement(element);
            commonElements.click(element);
    }

    public void validateSuccessMessageBox(String message) throws Exception {
       try {
           waitForElement(popOk1);
           screenshot("message box");
           String actualMessage = getLastValueInDropDown(popMessage2);
           System.out.println(actualMessage + " = " + message);
           Assert.assertEquals(actualMessage.trim(), message);
           click(popOk1);
       }catch (Exception e){
           System.out.println("Second trail");
           screenshot("message box 2 ");
           String actualMessage = getLastValueInDropDown(popMessage2);
           System.out.println(actualMessage + " = " + message);
           Assert.assertEquals(actualMessage.trim(), message);;
           click(popOk2);
       }
    }

    public String getLastValueInDropDown(List<WebElement> elementList) throws Exception {
        waitForFirstElement(elementList);
        return elementList.get(elementList.size()-1).getText();
    }

    public void screenshot(String name) throws IOException {
        File srcFile=driver.getScreenshotAs(OutputType.FILE);
        String filename = rg.getTimeStamp() + name;
        File targetFile=new File(System.getProperty("user.dir")+"/screenshot/" + filename +".jpg");
        FileUtils.copyFile(srcFile,targetFile);
    }


    public  void scroll(String element) throws InterruptedException {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+element+"\").instance(0))");
        Thread.sleep(2000);
    }


    public void scrollToElement(WebElement element) throws InterruptedException {
        int scroll = 30;
        while (0 != scroll--) {
            try {
                element.isDisplayed();
                System.out.println("Element Visible");
                break;
            } catch (Exception e) {
                touch.press(PointOption.point(50, 400)).waitAction(waitOptions(ofMillis(10))).moveTo(PointOption.point(50, 50)).perform();
            }
        }
    }

    public void singleScroll(){
        touch.press(PointOption.point(50, 600)).waitAction(waitOptions(ofMillis(10))).moveTo(PointOption.point(50, 50)).perform();
    }

    public void listSelection(WebElement element, List<WebElement> webElementList, String value) throws Exception {
        scrollToElement(element);
//        waitUtility.waitTillElementBecomeClickable(appiumDriver,element,30);
        click(element);
        selectFromDropDown(webElementList,value);
    }

    public void selectFromDropDown(List<WebElement> elementList, String value) throws Exception {
        waitForFirstElement(elementList);
        for(WebElement elm : elementList){
            System.out.println(elm.getText()+" = "+value);
            if (elm.getText().equals(value)){
                click(elm);
                break;
            }
        }
    }

    public void waitForFirstElement(List<WebElement> listELm) throws Exception {
        int i = 0;
        while (!(listELm.size() >= 1)){
            waitUtility.waitForSeconds(1);
            if (i == 60) {
                Assert.fail("Drop down not found");
                break;
            }
            i++;
        }
    }

    public void assertMessage(WebElement element, String message) {
        waitForElement(element);
        System.out.println(element.getText() +" = " +message);
        Assert.assertEquals(element.getText().trim(),message);
    }

    public boolean checkSameTextEnteredPresent(WebElement element, String text) {
        return element.getText().trim().equals(text);
    }

    public void waitForTextVisible(WebElement element) throws Exception {
        int i = 50;
        while (element.getText().isEmpty() && i!=0) {
            waitForSeconds(1);
            i--;
        }
    }

    public void waitForSeconds(int i) throws Exception {
        waitUtility.waitForSeconds(i);
    }

    public void waitForElementTextVisible(WebElement element, String text) throws Exception {
        int i = 50;
        while (!(element.getText().equals(text))) {
            waitForSeconds(1);
            i--;
        }
    }

}
