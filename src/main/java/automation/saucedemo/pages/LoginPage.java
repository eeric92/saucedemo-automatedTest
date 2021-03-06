package automation.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    private String baseURL = "https://www.saucedemo.com/index.html";

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPage goToThePage() {
        driver.get(baseURL);
        return this;
    }

    public void login(String userName, String password) {
        waitVisibility(loginButton);
        writeText(userNameInput, userName);
        writeText(passwordInput, password);
        loginButton.click();
    }

    public String validateLoginPage() {
        return exists(loginButton);
    }
}
