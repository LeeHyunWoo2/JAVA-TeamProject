package hotelProject.memberAndBoard.DTO;

public class MemberDTO {
	private String id;
	private String pw;
	private String phoneNumber;
	private String name;
	private String email;
	private String ssn;
	private String address;
	private String nonName;
	private String nonnum;
	private String Basket;
	private int year; // 예약 연도

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public void setTime(String time) {
		this.time = time;
	}

	int month; // 예약 월
	int date; // 예약 일
	String time; // 예약한 시간

	public String getBasket() {
		return Basket;
	}

	public void setBasket(String basket) {
		Basket = basket;
	}

	public String getNonName() {
		return nonName;
	}

	public String getNonnum() {
		return nonnum;
	}

	public void setNonName(String nonName) {
		this.nonName = nonName;
	}

	public void setNonnum(String nonnum) {
		this.nonnum = nonnum;
	}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
