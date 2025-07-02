package org.example.ecommerce;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductFormTest {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup(); // użyj ChromeDrivera

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        driver.get("http://127.0.0.1:3000");
    }

    @Test
    @Description("Testet das Hinzufügen eines Produkts über das React-Formular mit UI-Verifikation")
    void testAddProduct() {
        fillField("name", "Testprodukt");
        fillField("price", "9.99");
        clickSubmit();
        checkSuccessMessage(); // Überprüfung nach dem Absenden
    }

    @Step("Feld '{id}' wird mit dem Wert '{value}' ausgefüllt")
    void fillField(String id, String value) {
        WebElement input = driver.findElement(By.id(id));
        input.clear();
        input.sendKeys(value);
    }

    @Step("Der 'Submit'-Button wird geklickt")
    void clickSubmit() {
        WebElement button = driver.findElement(By.id("submit"));
        button.click();
    }

    @Step("Überprüfung: Erfolgsmeldung wird angezeigt")
    void checkSuccessMessage() {
        try {
            WebElement msg = driver.findElement(By.id("success"));
            assertTrue(msg.isDisplayed(), "Erfolgsmeldung wird nicht angezeigt");
        } catch (NoSuchElementException e) {
            Allure.addAttachment("Fehler", "Erfolgsmeldung wurde nicht gefunden");
            Assertions.fail("Element mit id='success' wurde nicht gefunden");
        }
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

//Proof
