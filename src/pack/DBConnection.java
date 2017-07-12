package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.fxml.FXML;

public class DBConnection {

	private Connection con = null;

	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/magicshop?useSSL=true", "root", "andrija");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean checkLogin(String user, String pass) {
		String query = "select username, password from korisnici";

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				if (rs.getString(1).equals(user) && rs.getString(2).equals(pass)) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkUsername(String user) {
		String query = "select username, password from korisnici";

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				if (rs.getString(1).equals(user)) {
					// User name is already in use
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @return 0 - username already exists
	 * @return 1 - username is ok and pass field is not empty
	 * @return 2 - pass field is empty
	 */
	@FXML
	public int register(String user, String pass, String name, String secondName) {

		String query = "insert into korisnici (username, password, name, secondName) values(?, ?, ?, ?)";

		if (!checkUsername(user)) {
			if(!(pass.trim().equals(""))) {
				try {
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1, user);
					ps.setString(2, pass);
					ps.setString(3, name);
					ps.setString(4, secondName);
					ps.executeUpdate();
					return 1;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else return 2;
		}
		return 0;
	}
}