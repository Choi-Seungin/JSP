package servlet;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.BookDAO;
import dto.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/searchBook.do")
public class BookSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String text = request.getParameter("search");
		BookDAO dao = new BookDAO();
		
		ArrayList<Book> list = dao.selectBookList(text);

		System.out.println(list);
		JSONObject json = new JSONObject();
		json.put("list", list);
		response.getWriter().println(json.toString());
	}
}
