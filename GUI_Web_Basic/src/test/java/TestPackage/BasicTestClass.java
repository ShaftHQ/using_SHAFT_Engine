package TestPackage;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class BasicTestClass {
    SHAFT.GUI.WebDriver driver;
    
    @Test
    public void test() {
        driver.browser().navigateToURL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
         loginPage.login("Admin","admin123")
                .clickDropDownList("Support");
    }

    @BeforeClass
    public void beforeClass() {
        driver = new SHAFT.GUI.WebDriver();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
