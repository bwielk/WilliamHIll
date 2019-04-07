package common;

import net.bytebuddy.dynamic.scaffold.TypeInitializer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.NoSuchElementException;

public class Common {

    public static void printDetailsOfAllChildElementsFromAnElement(WebDriverWait wait, By parameterParent, By parameterChild){
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

    public static WebElement findWebElement(WebDriverWait wait, By selector){
        WebElement element = null;
        try{
            element = wait.until(ExpectedConditions.presenceOfElementLocated(selector));
        }catch(NoSuchElementException e){
            System.out.println(e);
        }
        return element;
    }

    public static List<WebElement> findWebElements(WebDriverWait wait, By selector){
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selector));
    }

    public static void closeTheCookieDisclaimer(WebDriverWait wait){
        try {
            WebElement cookies = wait.until(ExpectedConditions.presenceOfElementLocated
                    (By.className("cookie-disclaimer__button")));
            cookies.click();
            Thread.sleep(2000);
        } catch (NoSuchElementException e) {
            System.out.println("Cookie disclaimer hasn't showed up");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
