package coloncancer;

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
    double minimumValue[]=new double[202];
    int counter=0;
    public ManagerFunction(){
     
    }
    
    public void findMin(){
     for(int i=33;i<52;i++){
      DoctorFunction dc = new DoctorFunction(i);
      dc.finalManager();
  double temp = dc.result[0];
   for(int r=0; r<202; r++) {
       if(dc.result[r]!=0){
      if(temp>dc.result[r]) {
         temp=dc.result[r];
      }
       }
       else
           continue;
       
     
  }
      minimumValue[counter]=temp;
       counter++;
       } 
 
      for(int i=0;i<counter;i++)
          System.out.print(minimumValue[i]+"***"); 
    }
    
   
}