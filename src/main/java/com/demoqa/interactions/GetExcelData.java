package com.demoqa.interactions;

import com.demoqa.abilities.ReadExcel;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actors.OnStage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static com.demoqa.utils.SessionVariables.EXCEL_DATA;

public class GetExcelData implements Interaction {

    private String sheet;

    public GetExcelData(String sheet) {
        this.sheet = sheet;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.whoCan(ReadExcel.savedInPath("data.xlsx", sheet));
            ArrayList<Map<String,String>> data;
            data = ReadExcel.as(OnStage.theActorInTheSpotlight()).getData();

            actor.remember(EXCEL_DATA.toString(),data);

        } catch (IOException e) {
            System.out.println("Error al obtener datos de excel");
            e.printStackTrace();
        }
    }

    public static GetExcelData from(String sheet){
        return Instrumented.instanceOf(GetExcelData.class).withProperties(sheet);
    }
}
