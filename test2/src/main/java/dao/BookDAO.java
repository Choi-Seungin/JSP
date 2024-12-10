package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.Book;

public class BookDAO {
    private static final String JDBC_URL = "jdbc:oracle:thin:@nam3324.synology.me:32800:XE";
    private static final String JDBC_USER = "C##SCOTT";
    private static final String JDBC_PASSWORD = "123456";
    private Connection conn;
    public BookDAO() {
    	try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    }



	public ArrayList<Book> getAllBooks(){
		ArrayList<Book> books = new ArrayList<Book>();

        
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM BOOKS")) {

            while (rs.next()) {
                Book book = new Book();
                book.setIsbn(rs.getString("ISBN"));
                book.setBookName(rs.getString("BOOK_NAME"));
                book.setAuthor(rs.getString("AUTHOR"));
                book.setPublishDate(rs.getString("PUBLISH_DATE"));
                book.setPublisher(rs.getString("PUBLISHER"));
                book.setPrice(rs.getInt("PRICE"));
                books.add(book);
            }
        } catch (SQLException e) {
			e.printStackTrace();
		}
        return books;
    }
	
	public int insertBook(Book book) {
        String sql = "INSERT INTO BOOKS (ISBN, BOOK_NAME, AUTHOR, PUBLISH_DATE, PUBLISHER, PRICE) VALUES (?, ?, ?, ?, ?, ?)";
        int row = 0;
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, book.getIsbn());
            pstmt.setString(2, book.getBookName());
            pstmt.setString(3, book.getAuthor());
            pstmt.setString(4, book.getPublishDate());
            pstmt.setString(5, book.getPublisher());
            pstmt.setInt(6,book.getPrice()); 

            row = pstmt.executeUpdate();
            	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return row;
		
	}
}
