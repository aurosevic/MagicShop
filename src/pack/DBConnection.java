package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
			
			while(rs.next()) {
				if(rs.getString(1).equals(user) && rs.getString(2).equals(pass)) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void register() {
		
	}
}