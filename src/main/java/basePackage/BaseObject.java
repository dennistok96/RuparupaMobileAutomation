package basePackage;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseObject {
    protected AndroidDriver driver;

    public BaseObject(AndroidDriver driver){
        this.driver=driver;
    }

    public void tapAtPosition(WebElement element, int x, int y){
        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "x",x,
                "y",y
        ));
    }

    public void waitUntilElementPresent(WebElement element,int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilTextPresentInElement(WebElement element,int seconds,String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.textToBePresentInElement(element,text));
    }

    public void scrollToText(String text){
//        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))"));
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\""+text+"\"))"));


    }

    public void scrollGesture(WebElement element,String direction){
        ((JavascriptExecutor)driver).executeScript("mobile: scrollGesture",
                ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),
                        "direction",direction,
                        "percent",0.75));
    }





}
