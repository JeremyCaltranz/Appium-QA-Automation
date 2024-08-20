package pageObjects.iOS;


import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Chapter1VideoPage {

    public Chapter1VideoPage(IOSDriver driver2) {
        PageFactory.initElements(new AppiumFieldDecorator(driver2), this);
    }
//submit button
@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Play icon']")
    public WebElement submitting;

// driver2.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"Chapter 1\"])[2]").isDisplayed();
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Chapter 1\"])[2]")
    public WebElement studyhomepage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Creating Customer Relationships and Value through Marketing\"]")
    public WebElement chapter1heading;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Defining Economics \"]")
    public WebElement chapter1definingeconomics;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"CC\u2028OFF\"]")
    public WebElement chapter1ccoff;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"1x\"]")
    public WebElement chapter1speed1x;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Back\"]")
    public WebElement chapter1backbutton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tap images to view them in full screen.\"]")
    public WebElement summarypopup1;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Swipe left to keep going\"]")
    public WebElement summarypopup2;

}
