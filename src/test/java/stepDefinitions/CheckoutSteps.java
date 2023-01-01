package stepDefinitions;

import POM.android.*;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutSteps {

    private Hooks hooks;

    public CheckoutSteps(Hooks hooks) {
        this.hooks = hooks;
    }

    private HomePage homePage;

    private RumahTanggaCategoryPage rumahTanggaCategoryPage;

    private ProductDetailPage productDetailPage;

    private ProductCartPage productCartPage;

    private ProductCheckoutPage productCheckoutPage;

    @Given("user open aplikasi rupa rupa mobile")
    public void user_open_aplikasi_rupa_rupa_mobile() {
        homePage= new HomePage((AndroidDriver) hooks.getDriver());
        homePage.closePopUpBtn();
        homePage.closeBanner();

    }
    @When("the user tap on {string} category button")
    public void the_user_tap_on_category_button(String category) {
        homePage.klikButtonByCategoryName(category);

    }
    @When("the user tap on Lihat Semua {string} category button")
    public void the_user_tap_on_lihat_semua_category_button(String category) {
        homePage.klikLihatSemuaButtonByCategoryName(category);
    }
    @When("the user tap on Filter button")
    public void the_user_tap_on_filter_button() {
        rumahTanggaCategoryPage = new RumahTanggaCategoryPage((AndroidDriver) hooks.getDriver());
        rumahTanggaCategoryPage.clickFilterButton();
        rumahTanggaCategoryPage.waitUntilElementPresent(rumahTanggaCategoryPage.getFilterSaveBtn(),10);
    }
    @When("the user tap on Promo button")
    public void the_user_tap_on_promo_button() {
        rumahTanggaCategoryPage.scrollToText("Promo");
        rumahTanggaCategoryPage.clickLihatSemuaPromoButton();

    }
    @When("the user tap on {string} checkbox")
    public void the_user_tap_on_checkbox(String categoryName) {
        rumahTanggaCategoryPage.clickPromoCheckboxByCategory(categoryName);
    }
    @When("the user tap on Simpan button")
    public void the_user_tap_on_simpan_button() {
        rumahTanggaCategoryPage.clickPromoSaveButton();
    }
    @When("the user tap on Terapkan button")
    public void the_user_tap_on_terapkan_button() {
        rumahTanggaCategoryPage.clickFilterSaveButton();
        rumahTanggaCategoryPage.waitUntilElementPresent(rumahTanggaCategoryPage.getFilterIcon(),10);

    }
    @When("the user scroll down to products")
    public void the_user_scroll_down_to_products() {
        rumahTanggaCategoryPage.scrollToText("Buy 1 Get 1 ");

    }
    @When("the user tap on first product")
    public void the_user_tap_on_first_product() {
        rumahTanggaCategoryPage.clickProductByIndex(1);

    }
    @When("the user tap on tambah ke keranjang button")
    public void the_user_tap_on_tambah_ke_keranjang_button() {
        productDetailPage= new ProductDetailPage((AndroidDriver) hooks.getDriver());
        productDetailPage.clickPopupTutupBtn();
        productDetailPage.clickTambahKeKeranjangBtn();
        productDetailPage.clickMetodePengirimanPilihBtn();

    }
    @When("the user tap on lanjut ke keranjang button")
    public void the_user_tap_on_lanjut_ke_keranjang_button() {
        productDetailPage.clickLanjutKeKeranjangBtn();
        productCartPage= new ProductCartPage((AndroidDriver) hooks.getDriver());
        productCartPage.clickPopupOkBtn();
        productCartPage.clickLanjutKePembayaranBtn();
    }
    @When("the user tap on sign in section")
    public void the_user_tap_on_sign_in_section() {
        productCheckoutPage = new ProductCheckoutPage((AndroidDriver) hooks.getDriver());
        productCheckoutPage.waitUntilElementPresent(productCheckoutPage.getLoginBtn(),15);
    }
    @When("the user fill on random email and password in sign in form")
    public void the_user_fill_on_random_email_and_password_in_sign_in_form() {
        productCheckoutPage.setEmailTextField("test@gmail.com");
        productCheckoutPage.setPasswordTextField("password");
        productCheckoutPage.clickLoginBtn();
    }
    @Then("the login error message should be displayed")
    public void the_login_error_message_should_be_displayed() {
        productCheckoutPage.verifyLoginErrorMessage();
    }
}
