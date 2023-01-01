package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class Hooks {
    protected AndroidDriver driver;
    protected AppiumDriverLocalService service;

    protected Properties prop;

    private static final String  APP_PACKAGE="com.mobileappruparupa";

    private static final String  APP_ACTIVITY="com.mobileappruparupa.MainActivity";

    @Before
    public void setUp() throws IOException {
        configureAppium();
    }
    public void configureAppium() throws IOException {
        //AndroidDriver,IOSDriver
        //Appium code -> send to appium server -> automate mobile

        prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties");
        prop.load(fis);

        //invoke appium server (cmd : appium)
        service= new AppiumServiceBuilder().withAppiumJS(new File(prop.getProperty("npm.modules.path")))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        //start appium server
        service.start();

        UiAutomator2Options options= new UiAutomator2Options();
        //nama device di android studio
        options.setDeviceName("DennisEmulator");
        options.setAutoGrantPermissions(true);
        options.setAutoGrantPermissions(true);
        options.setNoReset(false);
        options.setFullReset(false);
        options.setAppActivity(APP_ACTIVITY);
        options.setAppPackage(APP_PACKAGE);
        options.setApp(System.getProperty("user.dir") + "\\src\\test\\java\\resources\\ruparupa.com_ Home & Furniture_3.5.1_apkcombo.com.apk");
        driver= new AndroidDriver(new URL(prop.getProperty("remote.url")),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @After
    public void tearDown() {
        //close app
        driver.quit();
        //stop appium server
        service.stop();
    }

    public WebDriver getDriver() {
        return driver;
    }

}
