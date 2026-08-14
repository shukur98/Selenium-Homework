package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Clock;
import java.time.Duration;

public class SeleniumHomework3 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        Clock timeout;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://anarabbas.com/labs/auto-lab");


        // =========================
        // TEXT BOX
        // =========================

        WebElement fullName =
                driver.findElement(By.id("fullName"));

        fullName.clear();
        fullName.sendKeys("Selenium Student");


        WebElement email =
                driver.findElement(By.id("userEmail"));

        email.clear();
        email.sendKeys("selenium@test.az");


        WebElement password =
                driver.findElement(By.id("passField"));

        password.clear();
        password.sendKeys("Test12345");


        // Yazılan məlumatları yoxla

        System.out.println(
                "Full Name: "
                        + fullName.getAttribute("value")
        );

        System.out.println(
                "Email: "
                        + email.getAttribute("value")
        );

        System.out.println(
                "Password: "
                        + password.getAttribute("value")
        );



// BUTTONS
// =========================

// Soldakı Buttons kateqoriyasını tap
        WebElement buttonsMenu =
                driver.findElement(
                        By.cssSelector(
                                "#pg-nav button[data-p='btn']"
                        )
                );

// Buttons bölməsini aç
        buttonsMenu.click();


// Nəticə mesajının göstərildiyi element
        WebElement buttonNote =
                driver.findElement(By.id("btnNote"));


// -------------------------
// 1. PRIMARY CLICK
// -------------------------

        WebElement primaryButton =
                driver.findElement(By.id("clickBtn"));

        primaryButton.click();

        System.out.println(
                "Primary Click nəticəsi: "
                        + buttonNote.getText()
        );


// Actions obyekti
        Actions actions = new Actions(driver);



// 2. DOUBLE CLICK
// -------------------------

        WebElement doubleButton =
                driver.findElement(By.id("dblBtn"));

        actions
                .doubleClick(doubleButton)
                .perform();

        System.out.println(
                "Double Click nəticəsi: "
                        + buttonNote.getText()
        );


// -------------------------
// 3. RIGHT CLICK
// -------------------------

        WebElement rightButton =
                driver.findElement(By.id("rcBtn"));

        actions
                .contextClick(rightButton)
                .perform();

        System.out.println(
                "Right Click nəticəsi: "
                        + buttonNote.getText()
        );


// -------------------------
// 4. DISABLED
// -------------------------

        WebElement disabledButton =
                driver.findElement(
                        By.cssSelector(
                                "div.pg-panel[data-panel='btn'] button[disabled]"
                        )
                );

        System.out.println(
                "Disabled button aktivdir: "
                        + disabledButton.isEnabled()
        );

        driver.quit();
    }
}

