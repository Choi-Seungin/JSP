package controller;

import java.io.IOException;

import org.json.JSONObject;

import dto.BoardMemberDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BoardService;
import view.ModelAndView;

public class BoardLikeController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 글번호, 세션에서 사용자 아이디값
		int bno = Integer.parseInt(request.getParameter("bno"));
		String id = ((BoardMemberDTO) request.getSession().getAttribute("user")).getId();
		JSONObject json = new JSONObject();
		try {
			// 좋아요 등록
			BoardService.getInstance().insertBoardLike(bno, id);
			json.put("msg", "해당 게시글에 좋아요를 하셨습니다.");
		} catch (Exception e) {
			// 예외처리 발생하면 이미 등록되어 있는 좋아요를 삭제해서 취소 시
			BoardService.getInstance().deleteBoardLike(bno, id);
			json.put("msg", "해당 게시글에 좋아요를 취소하셨습니다.");

		}
		json.put("blike", BoardService.getInstance().getBoardLike(bno));
		json.put("bhate", BoardService.getInstance().getBoardHate(bno));

		response.getWriter().println(json.toString());
		return null;
	}

}
