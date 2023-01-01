package POM.android;

import basePackage.BaseObject;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage extends BaseObject {

    public ProductDetailPage(AndroidDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='OK']")
    private WebElement popupOkBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Lanjut Ke Keranjang']")
    private WebElement lanjutKeKeranjangBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Tutup']")
    private WebElement popupTutupBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Tambah ke keranjang']")
    private WebElement tambahKeKeranjangBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Pilih']")
    private WebElement metodePengirimanPilihBtn;

    public void closePopUpBtn(){
        waitUntilElementPresent(popupTutupBtn,15);
        popupTutupBtn.click();
    }

    public void clickPopupOkBtn(){
        waitUntilElementPresent(popupOkBtn,15);
        popupOkBtn.click();
    }

    public void clickLanjutKeKeranjangBtn(){
        lanjutKeKeranjangBtn.click();
    }

    public void clickPopupTutupBtn(){
        popupTutupBtn.click();
    }

    public void clickTambahKeKeranjangBtn(){
        tambahKeKeranjangBtn.click();
    }

    public void clickMetodePengirimanPilihBtn(){
        waitUntilElementPresent(metodePengirimanPilihBtn,15);
        metodePengirimanPilihBtn.click();
    }
}
