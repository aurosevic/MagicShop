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

public class ControllerRegister {

	/**
	 * Controller for Registration panel
	 */
	
    @FXML
    private JFXTextField tfUser;
    @FXML
    private JFXPasswordField pfPass;
    @FXML
    private JFXTextField tfName;
    @FXML
    private JFXTextField tfSecondName;
    @FXML
    private JFXButton btnBack;
    @FXML
    private JFXButton btnRegister;
    private DBConnection con = new DBConnection();
    
    @FXML
    public void goBack() {
    	
    	Stage stage = (Stage) btnBack.getScene().getWindow();
    	try {
			Pane pane = FXMLLoader.load(getClass().getResource("App.fxml"));
			Scene scene = new Scene(pane);
			stage.close();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public void createConnection() {
    	con.connect();
    }
    
    @FXML
    public void register() {

    	createConnection();
    	int registration = con.register(tfUser.getText().trim(), pfPass.getText().trim(), tfName.getText().trim(), tfSecondName.getText().trim());
    	if(registration == 0) {
    		tfUser.setPromptText(tfUser.getText().trim() + " already exists");
    		tfUser.requestFocus();
    	} else if (registration == 2) {
    		pfPass.setPromptText("enter the password");
    		pfPass.setText("");
    		pfPass.requestFocus();
    	}
    }
}