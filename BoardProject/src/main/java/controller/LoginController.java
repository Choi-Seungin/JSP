package controller;

import java.io.IOException;

import dto.BoardMemberDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BoardMemberService;
import view.ModelAndView;

public class LoginController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 아이디, 비밀번호 받음
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		BoardMemberDTO dto = BoardMemberService.getInstance().login(id, password);
		// 서비스로 아이디 비밀번호 보냄 - 결과로 BoardMemberDTO 받음

		ModelAndView view = new ModelAndView();
		// 로그인 성공
		if (dto != null) {
			request.getSession().setAttribute("user", dto);
			view.setPath("./boardMain.do");
			view.setRedirect(true);
		} else {
			// 로그인 실패
			view.setPath("login.jsp");
		}
		return view;
	}

}
