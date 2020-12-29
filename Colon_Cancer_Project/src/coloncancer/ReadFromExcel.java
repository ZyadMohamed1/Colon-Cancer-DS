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
public class ReadFromExcel {
    
    static String fileDictName = "";
    public ArrayList<Double> genesToBeTested = new ArrayList<>();
    public String condition;
    
    public void Read(int id)
    {  
        XSSFWorkbook workbook;

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Open the file"); //name for chooser
         
        FileFilter filter = new FileNameExtensionFilter("Excel File (.xlsx)","xlsx");
        fileChooser.setAcceptAllFileFilterUsed(false); //to show or not all other files
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.setSelectedFile(new File(fileDictName)); //when you want to show the name of file into the chooser
        fileChooser.setVisible(true);
        int result = fileChooser.showOpenDialog(fileChooser);
        if (result == JFileChooser.APPROVE_OPTION) {
            fileDictName = fileChooser.getSelectedFile().getAbsolutePath();
        } else {
            return;
        }

        File file = new File(fileDictName);
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
        }
        else {
            
      
           
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
                         if (row.getRowNum()== (id-32))
                         {
                             if (cell.getColumnIndex() == 202)
                             {
                                 condition=cell.getStringCellValue();
                             }
                             else {
                                 genesToBeTested.add((double)cell.getNumericCellValue());
                             }
                         }
                     }
                 }
//                 System.out.println("Sha3'al el7");
//                 System.out.println(condition);
//                 System.out.println(genesToBeTested);
             }
             catch (IOException ioex)
             {
                 System.out.println("Kalem Leissy 3ashn fy 7aga 3'alt (#awel exception)");
             }
    }
    }
    }
   

