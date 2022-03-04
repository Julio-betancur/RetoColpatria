package com.demoqa.stepdefinitions;


import com.demoqa.questions.RecordsNumber;
import com.demoqa.tasks.AddUser;
import com.demoqa.tasks.DeleteUser;
import com.demoqa.tasks.OpenBrowserTask;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import java.io.IOException;


public class AgregarEliminarRegistroStepDefinitions {

    @Managed(driver = "chrome")
    private WebDriver webDriver;

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());

        OnStage.theActorCalled("Maria").can(BrowseTheWeb.with(webDriver));
    }

    @Given("^Maria goes to demoqa home page$")
    public void mariaGoesToDemoqaHomePage() {
        OnStage.theActorInTheSpotlight().attemptsTo(OpenBrowserTask.on());
    }

    @When("^she register a new persona with their credentials$")
    public void sheRegisterANewPersonaWithTheirCredentials() throws IOException {
        OnStage.theActorInTheSpotlight().attemptsTo(AddUser.withInformation());

    }

    @When("^she removes any record from the table$")
    public void sheRemovesAnyRecordFromTheTable() {
        OnStage.theActorInTheSpotlight().attemptsTo(DeleteUser.on());

    }

    @Then("^she should see that the record was deleted$")
    public void sheShouldSeeThatTheRecordWasDeleted() {

        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat("The number of records", RecordsNumber.value(),Matchers.equalTo("3")));
    }

}
