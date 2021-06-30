package testmaven;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {

    private static WebDriver driver;

    @Test()
    public void static_select_test() {

        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

        Select select = new Select(staticDropdown);

        select.selectByIndex(3);
        select.getFirstSelectedOption().getText();
        assert select.getFirstSelectedOption().getText().equals("USD");

        select.selectByValue("INR");
        select.getFirstSelectedOption().getText();
        assert select.getFirstSelectedOption().getText().equals("INR");

        System.out.println("static_select_test");
    }

    @Test()
    public void updated_dropdown_test() throws InterruptedException {

        WebElement updatedDropdown = driver.findElement(By.id("divpaxinfo"));

        updatedDropdown.click();
        Thread.sleep(2000L);
        int i=1;
        while(i<5) {
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        assert updatedDropdown.getText().contentEquals("5 Adult");
        System.out.println("spicejet dropdown test");
    }

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver","D:\\javap\\sample-demo\\demo-new\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    @AfterClass
    public void cleanup() {
        driver.close();
    }
}
