package mapper;

import java.util.List;
import java.util.Map;

import dto.BoardsDTO;
import dto.CommentsDTO;

public interface BoardsMapper {

	List<BoardsDTO> selectAllBoards();

	BoardsDTO selectBoardByPostNumber(int postNumber);

	int deleteBoardByPostNumber(int postNumber);

	int insertBoard(BoardsDTO dto);

	int updateBoard(BoardsDTO board);

	List<BoardsDTO> searchBoardsByTitle(Map<String, Object> params);

	List<BoardsDTO> searchBoardsByWriter(Map<String, Object> params);

	List<BoardsDTO> searchBoardsByTitleSorted(Map<String, Object> params);

	List<BoardsDTO> searchBoardsByWriterSorted(Map<String, Object> params);
	
	//조회수
	int updateBoardsCount(int postNumber);
	
	int insertComment(CommentsDTO comment);

	List<CommentsDTO> getCommentList(int postNumber);

	int deleteComment(int commentNumber);

}