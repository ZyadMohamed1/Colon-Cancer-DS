package coloncancer;


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ColonCancer extends Application {
    public Stage window;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Homepage.fxml"));
        window = primaryStage;
        window.setTitle("Colon Cancer Management System");
        
        Scene scene = new Scene(root);
        
        window.setResizable(false);
        window.setScene(scene);
        window.show();
    }

    
    
}

