package pack;

import javafx.beans.property.SimpleStringProperty;

public class Person {

	private int id;
	private SimpleStringProperty username;
	private SimpleStringProperty name;
	private SimpleStringProperty secondName;
	
	public Person(int id, String username, String name, String secondName) {
		this.id = id;
		this.username = new SimpleStringProperty(username);
		this.name = new SimpleStringProperty(name);
		this.secondName = new SimpleStringProperty(secondName);
	}

	/**
	 *	Without getters and setters columns would not be filled in the table! 
	 */
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username.get();
	}

	public void setUsername(SimpleStringProperty username) {
		this.username = username;
	}

	public String getName() {
		return name.get();
	}

	public void setName(SimpleStringProperty name) {
		this.name = name;
	}

	public String getSecondName() {
		return secondName.get();
	}

	public void setSecondName(SimpleStringProperty secondName) {
		this.secondName = secondName;
	}
}