package guiMVC.controller;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import guiMVC.view.GUI;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
    public static String[][] data; // tablica z danymi z pliku Excel

    // Tworzenie metody do pobierania danych z pliku Excel
    public static String[][] main() {
        try {
            // Tworzenie nowego obiektu File na podstawie obiektu GUI.file
            File file = new File(String.valueOf(GUI.file));
            // Otwieranie pliku i pobieranie bajt�w z pliku
            FileInputStream fis = new FileInputStream(file);
            // Tworzenie obiektu Workbook, kt�ry odnosi si� do pliku .xlsx
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0); // Tworzenie obiektu Sheet do pobrania obiektu
            // Iterowanie przez plik Excel
            Iterator<Row> itr = sheet.iterator();
            int rowNum = 0; // zmienna do okre�lania aktualnego wiersza tablicy
            while (itr.hasNext()) {
                Row row = itr.next();
                // Iterowanie przez kolejne kolumny
                Iterator<Cell> cellIterator = row.cellIterator();
                int colNum = 0; // zmienna do okre�lania aktualnej kolumny tablicy
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    // Sprawdzanie typu kom�rki
                    switch (cell.getCellType()) {
                        // Pole, kt�re reprezentuje typ kom�rki tekstowej
                        case Cell.CELL_TYPE_STRING:
                            data[21][4] = cell.getStringCellValue();
                            break;
                        // Pole, kt�re reprezentuje typ kom�rki liczbowej
                        case Cell.CELL_TYPE_NUMERIC:
                            if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
                                SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                                data[21][4] = dateFormat.format(cell.getDateCellValue());
                            } else {
                                data[21][4] = String.valueOf(cell.getNumericCellValue());
                            }
                            break;
                        default:
                            break;
                    }
                }
                // Przej�cie do nowej linii po zako�czeniu iterowania po kolumnach
                System.out.println("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
    public static String[][] getData() {
        return data;
    }
}

