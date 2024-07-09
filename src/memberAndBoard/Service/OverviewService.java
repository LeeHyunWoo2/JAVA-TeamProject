package hotelProject.memberAndBoard.Service;

import java.util.Scanner;

public class OverviewService {
	// 메서드
		public static void menu(Scanner scanner) {
			// 자유게시판
			boolean run = true;
			while (run) {
				System.out.println("1. 호텔 소개 ");
				System.out.println("2. 객실 소개");
				System.out.println("3. 시설 소개");
				System.out.println("4. 서비스 소개");
				System.out.println("5. 맛집 & 관광지 소개");
				System.out.println("6. 메인메뉴로");
				System.out.print(">>>");

				int select = scanner.nextInt();
				switch (select) {
				case 1:
					System.out.println("게시글을 작성해주세요.");
					OverviewService.hotel();
					break;
				case 2:
					System.out.println("전체 객실 정보를 조회합니다.");
					OverviewService.room();
					break;
				case 3:
					System.out.println("호텔 시설을 조회합니다.");
					OverviewService.facility();
					break;
				case 4:
					System.out.println("호텔 서비스를 조회합니다.");
					OverviewService.service();
					break;
				case 5:
					System.out.println("주변 맛집 & 관광지를 조회합니다.");
					OverviewService.travel();
					break;
				case 6:
					System.out.println("메인 메뉴로 돌아갑니다.");
					run = false;
					break;
				default:
					System.out.println("1~4값을 입력해주세요.");
				}// switch
			} // while
		}// freeBoardmenu

		private static void travel() {
		// TODO Auto-generated method stub
		System.out.println("맛집");
		System.out.println("1.소친친\r\n"
				+ " 퓨전 중식집인데 중식좋아한다 자극적인거 좋아하시는 사람은 무조건 가보세요. \r\n"
				+ " 맛도리에 양도 많아서 세명이서 요리하나 면하나 시키면 배가 터집니다.\r\n"
				+ "\r\n"
				+ " 2.포르코로쏘\r\n"
				+ " 이탈리안 레스토랑임 화덕피자랑 파스타먹으러 가는곳 대학로에 화덕피자파는 이탈리안 레스토랑 꽤 있는데 여기가 제일 맛집입니다!\r\n"
				+ " 다소 생소한 메뉴들이 많은데 다 맛있어요\r\n"
				+ "\r\n"
				+ " 3.명동도면 \r\n"
				+ " 대학로에서 살짝 벗어나서 혜화동쪽으로 위치상으로는 혜화로타리입니다.\r\n"
				+ " 홈플러스건물에 붙어있음 원덬이 엄청 자주가는 칼국수집 육수가 그냥 설렁탕 진국임 엄청 진하고 맛있습니다.\r\n"
				+ " 추천하는 메뉴는 제육비빔밥인데 이거 시키면 칼국수 작은거 같이 나옵니다.");
		System.out.println("-----------------------------------------");
		System.out.println("\r\n"
				+ "1.마로니에 공원\r\n"
				+ "2. 아르코미술관\r\n"
				+ "3. 낙산공원\r\n"
				+ "4. 창경궁");
	}

		private static void service() {
		// TODO Auto-generated method stub
		System.out.println("캐리어 보관 서비스\r\n"
				+ "	숙박하지 않는 여행자나 숙박하시는 분께서 프론트 데스크에 캐리어를 위탁하실수 있습니다. \r\n"
				+ "	항공 픽업 서비스\r\n"
				+ "	입국 후 피곤하신 몸을 이끌고 호텔로 오기 힘드신 투숙객들을 위한 무료 픽업 서비스가 준비되어있습니다.\r\n"
				+ "	필요하시면 호텔에 따로 전화를 해서 예약을 해주세요.");
	}

		private static void facility() {
		// TODO Auto-generated method stub
		System.out.println("RESTAURANT \r\n"
				+ "	행복이 가득한 시간! 소중한 마음 그대로 전해드립니다.\r\n"
				+ "	최고의 맛과 정성을 담은 한식당으로 계절음식 및 제주토속음식 등 어머니의 손맛을 느낄 수 있는 혜화스테이인제주에서 정성을 다하여 준비해 드립니다.\r\n"
				+ "	위치 : 애월동 1층\r\n"
				+ "	이용시간 : 07:00 ~ 10:00\r\n"
				+ "	BAKERY\r\n"
				+ "	혜화스테이인서울는 고급스러운 미적 감각이 돋보이는 명품 ‘Bread & Pastry Boutique’입니다. Sidewalk café 형태로 다양한 페이스트리와 케이크, 타르트, 샌드위치 등과 함께 커피, 음료 등을 즐길 수 있습니다.\r\n"
				+ "	SIGNIEL JEJU BAR\r\n"
				+ "	시그니엘 서울의 바 81은 파노라믹 스카이뷰를 자랑하는 업스케일 샴페인바로, 매혹적인 제주의 밤을 즐길 수 있는 초고층 스카이바입니다.");
	}

		private static void room() {
		// TODO Auto-generated method stub
		System.out.println("디럭스 트윈 오션형 (52㎡) / 객실수 6 / 기준인원 4인 , 최대인원 4인 / 위치 : 애월동 / 요금 : 250,000원\r\n"
				+ "	디럭스 트윈 부분 오션 콘도형 (52㎡) / 객실수 24 / 기준인원 4인 , 최대인원 4인 / 위치 : 스테이동 / 요금 : 250,000원");
	}

		private static void hotel() {
			// TODO Auto-generated method stub
			System.out.println("눈 앞에 펼쳐지는 그림 같은 서울 도심의 아름다움은 해질녘 노을을 맞이 하면서 더욱 깊어집니다.\r\n"
					+ "	혜화스테이인서울은 이런 아름다운 애월바다를 온전히 하눈에 담아내고자 노력하였습니다.\r\n"
					+ "	저희 애월스테이인제수의 안락한 객실과 다양한 부대시설을 통해 즐거웠던 제주여행의 여유를 더하시길 바라면\r\n"
					+ "	조금 더 편안하고 조금 더 즐거운 마음을 느끼는 여정이 되시길 바랍니다.\r\n"
					+ "	-혜화 스테이 인 서울-\r\n"
					+ "	\r\n"
					+ "	예약문의 : 1588-2056\r\n"
					+ "	대표번호 : 064-713-5100");
		}
}
