package pack;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		Pane pane = FXMLLoader.load(getClass().getResource("App.fxml"));
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		
		stage.setTitle("Magic shop");
		stage.getIcons().add(new Image("img/logo.png"));
		stage.initStyle(StageStyle.UNIFIED);
		stage.centerOnScreen();
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}