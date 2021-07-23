package testmaven;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class HandleCert {

    @Test
    public void click_accept_cert() throws IOException {

        //general config
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.acceptInsecureCerts();
        dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

        //uesd to set local browser setting
        ChromeOptions co = new ChromeOptions();
        co.merge(dc);

        System.setProperty("webdriver.chrome.driver","D:\\javap\\sample-demo\\demo-new\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(co);

        driver.manage().window().maximize();
        //driver.manage().deleteAllCookies();

        //delete session cookie
        //driver.manage().deleteCookieNamed("sessionKey");

        driver.get("https://www.google.com/");
        Date d = new Date();
        long time = d.getTime();

        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File("C:\\Users\\Admin\\screnshot"+time+".png"));
    }
}
