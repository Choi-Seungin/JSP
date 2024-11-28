package dao;

import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class BoardMemberDAO {
	private static BoardMemberDAO instance = new BoardMemberDAO();
	private OracleDataSource ods;

	private BoardMemberDAO() {
		try {
			ods = new OracleDataSource();
			ods.setURL("jdbc:oracle:thin:@192.168.20.123/xe");
			ods.setUser("C##SCOTT");
			ods.setPassword("TIGER");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static BoardMemberDAO getInstance() {
		if(instance == null)
			instance = new BoardMemberDAO();
		return instance;
	}

}
