package tests;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import java.net.MalformedURLException;
import java.net.URL;

public class TestBase extends AbstractTestNGCucumberTests {
    public static AppiumDriver driver;

    public static void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appPackage", "com.saucelabs.mydemoapp.android");
        caps.setCapability("appActivity", "com.saucelabs.mydemoapp.android.view.activities.SplashActivity");
        caps.setCapability("platformName", "android");
        caps.setCapability("noReset", "true");
        caps.setCapability("aautomationName", "UiAutomator2");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }
}

