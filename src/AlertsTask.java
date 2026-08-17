import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsTask {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://anarabbas.com/labs/auto-lab");

        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );

        // Alerts & Modal bolmesini ac
        WebElement alertsModal = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(.,'Alerts & Modal')]")
                )
        );

        alertsModal.click();


        // 1. SIMPLE ALERT
        WebElement alertButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("alertBtn")
                )
        );

        alertButton.click();

        Alert simpleAlert = wait.until(
                ExpectedConditions.alertIsPresent()
        );

        System.out.println("Alert text: " + simpleAlert.getText());

        simpleAlert.accept();


        // 2. CONFIRM ALERT
        WebElement confirmButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("confirmBtn")
                )
        );

        confirmButton.click();

        Alert confirmAlert = wait.until(
                ExpectedConditions.alertIsPresent()
        );

        System.out.println("Confirm text: " + confirmAlert.getText());

        confirmAlert.dismiss();


        // 3. PROMPT ALERT
        WebElement promptButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("promptBtn")
                )
        );

        promptButton.click();

        Alert promptAlert = wait.until(
                ExpectedConditions.alertIsPresent()
        );

        System.out.println("Prompt text: " + promptAlert.getText());

        promptAlert.sendKeys("Shukur Huseynov");
        promptAlert.accept();


        // 4. HTML MODAL
        WebElement modalButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("openModal")
                )
        );

        modalButton.click();

        WebElement modalTitle = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[normalize-space()='Modal Pəncərə']")
                )
        );

        System.out.println("Modal text: " + modalTitle.getText());

        WebElement closeButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[normalize-space()='Bağla']")
                )
        );

        closeButton.click();

        driver.quit();
    }
}