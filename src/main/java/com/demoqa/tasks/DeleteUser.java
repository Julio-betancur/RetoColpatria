package com.demoqa.tasks;

import com.demoqa.interactions.DeleteRandomRecord;
import com.demoqa.interactions.GetRecordsNumber;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class DeleteUser implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                DeleteRandomRecord.on(),
                GetRecordsNumber.on()
        );
    }


    public static DeleteUser on(){
        return Instrumented.instanceOf(DeleteUser.class).withProperties();
    }
}
