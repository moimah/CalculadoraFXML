package dad.javafx.calculadora.fxml;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalculadoraApp extends Application {

	private CalculadoraController controller;
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		controller = new CalculadoraController();
		
		Scene scene = new Scene(controller.getView(), 350, 260);
		
		
		primaryStage.setTitle("Calculadora");
		primaryStage.setScene(scene);		
		primaryStage.setMinWidth(350);
		primaryStage.setMinHeight(260);
	
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
