import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrimeraPrueba {

    @Test
    public void abrirGoogle() {
        WebDriverManager.chromedriver().setup(); // Configura el driver automáticamente
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");
        System.out.println("Título: " + driver.getTitle());

        driver.quit(); // Cierra el navegador
    }
}