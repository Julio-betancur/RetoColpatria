package com.demoqa.tasks;

import com.demoqa.interactions.GetExcelData;
import com.demoqa.userinterface.DatePickerUI;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.ArrayList;
import java.util.Map;

import static com.demoqa.utils.SessionVariables.*;

public class SelectDateWithTime implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                GetExcelData.from("Fecha")
        );

        ArrayList<Map<String, String>> data = OnStage.theActorInTheSpotlight().recall(EXCEL_DATA.toString());
        //Recuerda la fecha seleccionada
        actor.remember(DATE_SELECTED.toString(),data.get(0).get("fecha_y_hora"));

        actor.attemptsTo(
                Enter.theValue(data.get(0).get("fecha_y_hora")).into(DatePickerUI.SELECT_DATE_TIME)
        );
    }

    public static SelectDateWithTime on(){
        return Instrumented.instanceOf(SelectDateWithTime.class).withProperties();
    }
}
