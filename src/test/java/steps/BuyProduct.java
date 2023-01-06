package steps;

import io.appium.java_client.MobileBy;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import tests.TestBase;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class BuyProduct extends TestBase {

    @Given("user select back pack items")
    public void userSelectBackPackItems() throws MalformedURLException {
        setUp();

        driver.findElement(MobileBy.id("productIV")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" + ".scrollIntoView(new UiSelector().text(\"Add to cart\"))"));
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    @Given("select two items back packs with blue colour")
    public void selectTwoItemsBackPacksWithBlueColour() {
        driver.findElement(MobileBy.AccessibilityId("Blue color")).click();
        driver.findElement(MobileBy.id("plusIV")).click();
        driver.findElement(MobileBy.id("cartBt")).click();
        driver.findElement(MobileBy.id("cartIV")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        driver.findElement(MobileBy.id("cartBt")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    @Given("user must be login before checkout")
    public void userMustBeLoginBeforeCheckout() {
        driver.findElement(MobileBy.id("nameET")).sendKeys("admin",(Keys.ENTER));
        driver.findElement(MobileBy.id("passwordET")).sendKeys("admin");
        driver.hideKeyboard();
        driver.findElement(MobileBy.id("loginBtn")).click();
    }

    @When("user input address and payment method")
    public void inputAddressAndPaymentMethod() {
        //address
        driver.findElement(MobileBy.id("fullNameET")).sendKeys("Ricky Rohman",(Keys.ENTER));
        driver.findElement(MobileBy.id("address1ET")).sendKeys("Kemang",(Keys.ENTER));
        driver.findElement(MobileBy.id("address2ET")).sendKeys("Street 1",(Keys.ENTER));
        driver.findElement(MobileBy.id("cityET")).sendKeys("Jakarta Selatan",(Keys.ENTER));
        driver.findElement(MobileBy.id("stateET")).sendKeys("DKI Jakarta",(Keys.ENTER));
        driver.findElement(MobileBy.id("zipET")).sendKeys("14045",(Keys.ENTER));
        driver.findElement(MobileBy.id("countryET")).sendKeys("Indonesia",(Keys.ENTER));
        driver.hideKeyboard();
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" + ".scrollIntoView(new UiSelector().text(\"To Payment\"))"));
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(MobileBy.AccessibilityId("Saves user info for checkout")).click();
//        driver.findElement(MobileBy.id("paymenBtn")).click();

        //payment
        driver.findElement(MobileBy.id("nameET")).sendKeys("Ricky Rohman",(Keys.ENTER));
        driver.findElement(MobileBy.id("cardNumberET")).sendKeys("1213425523212343",(Keys.ENTER));
        driver.findElement(MobileBy.id("expirationDateET")).sendKeys("11/12",(Keys.ENTER));
        driver.findElement(MobileBy.id("securityCodeET")).sendKeys("123",(Keys.ENTER));
        driver.hideKeyboard();
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).setMaxSearchSwipes(10)" +
                ".scrollIntoView(new UiSelector().text(\"My billing address is the same as my shipping address.\"))"));
//        driver.findElement(MobileBy.AccessibilityId("Saves payment info and launches screen to review checkout data")).click();
        driver.findElement(MobileBy.id("paymentBtn")).click();
    }

    @Then("user success buy product")
    public void userSuccessBuyProduct() {
        //last check out
        driver.findElement(MobileBy.AccessibilityId("Completes the process of checkout")).click();
//        driver.findElement(MobileBy.id("paymenBtn")).click();
    }
}
