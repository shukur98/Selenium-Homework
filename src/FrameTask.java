import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FrameTask {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://anarabbas.com/labs/auto-lab");

        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );

        // iFrame bolmesini ac
        WebElement iframeSection = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(.,'iFrame')]")
                )
        );

        iframeSection.click();


        // 1. Esas frame-e kec
        wait.until(
                ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                        By.id("demoFrame")
                )
        );


        // Frame daxilindeki input-a yaz
        WebElement frameInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("frameInput")
                )
        );

        frameInput.sendKeys("Shukur Huseynov");


        // Frame daxilindeki duymeye klik et
        WebElement frameButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("frameBtn")
                )
        );

        frameButton.click();


        // 2. Nested frame-e kec
        wait.until(
                ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                        By.id("innerFrame")
                )
        );


        // Nested frame daxilindeki duymeye klik et
        WebElement innerFrameButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("innerFrameBtn")
                )
        );

        innerFrameButton.click();


        // Birbasa esas sehifeye qayit
        driver.switchTo().defaultContent();


        // Esas sehifeye qayitdigimizi subut et
        WebElement mainPageElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h3[normalize-space()='iFrame']")
                )
        );

        System.out.println(
                "Main page element text: " + mainPageElement.getText()
        );


        driver.quit();
    }
}