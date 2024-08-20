package pageObjects.iOS;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(IOSDriver driver2) {
        PageFactory.initElements(new AppiumFieldDecorator(driver2), this);
    }

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Next\"]")
    public WebElement submitting;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"landingPageLoginButton\"]")
    public WebElement loginLink;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"landingPageCreateAccountButton\"]")
    public WebElement createLink;

    @iOSXCUITFindBy(xpath ="//XCUIElementTypeTextField[@name=\"createAccountEmailTextField\"]")
    public WebElement email;

}
