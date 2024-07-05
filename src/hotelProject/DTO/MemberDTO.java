package hotelProject.DTO;

public class MemberDTO {
	String id;
	String pw;
	int phoneNumber;
	String name;
	String email;
	int ssn;
	String address;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getPhoneNum() {
		return phoneNumber;
	}
	public void setPhoneNum(int phoneNum) {
		this.phoneNumber = phoneNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public MemberDTO(String id, String pw, int phoneNumber, String name, String email, int ssn, String address,
			int number) {
		super();
		this.id = id;
		this.pw = pw;
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.email = email;
		this.ssn = ssn;
		this.address = address;
		this.number = number;
	}
	

}
