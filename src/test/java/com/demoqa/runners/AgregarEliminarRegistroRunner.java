package com.demoqa.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/com.demoqa.features/AgregarEliminarRegistro.feature",
        glue = "com.demoqa.stepdefinitions",
        snippets = SnippetType.CAMELCASE
)
public class AgregarEliminarRegistroRunner {
}
