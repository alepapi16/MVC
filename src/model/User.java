package model;

public class User {

	
	// ATTRIBUTES
	
	/**
	 * Unique attribute (two or more users can't have the same username) 
	 */
	private String username;
	
	private String password;
	
	private int age;
	
	private String email;

	
	// CONSTRUCTOR
	
	public User(String username, String password, int age, String email) {
		this.username = username;
		this.password = password;
		this.age = age;
		this.email = email;
	}

	
	// GETTERS AND SETTERS
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Username: ");
		sb.append(this.username);
		sb.append(System.lineSeparator());
		sb.append("Password: ");
		sb.append(this.password);
		sb.append(System.lineSeparator());
		sb.append("Age: ");
		sb.append(this.age);
		sb.append(System.lineSeparator());
		sb.append("Email: ");
		sb.append(this.email);
		sb.append(System.lineSeparator());
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	
	
}
