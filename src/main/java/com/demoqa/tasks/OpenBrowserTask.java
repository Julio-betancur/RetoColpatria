package com.demoqa.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class OpenBrowserTask implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url("https://demoqa.com/")
        );
    }

    public static OpenBrowserTask on(){
        return Instrumented.instanceOf(OpenBrowserTask.class).withProperties();
    }
}
