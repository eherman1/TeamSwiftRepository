package edu.ucsd.teamswift.letsgo;

public class UserInfo {
	private String firstName,
				   lastName,
				   password,
				   email,
				   userName,
				   gender, 
				   school,
				   favActivities;
	
	

	private int    zipCode,
				   phoneNum;
	
	public UserInfo (String firstName,
          			 String lastName,
			         String password,
			         String email,
 			         String userName,
			         String gender, 
			         String school,
			         String favActivities,
			         int zipCode,
			         int phoneNum ) {

		this.firstName     = firstName;
		this.lastName      = lastName;
		this.password      = password;
		this.email         = email;
		this.userName      = firstName + " "  +lastName;
		this.gender        = gender;
		this.school        = school;
		this.favActivities = favActivities;
		this.zipCode       = zipCode;
		this.phoneNum      = phoneNum;		
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getFavActivities() {
		return favActivities;
	}

	public void setFavActivities(String favActivities) {
		this.favActivities = favActivities;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public int getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}

}
