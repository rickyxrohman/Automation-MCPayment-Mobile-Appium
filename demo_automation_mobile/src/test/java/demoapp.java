import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import java.time.Duration;

import java.net.URL;
import java.net.MalformedURLException;

public class demoapp {

    public AppiumDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appPackage", "com.saucelabs.mydemoapp.android");
        caps.setCapability("appActivity", "com.saucelabs.mydemoapp.android.view.activities.SplashActivity");
        caps.setCapability("platformName", "android");
        caps.setCapability("noReset", "true");
        caps.setCapability("aautomationName", "UiAutomator2");
        driver = new AndroidDriver(new URL("http://localhost:4726/wd/hub"), caps);
    }


    @Test
    public void click_App_Button(){
        driver.findElement(MobileBy.id("productIV")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" + ".scrollIntoView(new UiSelector().text(\"Add to cart\"))"));
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        //choose item
        driver.findElement(MobileBy.AccessibilityId("Blue color")).click();
        driver.findElement(MobileBy.id("plusIV")).click();
        driver.findElement(MobileBy.id("cartBt")).click();
        driver.findElement(MobileBy.id("cartIV")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        //checkout
        driver.findElement(MobileBy.id("cartBt")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        //login
        driver.findElement(MobileBy.id("nameET")).sendKeys("admin",(Keys.ENTER));
        driver.findElement(MobileBy.id("passwordET")).sendKeys("admin");
        driver.hideKeyboard();
        driver.findElement(MobileBy.id("loginBtn")).click();

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

        //last check out
        driver.findElement(MobileBy.AccessibilityId("Completes the process of checkout")).click();
//        driver.findElement(MobileBy.id("paymenBtn")).click();
    }

}
