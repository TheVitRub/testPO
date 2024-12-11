import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class MainClass {
    public static void main(String[] args) {
        String chromeDriverPath = "C:/Users/Ryabov/IdeaProjects/untitled1/drivers/chromedriver.exe";
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://supernatural-spn.net/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//i[class()='icon-person']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement loginField = driver.findElement(By.xpath("//input[@name='log']"));
        loginField.sendKeys("Логин_Лонгин"); //
        Assertions.assertEquals(loginField, driver.switchTo().activeElement());

        driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("Ключик_от_пароля");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//input[@id=\"dooplay_login_btn\"]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        try {
            WebElement captchaImage = driver.findElement(By.xpath("//img[@id='captcha']")); // Убедитесь, что ID соответствует
            Assertions.assertNotNull(captchaImage, "Вход пройден.");
        } catch (NoSuchElementException e) {
            System.out.println("Вход не пройден.");
        }

        driver.close();
    }
}
