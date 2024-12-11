import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class mail {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Ryabov/IdeaProjects/untitled1/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
    }
}
