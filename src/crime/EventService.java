package hotelProject.crime;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class EventService {

	public void crimeMenu(Scanner scanner) {
		while (true) {
			System.out.println("\n\n당신이 잠든 사이에 살인사건이 벌어졌습니다.\n\n");
			System.out.println("추리에 성공하면 다음 숙박을 무료로 처리해준다고 합니다!\n도전해볼까요? 아니면 도망칠까요?\n");
			System.out.println("1.추리 시작   |  2.도망치기");
			int select = scanner.nextInt();
			switch (select) {
			case 1:
				crimeEvent(scanner);
				break;
			case 2:
				System.out.println("메뉴로 돌아갑니다");
				break;
			}
			return;
		}
	}

	public void crimeEvent(Scanner scanner) {

		boolean Contradiction; // 대사 모순 발생 여부 판정. 모순이 일어나야 퀴즈가 성립되기 때문에 만듦
		List<SuspectDTO> suspectDTOs = new ArrayList<SuspectDTO>();
		// 용의자 명단
		String victimName = null;
		SuspectDTO liarSuspect = null;

		String[] namesArray = { "김기원", "이현우", "문지현", "김우혁", "김정하", "김지선", "김태희", "안희준", "양승환", "용상엽", "이영훈", "조건재",
				"조용재", "함시은" };
		List<String> names = new ArrayList<String>(List.of(namesArray));

		do {// 일단 한번 게임 세팅을 위한 셔플을 실행함
			// 그 후 대화문이 모순이 아니면 모순이 될때까지 무한반복함

			SecureRandom secureRandom = new SecureRandom();
			// 이름 셔플을 위해 시큐어랜덤 호출. 그냥 랜덤유틸은 특정 인원만 자꾸 범인되길래 검색해서 찾아옴
			Collections.shuffle(names, secureRandom);
			// 이건 컬렉션을 섞는 코드

			// 배열 앞에서부터 5명을 용의자로 선정, 6번쨰는 피해자로 선정
			suspectDTOs.clear(); // 와 이거 안해서 무한루프걸림
			suspectDTOs.add(new SuspectDTO(names.get(0), false, false)); // 킬러아님, 거짓말쟁이아님
			suspectDTOs.add(new SuspectDTO(names.get(1), false, false)); // 킬러아님, 거짓말쟁이아님
			suspectDTOs.add(new SuspectDTO(names.get(2), false, false)); // 킬러아님, 거짓말쟁이아님
			suspectDTOs.add(new SuspectDTO(names.get(3), false, true)); // 킬러아님, 거짓말쟁이 맞음
			suspectDTOs.add(new SuspectDTO(names.get(4), true, true)); // 킬러맞음, 거짓말쟁이맞음

			liarSuspect = suspectDTOs.get(3); // 용의자 명단에서 4번째칸 용의자를 거짓말쟁이로 임명

			// 피해자 이름 정하기
			// 배열에서 6번째의 이름은 희생자로 사용됨
			List<String> remainingNames = names.subList(5, names.size());
			victimName = remainingNames.get(secureRandom.nextInt(remainingNames.size()));

			ScriptGenerator scriptGenerator = new ScriptGenerator(suspectDTOs);
			scriptGenerator.addScript();

			// 모순이 발생하는지 체크
			ScriptChecker scriptChecker = new ScriptChecker(suspectDTOs);

			// 모순 출력
			Contradiction = scriptChecker.checkMethod();

		} while (!Contradiction); // while 종료 (모순이 발생하면 루프종료, 게임시작)

		System.out.println("\n추리 시작\n"); // 성공적으로 퀴즈에서 모순이 발생하면 게임 시작 안내 출력
		
		// 피해자 이름 출력
		System.out.println("피해자는 " + victimName + "입니다.\n\n");

		// 각 용의자의 대사 출력
		for (SuspectDTO suspectDTO : suspectDTOs) {
			System.out.println(suspectDTO.suspectName + "의 대사: " + suspectDTO.scripts);
		}

		// 범인 출력
		for (SuspectDTO suspectDTO : suspectDTOs) {
			if (suspectDTO.killer) {
				System.out.println("범인은 " + suspectDTO.suspectName + "입니다.");
				break;
			}
		}

		// 거짓말쟁이 출력
		System.out.println("거짓말쟁이는 " + liarSuspect.suspectName + "입니다.");

	
	}

}
