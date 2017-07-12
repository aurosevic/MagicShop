package pack;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;

public class ControllerApp {

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
    	
    }
    
    public JFXButton getBtnLogin() {
		return btnLogin;
	}
}