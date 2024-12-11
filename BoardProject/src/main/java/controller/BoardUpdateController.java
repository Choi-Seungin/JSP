package controller;

import java.io.IOException;

import dto.BoardDTO;
import dto.BoardMemberDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BoardService;
import view.ModelAndView;

public class BoardUpdateController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// title, content 파라미터 읽어옴
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int bno = Integer.parseInt(request.getParameter("bno"));

		// 게시글 등록
		BoardDTO dto = new BoardDTO();
		dto.setBno(bno);
		dto.setTitle(title);
		dto.setContent(content);
		
		BoardService.getInstance().updateBoard(dto);
		
		// main.jsp로 이동(./boardMain.do)
		ModelAndView view = new ModelAndView();
		view.setPath("./boardView.do?bno="+bno);
		view.setRedirect(true);

		return view;
	}

}
