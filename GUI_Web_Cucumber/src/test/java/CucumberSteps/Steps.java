package CucumberSteps;

import com.shaft.driver.SHAFT;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Home;
import pages.Results;

public class Steps {
    private SHAFT.GUI.WebDriver driver;

    /**
     * Requires the following setting in the cucumber.properties file to run
     * cucumber.glue=CucumberSteps
     */
    @Given("I Open the target browser")
    public void i_open_the_target_browser() {
        this.driver = new SHAFT.GUI.WebDriver();
    }

    @When("I Navigate to Google Homepage")
    public void i_navigate_to_google_homepage() {
        new Home(driver).navigate();
    }

    @When("I Search for {string}")
    public void i_search_for(String string) {
        new Home(driver).searchForQuery(string);
    }

    @Then("the result stats will show some data \\(will not be empty)")
    public void the_result_stats_will_show_some_data_will_not_be_empty() {
        new Results(driver).assertResultStatsIsNotEmpty();
    }
}
