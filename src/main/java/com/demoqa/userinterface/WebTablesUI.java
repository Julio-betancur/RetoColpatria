package com.demoqa.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class WebTablesUI {
    public static final Target BTN_ADD  = Target.the("Boton para agregar registro a la tabla").located(By.id("addNewRecordButton"));
    public static final Target TXT_FIRST_NAME  = Target.the("Campo de texto para ingresar el nombre").located(By.id("firstName"));
    public static final Target TXT_LAST_NAME  = Target.the("Campo de texto para ingresar el apellido").located(By.id("lastName"));
    public static final Target TXT_EMAIL  = Target.the("Campo de texto para ingresar el email").located(By.id("userEmail"));
    public static final Target TXT_AGE  = Target.the("Campo de texto para ingresar la edad").located(By.id("age"));
    public static final Target TXT_SALARY = Target.the("Campo de texto para ingresar el salario").located(By.id("salary"));
    public static final Target TXT_DEPARTMENT  = Target.the("Campo de texto para ingresar el departamento").located(By.id("department"));
    public static final Target BTN_SUBMIT = Target.the("Boton para confirmar ingreso de registro").located(By.id("submit"));
    public static final Target LBL_FIRST_NAME = Target.the("Label para validar el nuevo registro por su nombre").locatedBy("(//div[@class='rt-td'])[22]");

    public static final Target BTNS_DELETE = Target.the("Botones para eliminar registro").locatedBy("//span[@title='Delete']");




}
