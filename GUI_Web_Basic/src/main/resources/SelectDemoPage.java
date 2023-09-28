package orangeHRM;

import com.shaft.driver.SHAFT;
import com.shaft.driver.internal.DriverFactoryHelper;
import com.shaft.gui.element.ElementActions;
import com.shaft.gui.element.internal.ElementActionsHelper;
import com.shaft.gui.element.internal.ElementInformation;
import com.shaft.tools.io.ReportManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectDemoPage {

    public static ElementActions select(By elementLocator, String valueOrVisibleText) {
        ElementInformation elementInformation = ElementInformation.fromList(ElementActionsHelper.
                identifyUniqueElement((WebDriver) DriverFactoryHelper.getDriver().get(), elementLocator));

        //To check for the Element if it contains the Select Tag + capture the actual Tag
        String elementHTML = elementInformation.getOuterHTML();
        String elementTagName = DriverFactoryHelper.getDriver().get().findElement(elementLocator).getTagName();

        //Temporary Solution to set the Condition to test the Logic
        boolean handleNonSelectDropDown = true;
        SHAFT.Properties.flags.set().skipTestsWithLinkedIssues(handleNonSelectDropDown);

        //The Implemented Logic
        if (!elementHTML.contains("<select")) {
            if(SHAFT.Properties.flags.skipTestsWithLinkedIssues()) {
                ElementActions.getInstance().click(elementLocator);
                ElementInformation elementInformation1 = ElementInformation.fromList(ElementActionsHelper.
                        identifyUniqueElement((WebDriver) DriverFactoryHelper.getDriver().get(), elementLocator));
                RelativeLocator.RelativeBy relativeBy = null;
                try {
                    relativeBy = SHAFT.GUI.Locator.hasAnyTagName().and().containsText(valueOrVisibleText).relativeBy().below(elementInformation1.getLocator());
                } catch (Exception e) {
                    ReportManager.logDiscrete("Cannot Find Element with the following Locator in the DropDown Options: " + By.xpath("//*[text()='" + valueOrVisibleText + "']"));
                    ElementActionsHelper.failAction((WebDriver) DriverFactoryHelper.getDriver().get(),
                            valueOrVisibleText, By.xpath("//*[text()='" + valueOrVisibleText + "']"), e);
                }
                ElementActions.getInstance().click(relativeBy);
            }
            else {
                ReportManager.logDiscrete("Cannot Find Element with the following Locator in the DropDown Options: " + By.xpath("//*[text()='" + valueOrVisibleText + "']"));
                ElementActionsHelper.failAction((WebDriver) DriverFactoryHelper.getDriver().get(),
                        "Select: " , valueOrVisibleText + "\" from Element : " +   " Tag should be <Select, yet it was found to be " + elementTagName,elementLocator,null);
            }

            //End of Implemented Logic Block
            //================================================================//

        } else {

            try {
                String elementName = ElementActionsHelper.getElementName((WebDriver) DriverFactoryHelper.getDriver().get(), elementLocator);
                if (!Boolean.TRUE.equals(ElementActionsHelper.waitForElementTextToBeNot((WebDriver) DriverFactoryHelper.getDriver().get(), elementLocator, ""))) {
                    ElementActionsHelper.failAction((WebDriver) DriverFactoryHelper.getDriver().get(), valueOrVisibleText, elementLocator, new Throwable[0]);
                }

                boolean isOptionFound = false;
                List<WebElement> availableOptionsList = (new Select((WebElement) ElementActionsHelper.identifyUniqueElement((WebDriver) DriverFactoryHelper.getDriver().get(), elementLocator).get(1))).getOptions();

                for (int i = 0; i < availableOptionsList.size(); ++i) {
                    String visibleText = ((WebElement) availableOptionsList.get(i)).getText();
                    String value = ((WebElement) availableOptionsList.get(i)).getAttribute("value");
                    if (visibleText.trim().equals(valueOrVisibleText) || value.trim().equals(valueOrVisibleText)) {
                        (new Select((WebElement) ElementActionsHelper.identifyUniqueElement((WebDriver) DriverFactoryHelper.getDriver().get(), elementLocator).get(1))).selectByIndex(i);
                        ElementActionsHelper.passAction((WebDriver) DriverFactoryHelper.getDriver().get(), elementLocator, Thread.currentThread().getStackTrace()[1].getMethodName(), valueOrVisibleText, (List) null, elementName);
                        isOptionFound = true;
                        break;
                    }
                }

                if (Boolean.FALSE.equals(isOptionFound)) {
                    throw new NoSuchElementException("Cannot locate option with Value or Visible text =" + valueOrVisibleText);
                }
            } catch (Throwable var9) {
                ElementActionsHelper.failAction((WebDriver) DriverFactoryHelper.getDriver().get(), valueOrVisibleText, elementLocator, new Throwable[]{var9});
            }

        }
        return ElementActions.getInstance();
    }
}
