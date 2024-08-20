package pageObjects.iOS;


import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Chapter1Quiz {

    public Chapter1Quiz(IOSDriver driver2) {
        PageFactory.initElements(new AppiumFieldDecorator(driver2), this);
    }
//submit button
@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Play icon']")
    public WebElement submitting;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]")
    public WebElement okbutton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Processes for creating, communicating, delivering," +
            " and exchanging offerings that have value for customers\"]")
    public WebElement questionOneAnswer;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Product, price, promotion, place\"]")
    public WebElement questionTwoAnswer;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"discover the needs of prospective customers\"]")
    public WebElement questionThreeAnswer;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"customer value\"]")
    public WebElement questionFourAnswer;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Consumers will purchase any products that marketers " +
            "make available.\"]")
    public WebElement questionFiveWrongAnswer;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"An organization should strive to satisfy the needs " +
            "of consumers and try to achieve the organization’s goals.\"]")
    public WebElement questionFiveAnswer;

}
