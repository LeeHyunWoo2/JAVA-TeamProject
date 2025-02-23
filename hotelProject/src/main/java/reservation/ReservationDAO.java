package reservation;

import java.sql.SQLException;

import javax.servlet.ServletContext;

import common.HotelConnection;

public class ReservationDAO extends HotelConnection{

	public ReservationDAO(ServletContext application) {
		super(application); // 부모 생성자에게 전달
	} // 1, 2단계

	public ReservationDTO list(String name, String num) {
		String sql = "select * from reservation where name =? and num =?";
		ReservationDTO dto = new ReservationDTO();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, num);
			
			resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
				dto.setRno(resultSet.getString("rno"));
				dto.setName(resultSet.getString("name"));
				dto.setId(resultSet.getString("id"));
				dto.setNum(resultSet.getString("num"));
				dto.setCheckIn(resultSet.getString("checkIn"));
				dto.setCheckOut(resultSet.getString("checkOut"));
				dto.setPeople(resultSet.getString("people"));
				dto.setRoomType(resultSet.getString("roomType"));
				dto.setAmount(resultSet.getString("amount"));
				dto.setRegidate(resultSet.getString("regidate"));
			}
		} catch (SQLException e) {
			System.out.println("ReservationDAO() list메서드 예외발생");
			System.out.println("쿼리문을 확인하세요");
			e.printStackTrace();
		}
		return dto;
	} // list 종료
	
	public ReservationDTO View(String rno) {
		String sql = "select * from reservation where rno =?";
		ReservationDTO dto = new ReservationDTO();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, rno);
			
			resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
				dto.setRno(resultSet.getString("rno"));
				dto.setName(resultSet.getString("name"));
				dto.setId(resultSet.getString("id"));
				dto.setNum(resultSet.getString("num"));
				dto.setCheckIn(resultSet.getString("checkIn"));
				dto.setCheckOut(resultSet.getString("checkOut"));
				dto.setPeople(resultSet.getString("people"));
				dto.setRoomType(resultSet.getString("roomType"));
				dto.setAmount(resultSet.getString("amount"));
				dto.setRegidate(resultSet.getString("regidate"));
			}
		} catch (SQLException e) {
			System.out.println("ReservationDAO() list메서드 예외발생");
			System.out.println("쿼리문을 확인하세요");
			e.printStackTrace();
		}
		return dto;
	} // list 종료
	
	public int insert(ReservationDTO dto) {
		int result = 0;
		
		// 3단계
		String sql = "insert into RESERVATION (rno, id, name, num, people, checkIn, checkOut, roomType, amount, regidate)\r\n"
				+                      "	values(?, ?, ?, ?, ?, ?, ?, ?, '100000', sysdate)";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, dto.getRno());
			preparedStatement.setString(2, dto.getId());
			preparedStatement.setString(3, dto.getName());
			preparedStatement.setString(4, dto.getNum());
			preparedStatement.setString(5, dto.getPeople());
			preparedStatement.setString(6, dto.getCheckIn());
			preparedStatement.setString(7, dto.getCheckOut());
			preparedStatement.setString(8, dto.getRoomType());
			
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("reservation insert() 메서드 예외발생");
			System.out.println("쿼리문을 확인하세요");
			e.printStackTrace();
		}
		
		return result;
	} // insert 종료
	
	public int updata(ReservationDTO dto) {
		int result = 0;
		
		String sql = "update reservation set checkIn=?, checkOut=?, roomType=? , people=? where rno=?";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, dto.getCheckIn());
			preparedStatement.setString(2, dto.getCheckOut());
			preparedStatement.setString(3, dto.getRoomType());
			preparedStatement.setString(4, dto.getPeople());
			preparedStatement.setString(5, dto.getRno());
			System.out.println(dto.getPeople());
			System.out.println(dto.getCheckIn());
			System.out.println(dto.getCheckOut());
			System.out.println(dto.getRoomType());
			System.out.println(dto.getRno());
			
			result = preparedStatement.executeUpdate();
			System.out.println("수정갯수 : " + result);
		} catch (SQLException e) {
			System.out.println("ReservationDAO. updata() 메서드 예외발생");
			System.out.println("쿼리문을 확인하세요");
			e.printStackTrace();
		}
		return result;
	} // updata 종료
	
	public int delete(ReservationDTO dto) {
		int result = 0;
		
		String sql = "delete from reservation where rno=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, dto.getRno());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("ReservationDTO delete 메서드 예외발생");
			System.out.println("쿼리문을 확인하세요");
			e.printStackTrace();
		}
		
		return result;
	} // delete 종료
}
