package room;

import java.sql.Date;

public class RoomDTO {

	// 필드
	private String roomNum; // 객실 번호
	private String roomType; // 객실 타입
	private String roomStatus; // 객실 상태
	private String roomPrice; // 객실 가격
	private String roomCheckInNO; // 체크인
	private String roomCheckOutNO; // 체크아웃
	private String roomUser; // 사용자
	
	
	// 생성자
	
	
	
	
	// 메서드
	public String getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getRoomStatus() {
		return roomStatus;
	}
	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}
	public String getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(String roomPrice) {
		this.roomPrice = roomPrice;
	}
	public String getRoomCheckInNO() {
		return roomCheckInNO;
	}
	public void setRoomCheckInNO(String roomCheckInNO) {
		this.roomCheckInNO = roomCheckInNO;
	}
	public String getRoomCheckOutNO() {
		return roomCheckOutNO;
	}
	public void setRoomCheckOutNO(String roomCheckOutNO) {
		this.roomCheckOutNO = roomCheckOutNO;
	}
	public String getRoomUser() {
		return roomUser;
	}
	public void setRoomUser(String roomUser) {
		this.roomUser = roomUser;
	}
}
