package service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.DBManager;
import dto.BoardCommentDTO;
import dto.BoardDTO;
import mapper.BoardMapper;

public class BoardService {
	private static BoardService instance = new BoardService();

	private BoardService() {
	}

	public static BoardService getInstance() {
		if (instance == null)
			instance = new BoardService();
		return instance;
	}

	public List<BoardDTO> getBoardList() {
		try (SqlSession session = DBManager.getInstance().getSession()) {
			BoardMapper mapper = session.getMapper(BoardMapper.class);
			return mapper.getBoardList();
		}
	}

	public int insertBoard(BoardDTO dto) {
		try (SqlSession session = DBManager.getInstance().getSession()) {
			BoardMapper mapper = session.getMapper(BoardMapper.class);
			return mapper.insertBoard(dto);
		}
	}

	public BoardDTO getBoard(int bno) {
		try (SqlSession session = DBManager.getInstance().getSession()) {
			BoardMapper mapper = session.getMapper(BoardMapper.class);
			return mapper.getBoard(bno);
		}
	}

	public int updateBoardCount(int bno) {
		try (SqlSession session = DBManager.getInstance().getSession()) {
			BoardMapper mapper = session.getMapper(BoardMapper.class);
			return mapper.updateBoardCount(bno);
		}
	}

	public int insertBoardComment(BoardCommentDTO dto) {
		try (SqlSession session = DBManager.getInstance().getSession()) {
			BoardMapper mapper = session.getMapper(BoardMapper.class);
			return mapper.insertBoardComment(dto);
		}
	}

	public List<BoardCommentDTO> getCommentList(int bno) {
		try (SqlSession session = DBManager.getInstance().getSession()) {
			BoardMapper mapper = session.getMapper(BoardMapper.class);
			return mapper.getCommentList(bno);
		}
	}

	public int deleteBoard(int bno) {
		try (SqlSession session = DBManager.getInstance().getSession()) {
			BoardMapper mapper = session.getMapper(BoardMapper.class);
			return mapper.deleteBoard(bno);
		}
	}

	public int deleteBoardComment(int cno) {
		try (SqlSession session = DBManager.getInstance().getSession()) {
			BoardMapper mapper = session.getMapper(BoardMapper.class);
			return mapper.deleteBoardComment(cno);
		}
	}
}
