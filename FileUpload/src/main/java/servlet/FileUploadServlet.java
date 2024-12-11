package servlet;

import java.io.IOException;
import java.io.File;
import java.util.Iterator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/fileUpload.do")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 50)
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File root = new File("c:\\fileupload");
		//해당 경로가 있는지 체크, 없으면 해당 경로 생성
		if(!root.exists()) {
			System.out.println("파일 업로드할 폴더 및 경로 생성");
			root.mkdirs();
		}		
		
		Iterator<Part> it = request.getParts().iterator();
		//업로드할 파일 정보를 읽는 부분
		while(it.hasNext()) {
			Part part = it.next();
//			System.out.println("size : " + part.getSize());
			if(part.getSubmittedFileName() != null && !part.getSubmittedFileName().isEmpty()) {
				System.out.println(part.getName());
				System.out.println(part.getSubmittedFileName());
				System.out.println(part.getSize());
				//파일쓰기
				part.write(root.getAbsolutePath()+"\\"+part.getSubmittedFileName());
			}else {
				//받은 내용이 파일아닐때 네임속성값과 파라미터값을 꺼내게끔 처리
				System.out.println(part.getName() + " / " + request.getParameter(part.getName()));
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}