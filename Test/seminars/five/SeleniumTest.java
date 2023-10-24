package seminars.five;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class SeleniumTest {


    @Test
    void seleniumTest() throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.google.com");
        WebElement webElement = webDriver.findElement(By.name("q"));
        webElement.sendKeys("Selenium");
        webElement.submit();
        WebElement seleniumElement = webDriver.findElement(By.tagName("cite"));

        assertThat(seleniumElement.getText()).isEqualTo("https://www.selenium.dev");

        Thread.sleep(1000);
        webDriver.quit();
    }

    @Test
    void autorizationTest() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.saucedemo.com");

        WebElement nameElement = webDriver.findElement(By.id("user-name"));
        nameElement.sendKeys("standard_user");
        WebElement passElement = webDriver.findElement(By.id("password"));
        passElement.sendKeys("secret_sauce");
        passElement.submit();

        WebElement citeElement = webDriver.findElement(By.className("title"));

        assertThat(citeElement.getText()).isEqualTo("Products");

        webDriver.quit();
    }

    @Test
    void seleniumTestVer2() throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.google.com");
        WebElement webElement = webDriver.findElement(By.name("q"));
        webElement.sendKeys("Selenium");
        webElement.submit();
        List<WebElement> seleniumElement = webDriver.findElements(By.cssSelector("div"));
        boolean f = false;
        for (WebElement element : seleniumElement) {
            if (element.getText().contains("https://www.selenium.dev")) {
                f = true;
                break;
            }
        }
        assertThat(f).isTrue();

        Thread.sleep(1000);
        webDriver.quit();
    }
}
