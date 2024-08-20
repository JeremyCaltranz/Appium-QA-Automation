import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObjects.iOS.*;

import java.io.*;
import java.util.HashMap;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class iOS_RegisterNewUser extends iOSBase {
    @Test
    public void NewUserFlow() throws IOException, InterruptedException {

        IOSDriver driver2 = IOSDesiredCapabilities();

        //PageObjects
        LoginPage lp = new LoginPage(driver2);
        StudyHomePage sp = new StudyHomePage(driver2);
        SetUpStudyPage sup = new SetUpStudyPage(driver2);
        Chapter1VideoPage c1vp = new Chapter1VideoPage(driver2);
        Chapter1SummaryCards c1sc = new Chapter1SummaryCards(driver2);
        Chapter1Quiz c1qz = new Chapter1Quiz(driver2);

        WebDriverWait wait = new WebDriverWait(driver2, 120);
        wait.until(ExpectedConditions.visibilityOf(lp.createLink)).isDisplayed();
        lp.createLink.click();

        // Thread.sleep(10000);
        // driver2.findElement(By.xpath("//XCUIElementTypeButton[@name=\"landingPageCreateAccountButton\"]")).click();

        Random rn = new Random();
        int answer = rn.nextInt(100000) + 1;

        String emailAddress = "oldbay" + answer + "@team356747.testinator.com";

        Thread.sleep(3000);
        driver2.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"createAccountFirstNameTextField\"]")).sendKeys("Harris");

        driver2.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"createAccountLastNameTextField\"]")).sendKeys("Coopersmith");

        driver2.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"createAccountEmailTextField\"]")).sendKeys(emailAddress);

        driver2.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Continue\"]")).click();

        Thread.sleep(3000);
        driver2.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"OK\"]")).click();

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
                "\"]/XCUIElementTypeOther[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]")).sendKeys("https://www.mailinator.com/v4/login.jsp");

        Thread.sleep(3000);
        driver2.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Go\"]")).click();

        driver2.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"Email field\"]")).sendKeys("jeremy.callahan@mheducation.com");

        driver2.findElement(By.xpath("//XCUIElementTypeSecureTextField[@name=\"Password field\"]")).sendKeys(
                "McGraw123!");

        driver2.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Log in\"]")).click();

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
        Thread.sleep(2000);
        driver2.findElement(By.xpath("//XCUIElementTypeButton[@name=\"LOGOUT\"]")).click();


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

        driver2.findElement(By.name("Verify my account")).click();

        FCV2.delete();
        Thread.sleep(5000);

        // End login process to get validation code

        // Choose the Marketing Book
        wait.until(ExpectedConditions.visibilityOf(sup.setupbook)).isDisplayed();

        Thread.sleep(2000);
        sup.filterMarketing.sendKeys("marketing");

        Thread.sleep(2000);
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

        // Allow App Tracking
        Thread.sleep(3000);
        driver2.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Next\"]")).click();

        // iOS alert for Allowing device/ad tracking
        Thread.sleep(3000);
        driver2.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Allow\"]")).click();

        // Begin the video card test

        wait.until(ExpectedConditions.visibilityOf(sp.selectoverviewcard)).isDisplayed();
        sp.selectoverviewcard.click();

        wait.until(ExpectedConditions.visibilityOf(sp.chapter1playbutton)).isDisplayed();
        sp.chapter1playbutton.click();

        // Overview Prompts
        Thread.sleep(3000);

        sp.overviewPromptOne.isDisplayed();
        sp.okbutton.click();

        sp.overviewPromptTwo.isDisplayed();
        sp.okbutton.click();

        // Verifying visibility of fields of Chapter 1 video lesson
        Thread.sleep(3000);
        c1vp.chapter1backbutton.click();

        // End of video card test

        // Begin the summary card test

        wait.until(ExpectedConditions.visibilityOf(sp.selectsummarycard)).isDisplayed();
        sp.selectsummarycard.click();

        wait.until(ExpectedConditions.visibilityOf(sp.chapter1playbutton)).isDisplayed();
        sp.chapter1playbutton.click();

        Thread.sleep(3000);

        boolean ispresent10 = driver2.findElements(By.xpath("//XCUIElementTypeStaticText[@name=\"Tap images to " +
                "view them in full screen.\"]")).size() > 0;

        if (ispresent10) {
            sp.okbutton.click();
        } else { sp.okbutton.click(); }

        boolean ispresent11 = driver2.findElements(By.xpath("//XCUIElementTypeStaticText[@name=\"Swipe left to keep going\"]")).size() > 0;

        if (ispresent11) {
            sp.okbutton.click();
        } else { sp.okbutton.click(); }

        wait.until(ExpectedConditions.visibilityOf(c1sc.summarycard2)).isDisplayed();

        c1sc.backbutton.click();

        // End the summary card test

        // Begin the quiz card test

        wait.until(ExpectedConditions.visibilityOf(sp.selectquizcard)).isDisplayed();
        sp.selectquizcard.click();

        wait.until(ExpectedConditions.visibilityOf(sp.chapter1playbutton)).isDisplayed();
        sp.chapter1playbutton.click();

        Thread.sleep(2000);

        boolean ispresent12 =
                driver2.findElements(By.xpath("//XCUIElementTypeStaticText[@name=\"Questions can be single or multi choice.\"]")).size() > 0;
        if (ispresent12) {
            sp.okbutton.click();
        } else { }

        Thread.sleep(2000);

        boolean ispresent13 =
                driver2.findElements(By.xpath("//XCUIElementTypeStaticText[@name=\"Tap to select your answers\"]")).size() > 0;
        if (ispresent13) {
            sp.okbutton.click();
        } else { }

        Thread.sleep(2000);

        boolean ispresent14 =
                driver2.findElements(By.xpath("//XCUIElementTypeStaticText[@name=\"Then swipe left for results.\"]")).size() > 0;
        if (ispresent14) {
            sp.okbutton.click();
        } else { }

        Thread.sleep(3000);

        // Question One

        wait.until(ExpectedConditions.visibilityOf(c1qz.questionOneAnswer)).isDisplayed();
        c1qz.questionOneAnswer.click();

        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver2;
        HashMap<String, String> scrollObject = new HashMap<String, String>();

        scrollObject.put("direction", "right");
        scrollObject.put("xpath", "//XCUIElementTypeStaticText[@name=\"Processes for creating, communicating, " +
                "delivering, and exchanging offerings that have value for customers\"]");
        js.executeScript("mobile: scroll", scrollObject);

        Thread.sleep(3000);

        boolean ispresent15 =
                driver2.findElements(By.xpath("//XCUIElementTypeStaticText[@name=\"Tap an answer to see the " +
                        "explanation\"]")).size() > 0;
        if (ispresent15) {
            sp.okbutton.click();
        } else { }

        Thread.sleep(3000);

        boolean ispresent16 = driver2.findElements(By.xpath("//XCUIElementTypeStaticText[@name=\"You got it!\"]")).size() > 0;
        if (ispresent16) {
            sp.okbutton.click();
        } else { }

        scrollObject.put("direction", "right");
        scrollObject.put("xpath", "//XCUIElementTypeApplication[@name=\"Sharpen\"]/XCUIElementTypeWindow");
        js.executeScript("mobile: scroll", scrollObject);

        // Question 2

        Thread.sleep(3000);

        wait.until(ExpectedConditions.visibilityOf(c1qz.questionTwoAnswer)).isDisplayed();
        c1qz.questionTwoAnswer.click();

        Thread.sleep(1000);

        scrollObject.put("direction", "right");
        scrollObject.put("xpath", "//XCUIElementTypeStaticText[@name=\"Product, price, promotion, place\"]");
        js.executeScript("mobile: scroll", scrollObject);

        Thread.sleep(1000);

        scrollObject.put("direction", "right");
        scrollObject.put("xpath", "//XCUIElementTypeApplication[@name=\"Sharpen\"]/XCUIElementTypeWindow");
        js.executeScript("mobile: scroll", scrollObject);

        // Question Three

        Thread.sleep(3000);

        wait.until(ExpectedConditions.visibilityOf(c1qz.questionThreeAnswer)).isDisplayed();
        c1qz.questionThreeAnswer.click();

        Thread.sleep(1000);

        scrollObject.put("direction", "right");
        scrollObject.put("xpath", "//XCUIElementTypeStaticText[@name=\"discover the needs of prospective " +
                "customers\"]");
        js.executeScript("mobile: scroll", scrollObject);

        Thread.sleep(1000);

        scrollObject.put("direction", "right");
        scrollObject.put("xpath", "//XCUIElementTypeApplication[@name=\"Sharpen\"]/XCUIElementTypeWindow");
        js.executeScript("mobile: scroll", scrollObject);

        // Question Four

        Thread.sleep(3000);

        wait.until(ExpectedConditions.visibilityOf(c1qz.questionFourAnswer)).isDisplayed();
        c1qz.questionFourAnswer.click();

        Thread.sleep(1000);

        scrollObject.put("direction", "right");
        scrollObject.put("xpath", "//XCUIElementTypeStaticText[@name=\"customer value\"]");
        js.executeScript("mobile: scroll", scrollObject);

        Thread.sleep(1000);

        scrollObject.put("direction", "right");
        scrollObject.put("xpath", "//XCUIElementTypeApplication[@name=\"Sharpen\"]/XCUIElementTypeWindow");
        js.executeScript("mobile: scroll", scrollObject);

        // Question Five - This is purposfully answered wrong

        Thread.sleep(3000);

        wait.until(ExpectedConditions.visibilityOf(c1qz.questionFiveWrongAnswer)).isDisplayed();
        c1qz.questionFiveWrongAnswer.click();

        Thread.sleep(1000);

        scrollObject.put("direction", "right");
        scrollObject.put("xpath", "//XCUIElementTypeStaticText[@name=\"Consumers will purchase any products that " +
                "marketers make available.\"]");
        js.executeScript("mobile: scroll", scrollObject);

        Thread.sleep(1000);

        scrollObject.put("direction", "right");
        scrollObject.put("xpath", "//XCUIElementTypeApplication[@name=\"Sharpen\"]/XCUIElementTypeWindow");
        js.executeScript("mobile: scroll", scrollObject);

        // Quiz competed with 80% correct - Now we will correct the wrong answer

        Thread.sleep(3000);
        driver2.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Take a Break\"])[1]")).click();

        Thread.sleep(3000);
        driver2.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Track\"])[1]")).click();

        sp.onboarding5.isDisplayed();
        sp.okbutton.click();

        sp.popupmessgecard.isDisplayed();
        sp.okbutton.click();

        sp.onboarding6.isDisplayed();
        sp.okbutton.click();

        Thread.sleep(3000);
        driver2.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Creating Customer Relationships and " +
                "Value through Marketing\"]")).click();

        // Correct the final answer

        Thread.sleep(3000);

        wait.until(ExpectedConditions.visibilityOf(c1qz.questionFiveAnswer)).isDisplayed();
        c1qz.questionFiveAnswer.click();

        Thread.sleep(3000);

        scrollObject.put("direction", "right");
        scrollObject.put("xpath", "//XCUIElementTypeStaticText[@name=\"An organization should strive to satisfy " +
                "the needs of consumers and try to achieve the organization’s goals.\"]");
        js.executeScript("mobile: scroll", scrollObject);

        Thread.sleep(3000);

        scrollObject.put("direction", "right");
        scrollObject.put("xpath", "//XCUIElementTypeApplication[@name=\"Sharpen\"]/XCUIElementTypeWindow");
        js.executeScript("mobile: scroll", scrollObject);

        // Quiz completed with 100% correct

        // Now reset the progress on the book so we can re-run this test in the future

        Thread.sleep(3000);

        driver2.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Next\"]")).click();

        Thread.sleep(3000);

        driver2.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Settings\"]")).click();

        Thread.sleep(3000);
        driver2.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Reset Title\"]")).click();

        Thread.sleep(3000);
        driver2.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Yes, Reset Book\"]")).click();

        Thread.sleep(3000);
        driver2.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Sign Out\"]")).click();

        // End the test
        driver2.quit();

    }

}







