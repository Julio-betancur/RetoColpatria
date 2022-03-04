package com.demoqa.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnterTextPrompt implements Interaction {

    private String text;

    public EnterTextPrompt(String text) {
        this.text = text;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver webDriver = BrowseTheWeb.as(actor).getDriver();
        new WebDriverWait(webDriver,10).until(ExpectedConditions.alertIsPresent());
        BrowseTheWeb.as(actor).getAlert().sendKeys(text);
    }

    public static EnterTextPrompt text(String text){
        return Instrumented.instanceOf(EnterTextPrompt.class).withProperties(text);
    }
}
