package hotelProject.room.DTO;

import hotelProject.memberAndBoard.DTO.MemberDTO;

public class RoomDTO {
   // 필드
   private int roomNum;
   private String roomType;
   private String roomStatus;
   private int roomPrice;
   private MemberDTO loginState;

   // 생성자

   public RoomDTO(int roomNum) {
      this.roomNum = roomNum;
      if (roomNum > 200 && roomNum < 300) {
         roomType = "싱글룸";
         roomPrice = 100000;
      } else if (roomNum > 300 && roomNum < 400) {
         roomType = "더블룸";
         roomPrice = 200000;
      } else {
         roomType = "패밀리룸";
         roomPrice = 300000;
      }
      roomStatus = "빈방"; // 초기화한 후 예약받을 때 상태 변경
   }

   // 메서드

   public int getRoomPrice() {
      return roomPrice;
   }

   public void setRoomPrice(int roomPrice) {
      this.roomPrice = roomPrice;
   }

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

   public MemberDTO getLoginState() {
      return loginState;
   }

   public void setLoginState(MemberDTO loginState) {
      this.loginState = loginState;
   }

   @Override
   public String toString() {
      return "[객실 번호 : " + roomNum + ", 객실 타입 : " + roomType + ", 현재 객실 상태 : " + roomStatus + ", 객실 가격 : "
            + roomPrice + ", 고객 정보 : " + loginState + "]";
   }
}