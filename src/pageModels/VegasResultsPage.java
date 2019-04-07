package pageModels;

import common.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class VegasResultsPage {

    private By resultsSections = By.className("fixed-tiles-row fixed-tiles-row--desktop search__row");
    private By moreButton = By.className("tile-menu__button--more");

    public List<WebElement> getResultsSections(WebDriverWait wait) {
        return Common.findWebElements(wait, this.resultsSections);
    }

    public WebElement extractASpecificGameWidget(WebDriverWait wait, String gameName) {
        String xpathOfGameWidget = "//img[@alt=" + gameName + "']";
        if (getResultsSections(wait).isEmpty()) {
            throw new NoSuchElementException("Results sections are not displayed");
        } else {
            return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathOfGameWidget)));
        }
    }

    public void hoverOverAGameWidget(WebDriver driver, WebElement gameWidget){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Actions actions = new Actions(driver);
        Action moveOverTheTile = actions.moveToElement(gameWidget).build();
        moveOverTheTile.perform();
    }

    public void showMoreDetailsOnAGame(WebDriverWait wait){
        WebElement moreButton = wait.until(ExpectedConditions.presenceOfElementLocated(this.moreButton));
        moreButton.click();
    }
}
