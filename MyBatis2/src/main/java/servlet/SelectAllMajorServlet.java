package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mapper.MajorMapper;

import java.io.IOException;
import java.util.List;

import config.DBManager;
import dto.MajorDTO;

/**
 * Servlet implementation class SelectAllMajorServlet
 */
@WebServlet("/allMajor.do")
public class SelectAllMajorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectAllMajorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MajorMapper mapper = DBManager.getInstance().getSession().getMapper(MajorMapper.class);
		//1. 전체 학과정보 읽어옴
		List<MajorDTO> list = mapper.selectAllMajor();
		//2. request 영역에 저장
		request.setAttribute("majorList", list);
		//3. 페이지 이동
		request.getRequestDispatcher("./major_list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
