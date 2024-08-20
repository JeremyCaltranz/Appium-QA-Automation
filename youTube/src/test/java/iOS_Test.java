import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.*;
import java.net.URL;

public class iOS_Test {
    @Test
    public void NewUserFlow() throws IOException, InterruptedException {

        URL appiumServerUrl = new URL("http://127.0.0.1:4723/wd/hub");

        DesiredCapabilities appCaps = new DesiredCapabilities();

        // Comment these three lines out for AWS Device Farm Build

            // appCaps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "16.2");
            // appCaps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 14 Pro");

        // End of three lines out for AWS Device Farm Build

            appCaps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ios");
            appCaps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
            appCaps.setCapability("iosInstallPause","8000" );
            appCaps.setCapability("showXcodeLog", true);
            appCaps.setCapability("showIOSLog", true);
            appCaps.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 500000);
            appCaps.setCapability("commandTimeouts", "12000");

        IOSDriver driver2 = new IOSDriver(appiumServerUrl, appCaps);

        // WebDriverWait wait = new WebDriverWait(driver2, 120);
        // This should run for 20 minutes

        // This week in golf playlist: https://www.youtube.com/playlist?list=PLfyhrzMr4hTS5YiPqpbT5eHWWi33drHgR
        // Swing videos: https://www.youtube.com/playlist?list=PLfyhrzMr4hTRfZ39qzwA0IEUwr4MqgoGa

        // Open Safari
        driver2.activateApp("com.apple.mobilesafari");

        Thread.sleep(2000);
        driver2.get("https://www.google.com");

        Thread.sleep(3000);
        driver2.get("https://www.youtube.com/watch?v=mS5RR4SOCpA&list=PLfyhrzMr4hTS5YiPqpbT5eHWWi33drHgR&pp=gAQBiAQB");

/*
        // Bring it into focus
        Thread.sleep(2000);
        try {
            boolean openSafariTab =
                    driver2.findElements(By.xpath("//XCUIElementTypeApplication[@name=\"Safari\"]")).size() > 0;
                System.out.println("Element: Safari Found");
            if (openSafariTab) {
                driver2.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"Safari\"]")).click();
                System.out.println("Element: Safari Clicked");
            } else { }
        } catch (Exception e) {
            System.out.println("Element: Safari Not Found");
        }

        // It can be picky so try this to focus it...
        Thread.sleep(2000);
        try {
            boolean openSafariTab2 =
                    driver2.findElements(By.xpath("//XCUIElementTypeStaticText[@name=\"Done\"]")).size() > 0;
                System.out.println("Element: Done Button Found");
            if (openSafariTab2) {
                driver2.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Done\"]")).click();
                System.out.println("Element: Done Button Clicked");
            } else { }
        } catch (Exception e) {
            System.out.println("Element: Done Button Not Found");
        }

        Thread.sleep(3000);
        try {
            driver2.findElement(By.xpath("//XCUIElementTypeButton[@name=\"AddTabButton\"]")).click();
            System.out.println("Element: Add Button Found");
        }
        catch (Exception e) {
            System.out.println("Element: Add Button Not Found");
        }

        Thread.sleep(2000);
        try {
            driver2.findElement(By.xpath("//XCUIElementTypeTextField[@name='URL']")).sendKeys("https://www.youtube.com/watch?v=mS5RR4SOCpA&list=PLfyhrzMr4hTS5YiPqpbT5eHWWi33drHgR&pp=gAQBiAQB");
            System.out.println("Element: URL Input Found");
        }
        catch (Exception e) {
            System.out.println("Element: URL Input Not Found");
        }


        Thread.sleep(2000);
        try {
            driver2.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Go\"]")).click();
            System.out.println("Element: Go Button Found");
        }
        catch (Exception e) {
            System.out.println("Element: Go Button Not Found");
        }

        // Click the shuffle button

        Thread.sleep(2000);
        try {
            driver2.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Shuffle\"]")).click();
            System.out.println("Element: Shuffle Button Found");
        }
        catch (Exception e) {
            System.out.println("Element: Schuffle Button Not Found");
        }
*/

        Thread.sleep(60000);

        driver2.quit();

    }
}







