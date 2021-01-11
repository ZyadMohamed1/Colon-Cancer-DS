package coloncancer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class HomepageController implements Initializable {

    public void doctorButton(ActionEvent event) throws IOException {
        System.out.println("You clicked me!");
        Parent doctorParent = null;
        doctorParent = FXMLLoader.load((getClass().getResource("Doctor.fxml")));
        Scene doctorScene = new Scene(doctorParent);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(doctorScene);
     }
    
    public void managerButton(ActionEvent event) throws IOException {
        System.out.println("You clicked me!");
        Parent managerParent = null;
        managerParent = FXMLLoader.load((getClass().getResource("Manager.fxml")));
        Scene managerScene = new Scene(managerParent);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(managerScene);
     }
    
    public void helpButton(ActionEvent event) throws IOException {
        System.out.println("You clicked me!");
        Parent managerParent = null;
        managerParent = FXMLLoader.load((getClass().getResource("Help.fxml")));
        Scene managerScene = new Scene(managerParent);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(managerScene);
     }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
 

    
}
