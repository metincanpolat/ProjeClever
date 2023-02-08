package StepDefinitions;

import Pages.DialogContent;
import Pages.Parent;
import Utilities.ExcelUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;

public class _02_LoginSteps extends Parent {

    DialogContent dc=new DialogContent();

    @And("Navigate to Login Page")
    public void navigateToLoginPage() {
        dc.findAndClick("signIn");
    }

//    @When("Enter email as {string} and password as {string}and click Sign in button")
//    public void enterEmailAsAndPasswordAsAndClickSignInButton(String email, String password) {
//    dc.findAndSend("email",email);
//    dc.findAndSend("password",password);
//    dc.findAndClick("SignInRegistered");
//
//    }
    @When("{string} Enter email as {string} and password as {string}and click Sign in button")
    public void enterEmailAsAndPasswordAsAndClickSignInButton(String arg1, String email, String password) {
        System.out.println("Trying "+arg1+" to login");
        dc.findAndSend("email",email);
        dc.findAndSend("password",password);
        dc.findAndClick("SignInRegistered");

    }

    @Then("User should NOT be able to login successfully")
    public void userShouldNOTBeAbleToLoginSuccessfully() {
        dc.findAndContainsText("errorText","error");
        System.out.println("Login failed");

    }

    @When("Enter email and password and click Sign in button")
    public void enterEmailAndPasswordAndClickSignInButton() {
        System.out.println("Trying valid email address and valid password to login");
        dc.findAndSend("email","abc@metcan.com");
        dc.findAndSend("password","123-456");
        dc.findAndClick("SignInRegistered");
    }
    @Then("User should be able to login successfully")
    public void userShouldBeAbleToLoginSuccessfully() {
        dc.findAndContainsText("welcomeText","Welcome");
        System.out.println("Successful login");

    }

    @When("Enter email and password and click Sign in button with Excel")
    public void enterEmailAndPasswordAndClickSignInButtonWithExcel() {

        ArrayList<ArrayList<String>> table =
                ExcelUtility.getListData("src/test/java/ApachePOI/resource/ApacheExcel.xlsx","loginInfo",2);

        for (ArrayList<String> row : table) {
            dc.findAndSend("email", row.get(0));
            dc.findAndSend("password", row.get(1));
            dc.findAndClick("SignInRegistered");
        }

    }


//
//    @When("Enter username as {string} and password as {string}and click Login button")
//    public void enterUsernameAsAndPasswordAsAndClickLoginButton(String username, String password) {
//
//        dc.findAndSend("username",username);
//        dc.findAndSend("password",password);
//        dc.findAndClick("loginButton");
//
//    }
//
//    @Then("User should login successfully")
//    public void userShouldLoginSuccessfully() {
//        dc.findAndContainsText("welcomeMessage","Welcome");
//    }
//
//    @When("User send valid Username and invalid Password and click login button")
//    public void userSendValidUsernameAndInvalidPasswordAndClickLoginButton(DataTable elements) {
//
//        List<List<String>> listElements = elements.asLists(String.class);
//
//        for (int i = 0; i < listElements.size(); i++) {
//            dc.findAndSend(listElements.get(i).get(0), listElements.get(i).get(1));
//        }
//        dc.findAndClick("loginButton");
//
//    }
//
//    @Then("User should not be able to login")
//    public void userShouldNotBeAbleToLogin() {
//        dc.findAndContainsText("errorMessage","incorrect");
//
//
//    }
//
//    @When("User send invalid Username and valid Password and click login button")
//    public void userSendInvalidUsernameAndValidPasswordAndClickLoginButton(DataTable elements) {
//
//        List<List<String>> listElements = elements.asLists(String.class);
//
//        for (int i = 0; i < listElements.size(); i++) {
//            dc.findAndSend(listElements.get(i).get(0), listElements.get(i).get(1));
//        }
//        dc.findAndClick("loginButton");
//
//    }


}
