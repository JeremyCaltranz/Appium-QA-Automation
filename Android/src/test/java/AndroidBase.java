import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AndroidBase {

    public static AndroidDriver DesiredCapabilities() throws MalformedURLException {

        DesiredCapabilities capAndroid = new DesiredCapabilities();

        // Comment these three lines out for AWS Device Farm Build

            capAndroid.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
            capAndroid.setCapability(MobileCapabilityType.DEVICE_NAME, "sdk_gphone64_arm64");
            capAndroid.setCapability(MobileCapabilityType.APP, "/Users/jeremycallahan/Documents/Redi-QA/Android/sharpen1201.apk");

        // End of three lines out for AWS Device Farm Build

        capAndroid.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capAndroid.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capAndroid.setCapability("showGradleLog", true);
        capAndroid.setCapability("unicodeKeyboard", "true");
        capAndroid.setCapability("resetKeyboard", "true");
        //capAndroid.setCapability("commandTimeouts", "12000");
        //capAndroid.setCapability("browserName", MobileBrowserType.BROWSER);
        //capAndroid.setCapability("ChromeDriver", "/Users/jeremycallahan/Documents/Redi-QA/Android/chromedriver.exe");

        AndroidDriver driver2 = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capAndroid);

        return driver2;

    }
}