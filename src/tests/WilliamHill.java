package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class WilliamHill {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://vegas.williamhill.com/");
        wait = new WebDriverWait(driver, 20);
    }

    @Test
    public void searchForMayFairRoulette() throws InterruptedException {
        Thread.sleep(10000);
        WebElement magnifierButton = driver.findElement(By.className("btn-search-magnifier"));
        magnifierButton.click();
        String cssSelectorSearchInputField = "#root > div > div.sc-hMqMXs.koXVHj > div > input";
        WebElement gameSearchInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelectorSearchInputField)));
        gameSearchInput.sendKeys("Mayfair Roulette");
        String mayfairRouletteXPATH = "//img[@alt='Mayfair Roulette']";
        Thread.sleep(3000);
        WebElement mayfairRouletteWidget = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(mayfairRouletteXPATH)));
        Actions actions = new Actions(driver);
        Action moveOverTheTile = actions.moveToElement(mayfairRouletteWidget).build();
        moveOverTheTile.perform();
        WebElement moreButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("tile-menu__button--more")));
        moreButton.click();
        Thread.sleep(3000);
        String playButtonSelector = "#root > div > div.page.search.search--tablet.page--tablet > section > div.tile-details " +
                "> div > div.tile-details__left-content > div.tile-details__buttons > button.sc-EHOje.hGojEe";
        try {
            WebElement cookies = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("cookie-disclaimer__button")));
            cookies.click();
            Thread.sleep(2000);
        }catch(NoSuchElementException e){
            System.out.println("Cookie disclaimer hasn't showed up");
        }
        WebElement playButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'Play Now')]")));
//        List<WebElement> elementsInPanel = wait.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(By.className("tile-details__left-content"), By.tagName("button")));
//        for(int i=0; i< elementsInPanel.size(); i++){
//            WebElement currentElement = elementsInPanel.get(i);
//            System.out.println(currentElement.getText() + " " + currentElement.getLocation() + " " + currentElement.getTagName() +
//                    currentElement.getAttribute("class"));
//         }
        playButton.click();
        WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("login-component__wrapper")));
        Assert.assertNotNull(login);
    }
}
