package guiMVC.controller;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

public class Excel {
    private File file = new File("Plik_bankowy.xlsx");//instancja scieżki pliku
    private String[][] dataTable;//tablica dwuwymiarowa typu String
    private FileInputStream fis;//tworzenie nowej instancjii


    void Read(String path) throws IOException {
        this.file = new File(path);
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(fis);//odwołanie do pliku .xls
            XSSFSheet sheet = workbook.getSheetAt(0);//tworzy obiekt do pobierania na którym pracujemy
            Iterator<Row> itr = sheet.iterator();//iteruje po całym pliku
            while (itr.hasNext()) {
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();//iterowanie po każdej komórce
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                }
            }
            int numRows = sheet.getLastRowNum() + 1;
            int numCols = sheet.getRow(0).getLastCellNum();
//pętla for do wyciągnicia wszystkich danych i zapisania w tablicy dwuwymiarowej
            dataTable = new String[numRows][numCols];
            for (int i = 0; i < numRows; i++) {
                XSSFRow xlRow = sheet.getRow(i);
                for (int j = 0; j < numCols; j++) {
                    XSSFCell xlCell = xlRow.getCell(j);
                    dataTable[i][j] = xlCell.toString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        convertToString(dataTable);

    }

    void convertToString(String[][] dataTable) {

        for (int n = 0; n < dataTable.length; n++) {
            System.out.println("------------------");
            System.out.println(Arrays.deepToString(dataTable[n]));
        }

    }


}
