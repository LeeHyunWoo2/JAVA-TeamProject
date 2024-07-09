package hotelProject.reservation;

import java.util.Scanner;

import hotelProject.memberAndBoard.DTO.MemberDTO;

public class ReservationMenu {
	public static Scanner scanner = new Scanner(System.in);

	public void reservationMainMenu(Scanner scanner, MemberDTO loginState, ReservationDTO[][][] reservationDTOs,
			MemberDTO[] memberDTOs) {
		boolean run = true;
		while (run) {
			System.out.println("1. 예약하기 2. 예약조회 3. 예약변경 4. 예약취소 5. 뒤로가기");
			System.out.println("===================================================");
			System.out.print(">>> ");
			int select = scanner.nextInt();
			switch (select) {
			case 1:
				ReservationSV reservation = new ReservationSV();
				reservation.reservation(scanner, reservationDTOs, loginState, memberDTOs);
				break;

			case 2:
				check(scanner, loginState, memberDTOs);
				break;

			case 3:
				modify(scanner, loginState, reservationDTOs, memberDTOs);
				break;

			case 4:
				delete(scanner, loginState, memberDTOs);
				break;

			case 5:
				run = false;
				break;

			default:
				System.out.println("잘못된 입력입니다. 1~5까지 입력해주세요.");

			} // switch 종료
		} // while 종료
	} // main 종료

	public static void delete(Scanner scanner, MemberDTO loginState, MemberDTO[] memberDTOs) {

		if (loginState != null) {
			for (int i = 0; i < memberDTOs.length; i++) {
				if (loginState.getId().equals(memberDTOs[i].getId())
						&& loginState.getPw().equals(memberDTOs[i].getPw())) {
					System.out.println("현재 예약하신 내용");
					System.out.println();
					System.out.println("예약을 취소하시겠습니까?");
					System.out.println("1. Yes  2. No");
					int select = scanner.nextInt();
					switch (select) {
					case 1:
						memberDTOs[i] = null;
						System.out.println("예약이 취소되었습니다. 감사합니다.");
						break;

					case 2:
						System.out.println("전 화면으로 이동합니다.");
						break;

					default:
						System.out.println("잘못된 입력입니다. 1~2까지 입력해주세요.");
					} // if 종료
				} // 회원 switch 종료
			} // for 종료
		} else if (loginState == null) {
			System.out.println("예약정보를 입력해주세요");
			System.out.print("이름 : ");
			String name = scanner.next();
			System.out.print("번호 : ");
			String num = scanner.next();

			for (int i = 0; i < memberDTOs.length; i++) {
				if (memberDTOs[i] != null) {
					if (memberDTOs[i].getNonName().equals(name) && memberDTOs[i].getNonnum().equals(num)) {
						System.out.println("현재 예약하신 내용");
						System.out.println("예약자 성함 : " + memberDTOs[i].getNonName());
						System.out.println("예약자 번호 : " + memberDTOs[i].getNonnum());
						// System.out.println(""); 방 타입 DTO 붙히기
						System.out.println("예약날짜 : " + memberDTOs[i].getYear() + ". " + memberDTOs[i].getMonth() + ". "
								+ memberDTOs[i].getDate());
						System.out.println("예약시간 : " + memberDTOs[i].getTime());
						System.out.println("예약을 취소하시겠습니까?");
						System.out.println("1. Yes  2. No");
						int select = scanner.nextInt();
						switch (select) {
						case 1:
							System.out.println(name + " 님 예약이 취소되었습니다.");
							memberDTOs[i] = null;
							break;

						case 2:
							System.out.println("전 화면으로 이동합니다.");
							break;

						default:
							System.out.println("잘못된 입력입니다. 1~2까지 입력해주세요.");
						} // 수정내용 switch 종료
					} // 이름 번호 비교 종료
				} // null 아닌것 찾기 if 종료
			} // 비회원 for 종료
		} // loginState 비교 종료
	} // delete 종료

	public static void modify(Scanner scanner, MemberDTO loginState, ReservationDTO[][][] reservationDTOs,
			MemberDTO[] memberDTOs) {

		if (loginState != null) {
			System.out.println("접수하신 예약의 변경하실 번호를 입력해주세요.");
			System.out.println("1. 날짜변경 2. 방 타입변경 3. 뒤로가기");
			int select = scanner.nextInt();
			switch (select) {
			case 1:
				// 멤버 객체에 들어간 방 날짜 변경 get = set
				// reservationDTO[selectYear][selectMonth][selectDate]
				break;

			case 2:
				// 맴버 객체에 들어간 방 타입 DTO 변경 get = set
				break;

			case 3:
				System.out.println("전 화면으로 이동합니다.");
				break;
			} // 수정내용 switch 종료
		} else if (loginState == null) {
			System.out.println("예약정보를 입력해주세요");
			System.out.print("이름 : ");
			String name = scanner.next();
			System.out.print("번호 : ");
			String num = scanner.next();

			for (int i = 0; i < memberDTOs.length; i++) {
				if (memberDTOs[i] != null) {
					if (memberDTOs[i].getNonName().equals(name) && memberDTOs[i].getNonnum().equals(num)) {
						System.out.println("현재 예약하신 내용");
						System.out.println("예약자명 : " + memberDTOs[i].getNonName());
						System.out.println("전화번호 : " + memberDTOs[i].getNonnum());
						System.out.println("접수하신 예약의 변경하실 번호를 입력해주세요.");
						System.out.println("1. 날짜변경 2. 방 타입변경 3. 뒤로가기");
						System.out.print(">>> ");
						int select = scanner.nextInt();
						switch (select) {
						case 1:
							System.out.println("기존 예약날짜");
							System.out.println("예약날짜 : " + memberDTOs[i].getYear() + ". " + memberDTOs[i].getMonth()
									+ ". " + memberDTOs[i].getDate());
							System.out.println("===================================================");
							System.out.println("변경하실 날짜를 입력해주세요.");
							System.out.print("년 : ");
							int selectYear = scanner.nextInt();
							System.out.print("월 : ");
							int selectMonth = scanner.nextInt();
							System.out.print("일 : ");
							int selectDate = scanner.nextInt();

							memberDTOs[i].setYear(selectYear);
							memberDTOs[i].setMonth(selectMonth);
							memberDTOs[i].setDate(selectDate);
							System.out.println("===================================================");
							System.out.println("예약날짜 : " + memberDTOs[i].getYear() + ". " + memberDTOs[i].getMonth()
									+ ". " + memberDTOs[i].getDate() + " 로 변경 완료되었습니다.");
							break;

						case 2:
							// 방 DTO 변경 넣기
							break;

						case 3:
							System.out.println("이전 화면으로 이동합니다.");
							break;

						default:
							System.out.println("잘못된 입력입니다. 1~3까지 입력해주세요.");
						} // switch 종료
					} // name num 비교 종료
				} // 비회원 null 찾기 종료
			} // 비회원 for 종료

		} // 로그인상태 if 종료
	} // modify 종료

	public void check(Scanner scanner, MemberDTO loginState, MemberDTO[] memberDTOs) {
		if (loginState != null) {
			System.out.println(" 회원님께서 예약하신 내용입니다.");
			System.out.println(loginState.getName()+"님의 예약 정보 입니다\n나중에만들겠습니다"); // 방 정보 가져오기
		} else if (loginState == null) {
			System.out.println("예약정보를 입력해주세요");
			System.out.print("이름 : ");
			String name = scanner.next();
			System.out.print("번호 : ");
			String num = scanner.next();

			for (int i = 0; i < memberDTOs.length; i++) {
				if (memberDTOs[i] != null) {
					if (memberDTOs[i].getNonName().equals(name) && memberDTOs[i].getNonnum().equals(num)) {
						System.out.println("현재 예약하신 내용");
						System.out.println("예약자 성함 : " + memberDTOs[i].getNonName()); // 멤버객채 방 정보 가져오기
						System.out.println("예약자 번호 : " + memberDTOs[i].getNonnum());
						// System.out.println(""); 방 타입 DTO 붙히기
						System.out.println("예약날짜 : " + memberDTOs[i].getYear() + ". " + memberDTOs[i].getMonth() + ". "
								+ memberDTOs[i].getDate());
						System.out.println("예약시간 : " + memberDTOs[i].getTime());
					} else {
						System.out.println("입력하신 정보가 없습니다.");
					} // 비회원 비교 종료
				} // 맴버객체 null이 아닐때 종료
			} // 비회원 for 종료
		} // 로그인상태 조회 if 종료
	} // check 종료

} // class 종료
