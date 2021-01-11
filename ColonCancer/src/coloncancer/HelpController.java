package coloncancer;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
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


public class HelpController implements Initializable {

    public void homepageButton3(ActionEvent event) throws IOException {
        System.out.println("You clicked me!");
        Parent homepageParent = null;
        homepageParent = FXMLLoader.load((getClass().getResource("Homepage.fxml")));
        Scene homepageScene = new Scene(homepageParent);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(homepageScene);
     }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}