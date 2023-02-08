package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpNav extends Parent{

    public UpNav() {
        PageFactory.initElements(GWD.getDriver(),this);
    }

    @FindBy(xpath = "//span[text()='Men']")
    private WebElement men;




    WebElement myElement;

    public void findAndMoveToElement(String strElement)
    {
        switch (strElement)
        {
            case "men" : myElement=men;break;


        }

        moveToElement(myElement);

    }

    public void findAndClick(String strElement)
    {
        //element get : burada string isimden webelemente ulaşacağım
        switch (strElement)
        {



        }

        clickFunction(myElement);

//        if (myElement==bagAddToCart){
//            waitAWhile.until(ExpectedConditions.visibilityOf(bagLink));
//            productTitle=bagLink.getAttribute("title");}


    }


}
