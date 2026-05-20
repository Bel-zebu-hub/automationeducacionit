import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Ingreso {
    public static void main(String[] args) {
        final boolean USER_CHROME_MANUAL = true;

        final String RUTA_CHROMEDRIVER_EXE = "drivers/chromedriver.exe";

        WebDriver driver;

        if (USER_CHROME_MANUAL){
            System.setProperty("webdriver.chrome.driver", RUTA_CHROMEDRIVER_EXE);
            driver = new ChromeDriver();
        }else{
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");
        driver.findElement(By.id("login2")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
        driver.findElement(By.id("loginusername")).sendKeys("usuario");
        driver.findElement(By.id("loginpassword")).sendKeys("contrasenia");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        driver.quit();
    }
}