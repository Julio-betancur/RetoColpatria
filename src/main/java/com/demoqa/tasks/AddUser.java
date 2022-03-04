package com.demoqa.tasks;

import com.demoqa.interactions.GetExcelData;
import com.demoqa.userinterface.ElementsUI;
import com.demoqa.userinterface.HomeUI;
import com.demoqa.userinterface.WebTablesUI;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import java.util.ArrayList;
import java.util.Map;

import static com.demoqa.userinterface.WebTablesUI.LBL_FIRST_NAME;
import static com.demoqa.utils.SessionVariables.EXCEL_DATA;



public class AddUser implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomeUI.BTN_ELEMENTS),
                Click.on(ElementsUI.BTN_WEB_TABLES),
                Click.on(WebTablesUI.BTN_ADD),

                GetExcelData.from("Registro")
        );

        //Cargamos datos desde el excel
        ArrayList<Map<String, String>> data = OnStage.theActorInTheSpotlight().recall(EXCEL_DATA.toString());

        actor.attemptsTo(

                Enter.theValue(data.get(0).get("first_name")).into(WebTablesUI.TXT_FIRST_NAME),
                Enter.theValue(data.get(0).get("last_name")).into(WebTablesUI.TXT_LAST_NAME),
                Enter.theValue(data.get(0).get("email")).into(WebTablesUI.TXT_EMAIL),
                Enter.theValue(data.get(0).get("age")).into(WebTablesUI.TXT_AGE),
                Enter.theValue(data.get(0).get("salary")).into(WebTablesUI.TXT_SALARY),
                Enter.theValue(data.get(0).get("department")).into(WebTablesUI.TXT_DEPARTMENT),
                Click.on(WebTablesUI.BTN_SUBMIT)
        );
        actor.should(GivenWhenThen
                .seeThat(WebElementQuestion
                        .the(LBL_FIRST_NAME.of("")), WebElementStateMatchers
                        .containsText(data.get(0).get("first_name")))
        );

    }

    public static AddUser withInformation(){
        return Instrumented.instanceOf(AddUser.class).withProperties();
    }
}
