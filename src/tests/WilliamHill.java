package tests;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.Given;
import pageModels.GameIntroPage;
import pageModels.VegasHomePage;
import pageModels.VegasResultsPage;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WilliamHill {

    private WebDriver driver;
    private WebDriverWait wait;
    private VegasHomePage vegasHomePage;
    private VegasResultsPage vegasResultsPage;
    private GameIntroPage gameIntroPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://vegas.williamhill.com/");
        wait = new WebDriverWait(driver, 20);
        vegasHomePage = new VegasHomePage();
        vegasResultsPage = new VegasResultsPage();
        gameIntroPage = new GameIntroPage();
    }

    @Given("^user has navigated to William Hill Vegas$")
    public void navigateToPage() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertEquals(driver.getTitle(), vegasHomePage.getPageTitle());
    }

    @When("^searching for ([^\\\"]*)$")
    public void searchForGame(String gameName) throws InterruptedException {
        vegasHomePage.conductGameSearch(wait, gameName);
        Thread.sleep(3000);
        List<WebElement> results = vegasResultsPage.getResultsSections(wait);
        WebElement desiredGameWidget = vegasResultsPage.extractASpecificGameWidget(wait, gameName);
        Assert.assertNotNull(desiredGameWidget);
        Assert.assertTrue(results.size() > 0);
    }

    @Then("details of ([^\\\"]*) are shown after hovering on the widget")
    public void displayGameDetails(String gameName) throws InterruptedException {
        WebElement gameNameWidget = vegasResultsPage.extractASpecificGameWidget(wait, gameName);
        vegasResultsPage.hoverOverAGameWidget(driver, gameNameWidget);
        vegasResultsPage.showMoreDetailsOnAGame(wait);
        WebElement details = gameIntroPage.getDetailsTile(wait);
        WebElement gameHeader = gameIntroPage.getGameTitleHeader(wait);
        Assert.assertNotNull(details);
        Assert.assertEquals(gameHeader.getText(), gameName);
    }

    @When("Play Now button is clicked")
    public void playNowIsClicked(){

    }
}
