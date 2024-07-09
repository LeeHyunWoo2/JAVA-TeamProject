package hotelProject.memberAndBoard.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import hotelProject.memberAndBoard.DTO.BoardDTO;
import hotelProject.memberAndBoard.DTO.MemberDTO;

// 자유 게시판 서비스
public class BoardService extends BoardDTO {
	// 필드
	private static int nextBoardNo = 1; // 1부터 시작하는 보드넘버

	// 메서드
	public static void menu(Scanner scanner, BoardService[] BoardServices, MemberDTO[] memberDTOs,
			MemberDTO loginState) {
		// 자유게시판
		boolean run = true;
		while (run) {
			System.out.println("1. 게시글 작성 ");
			System.out.println("2. 전체 조회");
			System.out.println("3. 게시글 수정");
			System.out.println("4. 게시글 삭제");
			System.out.println("5. 메인메뉴로");
			System.out.print(">>>");

			int select = scanner.nextInt();
			switch (select) {
			case 1:
				System.out.println("게시글을 작성해주세요.");
				BoardService.write(scanner, BoardServices, memberDTOs, loginState);// 아직 미완
				break;
			case 2:
				System.out.println("전체 자유게시글을 조회합니다.");
				BoardService.read(scanner, BoardServices, memberDTOs);
				break;
			case 3:
				System.out.println("자유게시글을 수정하세요.");
				BoardService.modify(scanner, BoardServices, memberDTOs);
				break;
			case 4:
				System.out.println("게시글을 삭제하세요.");
				BoardService.delete(scanner, BoardServices, memberDTOs, loginState);
				break;
			case 5:
				System.out.println("메인메뉴로 돌아갑니다.");
				run = false;
				break;
			default:
				System.out.println("1~4값을 입력해주세요.");
			}// switch
		} // while
	}// Boardmenu

	public static void write(Scanner scanner, BoardService[] BoardServices, MemberDTO[] memberDTOs,
			MemberDTO loginState) {
		System.out.println("작성할 게시글의 제목을 입력해주세요.");
		System.out.print(">>>");
		String newTitle = scanner.next();
		System.out.println("작성할 게시글을 입력해주세요.");
		System.out.print(">>>");
		String newContent = scanner.next();

		BoardService newBoard = new BoardService();// 새로 작성한 보드를 넣기위한 배열 생성

		newBoard.setBoardNo(nextBoardNo); // Set the board number
		newBoard.setTitle(newTitle); // Set the title
		newBoard.setContent(newContent); // Set the content
		newBoard.setRegDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())); // Set the register date;
		if (loginState != null) {// 로그인 상태이면
			newBoard.setUserName(loginState.getId());// 아이디를 username으로 사용
		} else {
			newBoard.setUserName("익명");// 로그인이 안되었므면 익명
		}
		for (int i = 0; i < BoardServices.length; i++) {// 프리보드에 길이만큼 newboard배열을 넣음
			if (BoardServices[i] == null) {
				BoardServices[i] = newBoard;
				System.out.println("저장완료");
				nextBoardNo++; // 1개를 쓸때마다 늘어나는 게시물번호
				return;
			} // if
		} // for
		System.out.println("게시판이 가득 찼습니다.");
	}// write method close

	public static void read(Scanner scanner, BoardService[] BoardServices, MemberDTO[] memberDTOs) {
		for (int i = 0; i < BoardServices.length; i++) {
			System.out.println("------------------------------------");
			System.out.printf(BoardServices[i].getBoardNo() + ". " + " 제목 : " + BoardServices[i].getTitle()
					+ "\n 작성자 : " + BoardServices[i].getUserName() + "\n 작성일 : " + BoardServices[i].getRegDate()
					+ "\n 작성 내용 : " + BoardServices[i].getContent() + "\n");
			System.out.println("------------------------------------");
			System.out.println(" ");
		} // for
	} // read close

	private static void modify(Scanner scanner, BoardService[] boardServices, MemberDTO[] memberDTOs) {
		System.out.println("수정할 게시글의 게시글 번호를 입력해주세요.");
		System.out.print(">>>");
		int modifyNo = scanner.nextInt();

		BoardService boardToModify = null; // 게시물의 정보를 찾기 위한 BoardService 공백 변수 설정
		for (BoardService board : boardServices) { // boardServices 중에서 board 객체
			if (board != null && board.getBoardNo() == modifyNo) { // 게시물번호 같고 board가 공백이 아니면
				//boardToModify = board; // 수정할 공백 보드에 보드가 들어감
				if (boardToModify == null) { // 수정할 게시물 배열이 공백이면
					System.out.println("해당 번호의 게시글을 찾을 수 없습니다.");
					return;
				}

				System.out.println("작성자 패스워드을 입력해주세요.");
				System.out.print(">>>");
				String pw = scanner.next();

				if (!boardToModify.getUserName().equals(pw)) {// 작성자가 다르면
					System.out.println("수정 권한이 없습니다.");
					return;
				}

				System.out.println("수정할 제목을 입력해주세요.");
				System.out.print(">>>");
				String modifyTitle = scanner.next();

				System.out.println("수정할 내용을 입력해주세요.");
				System.out.print(">>>");
				String modifyContent = scanner.next();

				boardToModify.setTitle(modifyTitle);
				boardToModify.setContent(modifyContent);
				boardToModify.setRegDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

				System.out.println("수정이 완료되었습니다.");
			}
				break;
			} // if
		} // for

		

	public static void delete(Scanner scanner, BoardService[] BoardServices, MemberDTO[] memberDTOs,
			MemberDTO loginState) {
		System.out.println("삭제하실 게시글의 번호를 입력해주세요.");
		System.out.print(">>>");
		int deleteNo = scanner.nextInt();

		for (int i = 0; i < BoardServices.length; i++) {// 받은 보드 배열값을 중에서
			if (BoardServices[i] != null && BoardServices[i].getBoardNo() == deleteNo) {// 게시물 번호와 직접 입력한 게시물 번호
																						// 대조
				if (loginState != null && loginState.getId().equals(BoardServices[i].getUserName())) {
					// 로그인중일시 id와 username을 대조하여
					BoardServices[i] = null;// 게시물 삭제
					System.out.println("게시글이 삭제되었습니다.");
					return;// 삭제된 값을 보내줌
				} else {
					System.out.println("삭제 권한이 없습니다.");
					return;// 삭제되지 않은 값을 보내줌

				}
			} // if
		} // for
		System.out.println("해당 번호의 게시글을 찾을 수 없습니다.");
	}// delete method close

	// 공지사항 읽기 전용
	public static void read2(Scanner scanner, BoardService[] BoardServices, MemberDTO[] memberDTOs) {
		for (int i = 0; i < BoardServices.length; i++) {
			System.out.println("------------------------------------");
			System.out.printf(BoardServices[i].getBoardNo() + ". " + " 제목 : " + BoardServices[i].getTitle()
					+ "\n 작성자 : " + BoardServices[i].getUserName() + "\n 작성일 : " + BoardServices[i].getRegDate()
					+ "\n 작성 내용 : " + BoardServices[i].getContent() + "\n");
			System.out.println("------------------------------------");
			System.out.println(" ");
		} // for
	} // read close
}
