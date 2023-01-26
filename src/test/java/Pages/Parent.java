package Pages;

import Utilities.GWD;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Parent {
    WebDriverWait waitAWhile = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
    public void sendKeysFunction(WebElement element, String value)
    {
        waitUntilVisible(element); // gözükene kadar bekle
        scrollToElement(element);  // elemente kadar scroll yap
        element.clear(); // kutuyu temizle
        element.sendKeys(value); // değeri gönder

    }

    public void clickFunction(WebElement element)
    {
        waitAWhile.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loading-mask']")));

        moveToElement(element);

        waitUntilVisible(element);
        waitUntilClickable(element);
        scrollToElement(element);  // elemente kadar scroll yap
        element.click();
    }
    public void waitUntilVisible(WebElement element)
    {
        waitAWhile.until(ExpectedConditions.visibilityOf(element));
    }
    public void scrollToElement(WebElement element)
    {
        JavascriptExecutor js=(JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();",element);
    }
    public void waitUntilClickable(WebElement element)
    {
        //waitAWhile.until(ExpectedConditions.visibilityOf(element));
//        Duration dr=Duration.ofSeconds(20);
//        GWD.getDriver().manage().timeouts().implicitlyWait(dr);
        waitAWhile.until(ExpectedConditions.elementToBeClickable(element));

    }
    public void verifyContainsTextFunction(WebElement element,String value)
    {
        waitAWhile.until(ExpectedConditions.textToBePresentInElement(element,value));
        Assert.assertTrue(element.getText().toLowerCase().contains(value.toLowerCase()),"The Text you search could NOT be find");
        //new Actions(GWD.getDriver()).sendKeys(Keys.ESCAPE).perform();

    }
    public void verifyProductName(WebElement element)
    {
        System.out.println(productName);
        verifyContainsTextFunction(element,productName);
    }

    public void waitUntilLoading()
    {
        waitAWhile.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("fuse-progress-bar > *"), 0));
        // progressbar ın çocukları


    }
    public String title;
    public void moveToElement(WebElement element)
    {
        scrollToElement(element);
        new Actions(GWD.getDriver()).moveToElement(element).perform();

    }

    public void checkTheList(List<WebElement> elements,String text)
    {
        waitAWhile.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("[class='product-image-wrapper']>img"),0));

        Boolean success=false;
        for (WebElement e : elements) {
            if (e.getAttribute("title").contains(text)){
                success=true;
                break;
            }
        }
        if (!success)
            Assert.fail("the product is not in the shopping cart");

    }

    public void randomClickTheList(List<WebElement> elements)
    {
        //waitAWhile.until(ExpectedConditions.(By.cssSelector("[class='products list items product-items']>li"),0));

        int randomNum=(int) (Math.random()*elements.size());

        clickFunction(elements.get(randomNum));

    }

    String productName;
    public void randomMoveAndClickToElementInList(List<WebElement> elements,List<WebElement> elements2,List<WebElement> elements3)
    {

        int randomNum=(int) (Math.random()*elements.size());

        moveToElement(elements.get(randomNum));
        productName= elements3.get(randomNum).getText();
        System.out.println("2. "+productName);
        clickFunction(elements2.get(randomNum));
    }

}
