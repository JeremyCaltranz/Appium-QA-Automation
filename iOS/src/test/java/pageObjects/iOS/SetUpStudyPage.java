package pageObjects.iOS;


import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SetUpStudyPage {

    public SetUpStudyPage(IOSDriver driver2) {
        PageFactory.initElements(new AppiumFieldDecorator(driver2), this);
    }
//submit button
@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Play icon']")
    public WebElement submitting;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"What are you studying?\"]")
    public WebElement setupbook;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Sharpen\"]/XCUIElementTypeWindow" +
            "/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther" +
            "/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther" +
            "/XCUIElementTypeTextField")
    public WebElement filterMarketing;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Roger Kerin\"]")
    public WebElement setupbookmarketing;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Great!\"]")
    public WebElement greatmessage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Now let's set a study goal\"]")
    public WebElement setstudygoalmessage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"What are your study goals?\"]")
    public WebElement studygoalpage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Select at least one goal\"]")
    public WebElement selectkeygoalmessage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"When do you study best?\"]")
    public WebElement studybestmessage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Learn the basics\"]")
    public WebElement learnbasics;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Master chapter contents\"]")
    public WebElement masterchaptercontents;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Prepare with confidence\"]")
    public WebElement prepareconfidence;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Study for an exam\"]")
    public WebElement studyforexam;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Practice what I learned\"]")
    public WebElement practicelearned;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Train your brain\"]")
    public WebElement trainbrain;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"I'm not sure\"]")
    public WebElement notsure;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Just get started\"]")
    public WebElement justgetstarted;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Smart!\"]")
    public WebElement smartmessage;

    //When do you study best page

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"When do you study best?\"]")
    public WebElement studybestpage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"When’s your focus time?\"]")
    public WebElement whenfocustimemessage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Let’s see when you study best\"]")
    public WebElement seewhenyoustudybestmessage;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"In the morning\"]")
    public WebElement inmorning;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Before School\"]")
    public WebElement beforeschool;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"In the afternoon\"]")
    public WebElement inafternoon;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"During break\"]")
    public WebElement duringbreak;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"In the evening\"]")
    public WebElement inevening;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"After School\"]")
    public WebElement afterschool;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Late night\"]")
    public WebElement latenight;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Before bed\"]")
    public WebElement beforebed;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Ok, you’re a morning person!\"]")
    public WebElement morningpersonmessage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Let’s build your plan\"]")
    public WebElement buildplanmessage;

    // User Onboarding Experience Survey


}
