package hotelProject.memberAndBoard.Service;

import java.util.ArrayList;
import java.util.Scanner;

import hotelProject.memberAndBoard.DTO.ReviewDTO;
//객실정보 연계 필요
public class ReviewService {
    private ArrayList<ReviewDTO> reviews;

    public ReviewService() {
        this.reviews = new ArrayList<>();
    }

    public void menu(Scanner scanner) {
        boolean run = true;
        while (run) {
            System.out.println("\n리뷰 관리 메뉴");
            System.out.println("1. 리뷰 작성");
            System.out.println("2. 모든 리뷰 보기");
            System.out.println("3. 리뷰 수정");
            System.out.println("4. 리뷰 삭제");
            System.out.println("5. 메인 메뉴로 돌아가기");
            System.out.print(">>>");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addReview(scanner);
                    break;
                case 2:
                    displayAllReviews();
                    break;
                case 3:
                    editReview(scanner);
                    break;
                case 4:
                    deleteReview(scanner);
                    break;
                case 5:
                    run = false;
                    System.out.println("메인 메뉴로 돌아갑니다.");
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
        }
    }

    private void addReview(Scanner scanner) { //리뷰 작성 페이지
        ReviewDTO newReview = new ReviewDTO();
        
        System.out.print("이름을 입력하세요: ");
        newReview.setName(scanner.nextLine());

        System.out.print("별점을 입력하세요 (1-5): ");
        newReview.setStarRate(scanner.nextInt());
        scanner.nextLine(); 

        System.out.print("리뷰 내용을 입력하세요: ");
        newReview.setReview(scanner.nextLine());

        reviews.add(newReview);
        System.out.println("리뷰가 성공적으로 추가되었습니다.");
    }

    private void displayAllReviews() {//리뷰 조회 페이지
        if (reviews.isEmpty()) {
            System.out.println("작성된 리뷰가 없습니다.");
            return;
        }

        System.out.println("\n모든 리뷰:"); // 모든 리뷰를 조회하기
        for (int i = 0; i < reviews.size(); i++) {
            ReviewDTO review = reviews.get(i);
            System.out.println((i + 1) + ". 이름: " + review.getName() + 
                               ", 별점: " + review.getStarRate() + 
                               ", 리뷰: " + review.getReview());
        }
    }

    private void editReview(Scanner scanner) { //리뷰 수정 메서드
        displayAllReviews();
        if (reviews.isEmpty()) return;

        System.out.print("수정할 리뷰 번호를 선택하세요: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline

        if (index < 0 || index >= reviews.size()) {
            System.out.println("잘못된 번호입니다.");
            return;
        }

        ReviewDTO reviewToEdit = reviews.get(index);

        System.out.print("새로운 별점을 입력하세요 (1-5): "); 
        reviewToEdit.setStarRate(scanner.nextInt());
        scanner.nextLine(); // Consume newline

        System.out.print("새로운 리뷰 내용을 입력하세요: ");
        reviewToEdit.setReview(scanner.nextLine());

        System.out.println("리뷰가 성공적으로 수정되었습니다.");
    }

    private void deleteReview(Scanner scanner) { //리뷰 삭제 메서드
        displayAllReviews();
        if (reviews.isEmpty()) return;

        System.out.print("삭제할 리뷰 번호를 선택하세요: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline

        if (index < 0 || index >= reviews.size()) {
            System.out.println("잘못된 번호입니다.");
            return;
        }

        reviews.remove(index);
        System.out.println("리뷰가 성공적으로 삭제되었습니다.");
    }
}