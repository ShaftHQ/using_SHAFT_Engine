package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class Results {
    private SHAFT.GUI.WebDriver driver;
    private By resultStats = By.id("result-stats");

    public Results(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    @Step("Then the result stats will show some data (will not be empty).")
    public Results assertResultStatsIsNotEmpty(){
        driver.assertThat().element(resultStats).text().doesNotEqual("")
                .withCustomReportMessage("Check that result stats is not empty").perform();
        return this;
    }
}
