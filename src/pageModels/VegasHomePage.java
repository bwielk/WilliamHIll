package pageModels;

import org.openqa.selenium.By;
import common.Common;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VegasHomePage {

    private String pageTitle = "Play Vegas Games online today | William Hill";
    private By maginifierSearchFormButton = By.className("btn-search-magnifier");
    private By searchForm = By.xpath("#root > div > div.sc-hMqMXs.koXVHj > div > input");

    public String getPageTitle() {
        return pageTitle;
    }

    public void conductGameSearch(WebDriverWait wait, String searchPhrase){
        WebElement magnifierButton = Common.findWebElement(wait, maginifierSearchFormButton);
        magnifierButton.click();
        WebElement searchInput = Common.findWebElement(wait, searchForm);
        searchInput.sendKeys(searchPhrase);
    }
}
