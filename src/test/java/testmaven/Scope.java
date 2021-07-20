package testmaven;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class Scope extends LoginTest{

    @Test
    public void getAllLinksCount() {
        System.setProperty("webdriver.chrome.driver","D:\\javap\\sample-demo\\demo-new\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> element = driver.findElements(By.tagName("a"));
        System.out.println(element.size());

        WebElement footer = driver.findElement(By.id("gf-BIG"));
        List<WebElement> foo_element = footer.findElements(By.tagName("a"));
        System.out.println(foo_element.size());

        WebElement first_column = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        List<WebElement> column = first_column.findElements(By.tagName("a"));
        System.out.println(column.size());

        for (int i=1; i<column.size();i++) {
            String clickOnlink = Keys.chord(Keys.CONTROL,Keys.ENTER);
            first_column.findElements(By.tagName("a")).get(i).sendKeys(clickOnlink);
        }

        Set<String> winhandles = driver.getWindowHandles();

        for(String obj : winhandles) {
            driver.switchTo().window(obj);
            System.out.println(driver.getTitle());
        }
//        Iterator<String> it = winhandles.iterator();
//        while(it.hasNext()) {
//            driver.switchTo().window(it.next());
//            System.out.println(driver.getTitle());
//        }

    }
}
