package POM.android;

import basePackage.BaseObject;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductCheckoutPage extends BaseObject {

    public ProductCheckoutPage(AndroidDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//android.view.View[@resource-id='emailValidation']/android.widget.EditText")
    private WebElement emailTextField;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']")
    private WebElement locationPopUp;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='submit-btn']")
    private WebElement loginBtn;

    @AndroidFindBy(xpath = "//android.view.View[@resource-id='login-error-alert']")
    private WebElement loginErrorMsg;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='user-password']")
    private WebElement passwordTextField;

    public WebElement getLoginBtn(){
        return loginBtn;
    }

    public void setEmailTextField(String email){
        emailTextField.sendKeys(email);
    }

    public void setPasswordTextField(String password){
        passwordTextField.sendKeys(password);
    }

    public void clickLoginBtn(){
        loginBtn.click();
    }

    public void verifyLoginErrorMessage(){
        waitUntilElementPresent(loginErrorMsg,15);
        Assert.assertEquals(loginErrorMsg.getText()," Alamat email atau nomor telepon dan password Anda salah");
    }
}
