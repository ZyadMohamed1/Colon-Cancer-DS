package coloncancer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class DoctorController implements Initializable {
    
    
    @FXML
    public void homepageButton(ActionEvent event) throws IOException {
        System.out.println("You clicked me!");
        Parent homepageParent = null;
        homepageParent = FXMLLoader.load((getClass().getResource("Homepage.fxml")));
        Scene homepageScene = new Scene(homepageParent);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(homepageScene);
     }
    
    @FXML
    private TextField txt1;
    
    @FXML
    private Label label1,label2; 
  
    @FXML
    public void patientInput() {
        String mssg = txt1.getText();
        isInt(txt1,mssg);
        label2.setText("...");
    }
    
    
    public boolean flag=false;
    public int id;
    public String res, prediction ;
     
   @FXML
    public boolean isInt(TextField input,String message){
  
    try{
    id = Integer.parseInt(input.getText());
    
     if(id>=1 && id<=32){
    DoctorFunction dc = new DoctorFunction(id);
    dc.finalDoctor();
    prediction = dc.returnPrediction(res);
 
    label1.setText("VALID");
    flag = true; 
                        }
    
    else                {
    flag = false;
    label1.setText("INVALID");
                        }
    
    return true;
    
    }catch(NumberFormatException e){
   
    label1.setText("INVALID");
    flag = false;
    
    return false;
    } 
      
 }
    
  @FXML
    public void predictionDisplay() {
   
    if(flag){
    
    label2.setText(prediction);

    }
    
    else{
    
    label2.setText("Enter a Valid Patient ID!");
    
    }
        
 }  
       
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    
}
