package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Home {
    private SHAFT.GUI.WebDriver driver;
    private String url = "https://www.google.com/";
    private String title = "Google";
    private By searchBox = By.name("q");

    public Home(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    @Step("When I navigate to the Home page.")
    public Home navigate(){
        driver.browser().navigateToURL(url);
        return this;
    }

    @Step("Then the browser title should be 'Google'.")
    public Home verifyBrowserTitleIsCorrect(){
        driver.verifyThat().browser().title().isEqualTo(title).perform();
        return this;
    }

    @Step("And I search for '{query}'.")
    public Results searchForQuery(String query){
        driver.element().type(searchBox, query)
                .keyPress(searchBox, Keys.ENTER);
        return new Results(driver);
    }
}
