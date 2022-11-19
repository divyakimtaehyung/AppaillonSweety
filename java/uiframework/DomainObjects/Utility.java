package uiframework.DomainObjects;


import com.iexceed.uiframework.core.TestBase;
import com.iexceed.uiframework.implementations.CommonElements;
import com.iexceed.uiframework.implementations.DropdownControls;
import com.iexceed.uiframework.implementations.JavaScriptControls;
import com.iexceed.uiframework.implementations.TextBoxControls;
import com.iexceed.uiframework.utilites.WaitUtility;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Utility extends TestBase {

    WebDriver localDriver = TestBase.getDriver();

    RandomGeneratorUtility rg = new RandomGeneratorUtility();
    private static Logger log = LogManager.getLogger(Utility.class);
    TextBoxControls textBoxControls;
    CommonElements commonElements;
    JavaScriptControls javaScriptControls;
    WaitUtility waitUtility;
    DropdownControls dropdownControls;

    @FindBy(className = "ajs-content")
    WebElement popMessage;
    @FindBy(className = "ajs-button")
    WebElement popOk;

    @FindBy(xpath = "//*[@name='Allow Once']")
    WebElement allowPermission;


    public Utility() {
        PageFactory.initElements(localDriver, this);
        textBoxControls = new TextBoxControls();
        commonElements = new CommonElements();
        javaScriptControls = new JavaScriptControls(localDriver);
        waitUtility = new WaitUtility();
        dropdownControls = new DropdownControls();
    }

    public Boolean waitForElement(WebElement element) {
        waitUtility.waitTillElementVisible(localDriver, element, 100);
        return null;
    }

    public void sendKeys(WebElement element, String value) throws Exception {
        textBoxControls.clearText(element);
        textBoxControls.setText(element, value);
    }

    public void clearText(WebElement element) throws Exception {
        textBoxControls.clearText(element);
    }


    public void click(WebElement element) throws Exception {
        try {
            commonElements.click(element);
        } catch (Exception e) {
            javaScriptControls.executeJavaScript("arguments[0].scrollIntoView();", element);
            javaScriptControls.executeJavaScript("arguments[0].click();", element);
        }
    }

    public void listSelection(WebElement element, List<WebElement> webElementList, String value) throws Exception {
        javaScriptControls.executeJavaScript("arguments[0].scrollIntoView();", element);
        waitUtility.waitTillElementBecomeClickable(localDriver, element, 30);
        click(element);
        selectFromDropDown(webElementList, value);
    }

    public void selectFromDropDown(List<WebElement> elementList, String value) throws Exception {
        waitForFirstElement(elementList);
        for (WebElement elm : elementList) {
            System.out.println(elm.getText() + " = " + value);
            if (elm.getText().equals(value)) {
                click(elm);
                break;
            }
        }
    }

    public void listSelectionByData(WebElement element, List<WebElement> webElementList, String value) throws Exception {
        javaScriptControls.executeJavaScript("arguments[0].scrollIntoView();", element);
        waitUtility.waitTillElementBecomeClickable(localDriver, element, 30);
        click(element);
        selectFromDropDownByData(webElementList, value);
    }

    public void selectFromDropDownByData(List<WebElement> elementList, String value) throws Exception {
        waitForFirstElement(elementList);
        for (WebElement elm : elementList) {
            System.out.println(elm.getAttribute("data-value") + " = " + value);
            if (elm.getAttribute("data-value").equals(value)) {
                click(elm);
                break;
            }
        }
    }

    public void checkListContains(List<WebElement> elementList, String value) {
        boolean flag = true;
        for (WebElement elm : elementList) {
            System.out.println(elm.getText() + " = " + value);
            if (elm.getText().equals(value)) {
                flag = false;
                break;
            }
        }
        if (flag)
            Assert.fail("List value is not found");
    }

    public boolean verifyListContains(List<WebElement> elementList, String value) {
        boolean flag = false;
        for (WebElement elm : elementList) {
            System.out.println(elm.getText() + " = " + value);
            if (elm.getText().equals(value)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public void assertMessage(WebElement element, String message) {
        waitForElement(element);
        System.out.println(element.getText() + " = " + message);
        Assert.assertEquals(element.getText().trim(), message);
    }

    public void assertClassName(WebElement element, String cssValue) {
        waitForElement(element);
        System.out.println(element.getAttribute("class"));
        Assert.assertTrue(element.getAttribute("class").contains(cssValue));
    }

    public void selectTagSelection(WebElement entityName, String value) throws Exception {
        dropdownControls.selectViaVisibleText(entityName, value);
    }

    public void waitForSeconds(int i) throws Exception {
        waitUtility.waitForSeconds(i);
    }

    public void multiSelection(WebElement element, List<WebElement> elementList, String value) throws Exception {
        javaScriptControls.executeJavaScript("arguments[0].scrollIntoView();", element);
        click(element);
        String[] valueArray = value.split(",");
        for (String val : valueArray) {
            selectFromDropDown(elementList, val.trim());
        }
    }

    public void waitForFirstElement(List<WebElement> listELm) throws Exception {
        int i = 0;
        while (!(listELm.size() >= 1)) {
            waitUtility.waitForSeconds(1);
            if (i == 60) {
                Assert.fail("Drop down not found");
                break;
            }
            i++;
        }
    }


    public void waitForFirstElementPro(List<WebElement> listELm) throws Exception {
        int i = 0;
        while (!(listELm.get(0).getText().length() >= 1)) {
            waitUtility.waitForSeconds(1);
            if (i == 60) {
                Assert.fail("Drop down not found");
                break;
            }
            i++;
        }
    }

    public void verifyListContainsAllValues(WebElement element, List<WebElement> elementList, List<Map<String, String>> allListValues) throws Exception {
        javaScriptControls.executeJavaScript("arguments[0].scrollIntoView();", element);
        waitUtility.waitTillElementBecomeClickable(localDriver, element, 30);
        click(element);
        System.out.println("Access List " + elementList.size());
        for (Map<String, String> dataList : allListValues) {
            checkListContains(elementList, dataList.get("ApplicationName").trim());
        }
    }

    public void validateSuccessMessageBox(String message) throws Exception {
        waitForElement(popMessage);
        System.out.println(popMessage.getText() + " = " + message);
        assertClassName(popMessage, "success");
        assertMessage(popMessage, message);
        click(popOk);
    }

    public void validateErrorMessageBox(String message) throws Exception {
        waitForElement(popMessage);
        assertClassName(popMessage, "error");
        System.out.println(popMessage.getText() + " = " + message);
        assertMessage(popMessage, message);
        click(popOk);
    }


    public boolean checkSameTextEnteredPresent(WebElement element, String text) {
//        System.out.println(element.getAttribute("value").trim()+"="+text);
        return element.getText().trim().equals(text);
    }


    public void waitForTextVisible(WebElement element) throws Exception {
        int i = 50;
        while (element.getText().isEmpty() && i != 0) {
            waitForSeconds(1);
            i--;
        }
    }

    public String randomString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

//        System.out.println(generatedString);
        return generatedString;
    }


    public void selectionItemVisible(String itemType, List<WebElement> type) throws Exception {
        String stringmsg = null;
        for (WebElement name : type) {
            if (name.isDisplayed()) {
                if ((name.getText()).contains(itemType)) {
                    System.out.println(name.isDisplayed());
                    stringmsg = String.format(" %s", itemType);
                    System.out.println("User details is visible" + stringmsg);
                    break;
                }
            } else {
                log.debug("User details is not visible {}", stringmsg);

            }
        }
    }

    public void waitForElementTextVisible(WebElement element, String text) throws Exception {
        int i = 50;
        while (!(element.getText().equals(text))) {
            waitForSeconds(1);
            i--;
        }
    }

    public void acceptPermissionMessage() {
        try {
//            screenshot(" alert");
            click(allowPermission);
            System.out.println("Alert message clicked");
        }catch (Exception e){
            System.out.println("Alert message not found ");
        }
    }

    public void screenshot(String name) throws IOException {
        File srcFile=((AppiumDriver)localDriver).getScreenshotAs(OutputType.FILE);
        String filename = rg.getTimeStamp() + name;
        File targetFile=new File(System.getProperty("user.dir")+"/screenshot/" + filename +".jpg");
        FileUtils.copyFile(srcFile,targetFile);
    }
}
