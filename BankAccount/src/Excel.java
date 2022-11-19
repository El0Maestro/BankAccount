import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;


public class Excel {

    public static void main(String[] args) throws Exception {

        File file = new File("Plik_bankowy.xlsx");
        String[][] dataTable = null;

 // public static void Read(String path) {
        try {
            //File file = new File(path);
            DataFormatter dataFormatter = new DataFormatter();

//creating a new file instance
            FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file
// creating Workbook instance that refers to .xlsx file
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object
            Iterator<Row> itr = sheet.iterator();    //iterating over excel file
            while (itr.hasNext())
            {
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column
                while (cellIterator.hasNext())
                {
                    Cell cell = cellIterator.next();
                    String cellValue = dataFormatter.formatCellValue(cell);
                    switch (cell.getCellType())
                    {
                        case Cell.CELL_TYPE_STRING:    //field that represents string cell type
                            System.out.print(cellValue + "\t\t\t");
                            break;
                        case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type
                            System.out.print(cellValue + "\t\t\t");
                            break;
                        default:
                    }
                }
                System.out.println("");
            }
            System.out.println("__________________");
            int numRows = sheet.getLastRowNum() +1;
            int numCols = sheet.getRow(0).getLastCellNum();

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

    }


}