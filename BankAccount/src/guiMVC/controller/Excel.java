//package guiMVC.controller;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.text.SimpleDateFormat;
//import java.util.Iterator;
//
//import guiMVC.view.GUI;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class Excel {
//    public static void main(String[] args) {
//        try {
//            // Tworzenie nowego obiektu File na podstawie klasy GUI
//            File file = new File(String.valueOf(GUI.file));
//            // Otwieranie pliku i pobieranie bajtów z pliku
//            FileInputStream fis = new FileInputStream(file);
//            // Tworzenie obiektu Workbook, który odnosi się do pliku .xlsx
//            XSSFWorkbook wb = new XSSFWorkbook(fis);
//            XSSFSheet sheet = wb.getSheetAt(0); // Tworzenie obiektu Sheet do pobrania obiektu
//            // Iterowanie przez plik Excel
//            Iterator<Row> itr = sheet.iterator();
//            while (itr.hasNext()) {
//                Row row = itr.next();
//                // Iterowanie przez kolejne kolumny
//                Iterator<Cell> cellIterator = row.cellIterator();
//                while (cellIterator.hasNext()) {
//                    Cell cell = cellIterator.next();
//                    // Sprawdzanie typu komórki
//                    switch (cell.getCellType()) {
//                        // Formatowanie pola, które reprezentuje typ komórki tekstowej
//                        case Cell.CELL_TYPE_STRING:
//                            System.out.format("%-30s", cell.getStringCellValue());
//                            break;
//                        // Formatowanie pola, które reprezentuje typ komórki liczbowej
//                        case Cell.CELL_TYPE_NUMERIC:
//                            if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
//                                SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
//                                System.out.format("%-30s", dateFormat.format(cell.getDateCellValue()));
//                            } else {
//                                System.out.format("%-30s", cell.getNumericCellValue());
//                            }
//                            break;
//                        default:
//                    }
//                }
//                // Przejście do nowej linii po zakończeniu iterowania po kolumnach
//                System.out.println("\n");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//
package guiMVC.controller;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import guiMVC.view.GUI;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
    public static List<String[]> getDataFromExcel() {
        List<String[]> rowData = new ArrayList<>();
        try {
            File file = new File(String.valueOf(GUI.file));
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            Iterator<Row> itr = sheet.iterator();
            while (itr.hasNext()) {
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                String[] cellData = new String[row.getLastCellNum()];
                int i = 0;
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_STRING:
                            cellData[i] = cell.getStringCellValue();
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
                                SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                                cellData[i] = dateFormat.format(cell.getDateCellValue());
                            } else {
                                cellData[i] = String.valueOf(cell.getNumericCellValue());
                            }
                            break;
                        default:
                            cellData[i] = "";
                    }
                    i++;
                }
                rowData.add(cellData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowData;

    }
}