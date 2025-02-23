package room;

import java.sql.SQLException;

import javax.servlet.ServletContext;

import common.JDBConnect;

public class RoomDAO extends JDBConnect{
	
	// 생성자를 이용 1단계/2단계 처리
	public RoomDAO(ServletContext application) {
		super(application); // 3번째 개선한 jdbc 연결
	}

	public RoomDAO(String drv, String url, String id, String pw) {
		super(drv, url, id, pw); // 부모 생성자에게 전달
	} // 1단계, 2단계
	
	// 객실번호로 객실 현황 불러오기
	public RoomDTO getRoomDTO(String roomNo) {
		RoomDTO roomDTO = new RoomDTO(); // 빈 객체 생성
		String query = "select * from roomTBL where roomno=?"; // 쿼리문생성
		
		try {
			preparedStatement=connection.prepareStatement(query); // 동적쿼리문 적용
			preparedStatement.setString(1, roomNo);					// ? 처리
			resultSet = preparedStatement.executeQuery();			// 쿼리 실행 -> 표로 받음
			
			if(resultSet.next()){ // resultSet 표에 값이 있는지!!!
				roomDTO.setRoomNum(resultSet.getString("roomno"));
				roomDTO.setRoomType(resultSet.getString("roomtype"));
				roomDTO.setRoomStatus(resultSet.getString("roomstatus"));
				roomDTO.setRoomCheckInNO(resultSet.getString("roomcheckindate"));
				roomDTO.setRoomCheckOutNO(resultSet.getString("roomcheckoutdate"));
				roomDTO.setRoomUser(resultSet.getString("roomuser"));
			}
		} catch (SQLException e) {
			System.out.println("RoomDAO.getRoomDTO() 메서드 오류 (3단계)");
			e.printStackTrace();
		}
		return roomDTO;
	}
	
	// 객실번호로 객실 상태 체크인 변경하기
	public int updateRoomDTO(RoomDTO roomDTO) {
		int result = 0;
		
		String query = "update roomTBL set roomstatus=?, roomcheckindate=?, roomcheckoutdate=? where roomno=?";
		
		try {
			preparedStatement = connection.prepareStatement(query); // 3단계
			preparedStatement.setString(1, roomDTO.getRoomStatus());
			preparedStatement.setString(2, roomDTO.getRoomCheckInNO());
			preparedStatement.setString(3, roomDTO.getRoomCheckOutNO());
			preparedStatement.setString(4, roomDTO.getRoomNum());
			
			result = preparedStatement.executeUpdate(); // 4단계
			System.out.println("수정 개수 : " + result);
			
		} catch (SQLException e) {
			System.out.println("RoomDAO.updateRoomDTO() 메서드 예외발생");
			System.out.println("쿼리문을 확인하세요");
			e.printStackTrace();
		}
		return result;
	}
	
	// 삭제 메서드 dto를 받아서 삭제 후에 int로 리턴
	public int checkOutRoomDTO(RoomDTO roomDTO) {
		int result = 0;
				
		String query = "update roomTBL set roomstatus=?, roomcheckindate=?, roomcheckoutdate=? where roomno=?";
				
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, "빈방");
			preparedStatement.setString(2, "");
			preparedStatement.setString(3, "");
			preparedStatement.setString(4, roomDTO.getRoomNum());
			result = preparedStatement.executeUpdate();
					
		} catch (SQLException e) {
			System.out.println("RoomDAO.checkOutRoomDTO() 메서드 예외발생");
			System.out.println("쿼리문을 확인하세요");
			e.printStackTrace();
		}
		return result;
	}
}
