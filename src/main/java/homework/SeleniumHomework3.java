package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumHomework3 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

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


        // =========================
        // BUTTONS
        // =========================

        // Sol menyudakı Buttons düyməsini tap
        WebElement buttonsMenu =
                driver.findElement(
                        By.xpath(
                                "//nav[@id='pg-nav']//button[contains(.,'Buttons')]"
                        )
                );

        // Buttons bölməsini aç
        buttonsMenu.click();


        // Primary Click düyməsini tap
        WebElement primaryButton =
                driver.findElement(
                        By.id("clickBtn")
                );

        // Klik et
        primaryButton.click();


        // Nəticə mətnini tap
        WebElement buttonNote =
                driver.findElement(
                        By.id("btnNote")
                );


        // Nəticəni console-a çıxart
        System.out.println(
                "Primary Click nəticəsi: "
                        + buttonNote.getText()
        );


        // Disabled düyməni tap
        WebElement disabledButton =
                driver.findElement(
                        By.cssSelector(
                                "div.pg-panel[data-panel='btn'] button[disabled]"
                        )
                );


        // Aktiv olub-olmadığını yoxla
        System.out.println(
                "Disabled button aktivdir: "
                        + disabledButton.isEnabled()
        );


        driver.quit();
    }
}

