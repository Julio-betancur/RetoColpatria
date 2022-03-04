package com.demoqa.tasks;

import com.demoqa.interactions.GetExcelData;
import com.demoqa.userinterface.DatePickerUI;
import com.demoqa.userinterface.HomeUI;
import com.demoqa.userinterface.WidgetsUI;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.Map;

import static com.demoqa.utils.SessionVariables.EXCEL_DATA;

public class SelectDateWithoutTime implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomeUI.BTN_WIDGETS),
                Click.on(WidgetsUI.BTN_DATE_PICKER),
                GetExcelData.from("Fecha")
        );

        ArrayList<Map<String, String>> data = OnStage.theActorInTheSpotlight().recall(EXCEL_DATA.toString());

        actor.attemptsTo(
                Enter.theValue(data.get(0).get("fecha")).into(DatePickerUI.SELECT_DATE),
                Enter.theValue(Keys.ENTER).into(DatePickerUI.SELECT_DATE)
        );
    }

    public static SelectDateWithoutTime on(){
        return Instrumented.instanceOf(SelectDateWithoutTime.class).withProperties();
    }
}
