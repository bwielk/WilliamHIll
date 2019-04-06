package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class WilliamHill {

    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement foundWebElement;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://vegas.williamhill.com/");
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void searchForMayFairRoulette() throws InterruptedException, AWTException {
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
        WebElement detailsPanel = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#root > div > div.page.categories-list-page--home.categories-list-page.categories-list-page--tablet.page--tablet > div.categories-list-page__content.page__content > div:nth-child(3) > ul > li:nth-child(2) > div > div > div > div.gc-tile__content")))
    }
}
