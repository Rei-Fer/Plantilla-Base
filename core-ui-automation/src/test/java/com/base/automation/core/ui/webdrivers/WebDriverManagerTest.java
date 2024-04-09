package com.base.automation.core.ui.webdrivers;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Web Driver Manager Test")
class WebDriverManagerTest {
    public static final String GOOGLE_URL = "https://www.google.com/";
    public static final String GOOGLE = "Google";

    public static final String TRELLO_URL = "https://www.trello.com/";

    private WebDriverManager webDriverManager;

    @BeforeEach
    void setup() {
        webDriverManager = WebDriverManager.getInstance();
    }

    @AfterEach
    void teardown() {
        if (webDriverManager.getWebDriver() != null) {
            webDriverManager.quitWebDriver();
        }
    }

    @Test
    @DisplayName("Verifies if WebDriver quit")
    @Tag("unittest")
    void quitWebDriver() {
        webDriverManager.quitWebDriver();

        assertNull(webDriverManager.getWebDriver());
    }

    @Test
    @DisplayName("Verifies if WebDriver is not null")
    @Tag("UnitTest")
    void getWebDriver() {
        assertNotNull(webDriverManager.getWebDriver());
    }

    @Test
    @DisplayName("Verifies if WebDriverWait is not null")
    @Tag("UnitTest")
    void getWebDriverWait() {
        assertNotNull(webDriverManager.getWebDriverWait());
    }

    @Test
    @DisplayName("Gets Current Page Title")
    @Tag("UnitTest")
    void getCurrentPageTitle() {
        webDriverManager.getWebDriver().navigate().to(GOOGLE_URL);
        assertEquals(webDriverManager.getCurrentPageTitle(), GOOGLE);
    }

    @Test
    @DisplayName("Searches in Google")
    @Tag("UnitTest")
    void searchesInGoogle() {
        // Go to Google page
        webDriverManager.getWebDriver().navigate().to(GOOGLE_URL);

        // Find Search TextBox WebElement
        WebElement searchTextBox = webDriverManager.getWebDriver().findElement(By.id("APjFqb"));

        // Wait WebElement
        webDriverManager.getWebDriverWait().until(ExpectedConditions.visibilityOf(searchTextBox));

        // Fill Search TextBox
        searchTextBox.sendKeys("DeltaX");

        // Find Search Button
        WebElement searchButton = webDriverManager.getWebDriver().findElement(By.name("btnK"));

        // Wait WebElement
        webDriverManager.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(searchButton));

        // Click on Search Button
        searchButton.click();

        // Assertions
        WebElement searchLink = webDriverManager.getWebDriver().findElement(By.xpath("//div[text()='DeltaX']"));
        System.out.println(searchLink.getText());
        Assertions.assertEquals("DeltaX", searchLink.getText());
    }

/*    @Test
    @DisplayName("Login Trello")
    @Tag("UnitTest")
    void loginTrello() {

        // Navigate to Trello home page
        webDriverManager.getWebDriver().navigate().to(TRELLO_URL);

        // Find Log in button

        WebElement loginButton = webDriverManager.getWebDriver().findElement(By.cssSelector("a[data-uuid='MJFtCCgVhXrVl7v9HA7EH_login']"));

        // Wait WebElement
        webDriverManager.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(loginButton));

        // Click on Log in Button
        loginButton.click();


        // Find Continue button
        WebElement ContinueButton = webDriverManager.getWebDriver().findElement(By.id("login-submit"));
        // Wait WebElement
        webDriverManager.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(ContinueButton));

        // Click on Log in Button
        ContinueButton.click();

        // Assertions
        WebElement errorLogin = webDriverManager.getWebDriver().findElement(By.id("username-uid2-error"));
        Assertions.assertEquals("Enter an email address", errorLogin.getText());

    }*/
}
