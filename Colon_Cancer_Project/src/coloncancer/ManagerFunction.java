/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coloncancer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author A.Elleissy
 */
public class ManagerFunction extends Functions {
   
    static String trainingFile = "C:\\Users\\Karim\\Desktop\\1st year\\2nd year\\OOP\\Colon Cancer\\Datasets\\Training Dataset.xlsx";
    public String testFile;

    public ManagerFunction(String testFile) {
        this.testFile = testFile;
    }
    
    
    public void equlidean()
    {
         
        XSSFWorkbook workbook;
        File file = new File(trainingFile);
        if (file.exists() == false) {
            workbook = new XSSFWorkbook();
            XSSFSheet exampleSheet = workbook.createSheet("1");
            XSSFRow firstRow = exampleSheet.createRow(1);
            XSSFCell cell = firstRow.createCell(0);
            cell.setCellValue("value");

            try (
                    //Write the workbook in file system
                    FileOutputStream out = new FileOutputStream(file)) {
                     workbook.write(out);
            }catch (IOException ioex)
             {
                 System.out.println("Kalem Leissy 3ashn fy 7aga 3'alt (#awel exception)");
             }
        } else {
            
      
           
             try (FileInputStream in = new FileInputStream(file))
             {
                 XSSFWorkbook importedFile = new XSSFWorkbook(in);
                 int index=importedFile.getSheetIndex("Sheet1");
                  XSSFSheet sheet1 = importedFile.getSheetAt(index);
                 
                 Iterator<Row> rowIterator = sheet1.iterator();
                 while(rowIterator.hasNext())
                 {
                     Row row = rowIterator.next();
                     Iterator<Cell> cellIterator = row.cellIterator();
                     while(cellIterator.hasNext())
                     {
                         Cell cell = cellIterator.next();
                         
                     }
                 }
                 in.close();
                 
                 
            // Sheet already exists
            System.out.println("Sha3'al el7");
        }catch (IOException ioex)
             {
                 System.out.println("Kalem Leissy 3ashn fy 7aga 3'alt (#awel exception)");
             }
    }
    }
    
}

    
