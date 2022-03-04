package com.demoqa.abilities;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ReadExcel implements Ability {

    private String filePath;
    private String sheetName;
    File file;
    FileInputStream inputStream;
    XSSFWorkbook newWorkBook;
    XSSFSheet newSheet;

    public ReadExcel(String filePath, String sheetName) throws IOException {
        this.filePath = filePath;
        this.sheetName = sheetName;
        this.file = new File(filePath);
        this.inputStream = new FileInputStream(file);

    }

    public static ReadExcel savedInPath(String filePath, String sheetName) throws IOException {
        return new ReadExcel(filePath, sheetName);
    }

    public static ReadExcel as(Actor actor) {
        return actor.abilityTo(ReadExcel.class);
    }

    public ArrayList<Map<String, String>> getData() throws IOException {
        ArrayList<Map<String, String>> listaDatosPlanTrabajo = new ArrayList<>();
        Map<String, String> informacionProyecto = new HashMap<>();

        Workbook newWorkBook = new XSSFWorkbook(this.inputStream);
        Sheet newSheet = newWorkBook.getSheet(this.sheetName);

        Iterator<Row> rowIterator = newSheet.iterator();

        Row titulos = rowIterator.next();

        while (rowIterator.hasNext()) {

            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (cell.getCellTypeEnum()) {

                    case STRING:
                        informacionProyecto.put(titulos.getCell(cell.getColumnIndex()).toString(), cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        String numero = String.valueOf(cell.getNumericCellValue());
                        informacionProyecto.put(titulos.getCell(cell.getColumnIndex()).toString(), numero.substring(0,numero.length()-2));
                        break;
                    case BLANK:
                        informacionProyecto.put(titulos.getCell(cell.getColumnIndex()).toString(), "");
                        break;
                    default:
                        break;
                }


            }

            listaDatosPlanTrabajo.add(informacionProyecto);
            informacionProyecto = new HashMap<String, String>();
        }

        return listaDatosPlanTrabajo;
    }


}
