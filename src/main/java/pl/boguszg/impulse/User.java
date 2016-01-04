package pl.boguszg.impulse;

public class User {
	
	private int phone_number;
	private String username;
	private String role;
	
	
	public User(){
		
	}
	
	public User(int phone_number, String username, String role) {
		this.phone_number = phone_number;
		this.username = username;
		this.role = role;
	}
	public int getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [phone_number=" + phone_number + ", username=" + username + "]";
	}
	
	
}
