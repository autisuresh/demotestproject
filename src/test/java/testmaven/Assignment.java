package testmaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment {

    @Test
    public  void practice_page_assignment() {
        System.setProperty("webdriver.chrome.driver","D:\\javap\\sample-demo\\demo-new\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        WebElement cbox = driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[3]"));
        WebElement checkbox = cbox.findElement(By.id("checkBoxOption3"));
        checkbox.click();
        String checkboxtext = cbox.getText();

        Select select = new Select(driver.findElement(By.id("dropdown-class-example")));
        select.selectByVisibleText(checkboxtext);

        driver.findElement(By.id("name")).sendKeys(checkboxtext);
        driver.findElement(By.id("alertbtn")).click();

        String alertText = driver.switchTo().alert().getText();
        Assert.assertTrue(alertText.contains(checkboxtext));

        driver.switchTo().alert().accept();
        driver.close();
    }
}
