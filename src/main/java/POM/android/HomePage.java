package POM.android;

import basePackage.BaseObject;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseObject {

    public HomePage(AndroidDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Tutup']")
    private WebElement popUpBtn;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
    private WebElement bannerBtn;

    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
    private WebElement rumahTanggaBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Lihat Semua Rumah Tangga']")
    private WebElement lihatSemuaRumahTanggaBtn;


    public void closePopUpBtn(){
        waitUntilElementPresent(popUpBtn,5);
        popUpBtn.click();
    }

    public void closeBanner() {
        waitUntilElementPresent(bannerBtn,5);
        tapAtPosition(bannerBtn,1332,802);

    }

    public void klikButtonByCategoryName(String categoryName){
        if("rumah tangga".equalsIgnoreCase(categoryName)){
            rumahTanggaBtn.click();
        }
    }

    public void klikLihatSemuaButtonByCategoryName(String categoryName){
        WebElement lihatSemuaBtn=driver.findElement(By.xpath("//android.widget.TextView[@text='Lihat Semua "+categoryName+"']"));
        waitUntilElementPresent(lihatSemuaBtn,15);
        lihatSemuaBtn.click();
    }



}
