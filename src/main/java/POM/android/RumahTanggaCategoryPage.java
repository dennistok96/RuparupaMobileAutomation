package POM.android;

import basePackage.BaseObject;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class RumahTanggaCategoryPage extends BaseObject {

    public RumahTanggaCategoryPage(AndroidDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Filter']")
    private WebElement filterBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView[1]")
    private WebElement filterIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Terapkan']")
    private WebElement filterSaveBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Promo']")
    private WebElement lihatSemuaPromoBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[5]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView")
    private WebElement firstProduct;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Simpan']")
    private WebElement promoSaveBtn;

    @AndroidFindBy(xpath = "//android.widget.ScrollView")
    private WebElement scrollview;

    public WebElement getScrollViewFilter(){
        return scrollview;
    }

    public void clickFilterButton(){
        waitUntilElementPresent(filterBtn,15);
        filterBtn.click();
    }

    public WebElement getFilterSaveBtn(){
        return filterSaveBtn;
    }

    public void clickLihatSemuaPromoButton(){
        waitUntilTextPresentInElement(lihatSemuaPromoBtn,15,"Promo");
        lihatSemuaPromoBtn.click();
    }

    public void clickPromoCheckboxByCategory(String categoryName){
        WebElement element=driver.findElement(By.xpath("//android.widget.TextView[@text='"+categoryName+"']"));
        element.click();
    }

    public void clickPromoSaveButton(){
        promoSaveBtn.click();
    }

    public void clickFilterSaveButton(){
        waitUntilElementPresent(filterSaveBtn,15);
        filterSaveBtn.click();
    }

    public WebElement getFilterIcon(){
        return filterIcon;
    }

    public void clickProductByIndex(int index){
        if(index==1){
            firstProduct.click();
        }

    }
}
