package pack;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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
    
    public void createConnection() {
    	con.connect();
    }
    
    @FXML
    private void checkLogin() {

    	createConnection();
    	if(con.checkLogin(tfUser.getText().trim(), pfPass.getText().trim())) {
    		btnLogin.setText("Yep!");
    	} else {
    		btnLogin.setText("!Magga");
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
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}