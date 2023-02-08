package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class _03_AddToCartSteps {
    DialogContent dc=new DialogContent();


    @And("Add to cart a product")
    public void addToCartAProduct() {
        dc.findAndMoveToElement("womenTitle");
        dc.findAndClick("summerDresses");
        dc.findAndMoveAndClickToElementInList("productList","quickView","productName");
        GWD.getDriver().switchTo().frame(0);
        dc.findAndClick("addToCart");
        GWD.getDriver().switchTo().defaultContent();


        //dc.findAndContainsText("successShoppingText","successfully");


    }

    @Then("Check the shopping cart")
    public void checkTheShoppingCart() {

        dc.verifyContainsProductName("shoppingCartItemText");

    }
//
//    @Then("Success message should be displayed")
//    public void successMessageShouldBeDisplayed() {
//        dc.findAndContainsText("successMessage","added");
//    }
//
//    @And("Go to the shopping cart")
//    public void goToTheShoppingCart() {
//        dc.findAndClick("shoppingCart");
//        dc.findAndClick("checkout");
//    }
//
//    @Then("Check the shopping cart")
//    public void checkTheShoppingCart() {
//        dc.findAndContainsList("shoppingCartList");
//    }
//
//    @And("Proceed the checkout")
//    public void proceedTheCheckout() throws InterruptedException {
//
//        dc.findAndClick("zeroShipping");
//        dc.findAndClick("nextButton");
////        dc.findAndClick("orderSummeryTab");
////        dc.findAndClick("orderSummeryTab");
//        dc.findAndClick("placeOrder");
//
//    }
//
//    @Then("Complete the shopping")
//    public void completeTheShopping() {
//        dc.findAndContainsText("thankYouMessage","Thank");
//    }
}
