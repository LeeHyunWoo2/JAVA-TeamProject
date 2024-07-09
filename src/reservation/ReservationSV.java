package hotelProject.reservation;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import hotelProject.memberAndBoard.DTO.MemberDTO;

public class ReservationSV {

	public void reservation(Scanner scanner, ReservationDTO[][][] reservationDTO, MemberDTO loginState,
			MemberDTO[] memberDTOs) {
		int year = 2024;
		int month = 7;

		LocalDate date = LocalDate.of(year, month, 1); // 해당 연도와 월의 첫 날을 구함
		int lastDay = date.lengthOfMonth(); // 월의 마지막 날짜를 구함
		LocalDateTime now = LocalDateTime.now(); // 현재시간 구하기
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // 현재시간 표시
		String formattdeDateTime = now.format(formatter);
		// 달력 출력
		System.out.println("=================== " + year + " 년 " + month + " 월 ===================");
		System.out.println("  일     월      화      수       목      금       토");

		// 날짜 출력
		for (int day = 1; day <= lastDay; day++) {
			if (day > 6) {
				System.out.print(day + "\t");
			} else {
				System.out.print("\t" + day);
			} // if 종료
				// 토요일마다 줄 바꿈
			if (date.plusDays(day - 1).getDayOfWeek() == DayOfWeek.SATURDAY) {
				System.out.println();
			} // if 종료
		} // for 종료

		// 마지막 줄 끝나고 줄 바꿈
		if (date.plusDays(lastDay - 1).getDayOfWeek() != DayOfWeek.SATURDAY) {
			System.out.println();
		} // if 종료

		System.out.println();
		System.out.println("현재 시간 : " + formattdeDateTime);
		System.out.println("===================================================");

		System.out.println("예약하실 날짜를 입력해주세요.");
		System.out.print("년 : ");
		int selectYear = scanner.nextInt();
		System.out.print("월 : ");
		int selectMonth = scanner.nextInt();
		System.out.print("일 : ");
		int selectDate = scanner.nextInt();

		ReservationDTO selectedDay = new ReservationDTO();
		selectedDay.setyear(selectYear);
		selectedDay.setmonth(selectMonth);
		selectedDay.setDate(selectDate);

		reservationDTO[selectYear][selectMonth][selectDate] = selectedDay;
		boolean run = true;
		while (run) {
			System.out.println("입력하신 날짜는 :" + reservationDTO[selectYear][selectMonth][selectDate] + " 입니다.");
			System.out.println("사용하실 방 등급의 번호를 입력해주세요.");
			System.out.println("===================================================");
			System.out.println("1. 싱글룸      2. 더블룸      3. 패밀리룸     4. 뒤로가기");
			System.out.println("===================================================");
			System.out.print(">>> ");
			int select = scanner.nextInt();
			switch (select) {
			case 1:
				if (loginState != null) {
					System.out.println("예약날짜 : " + reservationDTO[selectYear][selectMonth][selectDate]);
					System.out.println("현재 시간 : " + formattdeDateTime);
					System.out.println("예약자 성함 : " + loginState.getName());
					System.out.println("예약자 연락처 : " + loginState.getPhoneNumber());
					System.out.println("방 타입 : ");
					System.out.println("침대 갯수 / 사이즈 : 1개 / Single");
					System.out.println("위 내용이 맞습니까?");
					System.out.println("1. Yes 2. No");
					int singleChoise = scanner.nextInt();
					switch (singleChoise) {
					case 1:
						System.out.println("예약이 완료되었습니다.");
						break;

					case 2:
						System.out.println("전 화면으로 이동합니다.");
						break;

					default:
						System.err.println("1~2까지 입력해주세요.");
					} // single switch 종료
				} else if (loginState == null) {
					System.out.println("사용자 정보를 입력해주세요.");
					System.out.print("이름 : ");
					String name = scanner.next();
					System.out.print("번호 : ");
					String num = scanner.next();
					System.out.println("예약날짜 : " + reservationDTO[selectYear][selectMonth][selectDate]);
					System.out.println("현재시간 : " + formattdeDateTime);
					System.out.println("예약자 성함 : " + name);
					System.out.println("예약자 연락처 : " + num);
					System.out.println("방 타입 :  Single Room");
					System.out.println("침대 갯수 / 사이즈 : 1개 / Single");
					System.out.println("위 내용이 맞습니까?");
					System.out.println("1. Yes 2. No");
					int singleChoise = scanner.nextInt();
					switch (singleChoise) {
					case 1:
						for (int i = 0; i < memberDTOs.length; i++) {
							if (memberDTOs[i] == null) {
								MemberDTO singleRoom = new MemberDTO();
								singleRoom.setYear(selectYear);
								singleRoom.setMonth(selectMonth);
								singleRoom.setDate(selectDate);
								singleRoom.setTime(formattdeDateTime);
								singleRoom.setNonName(name);
								singleRoom.setNonnum(num);
								memberDTOs[i] = singleRoom;
								System.out.println(memberDTOs[i].getNonName() + " 님 예약이 완료되었습니다.");

								break;
							} else if (memberDTOs[i] != null) {
								System.out.println("예약 가능한 방이 없습니다.");
							} // 방 정보 넣기 종료
						} // for 종료
						break;

					case 2:
						System.out.println("전 화면으로 이동합니다.");
						break;

					default:
						System.err.println("1~2까지 입력해주세요.");
					} // single switch 종료
				} // if 종료
				break;

			case 2:
				if (loginState != null) {
					System.out.println("예약날짜 : " + reservationDTO[selectYear][selectMonth][selectDate]);
					System.out.println("예약자 성함 : ");
					System.out.println("예약자 연락처 : ");
					System.out.println("방 타입 :  Double Room");
					System.out.println("침대 갯수 / 사이즈 : 1개 / Double");
					System.out.println("위 내용이 맞습니까?");
					System.out.println("1. Yes 2. No");
					int singleChoise = scanner.nextInt();
					switch (singleChoise) {
					case 1:
						System.out.println("예약이 완료되었습니다.");
						break;

					case 2:
						System.out.println("전 화면으로 이동합니다.");
						break;

					default:
						System.err.println("1~2까지 입력해주세요.");
					} // single switch 종료
				} else if (loginState == null) {
					System.out.println("사용자 정보를 입력해주세요.");
					System.out.print("이름 : ");
					String name = scanner.next();
					System.out.print("번호 : ");
					String num = scanner.next();
					System.out.println("예약날짜 : " + reservationDTO[selectYear][selectMonth][selectDate]);
					System.out.println("예약자 성함 : " + name);
					System.out.println("예약자 연락처 : " + num);
					System.out.println("방 타입 :  Double Room");
					System.out.println("침대 갯수 / 사이즈 : 1개 / Double");
					System.out.println("위 내용이 맞습니까?");
					System.out.println("1. Yes 2. No");
					int singleChoise = scanner.nextInt();
					switch (singleChoise) {
					case 1:
						System.out.println(name + " 님 예약이 완료되었습니다.");
						break;

					case 2:
						System.out.println("전 화면으로 이동합니다.");
						break;

					default:
						System.err.println("1~2까지 입력해주세요.");
					} // single switch 종료
				} // if 종료
				break;

			case 3:
				if (loginState != null) {
					System.out.println("예약날짜 : " + reservationDTO[selectYear][selectMonth][selectDate]);
					System.out.println("예약자 성함 : ");
					System.out.println("예약자 연락처 : ");
					System.out.println("방 타입 :  Family Room");
					System.out.println("침대 갯수 / 사이즈 : 2개 / Double");
					System.out.println("위 내용이 맞습니까?");
					System.out.println("1. Yes 2. No");
					int singleChoise = scanner.nextInt();
					switch (singleChoise) {
					case 1:
						System.out.println("예약이 완료되었습니다.");
						break;

					case 2:
						System.out.println("전 화면으로 이동합니다.");
						break;

					default:
						System.err.println("1~2까지 입력해주세요.");
					} // single switch 종료
				} else if (loginState == null) {
					System.out.println("사용자 정보를 입력해주세요.");
					System.out.print("이름 : ");
					String name = scanner.next();
					System.out.print("번호 : ");
					String num = scanner.next();
					System.out.println("예약날짜 : " + reservationDTO[selectYear][selectMonth][selectDate]);
					System.out.println("예약자 성함 : " + name);
					System.out.println("예약자 연락처 : " + num);
					System.out.println("방 타입 :  Family Room");
					System.out.println("침대 갯수 / 사이즈 : 2개 / Double");
					System.out.println("위 내용이 맞습니까?");
					System.out.println("1. Yes 2. No");
					int singleChoise = scanner.nextInt();
					switch (singleChoise) {
					case 1:
						System.out.println(name + " 님 예약이 완료되었습니다.");
						break;

					case 2:
						System.out.println("전 화면으로 이동합니다.");
						break;

					default:
						System.err.println("1~2까지 입력해주세요.");
					} // single switch 종료
				} // if 종료
				break;

			case 4:
				System.out.println("메인으로 이동합니다.");
				run = false;
				break;

			default:
				System.out.println("잘못된 입력입니다. 1~4까지 입력해주세요.");
			} // switch 종료

		} // while 종료

	} // reservation 종료

} // class 종료
