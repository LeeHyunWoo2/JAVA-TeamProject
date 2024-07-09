package hotelProject.memberAndBoard.DTO;

import java.util.Iterator;

public class ReviewDTO {
	//필드
	String name;
	int starRate;
	String review;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStarRate() {
		return starRate;
	}
	public void setStarRate(int starRate) {
		this.starRate = starRate;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public static Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
