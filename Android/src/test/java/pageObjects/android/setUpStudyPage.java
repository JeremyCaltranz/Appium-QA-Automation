package pageObjects.android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class setUpStudyPage {

    public setUpStudyPage(AndroidDriver driver2) { PageFactory.initElements(new AppiumFieldDecorator(driver2), this);
    }

    // @AndroidFindBy(xpath = "//android.view.View[contains(@resource-id,'tag-1')]")
    // public WebElement textFieldOne;

    @AndroidFindBy(xpath = "//android.view.View[contains(@resource-id,'createAccountNextButton')]")
    public WebElement submitting;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Create Account\"]")
    public WebElement createaccount;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sign In\"]")
    public WebElement signin;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Email\"]")
    public WebElement email;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.EditText")
    public WebElement emailInput;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'com.android.chrome:id/url_bar')]")
    public WebElement urlBar;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Verify your account\"]")
    public WebElement verifyEmailLink;

    // Begin Login Onboarding Popups

    @AndroidFindBy(className = "android.widget.ProgressBar")
    public WebElement arrowButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"OK\"]")
    public WebElement okPopupButton;

    @AndroidFindBy(className = "android.widget.Button")
    public WebElement okbutton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"What are you studying?\"]")
    public WebElement setupbook;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.EditText")
    public WebElement filterMarketing;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Roger Kerin\"]")
    public WebElement setupbookmarketing;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"What are your study goals?\"]")
    public WebElement studygoalpage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Learn the basics\"]")
    public WebElement learnbasics;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"When do you study best?\"]")
    public WebElement studybestmessage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"In the morning\"]")
    public WebElement inthemorning;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Tap a card to get started, or swipe it to the back of deck\"]")
    public WebElement onboarding1;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Tap to access your Titles\"]")
    public WebElement onboarding2;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Tap to see other Chapters\"]")
    public WebElement onboarding3;

    // End Login Onboarding Popups


    // Overview Card

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Overview\"])")
    public WebElement selectoverviewcard;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[4]/android.view.View")
    public WebElement swipeoverviewcard;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Swipe left or right to move through segments\"])")
    public WebElement overviewPromptOne;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Tap the progress bar to Jump, toggle Captions, or change playback speed\"])")
    public WebElement overviewPromptTwo;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Bookmark and Share\"])")
    public WebElement overviewPromptThree;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Go back to the list of activities\"]")
    public WebElement chapter1backbutton;

    // Summary Cards

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Summary\"])")
    public WebElement selectsummarycard;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[4]/android.view.View")
    public WebElement swipesummarycard;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Swipe left or right to move through segments\"])")
    public WebElement summaryPromptOne;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Tap the progress bar to Jump ahead\"])")
    public WebElement summaryPromptTwo;


    // Quiz Card

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Quiz\"])")
    public WebElement selectquizcard;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Questions can be single, or multiple choice\"])")
    public WebElement quizPromptOne;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Tap to select your answers, then swipe to see which answers are correct\"])")
    public WebElement quizPromptTwo;

    // Quiz Answers

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"An organization should strive to satisfy the needs of " +
            "consumers and try to achieve the organization’s goals.\"]")
    public WebElement questionOneAnswer;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Product, price, promotion, place\"]")
    public WebElement questionTwoAnswer;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"discover the needs of prospective customers\"]")
    public WebElement questionThreeAnswer;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Processes for creating, communicating, delivering," +
            " and exchanging offerings that have value for customers\"]")
    public WebElement questionFourAnswer;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"brand equity\"]")
    public WebElement questionFiveWrongAnswer;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"customer value\"]")
    public WebElement questionFiveAnswer;

    // End Quiz Answers

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Take a Break. Back to chapter list.\"]")
    public WebElement takebreak;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Track\"]")
    public WebElement tracklink;

    // @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"CH 1 Quiz\"]")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View")
    public WebElement retakelink;

}
