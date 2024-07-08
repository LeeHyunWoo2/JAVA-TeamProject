package hotelProject.DTO;

public class RoomDTO {
	// 필드
	private int roomNum; // 룸 번호
	private String roomType; // 룸 타입
	private String roomStatus; // 룸 상태 ( 체크인, 예약중, 빈방)
	RoomDTO roomDTO;

	// 생성자

	// 메서드
	

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
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


}
