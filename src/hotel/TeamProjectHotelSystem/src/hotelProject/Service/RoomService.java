package hotelProject.Service;

import java.time.LocalDate;
import java.util.Scanner;

import hotelProject.DTO.MemberDTO;
import hotelProject.DTO.RoomDTO;

public class RoomService {

	private static String status1 = "○"; // 빈 방
	private static String status2 = "●"; // 예약중
	private static String status3 = "x"; // 체크인
	
	
	

	public void roomMenu(Scanner scanner, RoomDTO[][] room, LocalDate today, RoomDTO roomDTO, MemberDTO loginStatus,
			MemberDTO nonMember, MemberDTO adminMember) {
		// 객실 메뉴 서비스

		System.out.println("==========객실 현황==========");
		System.out.println("1. 객실 확인 | 2. 뒤로 가기");
		int select = scanner.nextInt();
		switch (select) {
		case 1:
			System.out.println("객실 확인 메뉴입니다.");
			showRoomStatus(today);
			break;
		case 2:
			break;
		case 99:
			System.out.println("관리자 객실 관리메뉴입니다.");
			adminRoomMenu();
		} // 메뉴 switch 종료
	} // roomMenu() 종료

	private void adminRoomMenu() {
		
	}

	private void showRoom(RoomDTO[][] room, MemberDTO loginStatus) {
		System.out.println("예약메뉴 -> 날짜 선택");
		System.out.println("고객님이 선택하신 날짜의 객실 현황입니다.");
		for (int i = 0; i < room.length; i++) {
			for (int j = 0; j < room.length; j++) {
				if (room[i][j] != null) {
					String selectDayRoom = room[i][j].getRoomStatus();
					if (selectDayRoom.equals("체크인")) {
						System.out.println(room[i][j].getRoomNum() + "호 : " + status3);
					} else if (selectDayRoom.equals("예약중")) {
						System.out.println(room[i][j].getRoomNum() + "호 : " + status2);
					} else if (selectDayRoom.equals("빈 방")) {
						System.out.println(room[i][j].getRoomNum() + "호 : " + status1);
					} // if 종료
				} // null if 종료
			} // for 종료
		} // for 종료
		System.out.println("예약 하실 객실의 번호를 입력해주세요");

	} // showRoom() 종료
	
	
	public static void showRoomStatus(LocalDate today) {
		System.out.println("오늘 날짜 : " + today);
		System.out.println("(○ : 빈 방 | ● : 예약중 | x : 체크인)");
	}

} // class 종료
