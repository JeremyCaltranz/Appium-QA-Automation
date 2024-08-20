import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObjects.iOS.*;

import java.io.*;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class iOS_NavigateChapter1_Test extends iOSBase {
    @Test
    public void StudySmokeTest() throws IOException, InterruptedException {

        IOSDriver driver2 = IOSDesiredCapabilities();

        //PageObjects
        LoginPage lp = new LoginPage(driver2);
        StudyHomePage sp = new StudyHomePage(driver2);

        Thread.sleep(10000);
        boolean landingPage =
                driver2.findElements(By.xpath("//XCUIElementTypeButton[@name=\"landingPageLoginButton\"]")).size() > 0;
        if (landingPage) {
            lp.loginLink.click();
        } else {
            lp.email.sendKeys("prodtester24@team356747.testinator.com");
        }

        WebDriverWait wait = new WebDriverWait(driver2, 120);

        Thread.sleep(3000);
        driver2.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Continue\"]")).click();

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
        //driver2.findElement(By.xpath("//XCUIElementTypeOther[@name=\"CapsuleViewController\"]/XCUIElementTypeOther[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]")).sendKeys("https://www.mailinator.com/v4/public/inboxes.jsp?to=prodtester24");

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

        // driver2.findElement(By.name("Verify your account")).click();
        driver2.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Verify my account\"]")).click();

        FCV2.delete();

        Thread.sleep(5000);

        // End login process to get validation code

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

        Thread.sleep(3000);
        boolean nextButton =
                driver2.findElements(By.xpath("//XCUIElementTypeStaticText[@name=\"Next\"]")).size() > 0;
        if (nextButton) {
            driver2.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Next\"]")).click();
        } else { }

        // iOS alert for Allowing device/ad tracking
        Thread.sleep(3000);
        boolean allowButton =
                driver2.findElements(By.xpath("//XCUIElementTypeButton[@name=\"Allow\"]")).size() > 0;
        if (allowButton) {
            driver2.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Allow\"]")).click();
        } else { }

        // Close the onboarding...

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

        // Close the onboarding...

        driver2.quit();

    }
}
