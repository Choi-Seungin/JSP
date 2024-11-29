package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.BoardMemberDTO;
import oracle.jdbc.pool.OracleDataSource;

public class BoardMemberDAO {
	private static BoardMemberDAO instance = new BoardMemberDAO();
	private OracleDataSource ods;

	private BoardMemberDAO() {
		try {
			ods = new OracleDataSource();
			ods.setURL("jdbc:oracle:thin:@127.0.0.1:1521/xe");
            ods.setUser("C##SCOTT");
            ods.setPassword("tiger");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static BoardMemberDAO getInstance() {
		if (instance == null)
			instance = new BoardMemberDAO();
		return instance;
	}

	public ArrayList<BoardMemberDTO> selectAllMember() {
		ArrayList<BoardMemberDTO> list = new ArrayList<BoardMemberDTO>();
		// 1. sql문 작성
		String sql = "select * from board_member";
		// 2. Connection 받아옴
		// 3. PreparedStatement 생성
		try (Connection conn = ods.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			// 4. SQL문 실행
			try (ResultSet rs = pstmt.executeQuery();) {
				// 5. 결과처리
				while(rs.next()) {
					BoardMemberDTO dto = new BoardMemberDTO();
					dto.setId(rs.getString("id"));
					dto.setPassword(rs.getString("password"));
					dto.setNickName(rs.getString("nickName"));
					dto.setUserName(rs.getString("userName"));
					
					list.add(dto);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
