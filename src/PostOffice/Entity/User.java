package PostOffice.Entity;

public class User {

	private int id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;

	public User(int id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}
