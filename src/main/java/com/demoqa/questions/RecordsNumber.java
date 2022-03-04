package com.demoqa.questions;

import com.demoqa.utils.SessionVariables;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class RecordsNumber implements Question<String> {

    public static Question<String> value() {
        return new RecordsNumber();
    }

    @Override
    public String answeredBy(Actor actor) {
        return String.valueOf(actor.recall(SessionVariables.RECORDS_NUMBER.toString()));
    }
}
