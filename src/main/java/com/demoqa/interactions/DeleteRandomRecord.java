package com.demoqa.interactions;


import com.demoqa.userinterface.WebTablesUI;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import java.util.List;
import java.util.Random;


public class DeleteRandomRecord implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {


        Random random = new Random();
        //Creamos dos listas con WebElements
        List<WebElementFacade> listaBtnEliminar = WebTablesUI.BTNS_DELETE.resolveAllFor(actor);

        int randomNumber = random.nextInt(listaBtnEliminar.size()); //Generamos numero al azar
        listaBtnEliminar.get(randomNumber).click();

    }

    //Metodo  que reemplaza el instanciamiento de la clase
    public static Performable on(){
        return Instrumented.instanceOf(DeleteRandomRecord.class).withProperties();
    }
}
