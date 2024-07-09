package hotelProject.memberAndBoard.Service;

import java.util.Scanner;

import hotelProject.memberAndBoard.DTO.BoardDTO;
import hotelProject.memberAndBoard.DTO.MemberDTO;

public class QABoardService extends BoardDTO {
	String question;
	String answer;
	private static int nextBoardNo = 1;
	

	public static void menu(Scanner scanner, QABoardService[] qaBoardServices, MemberDTO loginState) {
		// 질문 게시판 메뉴
		boolean run = true;
		while (run) {
			System.out.println("1. 질문 작성 "); 
			System.out.println("2. 답변 작성"); //관리자 답변 권한 설정 필요
			System.out.println("3. 게시글 조회");
			System.out.println("4. 메인메뉴로");

			int select = scanner.nextInt();
			switch (select) {
			case 1:
				System.out.println("질문을 작성해주세요.");
				question(scanner, qaBoardServices);
				break;
			case 2:
				System.out.println("답변을 작성해주세요.");
//				answer(scanner, qaBoardServices, loginState);
				break;
			case 3:
				System.out.println("질문 게시글을 조회합니다.");
				viewQuestions(qaBoardServices);
				break;
			case 4:
				System.out.println("메인메뉴로 돌아갑니다.");
				run = false;
				break;
			default:
				System.out.println("1~4값을 입력해주세요.");
			}// switch
		} // while

	}// qaService menu

	private static void question(Scanner scanner, QABoardService[] qaBoardServices) {
		System.out.println("질문을 입력하세요.");
		String question = scanner.next();

		QABoardService newQA = new QABoardService();// newQA 배열을 생성
		newQA.setBoardNo(nextBoardNo++); // 게시글 번호가 1씩 증가
		newQA.question = question; // 새로운 질문 저장

		for (int i = 0; i < qaBoardServices.length; i++) {
			if (qaBoardServices[i] == null) { //빈 방에만
				qaBoardServices[i] = newQA; //새로운 질문글을 넣기
				System.out.println("질문이 등록되었습니다. 질문 번호: " + newQA.getBoardNo());
				return;//exits the entire method immediately(break 안됨)
			}//if
		}//for
		System.out.println("게시판이 가득 찼습니다.");
	}//question method close

//	 private static void answer(Scanner scanner, QABoardService[] qaBoardServices, MemberDTO loginState) {
//	        if (loginState == null || !loginState.isAdmin()) {
//	            System.out.println("관리자 권한이 필요합니다.");
//	            return; //메서드 종료
//	        }
//	        System.out.println("답변할 질문의 번호를 입력하세요.");
//	        int questionNo = scanner.nextInt();
//	        scanner.nextLine(); // 답변할 게시물 번호 입력
//	        
//	        System.out.println("답변을 입력하세요.");
//	        String answer = scanner.nextLine();
//	        for (QABoardService qa : qaBoardServices) {
//	            if (qa != null && qa.getBoardNo() == questionNo) {
//	                qa.setAnswer(answer);
//	                System.out.println("답변이 등록되었습니다.");
//	                return;
//	            }
//	        }
//	        System.out.println("해당 번호의 질문을 찾을 수 없습니다.");
//	    }

	private static void viewQuestions(QABoardService[] qaBoardServices) {
		for (int i =0; i < qaBoardServices.length; i++) {
			QABoardService qa = qaBoardServices[i]; //qa는 하나의 객체
			if (qa != null) {//qa보드가 빈값이 아니면
				System.out.println("질문 번호: " + qa.getBoardNo());
				System.out.println("질문: " + qa.question);
				System.out.print("답변: ");
				if (qa.answer != null) {//답변이 있으면
				    System.out.println(qa.answer);//답변을 출력
				} else {
				    System.out.println("아직 답변이 없습니다.");//답변이 아직 없을시
				}
				System.out.println("--------------------");
			}//if
		}//for
	}//view question method

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
