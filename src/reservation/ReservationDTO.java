package hotelProject.reservation;

public class ReservationDTO {

	// 필드
	int year; // 예약 연도
	int month; // 예약 월
	int date; // 예약 일
	String time; // 예약한 시간

	@Override
	public String toString() {
		return year + ". " + month + ". " + date;
	}

	// 생성자
	public ReservationDTO() {
	}

	public ReservationDTO(int year, int month, int date, String time) {
		super();

		this.year = year;
		this.month = month;
		this.date = date;
		this.time = time;
	}

	// 메서드

	public int getyear() {
		return year;
	}

	public int getmonth() {
		return month;
	}

	public int getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}

	public int setyear(int year) {
		return this.year = year;
	}

	public int setmonth(int month) {
		return this.month = month;
	}

	public int setDate(int date) {
		return this.date = date;
	}

	public String setTime(String time) {
		return this.time = time;
	}
}
