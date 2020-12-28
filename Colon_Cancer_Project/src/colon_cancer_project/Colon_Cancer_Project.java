package Colon_Cancer_Project;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Colon_Cancer_Project extends Application{
	
	Stage window;
	Scene scene;
	Button button;
	Button button2;
	ComboBox<String> comboBox;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	@Override
	public void start(Stage primaryStage) {
	
		window = primaryStage;
		window.setTitle("Colon Cancer");
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);
		
		//Label 1 for Patient ID
		Label Patient = new Label("Patient_ID");
		GridPane.setConstraints(Patient, 0, 2);
		
		//Text
		TextField ID = new TextField();
		GridPane.setConstraints(ID, 2, 2);
		
		button = new Button();
		button.setText("View Prediction");
		GridPane.setConstraints(button, 1, 5);
		
		button2 = new Button();
		button2.setText("Accuray");
		GridPane.setConstraints(button2, 1, 6);
		
		comboBox = new ComboBox<>();
		comboBox.getItems().addAll("Manager", "Doctor");
		comboBox.setPromptText("Select the user");
		
		GridPane.setConstraints(comboBox, 0, 0);
		
		

		
		comboBox.setOnAction(e -> {
			
			System.out.println("User Select : " + comboBox.getValue());
			String save;
			save = comboBox.getValue();
			System.out.println(save);
			if(save=="Manager") {
				grid.getChildren().add(button2);
				
			}
			else {
				grid.getChildren().remove(button2);
			}
			

		});
		button.setOnAction(e -> {

		
		});
		
		grid.getChildren().addAll(Patient, ID, comboBox, button);
		Scene scene = new Scene(grid, 720,500);
		window.setScene(scene);
		window.show();
		
	}
	
	
}
