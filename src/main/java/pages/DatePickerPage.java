package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DatePickerPage extends BasePage {

    // Date Picker menyusunu açmaq üçün locator
    private final By datePickerMenu =
            By.xpath("//button[normalize-space()='Date Picker']");


    // HTML:
    // <input id="datePicker" type="date">
    private final By datePicker =
            By.id("datePicker");


    // HTML:
    // <b id="dateValue">yoxdur</b>
    //
    // Seçilmiş tarix burada göstərilir
    private final By dateValue =
            By.id("dateValue");


    // HTML:
    // <input id="dateTimePicker" type="datetime-local">
    private final By dateTimePicker =
            By.id("dateTimePicker");


    // HTML:
    // <b id="dateTimeValue">yoxdur</b>
    //
    // Seçilmiş tarix və saat burada göstərilir
    private final By dateTimeValue =
            By.id("dateTimeValue");


    // Constructor
    public DatePickerPage(WebDriver driver) {

        // BasePage constructor-a driver göndəririk
        super(driver);
    }


    // Saytı açır və Date Picker bölməsinə keçir
    public void open() {

        driver.get(
                "https://anarabbas.com/labs/auto-lab"
        );

        click(datePickerMenu);
    }


    // Date input-a tarix daxil edir
    public void setDate(String date) {

        WebElement input =
                waitForVisible(datePicker);

        input.clear();

        input.sendKeys(date);
    }


    // Input-un öz value atributunu oxuyur
    //
    // Native date input browser daxilində
    // adətən YYYY-MM-DD formatında value saxlayır
    public String getDateInputValue() {

        return waitForVisible(datePicker)
                .getAttribute("value");
    }


    // Səhifənin aşağıda göstərdiyi tarixi oxuyur
    //
    // HTML:
    // <b id="dateValue">
    public String getDisplayedDate() {

        return waitForVisible(dateValue)
                .getText();
    }


    // Date + Time input-a dəyər daxil edir
    public void setDateTime(String dateTime) {

        WebElement input =
                waitForVisible(dateTimePicker);

        input.clear();

        input.sendKeys(dateTime);
    }


    // DateTime input-un value atributunu oxuyur
    public String getDateTimeInputValue() {

        return waitForVisible(dateTimePicker)
                .getAttribute("value");
    }


    // Aşağıda göstərilən Date + Time nəticəsini oxuyur
    public String getDisplayedDateTime() {

        return waitForVisible(dateTimeValue)
                .getText();
    }
}