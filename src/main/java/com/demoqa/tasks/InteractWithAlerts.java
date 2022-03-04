package com.demoqa.tasks;

import com.demoqa.interactions.AcceptAlert;
import com.demoqa.interactions.EnterTextPrompt;
import com.demoqa.interactions.GetExcelData;
import com.demoqa.questions.ConfirmResult;
import com.demoqa.userinterface.AlertsFrameUI;
import com.demoqa.userinterface.AlertsUI;
import com.demoqa.userinterface.HomeUI;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;

import java.util.ArrayList;
import java.util.Map;

import static com.demoqa.userinterface.AlertsUI.LBL_PROMPT_RESULT;
import static com.demoqa.utils.SessionVariables.EXCEL_DATA;


public class InteractWithAlerts implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomeUI.BTN_ALERTS_FRAMES),
                Click.on(AlertsFrameUI.BTN_ALERTS),
                Click.on(AlertsUI.BTN_ALERT),
                AcceptAlert.on(),
                Click.on(AlertsUI.BTN_TIMER_ALERT),
                AcceptAlert.on(),
                Click.on(AlertsUI.BTN_CONFIRM_ALERT),
                AcceptAlert.on(),
                Click.on(AlertsUI.BTN_PROMPT),
                GetExcelData.from("Alert")
        );

        ArrayList<Map<String, String>> data = OnStage.theActorInTheSpotlight().recall(EXCEL_DATA.toString());

        actor.attemptsTo(
                EnterTextPrompt.text(data.get(0).get("nombre")),
                AcceptAlert.on()
        );

        actor.should(GivenWhenThen.seeThat( ConfirmResult.of(LBL_PROMPT_RESULT), Matchers.containsString(data.get(0).get("nombre"))));


    }

    public static InteractWithAlerts on() {
        return Instrumented.instanceOf(InteractWithAlerts.class).withProperties();
    }
}
