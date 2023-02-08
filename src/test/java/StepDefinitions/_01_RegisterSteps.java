package StepDefinitions;

import Pages.DialogContent;
import Pages.Parent;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class _01_RegisterSteps extends Parent {

    DialogContent dc=new DialogContent();


    @Given("Navigate to Clever")
    public void navigateToClever() {

        GWD.getDriver().get("https://cleverppc.com/prestashop4/");
        GWD.getDriver().manage().window().maximize();

    }


    @And("Navigate to Registration Page")
    public void navigateToRegistrationPage() {
        dc.findAndClick("signIn");
        dc.findAndSend("emailNew","abc@metcan.com");
        dc.findAndClick("createAnAccountBut");

    }


    @When("Enter user information")
    public void enterUserInformation(DataTable elements) {

        List<List<String>> listElements = elements.asLists(String.class);

        for (int i = 0; i < listElements.size(); i++) {
            dc.findAndSend(listElements.get(i).get(0), listElements.get(i).get(1));
        }
        dc.findAndClick("registerButton");
    }

    @Then("User should register successfully")
    public void userShouldRegisterSuccessfully() {
        dc.findAndContainsText("successText","created");
    }
}
