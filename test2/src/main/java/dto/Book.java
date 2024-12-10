package dto;


public class Book {

	private String isbn;
	private String bookName;
	private String author;
	private String publishDate;
	private String publisher;
	private int price;

	public Book() {	}

	

	public Book(String isbn, String bookName, String author, String publishDate, String publisher, int price) {
		this.isbn = isbn;
		this.bookName = bookName;
		this.author = author;
		this.publishDate = publishDate;
		this.publisher = publisher;
		this.price = price;
	}



	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
