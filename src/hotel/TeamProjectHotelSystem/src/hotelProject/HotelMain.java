package hotelProject;

import java.time.LocalDate;
import java.util.Scanner;

import hotelProject.DTO.MemberDTO;
import hotelProject.DTO.RoomDTO;
import hotelProject.Service.LoginService;
import hotelProject.Service.RoomService;

public class HotelMain {

	public static Scanner scanner = new Scanner(System.in);
	public static RoomDTO[][] room = new RoomDTO[2][9]; // 객실 배열
	public static LocalDate today = LocalDate.now();
	public static RoomDTO roomDTO = new RoomDTO();
	public static MemberDTO loginStatus; // 회원 정보
	public static MemberDTO nonMember; // 비회원 정보
	public static MemberDTO adminMember; // 관리자계정

	static {
		RoomDTO roomDTO = new RoomDTO();
		roomDTO.setRoomNum(201);
		roomDTO.setRoomType("싱글룸");
		roomDTO.setRoomStatus("예약중");
		room[0][0] = roomDTO;
	}
	
	
	public static void roomSet() { // 룸 번호 초기값 설정
		for (int i = 0 ; i < room.length ; i++) {
			for (int j = 0 ; j < room[i].length ; j++) {
			int roomNum = (i+2)*100 + (j+1);
			room[i][j].setRoomNum(roomNum);
			}
		}
	}
	
	
	
	
	public static void main(String[] args) {

		while (true) {
			System.out.println("임시 메뉴");
			System.out.println("1. 회원메뉴 2.예약메뉴 3.객실메뉴");
			int select = scanner.nextInt();
			switch (select) {
			case 1:
				LoginService loginService = new LoginService();
				break;
			case 2:
				break;
			case 3:
				RoomService roomService = new RoomService();
				roomService.roomMenu(scanner, room, today, roomDTO, loginStatus, nonMember, adminMember);
				break;
			} // switch 종료

		} // while 종료

	} // main() 종료

} // class 종료
