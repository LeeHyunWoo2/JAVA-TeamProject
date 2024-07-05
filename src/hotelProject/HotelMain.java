package hotelProject;

import java.util.Scanner;

import hotelProject.Service.LoginService;

public class HotelMain {

	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		while(true) {
			System.out.println("임시 메뉴");
			System.out.println("1. 회원메뉴 2.예약메뉴 3.객실메뉴");
			int select = scanner.nextInt();
			switch(select) {
			case 1:
				LoginService loginService = new LoginService();
				loginService.menu(scanner);
				break;
			case 2:
				break;
			case 3:
				break;
			}
			
			
		}
		

	}

}
