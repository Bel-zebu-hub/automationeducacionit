import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistroTest {public static void main(String[] args) {
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
    driver.get("https://demo.guru99.com/test/newtours/");
    driver.findElement(By.name("userName")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.linkText("REGISTER")).click();
    driver.findElement(By.name("firstName")).sendKeys("agustin");
    driver.findElement(By.name("lastName")).sendKeys("galimberti");
    driver.findElement(By.name("phone")).sendKeys("123456789");
    driver.findElement(By.id("userName")).sendKeys("agustin@gmail.com");
    driver.findElement(By.name("address1")).sendKeys("calle 123");
    driver.findElement(By.name("city")).sendKeys("La Rioja");
    driver.findElement(By.name("state")).sendKeys("5300");

    WebElement comboBoxPais = driver.findElement(By.name("country"));
    Select cmbPais = new Select(comboBoxPais);
    cmbPais.selectByValue("ARGENTINA");

    driver.findElement(By.id("email")).sendKeys("agustingalimberti");
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("confirmPassword")).sendKeys("admin");
    driver.findElement(By.className("cb-close")).click();
    driver.findElement(By.name("submit")).click();
    driver.quit();

}
}
