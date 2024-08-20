import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.*;
import java.net.URL;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Android_ResourceID  {
    @Test
    public void NewUserFlow() throws IOException, InterruptedException {

        DesiredCapabilities capAndroid = new DesiredCapabilities();

        // Comment these three lines out for AWS Device Farm Build

        // capAndroid.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
        // capAndroid.setCapability(MobileCapabilityType.DEVICE_NAME, "sdk_gphone64_arm64");
        // capAndroid.setCapability(MobileCapabilityType.APP, "/Users/jeremycallahan/Documents/Redi-QA/Android" +
                // "/sharpen1201.apk");

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

        Thread.sleep(2000);

        driver2.activateApp("com.android.chrome");

        // On Chrome First Opening it Prompts User - This bypasses those prompts

        WebDriverWait wait = new WebDriverWait(driver2, 10000);

        boolean googlePromptOne =
                driver2.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.Button")).size() > 0;
        if (googlePromptOne) {
            driver2.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.Button")).click();
        } else { }

        Thread.sleep(2000);
        boolean googlePromptTwo =
                driver2.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[1]")).size() > 0;
        if (googlePromptTwo) {
            driver2.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[1]")).click();
        } else { }

        Thread.sleep(2000);
        boolean searchBoxPresent =
                driver2.findElements(By.xpath("//android.widget.EditText[contains(@resource-id,'com.android.chrome:id/search_box_text')]")).size() > 0;
        if (searchBoxPresent) {
            driver2.findElement(By.xpath("//android.widget.EditText[contains(@resource-id,'com.android.chrome:id/search_box_text')]")).click();
        } else { }

        WebElement urlBar = driver2.findElement(By.xpath("//android.widget.EditText[contains(@resource-id,'com" +
                ".android.chrome:id/url_bar')]"));
        wait.until(ExpectedConditions.visibilityOf(urlBar)).isDisplayed();
        urlBar.click();
        urlBar.sendKeys("https://www.youtube.com/watch?v=mS5RR4SOCpA&list=PLfyhrzMr4hTS5YiPqpbT5eHWWi33drHgR&pp=gAQBiAQB");

        Thread.sleep(2000);
        driver2.getKeyboard().sendKeys(Keys.ENTER);

        // Sometimes this page needs to be tapped to engage the HTML
        Thread.sleep(2000);
        boolean verifyLinkSearch = driver2.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]")).size() > 0;
        if (verifyLinkSearch) {
            driver2.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]")).click();
        } else { }

        Thread.sleep(30000);

        driver2.quit();

    }

}








