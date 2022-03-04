package com.demoqa.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AlertsUI {
    public static final Target BTN_ALERT= Target.the("Boton para abrir primera alerta").located(By.id("alertButton"));
    public static final Target BTN_TIMER_ALERT = Target.the("Boton para abrir la alerta con tiempo  ").located(By.id("timerAlertButton"));
    public static final Target BTN_CONFIRM_ALERT = Target.the("Botones para abrir alerta con boton de confirmar").located(By.id("confirmButton"));
    public static final Target BTN_PROMPT= Target.the("Botones para abrir prompt").located(By.id("promtButton"));

    public static final Target LBL_CONFIRM_RESULT = Target.the("Label para validar confirmacion de alerta").located(By.id("confirmResult"));
    public static final Target LBL_PROMPT_RESULT = Target.the("Label para validar ingreso valor a la alerta").located(By.id("promptResult"));

}
