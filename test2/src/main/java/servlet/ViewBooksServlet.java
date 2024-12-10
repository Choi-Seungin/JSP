package servlet;

import java.io.IOException;
import java.util.ArrayList;

import dao.BookDAO;
import dto.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/bookAll")
public class ViewBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookDAO dao = new BookDAO();

		ArrayList<Book> books = dao.getAllBooks();
		request.setAttribute("books", books);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view_books.jsp");
		dispatcher.forward(request, response);

	}
}
