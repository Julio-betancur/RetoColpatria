package com.demoqa.stepdefinitions;

import com.demoqa.questions.ConfirmResult;
import com.demoqa.tasks.InteractWithAlerts;
import com.demoqa.userinterface.AlertsUI;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;


public class AbrirCerrarAlertasStepDefinitions {

    @Managed(driver = "chrome")
    private WebDriver webDriver;

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());

        OnStage.theActorCalled("Maria").can(BrowseTheWeb.with(webDriver));
    }

    @When("^She interacts with the different alerts types$")
    public void sheInteractsWithTheDifferentAlertsTypes() {
        OnStage.theActorInTheSpotlight().attemptsTo(InteractWithAlerts.on());
    }


    @Then("^she should see a text displayed by the alerts$")
    public void sheShouldSeeATextDisplayedByTheAlerts() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat( ConfirmResult.of(AlertsUI.LBL_CONFIRM_RESULT), Matchers.equalTo("You selected Ok")));
    }
}
