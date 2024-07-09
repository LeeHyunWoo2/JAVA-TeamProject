package hotelProject;

import java.util.ArrayList;
import java.util.Scanner;

import hotelProject.crime.EventService;
import hotelProject.memberAndBoard.DTO.MemberDTO;
import hotelProject.memberAndBoard.DTO.ReviewDTO;
import hotelProject.memberAndBoard.Service.BoardService;
import hotelProject.memberAndBoard.Service.LoginService;
import hotelProject.memberAndBoard.Service.QABoardService;
import hotelProject.reservation.ReservationDTO;
import hotelProject.reservation.ReservationMenu;
import hotelProject.room.DTO.RoomDTO;
import hotelProject.room.Service.RoomService;

public class HotelMain {

	public static Scanner scanner = new Scanner(System.in);
	public static ArrayList<ReviewDTO> reviewDTOs = new ArrayList<ReviewDTO>();
	public static BoardService[] boardservices = new BoardService[100];
	public static QABoardService[] qaBoardservices = new QABoardService[100];
	public static MemberDTO[] memberDTOs = new MemberDTO[100];
	public static ReservationDTO[][][] reservationDTOs = new ReservationDTO[9999][12][31];
	public static RoomDTO[][] rooms = new RoomDTO[3][10];

	public static MemberDTO loginState;

	// static으로 메인에 저장하면 배열의 경우는 값 안받아와도 상관없지만
	// loginState 같은 배열이 아닌

	// 룸 초기화
	public static void roomSet() {
		// 룸 객체 생성(생성자 파라미터: 룸번호)
		// 룸 번호 설정 Room[0][1] = 202 -> (0+2)x100+(1+1)=202
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[i].length; j++) {
				int roomNum = (i + 2) * 100 + (j + 1);
				rooms[i][j] = new RoomDTO(roomNum);
			}
		}
	}

	static {
		MemberDTO adminDTO = new MemberDTO();
		adminDTO.setId("admin");
		adminDTO.setPw("0000");
		memberDTOs[0] = adminDTO;

		MemberDTO login = new MemberDTO();
		login.setId("123");
		login.setPw("123");
		login.setName("사용자");
		login.setEmail("123");
		login.setPhoneNumber("123");
		login.setAddress("123");
		login.setSsn("123");
		memberDTOs[1] = login;

	}

	public static void main(String[] args) {
		roomSet();

		while (true) {
			System.out.println("임시 메뉴");
			System.out.println("1. 회원메뉴 2. 객실메뉴 3. 예약메뉴");
			int select = scanner.nextInt();
			switch (select) {
			case 1:
				LoginService loginService = new LoginService();
				loginState = loginService.menu(scanner, memberDTOs, loginState);
				break;
			case 2:
				RoomService roomService = new RoomService();
				roomService.menu(scanner, rooms, loginState);
				break;
			case 3:
				ReservationMenu reservationMenu = new ReservationMenu();
				reservationMenu.reservationMainMenu(scanner, loginState, reservationDTOs, memberDTOs);
				break;
			case 4:
				EventService eventService = new EventService();
				System.out.println("\n\n\nZ");
				try {
					Thread.sleep(700); // 5초 동안 지연
				} catch (InterruptedException e) {
					e.printStackTrace();
				} // try-catch 종료
				System.out.println("\n\n\n\nZzz");
				try {
					Thread.sleep(700); // 5초 동안 지연
				} catch (InterruptedException e) {
					e.printStackTrace();
				} // try-catch 종료
				System.out.println("\n\n\n\nZzzzzzz");
				try {
					Thread.sleep(700); // 5초 동안 지연
				} catch (InterruptedException e) {
					e.printStackTrace();
				} // try-catch 종료
				System.out.println("\n\n\n\nZzzzzzzzzzzzz\n\n\n\n");
				eventService.crimeMenu(scanner);
				break;
			}

		}

	}

}
