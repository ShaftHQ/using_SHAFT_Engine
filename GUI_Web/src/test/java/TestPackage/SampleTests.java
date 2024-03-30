package TestPackage;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Home;

public class SampleTests {
    private  SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;

    @Epic("SHAFT Web GUI Template")
    @Story("Google Basic Validations")
    @TmsLink("TC-001")
    @Description("Given I am on the Home page,\nThen the browser title should be 'Google'.")
    @Test(description = "Check that Home Page Title is correct.")
    public void checkHomePageTitleIsCorrect() {
        new Home(driver).verifyBrowserTitleIsCorrect();
    }

    @Epic("SHAFT Web GUI Template")
    @Story("Google Basic Validations")@TmsLink("TC-002")
    @Description("Given I am on the Home page,\nWhen I search for a valid query,\nThen the result stats will show some data (will not be empty).")
    @Test(description = "Check that Result Stats is not empty after searching for a query.")
    public void checkResultStatsIsNotEmptyAfterSearchingForAQuery() {
        new Home(driver).searchForQuery(testData.getTestData("searchQuery"))
                .assertResultStatsIsNotEmpty();
    }

    @BeforeClass(description = "Setup Test Data.")
    public void beforeClass(){
        testData = new SHAFT.TestData.JSON("simpleJSON.json");
    }

    @BeforeMethod(description = "Setup Browser instance.")
    public void beforeMethod() {
        driver = new SHAFT.GUI.WebDriver();
        new Home(driver).navigate();
    }

    @AfterMethod(description = "Teardown Browser instance.")
    public void afterMethod() {
        driver.quit();
    }
}
