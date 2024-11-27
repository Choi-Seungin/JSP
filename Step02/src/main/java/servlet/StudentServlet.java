package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.StudentVO;

import java.io.IOException;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/studentRegister.do")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentNo = request.getParameter("studentNo");
		String studentName = request.getParameter("studentName");
		String majorName = request.getParameter("majorName");
		String studentScore = request.getParameter("studentScore");
		//String result = studentNo + " / " + studentName + " / " + majorName + " / " + studentScore;
		System.out.println(studentNo + "  " + studentName + "  " + majorName + "  " + studentScore);
		StudentVO vo = new StudentVO(studentNo, studentName, majorName, Double.parseDouble(studentScore));
		
		request.setAttribute("vo", vo);
		
		//student_result.jsp로 이동해서 vo에 있는 내용을 전부 출력
		request.getRequestDispatcher("student_result.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글이 깨지는 현상이 발생하면
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
