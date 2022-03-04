package com.demoqa.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DatePickerUI {
    public static final Target SELECT_DATE = Target.the("Campo para seleccionar la fecha sin hora").located(By.id("datePickerMonthYearInput"));
    public static final Target SELECT_DATE_TIME = Target.the("Campo para seleccionar la fecha con hora").located(By.id("dateAndTimePickerInput"));
}
