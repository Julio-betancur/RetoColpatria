package com.demoqa.stepdefinitions;

import com.demoqa.questions.DateWithTime;
import com.demoqa.tasks.SelectDateWithTime;
import com.demoqa.tasks.SelectDateWithoutTime;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import static com.demoqa.utils.SessionVariables.DATE_SELECTED;

public class SeleccionarFechaStepDefinitions {

    @Managed(driver = "chrome")
    private WebDriver webDriver;

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());

        OnStage.theActorCalled("Maria").can(BrowseTheWeb.with(webDriver));
    }

    @When("^she select a date without time$")
    public void sheSelectADateWithoutTime() {
        OnStage.theActorInTheSpotlight().attemptsTo(SelectDateWithoutTime.on());
    }


    @When("^she select a date with time$")
    public void sheSelectADateWithTime() {
        OnStage.theActorInTheSpotlight().attemptsTo(SelectDateWithTime.on());
    }

    @Then("^she should see that the dates are displayed$")
    public void sheShouldSeeThatTheDatesAreDisplayed() {
        String date = "\uE000" + OnStage.theActorInTheSpotlight().recall(DATE_SELECTED.toString());
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat("The date selected", DateWithTime.value(), Matchers.equalTo(date)));

    }
}
