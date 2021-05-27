package in.siva.model;

public class UserDetail {
	
	public UserDetail() {
		// Default constructor
	}

	
	// Declaring variables for storing user details
	private String name;
	private int age;
	private String gender;
	private long mobileNumber;
	private String email;
	private String username;
	private String password;
	private String role;
	
	
	/**
	 * This constructor is used to add values to the variables
	 * @param name
	 * @param age
	 * @param gender
	 * @param mobileNumber
	 * @param email
	 * @param username
	 * @param password
	 */
	
	/**
	 * This method is used to set name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * This method is used to set age
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * This method is used to set gender 
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * This method is used to set mobile number
	 * @param mobileNumber
	 */
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	/**
	 * This method is used to set email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * This method is used to set username
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * This method is used to set password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * This method is used to set role
	 * @param role
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	/**
	 * This method is used to get name
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This method is used to get age 
	 * @return
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * This method is used to get gender
	 * @return
	 */
	public String getGender() {
		return gender;
	}
	
	/**
	 * This method is used to get mobile number
	 * @return
	 */
	public long getMobileNumber() {
		return mobileNumber;
	}
	
	/**
	 * This method is used to get email
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	
	
	/**
	 * This method is used to get username
	 * @return
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * This method is used to get password
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * This method is used to get role of the user
	 * @return
	 */
	public String getRole() {
		return role;
	}

	@Override
	public String toString() {
		return "UserDetail [name=" + name + ", age=" + age + ", gender=" + gender + ", mobileNumber=" + mobileNumber
				+ ", email=" + email + ", username=" + username + ", password=" + password + ", role=" + role + "]";
	}
	
	
}
