package pageModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GameIntroPage {

    private By gamePanelWidgetXPATH;
    private String gameName;
    private WebDriver driver;

    public GameIntroPage(WebDriver driver, String gameName){
        this.driver = driver;
        this.gameName = gameName;
        this.gamePanelWidgetXPATH = By.xpath("//img[@alt='" + this.gameName + "']");
    }


}
