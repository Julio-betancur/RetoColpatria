package com.demoqa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ConfirmResult implements Question<String> {

    private Target target;

    public ConfirmResult(Target target) {
        this.target = target;
    }

    public static Question<String> of(Target target){
        return new ConfirmResult(target);
    }

    @Override
    public String answeredBy(Actor actor) {
        return target.resolveFor(actor).getText();
    }

}
