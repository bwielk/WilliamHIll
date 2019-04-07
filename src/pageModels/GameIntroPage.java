package pageModels;

import common.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GameIntroPage {

    private By gameHeader = By.cssSelector("#root > div > div.page.categories-list-page--home.categories-list-" +
                                            "page.categories-list-page--desktop.page--desktop > \" +\n" +
                                            "\"div.categories-list-page__content.page__content > div.tile-details > " +
                                            "div > div.tile-details__left-content > h2");
    private By playButton = By.xpath("//*[contains(text(), 'Play Now')]");
    private By loginPanel  = By.className("login-component__wrapper");

    public WebElement getGameTitleHeader(WebDriverWait wait){
        return Common.findWebElement(wait, this.gameHeader);
    }

    public void clickPlayButton(WebDriverWait wait){
        WebElement playButton = Common.findWebElement(wait, this.playButton);
        playButton.click();
    }

    public WebElement getLoginPanelIsDisplayed(WebDriverWait wait){
        return Common.findWebElement(wait, this.loginPanel);
    }
}
