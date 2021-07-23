package testmaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Calendar {
    @Test
    public void select_dynamic_date() {
        System.setProperty("webdriver.chrome.driver","D:\\javap\\sample-demo\\demo-new\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.path2usa.com/travel-companions/");

        driver.findElement(By.id("travel_date")).click();

        List<WebElement> dates = driver.findElements(By.className("day"));

        for(WebElement date : dates) {
            System.out.println(date.getText());
            if (date.getText().equals("23")) {
                date.click();
                break;
            }
        }
    }

}
