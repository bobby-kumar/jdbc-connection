package jdbcConnectionDemo;

public class User {
	private int UserId;
	private String userName;
	private String email;
	private String MobileNumber;
	
	
	public User(int userId, String userName, String email, String mobileNumber) {
		super();
		UserId = userId;
		this.userName = userName;
		this.email = email;
		MobileNumber = mobileNumber;
	}

     
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public int getUserId() {
		return UserId;
	}


	public void setUserId(int userId) {
		UserId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobileNumber() {
		return MobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		MobileNumber = mobileNumber;
	}


	@Override
	public String toString() {
		return "User [UserId=" + UserId + ", userName=" + userName + ", email=" + email + ", MobileNumber="
				+ MobileNumber + "]";
	}
	

}
