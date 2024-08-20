import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObjects.android.*;

import java.io.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Android_NavigateChapter1_Test extends AndroidBase {
    @Test
    public void StudySmokeTest() throws IOException, InterruptedException {

        AndroidDriver driver2 = DesiredCapabilities();

        //PageObjects
        setUpStudyPage sup = new setUpStudyPage(driver2);

        WebDriverWait wait = new WebDriverWait(driver2, 120);

        wait.until(ExpectedConditions.visibilityOf(sup.signIn)).isDisplayed();
        sup.signIn.click();

        Thread.sleep(3000);
        sup.email.click();

        Thread.sleep(1000);
        // Email
        driver2.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android" +
                ".widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android" +
                ".view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android" +
                ".widget.EditText[1]")).sendKeys("oldbay2870@team356747.testinator.com");

        // Password
        driver2.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[2]")).sendKeys("Linqto123");

        sup.signIn.click();

        Thread.sleep(2000);

        // Now go get the code from the email

        driver2.activateApp("com.android.chrome");

        Thread.sleep(3000);
        boolean searchBoxPresent =
                driver2.findElements(By.xpath("//android.widget.EditText[@text='Search or type web address']")).size() > 0;
        if (searchBoxPresent) {
            driver2.findElement(By.xpath("//android.widget.EditText[@text='Search or type web address']")).click();
        } else { }

        wait.until(ExpectedConditions.visibilityOf(sup.urlBar)).isDisplayed();
        sup.urlBar.click();
        sup.urlBar.sendKeys("https://api.mailinator.com/api/v2/domains/team356747.testinator.com/inboxes/*/?token=578df641ba894941b7c610bef88672a2");
        Thread.sleep(3000);
        driver2.getKeyboard().sendKeys(Keys.ENTER);

        // Go fetch the latest email message body text scrape the regID and the code
        // First, grab the JSON and get the latest email ID - This grabs the latest email in the inbox

        String jsonInboxRaw2;
        boolean jsonInboxRawFind2 = driver2.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android" +
                ".widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View")).size() > 0;
        if (jsonInboxRawFind2) {
            jsonInboxRaw2 = driver2.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget" +
                    ".LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View")).getText();

        } else {
            jsonInboxRaw2 = driver2.getPageSource();
        }

        // System.out.println("RAW JSON: " + jsonInboxRaw);

        Pattern patternID2 = Pattern.compile("(?:id\":\")(.*?)\"");
        Matcher matcherID2 = patternID2.matcher(jsonInboxRaw2);
        String emailID2;

        try {
            if (matcherID2.find()) {
                System.out.println("Email ID: " + matcherID2.group(1));
                emailID2 = matcherID2.group(1);

                // Go to the Email box with the message we need (The click to confirm email)
                Thread.sleep(3000);
                sup.urlBar.click();
                sup.urlBar.sendKeys("https://api.mailinator.com/api/v2/domains/team356747.testinator.com/messages/" + emailID2 +
                        "/?token=578df641ba894941b7c610bef88672a2");
                Thread.sleep(3000);
                driver2.getKeyboard().sendKeys(Keys.ENTER);

            }
        } catch (Exception e) {
            System.out.println("Email ID not found");
        }

        // Now the email with the six digit code will be present - Scrape that code

        String jsonMsgRaw2;
        boolean jsonMsgRawFind2 = driver2.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget" +
                ".LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View")).size() > 0;
        if (jsonMsgRawFind2) {
            jsonMsgRaw2 = driver2.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget" +
                    ".LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View")).getText();

        } else {
            jsonMsgRaw2 = driver2.getPageSource();
        }

        System.out.println("SIX DIGIT RAW MSG JSON: " + jsonMsgRaw2);

        Pattern patternMsg2 = Pattern.compile("(<h4>\\s*([0-9]{6}))");
        Matcher matcherMsg2 = patternMsg2.matcher(jsonMsgRaw2);
        String registrationID2 = null;
        String sixDigitCode = null;

        try {
            if (matcherMsg2.find()) {
                System.out.println("SIX DIGIT CODE: " + matcherMsg2.group(1));

                registrationID2 = matcherMsg2.group(1);
                sixDigitCode = registrationID2.replaceAll("<h4>", "");
                System.out.println("SIX DIGIT CODE CLEANED: " + sixDigitCode);


            }
        } catch (Exception e) {
            System.out.println("SIX DIGIT CODE not found");
        }

        Thread.sleep(3000);
        driver2.activateApp("com.linqto.investor.id");

        wait.until(ExpectedConditions.visibilityOf(sup.oneTimePassword)).isDisplayed();
        sup.oneTimePassword.sendKeys(sixDigitCode);
        sup.confirm.click();
        Thread.sleep(20000);

        /*
        Thread.sleep(3000);
        driver2.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText")).sendKeys(sixDigitCode);
        Thread.sleep(3000);
        sup.confirm.click();
        */

        // End the test
        System.out.println("Login Test Successful");
        driver2.quit();

    }
}
