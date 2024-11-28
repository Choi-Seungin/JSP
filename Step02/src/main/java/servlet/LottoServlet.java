package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class LottoServlet
 */
@WebServlet("/lotto.do")
public class LottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LottoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int set = Integer.parseInt(request.getParameter("set"));
		ArrayList<ArrayList<Integer>> lottoSet = new ArrayList<>();
		for (int i = 0; i < set; i++) {
			ArrayList<Integer> lottoNo = new ArrayList<Integer>();
			for (int j = 0; j < 6; j++) {
				int num = (int) (Math.random() * 45) + 1;
				if (!lottoNo.contains(num)) {
					lottoNo.add(num);
				} else {
					j--;
				}
			}
			lottoSet.add(lottoNo);
		}
		request.setAttribute("lottoSet", lottoSet);
		request.getRequestDispatcher("q2_lotto_result.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
