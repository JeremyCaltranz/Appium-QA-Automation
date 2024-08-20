import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObjects.iOS.LoginPage;
import pageObjects.iOS.SetUpStudyPage;
import pageObjects.iOS.StudyHomePage;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class iOS_Test {
    @Test
    public void NewUserFlow() throws IOException, InterruptedException {

        URL appiumServerUrl = new URL("http://127.0.0.1:4723/wd/hub");

        DesiredCapabilities appCaps = new DesiredCapabilities();

            // appCaps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "16.1");
            // appCaps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 14");
            appCaps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ios");
            appCaps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
            appCaps.setCapability("iosInstallPause","8000" );
            appCaps.setCapability("showXcodeLog", true);
            appCaps.setCapability("showIOSLog", true);
            appCaps.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 500000);
            appCaps.setCapability("commandTimeouts", "12000");
            // appCaps.setCapability(MobileCapabilityType.APP, "/Users/jeremycallahan/Documents/Redi-QA/iOS/Redi.app");

        DesiredCapabilities safariCaps = new DesiredCapabilities();

            // safariCaps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "16.1");
            // safariCaps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 14");
            // safariCaps.setCapability("safariInitialUrl", "https://www.mailinator.com/");
            // safariCaps.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
            safariCaps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ios");
            safariCaps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);

        IOSDriver driver2 = new IOSDriver(appiumServerUrl, appCaps);

            LoginPage lp = new LoginPage(driver2);
            StudyHomePage sp = new StudyHomePage(driver2);
            SetUpStudyPage sup = new SetUpStudyPage(driver2);

            Thread.sleep(5000);
            driver2.findElement(By.xpath("//XCUIElementTypeButton[@name=\"landingPageCreateAccountButton\"]")).click();

            Random rn = new Random();
            int answer = rn.nextInt(10000) + 1;

            String emailAddress = "oldbay" + answer + "@mailinator.com";

            Thread.sleep(3000);
            driver2.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"createAccountFirstNameTextField\"]")).sendKeys("Harris");

            driver2.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"createAccountLastNameTextField\"]")).sendKeys("Coopersmith");

            driver2.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"createAccountEmailTextField\"]")).sendKeys(emailAddress);

            driver2.findElement(By.xpath("//XCUIElementTypeButton[@name=\"createAccountNextButton\"]")).click();

            Thread.sleep(3000);
            driver2.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"OK\"]")).click();

            //driver2.quit();

        //IOSDriver driver3 = new IOSDriver(appiumServerUrl, safariCaps);

            // Begin login process to get validation code
            // Open a Browser -> Go to Mailinator -> Find the email and scrape the validation code from it:

            driver2.activateApp("com.apple.mobilesafari");

            Thread.sleep(5000);
            boolean openSafariTab =
                    driver2.findElements(By.xpath("//XCUIElementTypeButton[@name=\"AddTabButton\"]")).size() > 0;
            if (openSafariTab) {
                driver2.findElement(By.xpath("//XCUIElementTypeButton[@name=\"AddTabButton\"]")).click();
            } else { }

            Thread.sleep(3000);
            driver2.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"TabBarItemTitle\"]")).click();

            Thread.sleep(3000);
            driver2.findElement(By.xpath("//XCUIElementTypeOther[@name=\"CapsuleViewController" +
                    "\"]/XCUIElementTypeOther[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]")).sendKeys("https://www.mailinator.com/v4/public/inboxes.jsp?to=prodtester" + answer);

            Thread.sleep(3000);
            driver2.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Go\"]")).click();

            Thread.sleep(15000);

            driver2.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Verify your account\"]")).click();

            Thread.sleep(3000);

            String vCodeRaw = driver2.getPageSource();

            // Create a temp text file to store the validation code in

            String TestFileReg = "clipboard.txt";
            File FCV2 = new File(TestFileReg);
            FCV2.createNewFile();
            FileWriter FW2 = new FileWriter(TestFileReg);
            BufferedWriter BW2 = new BufferedWriter(FW2);

            // Find the code within the raw text

            Pattern pattern = Pattern.compile("label=\"([0-9]{6})\"");
            Matcher matcher = pattern.matcher(vCodeRaw);

            // Copy the extracted code

            if (matcher.find()) {
                System.out.println("Verification Code Copied: " + matcher.group(1));
                BW2.write(matcher.group(1));
            }
            else {
                System.out.println("Verification Code Copied: 123456");
                BW2.write("123456");
            }

            BW2.close();

            // Go back to the App and insert the stored validation code

            driver2.activateApp("com.mhe.redi");

            FileReader FR2 = new FileReader(TestFileReg);
            BufferedReader BR2 = new BufferedReader(FR2);
            String Content2 = "";
            Content2 = BR2.readLine();

            Thread.sleep(3000);
            System.out.println("Verification Code Pasted: " + Content2);

            driver2.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"Sharpen\"]/XCUIElementTypeWindow[1" +
                    "]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther" +
                    "/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeTextField")).sendKeys(Content2);

            driver2.findElement(By.name("Let me in")).click();

            FCV2.delete();
            Thread.sleep(5000);

            WebDriverWait wait = new WebDriverWait(driver2, 10000);

            // Choose the Marketing Book
            wait.until(ExpectedConditions.visibilityOf(sup.setupbook)).isDisplayed();
            sup.setupbookmarketing.click();
            lp.submitting.click();

            // Set Study Goal
            wait.until(ExpectedConditions.visibilityOf(sup.studygoalpage)).isDisplayed();
            sup.learnbasics.click();
            lp.submitting.click();

            // When do you study best
            wait.until(ExpectedConditions.visibilityOf(sup.studybestmessage)).isDisplayed();
            sup.notsure.click();
            lp.submitting.click();

            wait.until(ExpectedConditions.visibilityOf(sp.studyreminder)).isDisplayed();

            Thread.sleep(3000);
            driver2.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Next\"]")).click();

            // iOS alert for Allowing device/ad tracking
            Thread.sleep(3000);
            driver2.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Allow\"]")).click();

            Thread.sleep(3000);
            driver2.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Yes please\"]")).click();

            // iOS alert for Allowing push notification
            Thread.sleep(3000);
            driver2.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Allow\"]")).click();

            wait.until(ExpectedConditions.visibilityOf(sp.onboarding1)).isDisplayed();
            sp.okbutton.click();

            sp.onboarding2.isDisplayed();
            sp.okbutton.click();

            sp.scrollpopup.isDisplayed();
            sp.okbutton.click();

            sp.onboarding3.isDisplayed();
            sp.okbutton.click();

            sp.onboarding4.isDisplayed();
            sp.okbutton.click();

            Thread.sleep(3000);
            driver2.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Track\"])[1]")).click();

            sp.onboarding5.isDisplayed();
            sp.okbutton.click();

            sp.popupmessgecard.isDisplayed();
            sp.okbutton.click();

            sp.onboarding6.isDisplayed();
            sp.okbutton.click();

            Thread.sleep(3000);
            driver2.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Settings\"]")).click();

            Thread.sleep(3000);
            driver2.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Sign Out\"]")).click();

            driver2.quit();

    }
}







