package hotelProject.memberAndBoard.Service;

import java.util.Scanner;

import hotelProject.memberAndBoard.DTO.MemberDTO;

public class LoginService extends MemberDTO {

	public MemberDTO menu(Scanner scanner, MemberDTO[] MemberDTOs, MemberDTO loginState) {
		// 부메뉴
		System.out.println("회원가입, 로그인, 회원수정 페이지");

		boolean run = true;
		while (run) {
			System.out.println("1. 회원 가입 2. 로그인 3. 회원 수정 4. 회원 삭제 5. 메인메뉴로");
			int select = scanner.nextInt();
			switch (select) {
			case 1:
				MemberDTO memberDTO = new MemberDTO();
				System.out.println("계정을 생성하기");
				System.out.println("ID를 입력하세요.");
				memberDTO.setId(scanner.next());
				System.out.println("PW를 입력하세요.");
				memberDTO.setPw(scanner.next());
				System.out.println("핸드폰 번호를 입력하세요.");
				memberDTO.setPhoneNumber(scanner.next());
				System.out.println("성함을 입력하세요.");
				memberDTO.setName(scanner.next());
				System.out.println("주소을 입력하세요.");
				memberDTO.setAddress(scanner.next());

				for (int i = 0; i < MemberDTOs.length; i++) {
					if (MemberDTOs[i] == null) {
						MemberDTOs[i] = memberDTO;
						System.out.println("계정이 생성되었습니다.");
						System.out.println(MemberDTOs[i].getId() + "님 로그인해주세요.");
						break;
					} // if
				} // for
				break;
			case 2:

//				System.out.println("로그인 페이지");
//				System.out.println("아이디를 입력하세요.");
//				String id = scanner.next();
//				System.out.println("비밀번호를 입력하세요.");
//				String pw = scanner.next();
//
//				MemberDTO login = new MemberDTO(); //
//				login.setId(id); // set
//				login.setPw(pw); // set
//				for (int i = 0; i < MemberDTOs.length; i++) {// get
//					if (MemberDTOs[i] != null) {
//						if (MemberDTOs[i].getId().equals(id)) {
//							System.out.println("아이디 확인");
//						}
//						if (MemberDTOs[i].getPw().equals(pw)) {
//							System.out.println("비밀번호 확인");
//						}
//						System.out.println("로그인 성공!");
//						login = MemberDTOs[i];
//						loginState = login;
//						break;
//					} else {
//						System.out.println("아이디나 비밀번호가 존재하지 않습니다.");
//						break;
//					}

				MemberDTO loginMember = new MemberDTO();

				System.out.println("아이디");
				System.out.print(">>>");
				loginMember.setId(scanner.next());

				System.out.println("비밀번호");
				System.out.print(">>>");
				loginMember.setPw(scanner.next());

				for (int i = 0; i < MemberDTOs.length; i++) {
					if (MemberDTOs[i] != null) {
						if (MemberDTOs[i].getId().equals(loginMember.getId())
								&& MemberDTOs[i].getPw().equals(loginMember.getPw())) {
							loginMember = MemberDTOs[i];
							break;
						}
					} else {
						System.out.println("아이디 비밀번호 재확인필요");
						loginMember = null;
						loginState = loginMember;
						break;
					} // else종료

				} // for종료
				break;
			case 3:
				System.out.println("계정을 수정하기");
				System.out.println("자신의 id 입력해주세요.");
				String modifyId = scanner.next();
				System.out.println("바꾸실 비밀번호를 입력해주세요.");
				String modifyPw = scanner.next();

				for (int i = 0; i < MemberDTOs.length; i++) {
					if (MemberDTOs[i] != null) {
						if (MemberDTOs[i].getId().equals(modifyId)) {
							MemberDTOs[i].setPw(modifyPw);// 수정한 비밀번호를 저장
							loginState = MemberDTOs[i];// 수정한 로그인상태를 저장
							System.out.println("수정완료");
						} // if
					} // if
				} // for
				break;
			case 4:
				System.out.println("계정을 삭제하기");
				System.out.println("삭제할 id를 입력해주세요.");
				String deleteId = scanner.next();
				for (int i = 0; i < MemberDTOs.length; i++) {
					if (deleteId != null && MemberDTOs[i].getId() == deleteId) {
						MemberDTOs[i] = null;
					} // if
				} // for
				break;

			case 5:
				run = false;
				break;
			case 99:
				System.out.println("관리자 로그인 페이지");
				System.out.println("아이디를 입력하세요.");
				String id2 = scanner.next();
				System.out.println("비밀번호를 입력하세요.");
				String pw2 = scanner.next();

				if (id2.equals("admin") && pw2.equals("0000")) {
					System.out.println("관리자 로그인 성공!");
					MemberDTO adminLoginState = new MemberDTO(); // 로그인 하기 위한 객체생성
					adminLoginState.setId("admin");
					adminLoginState.setPw("0000");
					AdminService.menu(scanner, MemberDTOs);

				} else {
					System.out.println("관리자 로그인 실패. 아이디 또는 비밀번호가 올바르지 않습니다.");
				}
				break;
			default:
				System.out.println("잘못된 선택입니다. 다시 선택해주세요.");

			} // switch main
		} // menu
		return loginState;
	}
// class
}