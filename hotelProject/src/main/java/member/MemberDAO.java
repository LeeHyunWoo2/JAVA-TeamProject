package member;
import java.sql.SQLException;
import common.DBConPool;

public class MemberDAO extends DBConPool {
	
	public MemberDTO getMemberDTO(String id, String pw) {
		MemberDTO memberDTO = new MemberDTO(); // 빈 객체 생성
		
		// 쿼리문 생성
		String sql = "select * from member where id=? and pw=?";
		// 아이디&패스워드가 동일한거 찾기

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, pw);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				memberDTO.setId(resultSet.getString("id"));
				memberDTO.setPw(resultSet.getString("pw"));
				memberDTO.setName(resultSet.getString("name"));
			}
			
		} catch (SQLException e) {
			System.out.println("3단계 오류");
			e.printStackTrace();
		}
		return memberDTO;
	}
	
	public int createAccount(MemberDTO memberDTO) {
		int success = 0;
		
		String sql = "insert into member(id, pw, name, sex, num, email, agree1, agree2) "
				+ "values(?,?,?,?,?,?,?,?)";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberDTO.getId());
			preparedStatement.setString(2, memberDTO.getPw());
			preparedStatement.setString(3, memberDTO.getName());
			preparedStatement.setString(4, memberDTO.getSex());
			preparedStatement.setString(5, memberDTO.getNum());
			preparedStatement.setString(6, memberDTO.getEmail());
			preparedStatement.setString(7, memberDTO.getAgree1());
			preparedStatement.setString(8, memberDTO.getAgree2());
			success = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("MemberDAO.createAccount() 메서드");
			e.printStackTrace();
		}
		
		return success;
	}
	
	public MemberDTO accountInfo(String id) {
		MemberDTO memberDTO = new MemberDTO();
		
		String sql = "select * from member where id=?";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
			memberDTO.setId(resultSet.getString("id"));
			memberDTO.setPw(resultSet.getString("pw"));
			memberDTO.setName(resultSet.getString("name"));
			memberDTO.setNum(resultSet.getString("num"));
			memberDTO.setSex(resultSet.getString("sex"));
			memberDTO.setEmail(resultSet.getString("email"));
			memberDTO.setRegidate(resultSet.getString("regidate"));
			}
			
		} catch (SQLException e) {
			System.out.println("MemberDAO.accountInfo");
			e.printStackTrace();
		}
		
		return memberDTO;
	}
	
	public int editAccount(MemberDTO memberDTO) {
		int result = 0;
		
		String sql = "update member set pw=?, name=?, num=?, email=? where id=?";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberDTO.getPw());
			preparedStatement.setString(2, memberDTO.getName());
			preparedStatement.setString(3, memberDTO.getNum());
			preparedStatement.setString(4, memberDTO.getEmail());
			preparedStatement.setString(5, memberDTO.getId());
			
			result = preparedStatement.executeUpdate();
			System.out.println(result);
			
		} catch (SQLException e) {
			System.out.println("MemberDTO.editAccount");
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	public int deleteAccount(MemberDTO memberDTO) {
		int result = 0;
		
		String sql = "delete from member where id=?";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberDTO.getId());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("BoardDAO.deleteAccount");
			e.printStackTrace();
		}
		
		return result;
	}
	
}
