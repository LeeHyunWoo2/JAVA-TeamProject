package hotelProject.room.Service;

import java.time.LocalDate;
import java.util.Scanner;
import hotelProject.memberAndBoard.DTO.MemberDTO;
import hotelProject.room.DTO.RoomDTO;

public class RoomService {
	// 객실관리 서비스

	private static String booking1 = "○ "; // 빈방
	private static String booking2 = "X "; // 체크인
	private static String booking3 = "● "; // 예약중
	private static String booking4 = "※ "; // 청소 요망

	public void menu(Scanner scanner, RoomDTO[][] rooms, MemberDTO loginState) {
		boolean run = true;
		while (run) {
			System.out.println("=====객실 관리 서비스메뉴입니다=====");
			System.out.println("1. 호텔 소개 \t 2. 객실 현황 \t 3. 객실 정보 \t 4. 결제 하기 \t 5. 뒤로 가기");
			int select = scanner.nextInt();
			switch (select) {
			case 1:
				hotelIntroduction(scanner);
				break;
			case 2:
				System.out.println("객실 현황입니다.");
				roomStatus(rooms);
				break;
			case 3:
				System.out.println("객실 정보입니다.");
				System.out.println("┌───────────┐");
				System.out.println("│□ □ □ □ □ □│  6층 : 라운지, 수영장");
				System.out.println("│□ □ □ □ □ □│  5층 : 웨딩홀");
				System.out.println("│□ □ □ □ □ □│  4층 : 패밀리룸");
				System.out.println("│□ □ □ □ □ □│  3층 : 더블룸");
				System.out.println("│□ □ □ □ □ □│  2층 : 싱글룸, 레스토랑");
				System.out.println("│□ □ □ □ □ □│  1층 : 프런트 & 로비(비즈니스 센터)");
				System.out.println();
				roomInformation(rooms);
				break;
			case 4:
				System.out.println("결제를 진행합니다.");
				payment(scanner, rooms, loginState);
			case 5:
				run = false;
				break;
			case 99: // 히든 메뉴 (관리자)
				System.out.println("관리자 메뉴로 진입합니다.");
				roomAdmin(scanner, rooms);
				break;
			default:
				System.out.println("1~3 사이 번호를 입력해주세요");
			} // switch 종료
		} // while 종료
	} // menu() 종료

	// 결제 메서드
	private static void payment(Scanner scanner, RoomDTO[][] rooms, MemberDTO loginState) {
		System.out.println("1. 예약 객실 결제하기 | 2. 부가서비스 결제하기");
		int select = scanner.nextInt();
		switch (select) {
		case 1:
			System.out.println("예약한 객실 결제를 위해 본인 인증 부탁드립니다.");
			System.out.println("예약자 성함과 연락처를 입력해주세요");
			System.out.print("이름 : ");
			String name = scanner.next();
			System.out.print("연락처 : ");
			String phone = scanner.next();
			if (loginState.getName().equals(name)) {
				if (loginState.getPhoneNumber().equals(phone)) {
					for (int i = 0; i < rooms.length; i++) {
						for (int j = 0; j < rooms[i].length; j++) {
							if (rooms[i][j] != null) {
								System.out.println("정보가 일치합니다.");
								System.out.println("고객님의 연락처로 발송된 문자의 인증번호를 입력해주세요");
								System.out.println("임시 인증번호(랜덤) : " + (int) Math.random() * 99 + 10);
								System.out.println("인증이 완료되었습니다.");
								System.out.println("예약 내역 : " + loginState.getBasket());
								System.out.println("결제하시겠습니까? 1. Y | 2. N");
								int num = scanner.nextInt();
								if (num == 1) {
									System.out.println("고객님의 연락처 정보로 온라인 결제가 완료되었습니다.");
								} else {
									System.out.println("다시 진행해주세요");
								}
								break;
							} // 결제 if 종료
						} // j for 종료
						System.out.println("예약자 정보가 없습니다.");
					} // i for 종료
				} // phone if 종료
			} // name if 종료
			break;
		case 2:
			System.out.println("레스토랑, 수영장, 웨딩홀 등의 서비스는 관리자에게 문의하셔야 합니다.");
			System.out.println("관리자 연락처 : 010-8849-57**");
			System.out.println("편하게 언제든지 연락주세요");
			break;
		default:
			System.out.println("1~2 사이의 번호를 입력해주세요");
		} // switch 종료
	} // payment() 종료

	// 호텔 정보
	private static void hotelIntroduction(Scanner scanner) {
		System.out.println("고전적인 우아함을 현대적인 감각으로 재해석한 5성급 럭셔리 리조트 호텔입니다.");
		System.out.println("1. room | 2. things");
		int select = scanner.nextInt();
		switch (select) {
		case 1:
			System.out.println("싱글룸 (100,000원) : 전 객실 발코니를 보유한 싱글룸은 넓고 쾌적한 공간감으로 진정한 휴식을 제공합니다.");
			System.out.println("더블룸 (200,000원) : 침실과 거실을 연결하여 머무는 즐거움을 극대화했습니다.");
			System.out.println("패밀리룸 (300,000원) : 키즈 전용 침실과 실내 놀이시설을 통해 부모와 아이에게 최고의 경험을 제공하는 패밀리룸입니다.");
			break;
		case 2:
			System.out.println(
					"2층 레스토랑 : 탁트인 전망과 함께 식사를 즐길 수 있는 레스토랑은 전문 쉐프가 신선한 재료로 준비한 조식, 디너 뷔페와 함께 중식에는 고품격 단품 메뉴가 준비되어 있습니다.");
			System.out.println("5층 웨딩홀 : 야외 웨딩, 리마인드 웨딩 등 소중한 사람들과 함께 소규모 특별한 결혼식을 올릴 수 있습니다.");
			System.out.println("6층 라운지 & 수영장 : 호텔 고객들을 위해 특별히 제작된 인피니티 풀로 마치 호수에 떠있는 듯한 환상적인 분위기를 즐길 수 있습니다.");
			System.out.println("이용문의는 관리자에게 연락주세요");
			break;
		default:
			System.out.println("1~2 사이 번호를 입력해주세요");
		} // switch 종료
	} // hotelIntroduction() 종료

	// 객실 정보 보기 (손님)
	private static void roomInformation(RoomDTO[][] rooms) {
		for (int i = 0; i < rooms.length; i++) {
			System.out.println("\n" + "*" + (i + 2) + "층*" + "\n");
			for (int j = 0; j < rooms[i].length; j++) {
				System.out.println("객실 번호 : " + rooms[i][j].getRoomNum() + "\t 객실 타입 : " + rooms[i][j].getRoomType()
						+ "\t \t 현재 객실 상태 : " + rooms[i][j].getRoomStatus()); // loginState의 예약된 정보가 나옴
			} // j for 종료
		} // i for 종료
	} // roomInformation() 종료

	// 객실 현황 보기 (손님)
	private static void roomStatus(RoomDTO[][] rooms) {
		System.out.println("오늘 날짜 : " + LocalDate.now());
		System.out.println("(○:예약 가능 X:예약 불가)");
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[i].length; j++) {
				String todayStatus = rooms[i][j].getRoomStatus();
				if (todayStatus.equals("체크인")) {
					System.out.print((i + 2) * 100 + (j + 1) + "호 : " + booking2 + "  ");
				} else if (todayStatus.equals("예약중")) {
					System.out.print((i + 2) * 100 + (j + 1) + "호 : " + booking2 + "  ");
				} else if (todayStatus.equals("빈방")) {
					System.out.print((i + 2) * 100 + (j + 1) + "호 : " + booking1 + "  ");
				} else {
					System.out.print((i + 2) * 100 + (j + 1) + "호 : " + booking2 + "  ");
				} // if 종료
			} // j for 종료
			System.out.println();
		} // i for 종료
	} // roomStatus() 종료

	// 관리자 메뉴진입 (히든메뉴)
	private static void roomAdmin(Scanner scanner, RoomDTO[][] rooms) {
		boolean run = true;
		while (run) {
			System.out.println("***관리자 객실 메뉴입니다***");
			System.out.println("1. 객실 현황 \t 2. 객실 정보");
			System.out.println("3. 체크인 \t 4. 체크아웃 및 청소");
			System.out.println("5. 뒤로가기");
			int select = scanner.nextInt();
			switch (select) {
			case 1:
				System.out.println("객실 현황입니다.");
				roomStatusAdmin(rooms);
				break;
			case 2:
				System.out.println("객실 정보입니다.");
				roomInformationAdmin(rooms);
				break;
			case 3:
				System.out.println("체크인 입니다.");
				checkIn(scanner, rooms);
				break;
			case 4:
				System.out.println("체크아웃입니다.");
				checkOut(scanner, rooms);
				break;
			case 5:
				run = false;
				break;
			default:
				System.out.println("1~5 사이 번호를 입력해주세요");
			} // switch 종료
		} // while 종료
	} // roomAdmin() 종료

	// 체크아웃 (체크인 -> 청소 요망 -> 빈방)
	public static void checkOut(Scanner scanner, RoomDTO[][] rooms) {
		System.out.println("객실 번호를 입력해주세요");
		System.out.print(">>>");
		int roomNum = scanner.nextInt();
		int indexFloor = roomNum / 100 - 2; // ex) 301호 -> 301/100 = 3 - 2 = 1 ( 배열의 1번 값 )
		int indexNum = roomNum % 100 - 1; // ex) 301호 -> 301 % 100 = 1 - 1 = 0 ( 배열의 0번 값 )

		rooms[indexFloor][indexNum].setRoomStatus("청소 요망");
//		rooms[indexFloor][indexNum].getLoginState().getName();
//		rooms[indexFloor][indexNum].getLoginState().getPhoneNumber();
		// 어차피 저장된 정보라서 없어도 되기 때문에 주석처리
		System.out.println(rooms[indexFloor][indexNum].toString());
		System.out.println("체크아웃 완료");

		System.out.println("객실 청소를 진행하시겠습니까?");
		System.out.println("1. Y \t 2. N");
		int select = scanner.nextInt();
		switch (select) {
		case 1:
			for (int i = 0; i < 1; i++) {
				System.out.println("객실 청소 중");
				try {
					Thread.sleep(2000); // 2초 동안 지연
				} catch (InterruptedException e) {
					e.printStackTrace();
				} // try-catch 종료
				rooms[indexFloor][indexNum].setRoomStatus("빈방");
				rooms[indexFloor][indexNum].setLoginState(null);
				System.out.println(rooms[indexFloor][indexNum].toString());
				System.out.println("객실 청소가 완료되었습니다!!!");
			} // for 종료
			break;
		case 2:
			break;
		default:
			System.out.println("1~2사이의 번호를 선택해주세요");
		}// switch 종료
	} // checkOut() 종료

	// 예약고객 체크인 (빈방, 예약중 -> 체크인)
	public static void checkIn(Scanner scanner, RoomDTO[][] rooms) {
		System.out.println("객실 번호를 입력해주세요");
		System.out.print(">>>");
		int roomNum = scanner.nextInt();
		int indexFloor = roomNum / 100 - 2;
		int indexNum = roomNum % 100 - 1;

		rooms[indexFloor][indexNum].setRoomStatus("체크인");
		System.out.println(rooms[indexFloor][indexNum].toString());
		System.out.println("체크인 완료");
	} // checkIn() 종료

	// 객실의 정보 확인 (관리자)
	public static void roomInformationAdmin(RoomDTO[][] rooms) {
		for (int i = 0; i < rooms.length; i++) {
			System.out.println("\n" + "*" + (i + 2) + "층*" + "\n");
			for (int j = 0; j < rooms[i].length; j++) {
				System.out.println(rooms[i][j].toString()); // loginState의 예약된 정보가 나옴
			} // j for 종료
		} // i for 종료
	} // roomInformation() 종료

	// 객실 현황 보기 (관리자)
	public static void roomStatusAdmin(RoomDTO[][] rooms) {
		System.out.println("오늘 날짜 : " + LocalDate.now());
		System.out.println("(○:빈방  ●:예약중  X:체크인  ※:청소요망)");
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[i].length; j++) {
				String todayStatus = rooms[i][j].getRoomStatus();
				if (todayStatus.equals("체크인")) {
					System.out.print((i + 2) * 100 + (j + 1) + "호 : " + booking2 + "  ");
				} else if (todayStatus.equals("예약중")) {
					System.out.print((i + 2) * 100 + (j + 1) + "호 : " + booking3 + "  ");
				} else if (todayStatus.equals("빈방")) {
					System.out.print((i + 2) * 100 + (j + 1) + "호 : " + booking1 + "  ");
				} else {
					System.out.print((i + 2) * 100 + (j + 1) + "호 : " + booking4 + "  ");
				} // if 종료
			} // j for 종료
			System.out.println();
		} // i for 종료
	} // roomStatus() 종료
}