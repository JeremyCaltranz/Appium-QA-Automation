import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObjects.android.*;

import java.io.*;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Android_RegisterNewUser  extends AndroidBase {
    @Test
    public void NewUserFlow() throws IOException, InterruptedException {

        AndroidDriver driver2 = DesiredCapabilities();

        setUpStudyPage sup = new setUpStudyPage(driver2);

        WebDriverWait wait = new WebDriverWait(driver2, 60);
        wait.until(ExpectedConditions.visibilityOf(sup.createaccount)).isDisplayed();
        sup.createaccount.click();

        Random rn = new Random();
        int answer = rn.nextInt(100000) + 1;

        String emailAddress = "oldbay" + answer + "@team356747.testinator.com";

        Thread.sleep(3000);
        // First Name
        driver2.findElement(By.xpath("//android.widget.EditText[contains(@resource-id,'createAccountFirstNameTextField')]")).sendKeys(
                "Albert");
        // Last Name
        driver2.findElement(By.xpath("//android.widget.EditText[contains(@resource-id,'createAccountLastNameTextField')]")).sendKeys(
                "Stapleton");
        // Email
        driver2.findElement(By.xpath("//android.widget.EditText[contains(@resource-id,'createAccountEmailTextField')" +
                "]")).sendKeys(emailAddress);

        // Go to the next page
        driver2.findElement(By.xpath("//android.view.View[contains(@resource-id,'createAccountNextButton')]")).click();

        // Tap the Success popup
        Thread.sleep(10000);
        driver2.findElement(By.xpath("//android.widget.TextView[@text=\"Login\"]")).click();


        // Begin login process to get validation code
        // Open a Browser -> Go to Mailinator -> Find the email and scrape the validation code from it:

        driver2.activateApp("com.android.chrome");

        // Create a Temp file to store the six digit code into

        Thread.sleep(3000);
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

        // System.out.println("RAW MSG JSON: " + jsonMsgRaw);

        Pattern patternMsg = Pattern.compile("(?:body\":\")(.*?)\"");
        Matcher matcherMsg = patternMsg.matcher(jsonMsgRaw);
        // System.out.println("MSG Text: " + matcherMsg);
        String matcherMsgText;

        try {
            if (matcherMsg.find()) {

                // Now extract the code from the message body

                System.out.println("MSG Text: " + matcherMsg.group(1));
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
        driver2.findElement(By.xpath("//android.widget.TextView[@text=\"Let me in\"]")).click();

        FCV2.delete();

        System.out.println("New Account Created and Logged In");

        // End login process to get validation code

        // Choose the Marketing Book

        wait.until(ExpectedConditions.visibilityOf(sup.setupbook)).isDisplayed();
        sup.filterMarketing.sendKeys("Roger Kerin");

        wait.until(ExpectedConditions.visibilityOf(sup.setupbookmarketing)).isDisplayed();
        sup.setupbookmarketing.click();
        sup.arrowButton.click();

        // Set Study Goal
        wait.until(ExpectedConditions.visibilityOf(sup.studygoalpage)).isDisplayed();
        sup.learnbasics.click();
        sup.arrowButton.click();

        // When do you study best
        wait.until(ExpectedConditions.visibilityOf(sup.studybestmessage)).isDisplayed();
        sup.inthemorning.click();
        sup.arrowButton.click();

        System.out.println("Book Setup Passed");

        // Onboarding Popups
        wait.until(ExpectedConditions.visibilityOf(sup.onboarding1)).isDisplayed();
        sup.okPopupButton.click();

        wait.until(ExpectedConditions.visibilityOf(sup.onboarding2)).isDisplayed();
        sup.okPopupButton.click();

        wait.until(ExpectedConditions.visibilityOf(sup.onboarding3)).isDisplayed();
        sup.okPopupButton.click();

        System.out.println("Onboarding Popups Passed");

        // Begin the video card test

        wait.until(ExpectedConditions.visibilityOf(sup.selectoverviewcard)).isDisplayed();
        sup.selectoverviewcard.click();

        sup.arrowButton.click();

        wait.until(ExpectedConditions.visibilityOf(sup.overviewPromptOne)).isDisplayed();
        sup.overviewPromptOne.isDisplayed();
        sup.okPopupButton.click();

        sup.overviewPromptTwo.isDisplayed();
        sup.okPopupButton.click();

        sup.overviewPromptThree.isDisplayed();
        sup.okPopupButton.click();

        wait.until(ExpectedConditions.visibilityOf(sup.chapter1backbutton)).isDisplayed();
        sup.chapter1backbutton.click();

        System.out.println("Overview Card Passed");

        // End of video card test

        // Swipe the Card

        wait.until(ExpectedConditions.visibilityOf(sup.selectoverviewcard)).isDisplayed();
        Point swipeLocationOne = sup.swipeoverviewcard.getLocation();
        // System.out.println("Card Coordinates: " + swipeLocationOne);

        new TouchAction(driver2)
                .press(PointOption.point(swipeLocationOne))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(1261, 1136))
                .release()
                .perform();

        // End Swipe the Card

        // Begin the summary card test

        wait.until(ExpectedConditions.visibilityOf(sup.selectsummarycard)).isDisplayed();
        sup.arrowButton.click();

        sup.summaryPromptOne.isDisplayed();
        sup.okPopupButton.click();

        sup.summaryPromptTwo.isDisplayed();
        sup.okPopupButton.click();

        wait.until(ExpectedConditions.visibilityOf(sup.chapter1backbutton)).isDisplayed();
        sup.chapter1backbutton.click();

        System.out.println("Summary Card Passed");

        // End the summary card test

        // Swipe the Card

        wait.until(ExpectedConditions.visibilityOf(sup.selectsummarycard)).isDisplayed();
        Point swipeLocationTwo = sup.swipesummarycard.getLocation();
        // System.out.println("Card Coordinates: " + swipeLocationOne);

        new TouchAction(driver2)
                .press(PointOption.point(swipeLocationTwo))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(1261, 1136))
                .release()
                .perform();

        new TouchAction(driver2)
                .press(PointOption.point(swipeLocationTwo))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(1261, 1136))
                .release()
                .perform();

        // End Swipe the Card

        // Begin the quiz card test

        wait.until(ExpectedConditions.visibilityOf(sup.selectquizcard)).isDisplayed();
        sup.arrowButton.click();

        sup.quizPromptOne.isDisplayed();
        sup.okPopupButton.click();

        sup.quizPromptTwo.isDisplayed();
        sup.okPopupButton.click();

        // Question One

        wait.until(ExpectedConditions.visibilityOf(sup.questionOneAnswer)).isDisplayed();
        sup.questionOneAnswer.click();
        Point swipeQuestionOne = sup.questionOneAnswer.getLocation();
        System.out.println("Answer One Coordinates: " + swipeQuestionOne);

        new TouchAction(driver2)
                .press(PointOption.point(swipeQuestionOne))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(0, swipeQuestionOne.getY()))
                .release()
                .perform();

        Thread.sleep(1000);

        boolean ispresent15 =
                driver2.findElements(By.xpath("//android.widget.TextView[@text=\"Tap an answer to see the explanation. Swipe to move on to next question.\"]")).size() > 0;
        if (ispresent15) {
            sup.okbutton.click();
        } else { }

        Thread.sleep(1000);

        Dimension answerOneWidth = sup.questionOneAnswer.getSize();
        Integer startSecondSwipe = answerOneWidth.getWidth();
        System.out.println("Width of element to swipe: " + startSecondSwipe);

        // Integer startSecondSwipe = swipeQuestionOne.getX() + 500;

        new TouchAction(driver2)
                .press(PointOption.point(startSecondSwipe, swipeQuestionOne.getY()))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(0, swipeQuestionOne.getY()))
                .release()
                .perform();

        System.out.println("Second Swipe Coordinates: " + startSecondSwipe + " & " + swipeQuestionOne.getY());

        // Question 2

        wait.until(ExpectedConditions.visibilityOf(sup.questionTwoAnswer)).isDisplayed();
        sup.questionTwoAnswer.click();

        Point swipeQuestionTwo = sup.questionTwoAnswer.getLocation();
        System.out.println("Answer Two Coordinates: " + swipeQuestionTwo);


        new TouchAction(driver2)
                .press(PointOption.point(swipeQuestionTwo))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(0, swipeQuestionTwo.getY()))
                .release()
                .perform();

        Thread.sleep(1000);

        Dimension answerTwoWidth = sup.questionTwoAnswer.getSize();
        Integer startSecondSwipeTwo = answerTwoWidth.getWidth();

        new TouchAction(driver2)
                .press(PointOption.point(startSecondSwipeTwo, swipeQuestionTwo.getY()))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(0, swipeQuestionTwo.getY()))
                .release()
                .perform();

        // Question Three

        wait.until(ExpectedConditions.visibilityOf(sup.questionThreeAnswer)).isDisplayed();
        sup.questionThreeAnswer.click();

        Point swipeQuestionThree = sup.questionThreeAnswer.getLocation();
        System.out.println("Answer Three Coordinates: " + swipeQuestionThree);

        new TouchAction(driver2)
                .press(PointOption.point(swipeQuestionThree))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(0, swipeQuestionThree.getY()))
                .release()
                .perform();

        Thread.sleep(1000);

        Dimension answerThreeWidth = sup.questionThreeAnswer.getSize();
        Integer startSecondSwipeThree = answerThreeWidth.getWidth();

        new TouchAction(driver2)
                .press(PointOption.point(startSecondSwipeThree, swipeQuestionThree.getY()))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(0, swipeQuestionThree.getY()))
                .release()
                .perform();

        // Question Four

        wait.until(ExpectedConditions.visibilityOf(sup.questionFourAnswer)).isDisplayed();
        sup.questionFourAnswer.click();

        Point swipeQuestionFour = sup.questionFourAnswer.getLocation();
        System.out.println("Answer Four Coordinates: " + swipeQuestionFour);

        new TouchAction(driver2)
                .press(PointOption.point(swipeQuestionFour))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(0, swipeQuestionFour.getY()))
                .release()
                .perform();

        Thread.sleep(1000);

        Dimension answerFourWidth = sup.questionFourAnswer.getSize();
        Integer startSecondSwipeFour = answerFourWidth.getWidth();

        new TouchAction(driver2)
                .press(PointOption.point(startSecondSwipeFour, swipeQuestionFour.getY()))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(0, swipeQuestionFour.getY()))
                .release()
                .perform();

        // Question Five - This is purposfully answered wrong

        wait.until(ExpectedConditions.visibilityOf(sup.questionFiveWrongAnswer)).isDisplayed();
        sup.questionFiveWrongAnswer.click();

        Point swipeQuestionFiveWrong = sup.questionFiveWrongAnswer.getLocation();
        System.out.println("Answer Five Wrong Coordinates: " + swipeQuestionFiveWrong);

        new TouchAction(driver2)
                .press(PointOption.point(swipeQuestionFiveWrong))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(0, swipeQuestionFiveWrong.getY()))
                .release()
                .perform();

        Thread.sleep(1000);

        Dimension answerFiveWidth = sup.questionFiveWrongAnswer.getSize();
        Integer startSecondSwipeFiveWrong = answerFiveWidth.getWidth();

        new TouchAction(driver2)
                .press(PointOption.point(startSecondSwipeFiveWrong, swipeQuestionFiveWrong.getY()))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(0, swipeQuestionFiveWrong.getY()))
                .release()
                .perform();

        System.out.println("Quiz Completed at 80%");

        // Quiz competed with 80% correct - Now we will correct the wrong answer

        Thread.sleep(6000);

        wait.until(ExpectedConditions.visibilityOf(sup.takebreak)).isDisplayed();
        sup.takebreak.click();

        wait.until(ExpectedConditions.visibilityOf(sup.tracklink)).isDisplayed();
        sup.tracklink.click();

        boolean ispresent17 =
                driver2.findElements(By.xpath("//android.widget.TextView[@text=\"Tap the Summary Bar to dive into your History\"]")).size() > 0;
        if (ispresent17) {
            sup.okbutton.click();
        } else { }

        boolean ispresent18 =
                driver2.findElements(By.xpath("//android.widget.TextView[@text=\"Tap to access Settings like Dark Mode, Type Size, Account, and Help\"]")).size() > 0;
        if (ispresent18) {
            sup.okbutton.click();
        } else { }

        new TouchAction(driver2)
                .press(PointOption.point(200, 800))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(200, 200))
                .release()
                .perform();

        wait.until(ExpectedConditions.visibilityOf(sup.retakelink)).isDisplayed();
        sup.retakelink.click();

        // Correct the final answer

        wait.until(ExpectedConditions.visibilityOf(sup.questionFiveAnswer)).isDisplayed();
        sup.questionFiveAnswer.click();

        Point swipeQuestionFiveRight = sup.questionFiveAnswer.getLocation();
        System.out.println("Answer Five Right Coordinates: " + swipeQuestionFiveRight);

        new TouchAction(driver2)
                .press(PointOption.point(swipeQuestionFiveRight))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(0, swipeQuestionFiveRight.getY()))
                .release()
                .perform();

        Thread.sleep(1000);

        Dimension answerFiveWidthRight = sup.questionFiveAnswer.getSize();
        Integer startSecondSwipeFiveRight = answerFiveWidthRight.getWidth();

        new TouchAction(driver2)
                .press(PointOption.point(startSecondSwipeFiveRight, swipeQuestionFiveRight.getY()))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(0, swipeQuestionFiveRight.getY()))
                .release()
                .perform();

        System.out.println("Quiz Corrected to 100%");

        // Quiz completed with 100% correct

        // Now reset the progress on the book so we can re-run this test in the future

        Thread.sleep(3000);
        sup.arrowButton.click();

        Thread.sleep(3000);
        new TouchAction(driver2)
                .press(PointOption.point(200, 200))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(200, 2000))
                .release()
                .perform();

        Thread.sleep(3000);
        driver2.findElement(By.xpath("//android.widget.TextView[@text=\"Settings\"]")).click();

        // Scroll to the bottom of the page

        Thread.sleep(3000);
        Dimension screenSize = driver2.manage().window().getSize();
        int endy = (int) (screenSize.getHeight() * 0.90);
        System.out.println("90% of device height: " + endy);

        new TouchAction(driver2)
                .press(PointOption.point(200, endy))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(200, 100))
                .release()
                .perform();

        new TouchAction(driver2)
                .press(PointOption.point(200, endy))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(200, 100))
                .release()
                .perform();

        new TouchAction(driver2)
                .press(PointOption.point(200, endy))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(200, 100))
                .release()
                .perform();

        Thread.sleep(3000);
        driver2.findElement(By.xpath("//android.widget.TextView[@text=\"Reset Title\"]")).click();

        Thread.sleep(3000);
        driver2.findElement(By.xpath("//android.widget.TextView[@text=\"Yes, Reset Book\"]")).click();

        Thread.sleep(3000);
        driver2.findElement(By.xpath("//android.widget.TextView[@text=\"OK\"]")).click();

        Thread.sleep(3000);
        driver2.findElement(By.xpath("//android.view.View[@content-desc=\"Back\"]")).click();

        Thread.sleep(3000);
        driver2.findElement(By.xpath("(//android.view.View[@content-desc=\"Tab\"])[1]")).click();

        System.out.println("New Registration & Quiz Test Passed Successfully!");

        // End the test
        driver2.quit();

    }

}