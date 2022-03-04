package com.demoqa.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class HomeUI {

    public static final Target BTN_ELEMENTS = Target.the("Boton para abrir seccion elementos").locatedBy("(//div[@class='card-body'])[1]");
    public static final Target BTN_WIDGETS= Target.the("Boton para abrir seccion widgets").locatedBy("(//div[@class='card-body'])[4]");
    public static final Target BTN_ALERTS_FRAMES = Target.the("Boton para abrir seccion de alertas y frames").locatedBy("(//div[@class='card-body'])[3]");


}
