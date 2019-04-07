package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class Common {

    private static WebDriverWait wait;

    public Common(WebDriverWait wait){
        this.wait = wait;
    }

    public static void printDetailsOfAllChildElementsFromAnElement(By parameterParent, By parameterChild){
//        List<WebElement> elementsInPanel = this.wait.until(ExpectedConditions.presenceOfNestedElementsLocatedBy
//                (By.className("tile-details__left-content"), By.tagName("button")));//
        List<WebElement> elementsInPanel = wait.until(ExpectedConditions.presenceOfNestedElementsLocatedBy
            (parameterParent, parameterChild));
        for(int i=0; i< elementsInPanel.size(); i++){
            WebElement currentElement = elementsInPanel.get(i);
            System.out.println(currentElement.getText() +
                    " " + currentElement.getLocation() +
                    " " + currentElement.getTagName() +
                    " " + currentElement.getAttribute("class"));
         }
    }
}
