package hotelProject.Service;

import java.util.Scanner;

import hotelProject.DTO.MemberDTO;



public class LoginService {
	public static MemberDTO menu(Scanner scanner, MemberDTO[] memberDTOs, MemberDTO loginState) {
		// 부메뉴
		System.out.println("회원 관리 페이지");
			
		boolean run = true;
		while (run) {
			
			int select = scanner.nextInt();
			switch (select) {
		System.out.println("1. 회원 가입 2. 로그인 3. 회원 수정 4. 회원 삭제 5. 메인메뉴로");
		int select = scanner.nextInt();
		switch (select) {
		case 1:
			System.out.println("계정을 생성하기");
			System.out.println("ID를 입력하세요.");
			String newId = scanner.next();
			System.out.println("PW를 입력하세요.");
			String newPw = scanner.next();
			System.out.println("핸드폰 번호를 입력하세요.");
			String newPhoneNum = scanner.next();
			System.out.println("성함을 입력하세요.");
			String newName = scanner.next();
			System.out.println("주소을 입력하세요.");
			String newAdress = scanner.next();
			System.out.println("을 입력하세요.");
			String newSsn = scanner.next();
			
			MemberDTO newmemberDTO = new MemberDTO();
			newmemberDTO.setId(newId);
			newmemberDTO.setPw(newPw);
			for (int i = 0; i < memberDTOs.length; i++) {
				if (memberDTOs[i] == null) {
					System.out.println("계정이 생성되었습니다.");
					memberDTOs[i] = newmemberDTO;
					loginState = memberDTOs[i]; // 로그인상태를 저장
					System.out.println(memberDTOs[i].getId() + "님 로그인해주세요.");
					break;
				}//if
			}//for
			break;
		case 2:
			
			System.out.println("로그인 페이지");
			System.out.println("아이디를 입력하세요.");
			String id = scanner.next();
			System.out.println("비밀번호를 입력하세요.");
			String pw = scanner.next();
		
			MemberDTO memberDTOs1 = new MemberDTO(); //
			memberDTOs1.setId(id); // set
			memberDTOs1.setPw(pw); // set
			for (int i = 0; i < memberDTOs.length; i++) {// get
				if (memberDTOs[i] != null) {
					if (memberDTOs1.getId().equals(id)) {
						System.out.println("아이디가 존재합니다.");
					} else {
						System.out.println("아이디가 틀립니다.");}
						if (memberDTOs1.getPw().equals(pw)) {
							System.out.println("비밀번호가 존재합니다.");
						} else {
							System.out.println("비밀번호가 틀렸습니다."); }
							loginState = memberDTOs[i];
							System.out.println("로그인 성공!");
							break;							
				} else {
					System.out.println("잘못된 입력");
					break;
				}
			} // for close
			break;
		case 3:
			System.out.println("계정을 수정하기");
			System.out.println("자신의 id 입력해주세요.");
			String modifyId = scanner.next();
			System.out.println("바꾸실 비밀번호를 입력해주세요.");
			String modifyPw = scanner.next();

			for (int i = 0; i < memberDTOs.length; i++) {
				if (memberDTOs[i] != null) {
					if (memberDTOs[i].getId().equals(modifyId)) {
						memberDTOs[i].setPw(modifyPw);//수정한 비밀번호를 저장
						loginState = memberDTOs[i];// 수정한 로그인상태를 저장
						System.out.println("수정완료");
					}//if
				}//if
			}//for
			break;
		case 4:
			System.out.println("계정을 삭제하기");
			System.out.println("삭제할 id를 입력해주세요.");
			String deleteId = scanner.next();
			for (int i = 0; i < memberDTOs.length; i++) {
				if (deleteId != null && memberDTOs[i].getId() == deleteId) {
					memberDTOs[i] = null;
				} // if
			} // for
			break;
		case 5:
			run = false;
		default:
			System.out.println("1~4값을 입력해주세요.");
		}
	} // switch main
	return loginState;
}// while

