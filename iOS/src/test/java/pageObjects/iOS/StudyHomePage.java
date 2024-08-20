package pageObjects.iOS;


import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class StudyHomePage {

    public StudyHomePage(IOSDriver driver2) {
        PageFactory.initElements(new AppiumFieldDecorator(driver2), this);
    }
//submit button
@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Play icon']")
    public WebElement submitting;

// Begin Login Onboarding Popups

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Chapter 1\"])[2]")
    public WebElement studyhomepage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Yes please\"]")
    public WebElement studyreminder;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Tap a card to get started...\"])")
    public WebElement onboarding1;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Or swipe it to the back of the deck for later\"])")
    public WebElement onboarding2;

    // Missing one here!!!
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Scroll down to skip to a different Chapter\"])")
    public WebElement scrollpopup;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Tap to scroll down to the selected chapter\"])")
    public WebElement onboarding3;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Tap to access your Titles\"])")
    public WebElement onboarding4;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Tap Prep for recommended exam prep materials\"])")
    public WebElement taptrackpop;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Use Search or Filters to refine your selection\"])")
    public WebElement onboardingSearch;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Tap Track to view your progress\"])")
    public WebElement onboardingProgress;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"See how far you’ve come, Improve your scores, and view your Awards & Bookmarks\"])")
    public WebElement onboarding5;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Tap the calendar to view your full activity history for the month\"])")
    public WebElement popupmessgecard;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Tap to access Settings like Dark Mode, Type Size, Account, and Help\"])")
    public WebElement onboarding6;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]")
    public WebElement okbutton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Get Started!\"]")
    public WebElement getstartedbutton;

// End Login Onboarding Popups

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"See how far you’ve come, or Improve your scores by taking a recommended Quiz\"])")
    public WebElement howfarcomepop;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"OK\"]")
    public WebElement okbuttonchapter1;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Switch books, change theme, or get help\"])")
    public WebElement switchbookspop;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Get Started!\"]")
    public WebElement getstartedpop;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Limits, Alternatives, and Choices\"])[5]")
    public WebElement chapter1limitsaltoverview;

    //Overview Prompts
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Tap to pause. Double tap on the left or right side " +
            "of the screen to skip.\"])")
    public WebElement overviewPromptOne;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Turn closed captions on, jump to a different " +
            "section, or change speed.\"])")
    public WebElement overviewPromptTwo;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Note: You can't skip forward past parts you haven't" +
            " watched yet.\"])")
    public WebElement overviewPromptThree;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Next\"])[2]")
    public WebElement chapter1playbutton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Questions can be single or multi choice." +
            ".\"]")
    public WebElement quizOnboardingOne;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tap to select your answers\"]")
    public WebElement quizOnboardingTwo;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Then swipe left for results.\"]")
    public WebElement quizOnboardingThree;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Limits, Alternatives, and Choices\"])[5]")
    public WebElement limitalternativeschoicessummary;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Creating Customer Relationships and Value through " +
            "Marketing\"]")
    public WebElement selectchapterone;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Summary\"])[1]")
    public WebElement selectsummarycard;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Overview\"])[1]")
    public WebElement selectoverviewcard;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Quiz\"])[1]")
    public WebElement selectquizcard;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Quiz\"])[2]")
    public WebElement quizchapter1;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Track Nav Icon\"]")
    public WebElement track;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"1 Card This Week\"]")
    public WebElement onecarddisplayed;
    
}
