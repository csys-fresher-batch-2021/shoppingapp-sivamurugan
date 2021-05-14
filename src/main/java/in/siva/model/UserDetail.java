package in.siva.model;

public class UserDetail {

	static UserDetail obj = null;
	private UserDetail() {
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
	public UserDetail(String name, int age, String gender, long mobileNumber, String email, String username, String password, String role) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.username = username;
		this.password = password;
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