package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DialogContent extends Parent{

    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(),this);
    }

    @FindBy(linkText = "Sign in")
    private WebElement signIn;

    @FindBy(id = "email_create")
    private WebElement emailNew;

    @FindBy(css = "[class='icon-user left']")
    private WebElement createAnAccountBut;

    @FindBy(id = "customer_firstname")
    private WebElement firstname;

    @FindBy(id = "customer_lastname")
    private WebElement lastname;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "submitAccount")
    private WebElement registerButton;

    @FindBy(css = "[class='alert alert-success']")
    private WebElement successText;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(css = "[class='icon-lock left']")
    private WebElement SignInRegistered;

    @FindBy(css = "[class='alert alert-danger']>p")
    private WebElement errorText;

    @FindBy(className = "info-account")
    private WebElement welcomeText;

    @FindBy(css = "[class='sf-with-ul'][title='Women']")
    private WebElement womenTitle;

    @FindBy(linkText = "Summer Dresses")
    private WebElement summerDresses;

    @FindBy(css = "[id='product_list']>li")
    private List<WebElement> productList;

    @FindBy(xpath = "//span[text()='Quick view']")
    private List<WebElement> quickView;

    @FindBy(css = "[id='layer_cart']")
    private WebElement successShoppingText;

    @FindBy(xpath = "//button[@class='exclusive']/span")
    private WebElement addToCart;

    @FindBy(xpath = "(//p[@class='product-name']//a)[2]")
    private WebElement shoppingCartItemText;

    @FindBy(css = "a[class='product-name']")
    private List<WebElement> productName;







    WebElement myElement;
    List<WebElement> myElements;
    List<WebElement> myElements2;
    List<WebElement> myElements3;
    String productTitle;

    public void findAndSend(String strElement,String value)
    {
        //element get : burada string isimden webelemente ulaşacağım
        switch (strElement)
        {
            case "emailNew" : myElement=emailNew;break;
            case "firstname" : myElement=firstname;break;
            case "lastname" : myElement=lastname;break;
            case "password" : myElement=password;break;
            case "email" : myElement=email;break;


        }
        sendKeysFunction(myElement,value);

    }
    public void findAndClick(String strElement)
    {
        //element get : burada string isimden webelemente ulaşacağım
        switch (strElement)
        {
            case "signIn" : myElement=signIn;break;
            case "createAnAccountBut" : myElement=createAnAccountBut;break;
            case "registerButton" : myElement=registerButton;break;
            case "SignInRegistered" : myElement=SignInRegistered;break;
            case "summerDresses" : myElement=summerDresses;break;
            case "addToCart" : myElement=addToCart;break;


        }
        clickFunction(myElement);

    }
    public void findAndContainsText(String strElement, String text)
    {

        switch (strElement)
        {
            case "successText" : myElement=successText;break;
            case "errorText" : myElement=errorText;break;
            case "welcomeText" : myElement=welcomeText;break;
            case "successShoppingText" : myElement=successShoppingText;break;


        }

        verifyContainsTextFunction(myElement,text);

    }
    public void findAndContainsList(String strElement)
    {

        switch (strElement)
        {
            //case "shoppingCartList" : myElements=shoppingCartList;break;

        }

        checkTheList(myElements,productTitle);

    }

    public void findAndMoveToElement(String strElement)
    {
        switch (strElement)
        {
            case "womenTitle" : myElement=womenTitle;break;

        }

        moveToElement(myElement);

    }
    public void findAndMoveAndClickToElementInList(String strElement,String element,String text)
    {
        switch (strElement)
        {
            case "productList" : myElements=productList;break;

        }
        switch (element)
        {
            case "quickView" : myElements2=quickView;break;

        }

        switch (text)
        {
            case "productName" : myElements3=productName;break;

        }

        randomMoveAndClickToElementInList(myElements,myElements2,myElements3);

    }

    public void verifyContainsProductName(String strElement)
    {
        switch (strElement)
        {
            case "shoppingCartItemText" : myElement=shoppingCartItemText;break;

        }
        verifyProductName(myElement);
    }




//    public void findAndDelete(String searchText)
//    {
//
//        findAndSend("nameSearch",searchText);
//        findAndClick("searchButton");
//        waitUntilLoading();
//        findAndContainsText("searchResultCell",searchText);
//        findAndClick("deleteIcon");
//        findAndClick("deleteButton");
//
//
//    }






}
