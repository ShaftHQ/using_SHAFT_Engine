package orangeHRM;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
public class HomePage {

    private SHAFT.GUI.WebDriver driver;
    public HomePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private final By dropDownList = By.xpath("//span[@class='oxd-userdropdown-tab']");

    public HomePage clickDropDownList(String text){
        SelectDemoPage.select(dropDownList, text);
        return this;
    }
}
