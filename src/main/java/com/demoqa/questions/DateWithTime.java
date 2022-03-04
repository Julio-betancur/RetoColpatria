package com.demoqa.questions;

import com.demoqa.userinterface.DatePickerUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class DateWithTime implements Question<String> {

    public static Question<String> value(){
        return new DateWithTime();
    }

    @Override
    public String answeredBy(Actor actor) {
        return DatePickerUI.SELECT_DATE_TIME.resolveFor(actor).getValue();
    }
}
