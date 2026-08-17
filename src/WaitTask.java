import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitTask {
    public static void main (String[] args) {

WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://anarabbas.com/labs/auto-lab");
WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

//dynamics elements hissesini acsin.

WebElement dynamicsElements = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'Dynamic Elements')]")));

dynamicsElements.click();

//Gecikmis elementi gosteren duyme;

WebElement delayButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("delayBtn")))       ;

//Vaxti duymeye klik elemezden evvel baslayyiriq

        long startTime = System.currentTimeMillis();
        delayButton.click();

//Element Gorunene qeder Explicit Wait

WebElement delayedElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='delayed']")));

//Eleement gorunende vaxti gotururuk

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

 //Indide print eliyek neticeleri:
        System.out.println("Element text: " + delayedElement.getText());
        System.out.println("Element Goruldu: " + elapsedTime + " ms");

        driver.quit();

    }

}
