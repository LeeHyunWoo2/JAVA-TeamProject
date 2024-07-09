package hotelProject.crime;

import java.security.SecureRandom;
import java.util.List;

public class ScriptGenerator {

	List<SuspectDTO> suspectDTOs;
	SecureRandom secureRandom;

	public ScriptGenerator(List<SuspectDTO> suspectDTOs) { // 생성자
		this.suspectDTOs = suspectDTOs;
		this.secureRandom = new SecureRandom();
	}

	void addScript() {
		// 대사를 용의자정보에 넣을건데, 전부 랜덤으로 생성하되, 킬러랑 거짓말쟁이는 따로 만든 스크립트를 따르게 함

		SuspectDTO killerScript = null; // 빨간줄 누르니까 이렇게 해줬음
		SuspectDTO liarScript = null;

		for (SuspectDTO suspectDTO : suspectDTOs) { // suspectDTOs 배열 쭉 스캔
			if (suspectDTO.liar) { // 거짓말쟁이면
				liarScript = suspectDTO; // 거짓말쟁이 스크립트에 그 사람 정보 넣음
				break;
			} else if (suspectDTO.killer) { // 그게 아니라 킬러면
				killerScript = suspectDTO; // 킬러 스크립트에 그 사람 정보 넣음
			} // if 종료

		} // for문 종료
		
		for (SuspectDTO suspectDTO : suspectDTOs) {
			String suspectScript; // String 대사 변수
			if (suspectDTO == liarScript) {
				suspectScript = generateRandomLiarScripts(suspectDTO);
			} else if (suspectDTO == killerScript) {
				suspectScript = generateRandomKillerScripts(suspectDTO);
			} else {
				suspectScript = generateRandomScripts(suspectDTO);
			}
			suspectDTO.makeScript(suspectScript);
		}

	} // addScript

	private String generateRandomScripts(SuspectDTO suspectDTO) {
		String[] dialogs = { "[suspectName]은(는) 진실을 말하고 있습니다.", "[suspectName]은(는) 항상 진실을 말합니다.",
				"[suspectName]은(는) 진실대로 이야기합니다.", "[suspectName]은(는) 진실을 말하는 사람입니다." };
		String dialog = dialogs[secureRandom.nextInt(dialogs.length)];
		// 배열에서 랜덤돌려서 나온 자릿수를 골라서 스크립트에 넣음
		String script = dialog.replace("[suspectName]", getRandomSuspectName(suspectDTO.suspectName));

		return script;
	} // 대사 랜덤 생성 스크립트 메서드 종료

	private String generateRandomLiarScripts(SuspectDTO suspectDTO) { // 위에거랑 똑같은데 대사만 반대로하고 거짓말쟁이 한명한테만 넣는 대사들
		String[] dialogs = { "[suspectName]은(는) 거짓말을 합니다.", "[suspectName]은(는) 거짓말쟁이입니다.",
				"[suspectName]은(는) 거짓말을 하고 있습니다.", "[suspectName]은(는) 믿을 수 없는 거짓말쟁이입니다." };
		String dialog = dialogs[secureRandom.nextInt(dialogs.length)];
		String script = dialog.replace("[suspectName]", getRandomSuspectName(suspectDTO.suspectName));

		return script;
	} // 거짓말쟁이 대사 랜덤 생성 스크립트 메서드 종료

	private String generateRandomKillerScripts(SuspectDTO suspectDTO) { // 마찬가지
		String[] dialogs = { "[suspectName]은(는) 범인입니다.", "[suspectName]이(가) 범인입니다." };

		String dialog = dialogs[secureRandom.nextInt(dialogs.length)];
		String script = dialog.replace("[suspectName]", getRandomSuspectName(suspectDTO.suspectName));

		return script;
	} // 킬러 대사 랜덤 생성 스크립트 메서드 종료

	private String getRandomSuspectName(String exclude) {
		// 이름 랜덤 생성 메서드, 같은 이름이 걸리면 다시 생성하도록 반복시킴
		// 중복이름 안나오게 조절해야함.
		String suspectName;
		do { // 일단 이름을 한번 뽑고 그게 중복인가 검사해야 하기 때문에 do-while을 사용
			suspectName = suspectDTOs.get(secureRandom.nextInt(suspectDTOs.size())).suspectName;
			// 컬렉션에 속한 애들은 length 말고 size로 크기 비교를 함
		} while (suspectName.equals(exclude));
		return suspectName;
	}

} // 클래스
