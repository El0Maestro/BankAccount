import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
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
    static File file = new File("Plik_bankowy.xlsx");//instancja scieżki pliku
    static String[][] dataTable = null;//tablica dwuwymiarowa typu String


    public static void Read(String path) throws IOException {
//        File file = new File(path);

    }
    public static void convertToString(String dataTable [][]){

        for (int n = 0; n < dataTable.length; n++ )
        {
            System.out.println("------------------");
            System.out.println(Arrays.deepToString(dataTable[n]));
        }
    }

    public static void main(String[] args) throws Exception {
        try {
            FileInputStream fis = new FileInputStream(file);//tworzenie nowej instancjii
            XSSFWorkbook workbook = new XSSFWorkbook(fis);//odwołanie do pliku .xls
            DataFormatter dataFormatter = new DataFormatter();//jedna z funkcjonalności apache poi, która zawiera metody służące do formatowania wartości w komórkach pliku
            XSSFSheet sheet = workbook.getSheetAt(0);//tworzy obiekt do pobierania na którym pracujemy
            Iterator<Row> itr = sheet.iterator();//iteruje po całym pliku
            while (itr.hasNext())
            {
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();//iterowanie po każdej komórce
                while (cellIterator.hasNext())
                {
                    Cell cell = cellIterator.next();
                    String cellValue = dataFormatter.formatCellValue(cell);
                    switch (cell.getCellType())
                    {
                        case Cell.CELL_TYPE_STRING:    //reprezentuje komorki typu String
                            break;
                        case Cell.CELL_TYPE_NUMERIC:    //reprezentuje komurki typu numerycznego
                            break;
                        default:
                    }
                }
            }
            int numRows = sheet.getLastRowNum() +1;
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
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        convertToString(dataTable);


    }
}