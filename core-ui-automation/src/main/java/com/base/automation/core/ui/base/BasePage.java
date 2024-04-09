package com.base.automation.core.ui.base;

import com.base.automation.core.ui.enviroment.EnvironmentManager;
import com.base.automation.core.ui.webdrivers.WebDriverActions;
import com.base.automation.core.ui.webdrivers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected final WebDriver driver;
    protected final WebDriverWait wait;
    protected final EnvironmentManager environmentManager;

    protected final WebDriverActions action;

    public BasePage() {
        environmentManager = EnvironmentManager.getInstance();
        WebDriverManager webDriverManager = WebDriverManager.getInstance();
        driver = webDriverManager.getWebDriver();
        wait = webDriverManager.getWebDriverWait();
        action = new WebDriverActions(driver, wait);
        PageFactory.initElements(driver, this);
    }
}
