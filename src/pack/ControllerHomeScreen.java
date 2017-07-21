package pack;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ControllerHomeScreen {

    @FXML
    private Label lblUser;
    @FXML
    private JFXButton btnShowCustomers;
    @FXML
    private JFXButton btnLogout;
    @FXML
    private TableView<Person> tableUsers;
    @FXML
    private TableColumn<Person, Integer> columnId;
    @FXML
    private TableColumn<Person, String> columnUsername;
    @FXML
    private TableColumn<Person, String> columnName;
    @FXML
    private TableColumn<Person, String> columnSecondName;

    private DBConnection con = new DBConnection();
    
    public void createConnection() {
    	con.connect();
    }
    
    public void showTable() {
    	tableUsers.getItems().clear();
    	createConnection();
    	columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
    	columnUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
    	columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
    	columnSecondName.setCellValueFactory(new PropertyValueFactory<>("secondName"));
    	tableUsers.setItems(con.loadTableData());
    	tableUsers.setVisible(true);
    }
    
    public void logout() {
    	Stage stage = (Stage) btnLogout.getScene().getWindow();
    	try {
			Pane pane = FXMLLoader.load(getClass().getResource("App.fxml"));
			Scene scene = new Scene(pane);
			stage.setScene(scene);
			stage.setTitle("Magic shop");
			stage.centerOnScreen();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public Label getLblUser() {
		return lblUser;
	}

	public TableColumn<Person, Integer> getColumnId() {
		return columnId;
	}

	public void setColumnId(TableColumn<Person, Integer> columnId) {
		this.columnId = columnId;
	}

	public TableColumn<Person, String> getColumnUsername() {
		return columnUsername;
	}

	public void setColumnUsername(TableColumn<Person, String> columnUsername) {
		this.columnUsername = columnUsername;
	}

	public TableColumn<Person, String> getColumnName() {
		return columnName;
	}

	public void setColumnName(TableColumn<Person, String> columnName) {
		this.columnName = columnName;
	}

	public TableColumn<Person, String> getColumnSecondName() {
		return columnSecondName;
	}

	public void setColumnSecondName(TableColumn<Person, String> columnSecondName) {
		this.columnSecondName = columnSecondName;
	}

	public TableView<Person> getTableUsers() {
		return tableUsers;
	}

	public void setTableUsers(TableView<Person> tableUsers) {
		this.tableUsers = tableUsers;
	}
}