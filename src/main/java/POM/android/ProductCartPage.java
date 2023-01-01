package POM.android;

import basePackage.BaseObject;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProductCartPage extends BaseObject {

    public ProductCartPage(AndroidDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='OK']")
    private WebElement popupOkBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Lanjut ke Pembayaran']")
    private WebElement lanjutKePembayaranBtn;

    public void clickLanjutKePembayaranBtn(){
        lanjutKePembayaranBtn.click();
    }

    public void clickPopupOkBtn(){
        popupOkBtn.click();
    }
}
