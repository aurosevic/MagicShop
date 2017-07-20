package pack;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ControllerApp {

	/**
	 * Controller for Login screen 
	 */
	
	private DBConnection con = new DBConnection();
	@FXML
    private JFXButton btnLogin;
    @FXML
    private JFXButton btnRegister;
    @FXML
    private JFXTextField tfUser;
    @FXML
    private JFXPasswordField pfPass;
    @FXML
    private Label lblIncorrect;
    
    public void createConnection() {
    	con.connect();
    }
    
    @FXML
    private void checkLogin() {

    	createConnection();
    	if(con.checkLogin(tfUser.getText().trim(), pfPass.getText().trim())) {
    		lblIncorrect.setVisible(false);
    		//	btnLogin.setText("Yep!");
    		Stage stage = (Stage) btnLogin.getScene().getWindow();
    		try {
				Pane pane = FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
				Scene scene = new Scene(pane);
				stage.setScene(scene);
				stage.setTitle("Magic shop");
				stage.centerOnScreen();
				
				/** Forwarding data from text field on one pane to label on another pane */
				Label lbl = (Label) pane.getChildren().get(0);
				lbl.setText(tfUser.getText().trim());
			} catch (IOException e) {
				e.printStackTrace();
			}
    	} else {
    		lblIncorrect.setVisible(true);
    	}
    	btnLogin.setDefaultButton(true);
    }
    
    @FXML
    private void registerUser() {
    	Stage stage = (Stage) btnRegister.getScene().getWindow();
    	try {
			Pane root = FXMLLoader.load(getClass().getResource("Register.fxml"));
			Scene scene = new Scene(root);
			stage.close();
			stage.setScene(scene);
			stage.setTitle("Registration");
			stage.centerOnScreen();
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}