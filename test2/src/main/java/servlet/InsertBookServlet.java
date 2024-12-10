package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.BookDAO;
import dto.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/insertBook")
public class InsertBookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	String isbn = request.getParameter("isbn");
    	String bookName = request.getParameter("book_name");
    	String author = request.getParameter("author");
    	String publishDate = request.getParameter("publish_date");
    	String publisher = request.getParameter("publisher");
    	int price = Integer.parseInt(request.getParameter("price")); 
        
        BookDAO dao = new BookDAO();
        
        dao.insertBook(new Book(isbn, bookName, author, publishDate, publisher, price));
        
        response.sendRedirect("./bookAll");
        
    }
}
