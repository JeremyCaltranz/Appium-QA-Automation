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
        wait.until(ExpectedConditions.visibilityOf(sup.signin)).isDisplayed();
        sup.signin.click();

        wait.until(ExpectedConditions.visibilityOf(sup.email)).isDisplayed();
        sup.email.click();
        sup.emailInput.sendKeys("prodtester24@team356747.testinator.com");
        sup.submitting.click();

        // Begin login process to get validation code
        // Open a Browser -> Go to Mailinator -> Find the email and scrape the validation code from it:

        driver2.activateApp("com.android.chrome");

        // Create a temp text file to store the validation code in

        String TestFileReg = "clipboard.txt";
        File FCV2 = new File(TestFileReg);
        FCV2.createNewFile();
        FileWriter FW2 = new FileWriter(TestFileReg);
        BufferedWriter BW2 = new BufferedWriter(FW2);

        // On Chrome First Opening it Prompts User - This bypasses those prompts

        boolean googlePromptOne =
                driver2.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.Button")).size() > 0;
        if (googlePromptOne) {
            driver2.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.Button")).click();
        } else { }

        Thread.sleep(3000);
        boolean googlePromptTwo =
                driver2.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[1]")).size() > 0;
        if (googlePromptTwo) {
            driver2.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[1]")).click();
        } else { }

        Thread.sleep(3000);
        boolean searchBoxPresent =
                driver2.findElements(By.xpath("//android.widget.EditText[contains(@resource-id,'com.android.chrome:id/search_box_text')]")).size() > 0;
        if (searchBoxPresent) {
            driver2.findElement(By.xpath("//android.widget.EditText[contains(@resource-id,'com.android.chrome:id/search_box_text')]")).click();
        } else { }

        wait.until(ExpectedConditions.visibilityOf(sup.urlBar)).isDisplayed();
        sup.urlBar.click();
        sup.urlBar.sendKeys("https://api.mailinator.com/api/v2/domains/team356747.testinator.com/inboxes/*/?token=578df641ba894941b7c610bef88672a2");
        Thread.sleep(3000);
        driver2.getKeyboard().sendKeys(Keys.ENTER);

        // Sometimes this page needs to be tapped to engage the HTML

        Thread.sleep(3000);
        boolean verifyLinkSearch = driver2.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]")).size() > 0;
        if (verifyLinkSearch) {
            driver2.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]")).click();
        } else { }

        // Now grab the JSON and get the latest email ID
        String jsonInboxRaw;
        boolean jsonInboxRawFind = driver2.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View")).size() > 0;
        if (jsonInboxRawFind) {
            jsonInboxRaw = driver2.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View")).getText();

        } else {
            jsonInboxRaw = driver2.getPageSource();
        }
        // System.out.println("RAW JSON: " + jsonInboxRaw);

        Pattern patternID = Pattern.compile("(?:id\":\")(.*?)\"");
        Matcher matcherID = patternID.matcher(jsonInboxRaw);
        String emailID;

        try {
            if (matcherID.find()) {
                System.out.println("Email ID: " + matcherID.group(1));
                emailID = matcherID.group(1);

                // Go to the Email JSON Message
                Thread.sleep(3000);
                sup.urlBar.click();
                sup.urlBar.sendKeys("https://api.mailinator.com/api/v2/domains/team356747.testinator.com/messages/" + emailID +
                        "/?token=578df641ba894941b7c610bef88672a2");
                Thread.sleep(3000);
                driver2.getKeyboard().sendKeys(Keys.ENTER);

            }
        } catch (Exception e) {
            System.out.println("Email ID not found");
        }

        // Sometimes this page needs to be tapped to engage the HTML
        Thread.sleep(3000);
        boolean verifyLinkSearch2 = driver2.findElements(By.xpath("/hierarchy/android.widget" +
                ".FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]")).size() > 0;
        if (verifyLinkSearch2) {
            driver2.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]")).click();
        } else { }

        // Go fetch the latest email message body text

        String jsonMsgRaw;
        boolean jsonMsgRawFind = driver2.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View")).size() > 0;
        if (jsonMsgRawFind) {
            jsonMsgRaw = driver2.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View")).getText();

        } else {
            jsonMsgRaw = driver2.getPageSource();
        }

        // String jsonMsgRaw = driver2.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View")).getText();
        // System.out.println("RAW MSG JSON: " + jsonMsgRaw);

        Pattern patternMsg = Pattern.compile("(?:body\":\")(.*?)\"");
        Matcher matcherMsg = patternMsg.matcher(jsonMsgRaw);
        // System.out.println("MSG Text: " + matcherMsg);
        String matcherMsgText;

        try {
            if (matcherMsg.find()) {

                // Now extract the code from the message body

                // System.out.println("MSG Text: " + matcherMsg.group(1));
                matcherMsgText = matcherMsg.group(1);

                Pattern pattern = Pattern.compile("([0-9]{6})");
                Matcher matcher = pattern.matcher(matcherMsgText);

                if (matcher.find()) {
                    System.out.println("Verification Code Copied: " + matcher.group(1));
                    BW2.write(matcher.group(1));
                }
                else {
                    System.out.println("123456");
                    BW2.write("123456");
                }

            }
        } catch (Exception e) {
            System.out.println("MSG Text not found");
        }

        BW2.close();

        // Go back to the App and insert the stored validation code

        try {
            driver2.activateApp("com.mheducation.redi");
        } catch (Exception e) {
            System.out.println("Not Production");
        }

        try {
            driver2.activateApp("com.mheducation.redi.staging");
        } catch (Exception e) {
            System.out.println("Not Staging");
        }

        try {
            driver2.activateApp("com.mheducation.redi.debug");
        } catch (Exception e) {
            System.out.println("Not Debug");
        }

        // Open the temp text file -> get the code -> populate the alert box

        FileReader FR2 = new FileReader(TestFileReg);
        BufferedReader BR2 = new BufferedReader(FR2);
        String Content2 = "";
        Content2 = BR2.readLine();

        // Submit the Code
        Thread.sleep(5000);
        System.out.println("Verification Code Pasted: " + Content2);

        driver2.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.widget.EditText")).sendKeys(Content2);
        driver2.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget" +
                ".FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view" +
                ".View/android.view.View[1]/android.widget.Button")).click();

        FCV2.delete();

        System.out.println("User Logged In");

        // End login process to get validation code

        // Onboarding Popups

            wait.until(ExpectedConditions.visibilityOf(sup.onboarding1)).isDisplayed();
            sup.okPopupButton.click();

            wait.until(ExpectedConditions.visibilityOf(sup.onboarding2)).isDisplayed();
            sup.okPopupButton.click();

            wait.until(ExpectedConditions.visibilityOf(sup.onboarding3)).isDisplayed();
            sup.okPopupButton.click();

            System.out.println("Onboarding Popups Passed");

        // End of Onboarding Popups

        // End the test
            System.out.println("Login Test Successful");
            driver2.quit();

    }
}
