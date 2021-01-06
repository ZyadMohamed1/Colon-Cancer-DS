/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coloncancer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
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
public class DoctorFunction extends Functions {
   
   static String trainingFile = "C:\\Users\\Zyad\\Documents\\NetBeansProjects\\Trainer.xlsx";
   public int patiantID;
   ReadFromExcel readPatiant=new ReadFromExcel();
   readForManager readManager = new readForManager();
   public double[] arr = new double[205];
   public double[] arr2 = new double[205];
   public double[] result = new double[205];
   public ArrayList<Double> trainerList = new ArrayList<>();
   public String condition;
   HashMap<Integer,String> map=new HashMap<Integer,String>();
   
   
   public DoctorFunction(){
       
   }
   
    public DoctorFunction(int patiantID) {
        this.patiantID = patiantID;
    }
   
    public void finalManager(){
        readManager.ReadManager(patiantID);
        predictManager();
    }
    
    public void finalDoctor(){
    readPatiant.Read(patiantID);
    predict();   
    }
    
    public void predict()
    {   
        
        
        XSSFWorkbook workbook;
        File file = new File(trainingFile);
        if (file.exists() == false) {
            workbook = new XSSFWorkbook();
            XSSFSheet exampleSheet = workbook.createSheet("1");
            XSSFRow firstRow = exampleSheet.createRow(1);
            XSSFCell cell = firstRow.createCell(0);
            cell.setCellValue("value");

            try ( //Write the workbook in file system
                    FileOutputStream out = new FileOutputStream(file)) 
            {
                     workbook.write(out);
            }
            catch(IOException ioex)
            {
                System.out.println("File Not Found , kalem Leissy (#awel exception)");
            }
        } else {
            
      
           
             try (FileInputStream in = new FileInputStream(file))
             {
                 XSSFWorkbook importedFile = new XSSFWorkbook(in);
                 int index=importedFile.getSheetIndex("Sheet1");
                  XSSFSheet sheet1 = importedFile.getSheetAt(index);
                 
                 Iterator<Row> rowIterator = sheet1.iterator();
                 //******************Zyad Code************************************
                 //To get the trainer in arraylist
                 int loop = 0;
                 int patientMap = 1;
                 int answer = 1;
                 int finalAnswer = 1;
                 double minimum = 999999999;
                   while(rowIterator.hasNext())
                 {
                     
                     Row row = rowIterator.next();
                     Iterator<Cell> cellIterator = row.cellIterator();
                     while(cellIterator.hasNext())
                     {
                         Cell cell = cellIterator.next();
                         if (row.getRowNum()== loop)
                         {
                             if (cell.getColumnIndex() == 202)
                             {
                                 
                                 condition=cell.getStringCellValue();
                                 map.put(patientMap, condition);
                                 patientMap++;
                             }
                             else {
                                 trainerList.add((double)cell.getNumericCellValue());
                             }
                         }
                     }
                 
                  Object[] obj1 = readPatiant.genesToBeTested.toArray();
                  Object[] obj2 = trainerList.toArray();
                  //putting test in the array
                  int i=0;
                  for(Object objTest : obj1){
                     double test = (double) objTest;
                     arr[i]=test;
                     i++;
                  }
                  
//                  for(int j=0;j<202;j++){
//                      System.out.println(arr[j]);
//                  }
//                  
//                  System.out.println();
                  //putting trainer in the array
                  
                  int t = 0;
              
                   for(Object objTrainer : obj2){
                     double trainer = (double) objTrainer;
                     arr2[t]=trainer;
                     t++;
                  }
                   
//                   for(int k=0;k<202;k++){
//                      System.out.println(arr2[k]);
//                  }
                   
                  //Diff and sum of the numbers between test and trainer 
                  double sum = 0;
                  double difference = 0;
                  
                  for(int iteration=1;iteration < 202;iteration++){
                      difference = arr[iteration] - arr2[iteration];
                     difference = Math.pow(difference, 2);
                      sum += difference;
                  }
                    sum = Math.sqrt(sum);
                   result[loop] = sum;
                   
                   if(sum<minimum){
                       minimum = sum;
                       finalAnswer = answer;
                       answer++;
                   }
                   else{
                       answer++;
                   }
                   
                   loop++;
                   trainerList.removeAll(trainerList);
                 }
                   
//                    System.out.println(minimum);
//                    System.out.println(finalAnswer);
//                  for(int done=0;done<202;done++){
//                       
//                       if(result[done]==0){
//                           break;
//                       }
//                       System.out.println(result[done]);
//                   }
                    System.out.println(finalAnswer);
                    System.out.println(map.get(finalAnswer));
                  
                    
                 in.close();
//                 System.out.println("Sha3'al el7");
//                 System.out.println(readPatiant.condition);
//                 System.out.println(readPatiant.genesToBeTested);
//                 System.out.println(trainerList);
                   
             }
             catch(IOException ioex)
             {
                 System.out.println("Kalem Leissy 3shn fy 7aga 3'alat (#a5er exception)");
             }
    }
    }
    
    public void predictManager(){
          XSSFWorkbook workbook;
        File file = new File(trainingFile);
        if (file.exists() == false) {
            workbook = new XSSFWorkbook();
            XSSFSheet exampleSheet = workbook.createSheet("1");
            XSSFRow firstRow = exampleSheet.createRow(1);
            XSSFCell cell = firstRow.createCell(0);
            cell.setCellValue("value");

            try ( //Write the workbook in file system
                    FileOutputStream out = new FileOutputStream(file)) 
            {
                     workbook.write(out);
            }
            catch(IOException ioex)
            {
                System.out.println("File Not Found , kalem Leissy (#awel exception)");
            }
        } else {
            
      
           
             try (FileInputStream in = new FileInputStream(file))
             {
                 XSSFWorkbook importedFile = new XSSFWorkbook(in);
                 int index=importedFile.getSheetIndex("Sheet1");
                  XSSFSheet sheet1 = importedFile.getSheetAt(index);
                 
                 Iterator<Row> rowIterator = sheet1.iterator();
                 //******************Zyad Code************************************
                 //To get the trainer in arraylist
                 int loop = 0;
                   while(rowIterator.hasNext())
                 {
                     
                     Row row = rowIterator.next();
                     Iterator<Cell> cellIterator = row.cellIterator();
                     while(cellIterator.hasNext())
                     {
                         Cell cell = cellIterator.next();
                         if (row.getRowNum()== loop)
                         {
                             if (cell.getColumnIndex() == 202)
                             {
                                 condition=cell.getStringCellValue();
                             }
                             else {
                                 trainerList.add((double)cell.getNumericCellValue());
                             }
                         }
                     }
                 
                  Object[] obj1 = readManager.genesToBeTested.toArray();
                  Object[] obj2 = trainerList.toArray();
                  //putting test in the array
                  int i=0;
                  for(Object objTest : obj1){
                     double test = (double) objTest;
                     arr[i]=test;
                     i++;
                  }
                  
//                  for(int j=0;j<202;j++){
//                      System.out.println(arr[j]);
//                  }
//                  
//                  System.out.println();
                  //putting trainer in the array
                  
                  int t = 0;
              
                   for(Object objTrainer : obj2){
                     double trainer = (double) objTrainer;
                     arr2[t]=trainer;
                     t++;
                  }
                   
//                   for(int k=0;k<202;k++){
//                      System.out.println(arr2[k]);
//                  }
                   
                  //Diff and sum of the numbers between test and trainer 
                  double sum = 0;
                  double difference = 0;
                  
                  for(int iteration=1;iteration < 202;iteration++){
                      difference = arr[iteration] - arr2[iteration];
                     difference = Math.pow(difference, 2);
                      sum += difference;
                  }
                   sum = Math.sqrt(sum);
                   result[loop] = sum;
                   loop++;
                   trainerList.removeAll(trainerList);
                 }
                   
                   
                  for(int done=0;done<202;done++){
                       
                       if(result[done]==0){
                           break;
                       }
                       System.out.println(result[done]);
                   }
                  

                 in.close();
//                 System.out.println("Sha3'al el7");
//                 System.out.println(readPatiant.condition);
//                 System.out.println(readPatiant.genesToBeTested);
//                 System.out.println(trainerList);
                   
             }
             catch(IOException ioex)
             {
                 System.out.println("Kalem Leissy 3shn fy 7aga 3'alat (#a5er exception)");
             }
    }
    }
    
       
   
}
   

