package coloncancer;

import java.math.BigDecimal;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
 * @author ElGAZOLY
 */
 //******************Adham Code************************************
public class ManagerFunction extends Functions {
    double minimumValue[];
    String something[];
    int minIndex[];
     String[] arr1;
    readForManager read;
    int counter;
    int correct;
     double accuracy;
     
     
    public ManagerFunction(){
        this.minimumValue = new double[202];
        this.something = new String [50];
        this.minIndex = new int[202];
        this.arr1 = new String[50];
        this.read = new readForManager();
        this.counter = 0;
        this.accuracy = 0.0;
        this.correct = 0;
        
    }
    
    public void findMin(){
   
    
     for(int i=1;i<33;i++){
      DoctorFunction dc = new DoctorFunction(i);
      dc.finalManager();
      dc.predict();
      something[counter]=dc.map.get(dc.finalAnswer);
      counter++;
     }
        
    read.readPatientState(arr1);
    
       for(int i=0;i<counter;i++){
       if(arr1[i].equals(something[i]))
           correct++;
     }
  
    }
    
    
    
      public String accuracy(){
    findMin();
        accuracy= (correct/32.0)*100 ;
        String s = String.valueOf(accuracy);
        return s;
    }
   
}