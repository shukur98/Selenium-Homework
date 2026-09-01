package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DatePickerPage;

public class DatePickerTest extends BaseTest {


    // TEST 1
    // Tarix daxil edilir və səhifədə düzgün göstərildiyi yoxlanılır
    @Test
    public void verifyDateCanBeSelected() {

        // DatePickerPage object yaradırıq
        DatePickerPage datePickerPage =
                new DatePickerPage(driver);


        // Date Picker bölməsini açırıq
        datePickerPage.open();


        /*
         * Native date input-a tarix daxil edirik.
         *
         * Səhifənin öz Selenium nümunəsində də
         * sendKeys ilə tarix daxil etmək göstərilir.
         */
        datePickerPage.setDate(
                "08/25/2026"
        );


        // Input-un browser-də saxladığı real value
        String inputValue =
                datePickerPage.getDateInputValue();


        // Səhifənin aşağıda göstərdiyi value
        String displayedValue =
                datePickerPage.getDisplayedDate();


        // Input-da olan tarix ilə
        // səhifədə göstərilən tarix eyni olmalıdır
        Assert.assertEquals(
                displayedValue,
                inputValue,
                "Seçilmiş tarix səhifədə düzgün göstərilmədi!"
        );
    }


    // TEST 2
    // Tarix + saat daxil edilir və səhifədə yoxlanılır
    @Test
    public void verifyDateTimeCanBeSelected() {

        DatePickerPage datePickerPage =
                new DatePickerPage(driver);

        datePickerPage.open();


        /*
         * datetime-local native browser elementidir.
         *
         * Chrome-da input formatı sistem/browser
         * formatından asılı ola bilər.
         *
         * Ona görə input-un öz real value-sunu
         * aşağıda göstərilən value ilə müqayisə edirik.
         */
        datePickerPage.setDateTime(
                "08/25/2026 02:30PM"
        );


        String inputValue =
                datePickerPage
                        .getDateTimeInputValue();


        String displayedValue =
                datePickerPage
                        .getDisplayedDateTime();


        Assert.assertEquals(
                displayedValue,
                inputValue,
                "Seçilmiş tarix və saat səhifədə düzgün göstərilmədi!"
        );
    }
}