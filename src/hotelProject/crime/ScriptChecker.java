package hotelProject.crime;

import java.util.List;

public class ScriptChecker {

	List<SuspectDTO> suspectDTOs;

	public ScriptChecker(List<SuspectDTO> suspectDTOs) {
		this.suspectDTOs = suspectDTOs;
	}

	boolean checkMethod() { // T/F 를 반환할 메서드라서 boolean 타입으로 생성
		boolean Contradiction = false;

		for (SuspectDTO suspectDTO : suspectDTOs) {
			// 용의자를 한명씩 루프돌림
			for (String script : suspectDTO.scripts) {
				// 용의자의 대사를 한줄씩 루프돌림
				String[] nums = script.split(" "); // split은 자바마스터 403페이지 표에 밑에서 4~5번째에 있음
				// 이것의 의미는 띄어쓰기마다 단어를 자른다는 뜻임
				// 즉, 김기원은 거짓말을 하지 않습니다. 라면 -> 김기원은 / 거짓말을 / 하지 / 않습니다. 로 나뉘어서 배열에 저장됨
				// 이러면 무조건 0번인덱스 자리에는 이름이 배치됨
				String targetName = nums[0].replace("은(는)", "").replace("을(를)", "");
				// replace는 자바마스터 403페이지 표 밑에서 6~7번째
				// 0번인덱스 자리의 이름에서 "은(는)" 을 공백으로 바꿔버림. 을를도 마찬가지로 공백으로 바꿈
				// 이러면 무조건 이름만 딱 잘려서 나옴
				SuspectDTO targetSuspect = findSuspectByName(targetName);
				// 이제 이 이름의 용의자를 찾아서 비교시작
				if (targetSuspect != null) {
					if (script.contains("거짓말")) { // 대사에 "거짓말" 이 포함된 경우
						// contains는 자바마스터 403페이지 위에서 3번째
						if ((suspectDTO.liar && targetSuspect.liar) || (!suspectDTO.liar && !targetSuspect.liar)) {
							// 말한사람이 거짓말쟁이고, 대상자가 거짓말쟁이라면 모순
							// 말한사람이 거짓말쟁이가 아니고, 대상자가 거짓말쟁이가 아니라면 모순
							Contradiction = true;
							// 모순이니까 true 반환
						}
					} else if (script.contains("진실")) {
						// 똑같은건데 단어만 "진실"이 포함된 경우 로직
						if ((suspectDTO.liar && targetSuspect.liar) || (!suspectDTO.liar && targetSuspect.liar)) {
							// 말한사람이 거짓말쟁이고, 대상자가 거짓말쟁이면 모순
							// 말하는 사람이 거짓말쟁이가 아니고, 대상자가 거짓말쟁이면 모순
							Contradiction = true;
						}
					} else if (script.contains("범인")) {
						// 단어에 "범인" 이 포함된 경우 로직
						if ((suspectDTO.liar && targetSuspect.killer) || (!suspectDTO.liar && !targetSuspect.killer)) {
							// 말한사람이 거짓말쟁이, 대상이 킬러면 모순
							// 말한사람이 거짓말쟁이가 아니고, 타겟도 킬러가 아니면 모순
							Contradiction = true;

						} // if

					} // if

				} // if

			} // for

		} // for

		return Contradiction;
	} // 메서드 종료

	private SuspectDTO findSuspectByName(String suspectName) {
		for (SuspectDTO suspect : suspectDTOs) {
			if (suspect.suspectName.equals(suspectName)) {
				return suspect;
			}

		}
		return null;
	}

}

//package hotelProject.crime;
//
//import java.util.List;
//
//public class ScriptChecker {
//
//	List<SuspectDTO> suspectDTOs;
//
//	public ScriptChecker(List<SuspectDTO> suspectDTOs) {
//		this.suspectDTOs = suspectDTOs;
//	}
//
//	boolean checkMethod() { // T/F 를 반환할 메서드라서 boolean 타입으로 생성
//		boolean Contradiction = false;
//
//		for (SuspectDTO suspectDTO : suspectDTOs) {
//			// 용의자를 한명씩 루프돌림
//			for (String script : suspectDTO.scripts) {
//				// 용의자의 대사를 한줄씩 루프돌림
//				String[] nums = script.split(" "); // split은 자바마스터 403페이지 표에 밑에서 4~5번째에 있음
//				// 이것의 의미는 띄어쓰기마다 단어를 자른다는 뜻임
//				// 즉, 김기원은 거짓말을 하지 않습니다. 라면 -> 김기원은 / 거짓말을 / 하지 / 않습니다. 로 나뉘어서 배열에 저장됨
//				// 이러면 무조건 0번인덱스 자리에는 이름이 배치됨
//				String targetName = nums[0].replace("은(는)", "").replace("을(를)", "");
//				// replace는 자바마스터 403페이지 표 밑에서 6~7번째
//				// 0번인덱스 자리의 이름에서 "은(는)" 을 공백으로 바꿔버림. 을를도 마찬가지로 공백으로 바꿈
//				// 이러면 무조건 이름만 딱 잘려서 나옴
//				SuspectDTO targetSuspect = findSuspectByName(targetName);
//				// 이제 이 이름의 용의자를 찾아서 비교시작
//				if (targetSuspect != null) {
//					// 발언의 키워드에 따라 조건 검사
//					if (script.contains("진실")) {
//						// 진실 관련 대화는 거짓말쟁이와 킬러를 제외한 용의자만 할 수 있음
//						if (suspectDTO.liar || suspectDTO.killer) {
//							return true; // 모순 발생
//						}
//						if ((suspectDTO.liar && targetSuspect.liar) || (!suspectDTO.liar && targetSuspect.liar)) {
//							return true; // 모순 발생
//						}
//					} else if (script.contains("거짓말")) {
//						// 거짓말 관련 대화는 거짓말쟁이와 킬러만 할 수 있음
//						if (!suspectDTO.liar && !suspectDTO.killer) {
//							return true; // 모순 발생
//						}
//						if ((suspectDTO.liar && targetSuspect.liar) || (!suspectDTO.liar && !targetSuspect.liar)) {
//							return true; // 모순 발생
//						}
//					} else if (script.contains("범인")) {
//						// 범인 관련 대화는 킬러만 할 수 있음
//						if (!suspectDTO.killer) {
//							return true; // 모순 발생
//						}
//						if ((suspectDTO.liar && targetSuspect.killer) || (!suspectDTO.liar && !targetSuspect.killer)) {
//							return true; // 모순 발생
//						}
//					} else {
//						// 지정된 단어가 포함되지 않은 경우
//						return true; // 모순 발생
//					}
//				}
//			}
//		}
//		return false; // 모순 없음
//	}
//
//	private SuspectDTO findSuspectByName(String suspectName) {
//		for (SuspectDTO suspect : suspectDTOs) {
//			if (suspect.suspectName.equals(suspectName)) {
//				return suspect;
//			}
//
//		}
//		return null;
//	}
//
//}