package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletContext;

public class HotelConnection {

	// 필드 
	public Connection connection;
	public Statement statement;
	public PreparedStatement preparedStatement;
	public ResultSet resultSet;
	
	// 생성자
	public HotelConnection(ServletContext application) {
		String driver = application.getInitParameter("OracleDriver");
		String url = application.getInitParameter("OracleURL");
		String id = application.getInitParameter("OracleId");
		String pw = application.getInitParameter("OraclePw");
		
		try {
			Class.forName(driver);
			System.out.println("1단계 성공");
			
			connection = DriverManager.getConnection(url, id, pw);
			System.out.println("2단계 성공");
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("커스텀 생성자 2로 1,2,3 단계 실패");
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			if(resultSet != null) resultSet.close();
			if(statement != null) statement.close();
			if(preparedStatement != null) preparedStatement.close();
			if(connection != null) connection.close();
			System.out.println("5단계 성공");
		} catch (SQLException e) {
			System.out.println("정상적으로 안꺼짐 5단계 확인");
			e.printStackTrace();
		}
	}
	
}
