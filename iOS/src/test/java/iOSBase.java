import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;


public class iOSBase {

    public static IOSDriver IOSDesiredCapabilities() throws MalformedURLException {

        DesiredCapabilities cap2 = new DesiredCapabilities();

        // Comment these three lines out for AWS Device Farm Build

            cap2.setCapability(MobileCapabilityType.PLATFORM_VERSION, "16.4");
            cap2.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 14 Pro");
            cap2.setCapability(MobileCapabilityType.APP, "/Users/jeremycallahan/Documents/Redi-QA/iOS/Redi.app");

        // End of three lines out for AWS Device Farm Build

        cap2.setCapability(MobileCapabilityType.PLATFORM_NAME, "ios");
        cap2.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        cap2.setCapability("iosInstallPause","8000" );
        cap2.setCapability("showXcodeLog", true);
        cap2.setCapability("showIOSLog", true);
        cap2.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 500000);
        cap2.setCapability("commandTimeouts", "12000");

        IOSDriver driver2 = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap2);

        return driver2;

    }

}

