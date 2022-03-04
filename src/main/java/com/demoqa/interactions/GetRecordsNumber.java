package com.demoqa.interactions;

import com.demoqa.userinterface.WebTablesUI;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import java.util.List;

import static com.demoqa.utils.SessionVariables.RECORDS_NUMBER;


public class GetRecordsNumber implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElementFacade> listaBtnEliminar = WebTablesUI.BTNS_DELETE.resolveAllFor(actor);

        actor.remember(RECORDS_NUMBER.toString(),listaBtnEliminar.size());
    }

    public static GetRecordsNumber on(){
        return Instrumented.instanceOf(GetRecordsNumber.class).withProperties();
    }
}
