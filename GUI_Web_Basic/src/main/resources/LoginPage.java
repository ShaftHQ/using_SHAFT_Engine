package orangeHRM;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class LoginPage {

    SHAFT.GUI.WebDriver driver;
    public LoginPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    private final By userNameField = By.name("username");
    private final By passwordField = By.name("password");
    private final By loginBtn = By.tagName("button");
    public HomePage login(String userName, String password){
        fillLoginInfo(userName, password).clickLoginBtn();
        return new HomePage(driver);
    }

    public LoginPage fillLoginInfo(String userName, String password){
        driver.element().type(userNameField, userName);
        driver.element().type(passwordField, password);
        return this;
    }

    public LoginPage clickLoginBtn(){
        driver.element().click(loginBtn);
        return this;
    }
}
