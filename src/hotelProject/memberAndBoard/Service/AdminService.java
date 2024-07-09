package hotelProject.memberAndBoard.Service;

import java.util.ArrayList;
import java.util.Scanner;

import hotelProject.HotelMain;
import hotelProject.memberAndBoard.DTO.MemberDTO;

//회원 관리
//객실 관리
//예약 관리
public class AdminService {

	public static void menu(Scanner scanner, MemberDTO[] memeberDTOs) {
		boolean isadmin = true;
		boolean run = true;
		while (run) {
			System.out.println("\n회원 관리 메뉴");
			System.out.println("1. 회원 목록 조회");
			System.out.println("2. ");
			System.out.println("3. ");
			System.out.println("4. ");
			System.out.println("5. 메인 메뉴로 돌아가기");
			System.out.print("선택해주세요: ");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				viewAllMembers(memeberDTOs); // 회원 조회 메서드
				break;
//			case 2:
//				roomCheck(scanner); // 객실 조회 메서드
//				break;
//			case 3:
//				reserveCheck(scanner); // 예약 조회 메서드
//				break;
			case 4:
				run = false;
				System.out.println("메인 메뉴로 돌아갑니다.");
				break;
			default:
				System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
			}
		}
	}

	private void reserveCheck(Scanner scanner) {
		// TODO Auto-generated method stub

	}

	private void roomCheck(Scanner scanner) {
		// TODO Auto-generated method stub

	}

	private static void viewAllMembers(MemberDTO[] memberDTOs) {
		for (int i = 0; i < memberDTOs.length; i++) {
			if (memberDTOs[i] == null) {
				System.out.println("등록된 회원이 없습니다.");
				return;
			}
		}

		System.out.println("\n회원 목록:");
		for (int i = 0; i < memberDTOs.length; i++) {
			MemberDTO member = memberDTOs[i];
			System.out.println((i + 1) + ". ID: " + member.getId() + ", 이름: " + member.getName() + ", 핸드폰번호: "
					+ member.getPhoneNumber() + ", 이메일: " + member.getEmail());
		}
	}
}
