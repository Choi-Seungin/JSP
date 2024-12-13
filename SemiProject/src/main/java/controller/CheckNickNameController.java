package controller;

import java.io.IOException;

import org.json.JSONObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UsersService;
import view.ModelAndView;

/**
 * CheckNickNameController
 * 닉네임 중복 여부를 확인하고 결과를 JSON 형식으로 반환하는 컨트롤러.
 */
public class CheckNickNameController implements Controller {
    @Override
    public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // 클라이언트로부터 닉네임 파라미터를 가져옴
            String nickName = request.getParameter("nickName");
            System.out.println("요청받은 닉네임: " + nickName); // 로그 출력

            // 유효성 검사: 닉네임이 비어 있는 경우
            if (nickName == null || nickName.trim().isEmpty()) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.setContentType("application/json");
                response.getWriter().write(new JSONObject().put("error", "닉네임이 제공되지 않았습니다.").toString());
                return null;
            }

            // 닉네임 중복 여부 확인
            boolean exists = UsersService.getInstance().isNickNameExists(nickName.trim());

            // JSON 응답 생성
            JSONObject jsonResponse = new JSONObject();
            jsonResponse.put("exists", exists);

            response.setContentType("application/json");
            response.getWriter().write(jsonResponse.toString());
        } catch (Exception e) {
            // 예외 처리: 서버 내부 오류 발생 시 JSON 응답 반환
            System.err.println("[CheckNickNameController] 예외 발생: " + e.getMessage());
            e.printStackTrace();

            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.setContentType("application/json");
            response.getWriter().write(new JSONObject().put("error", "서버 내부 오류가 발생했습니다.").toString());
        }

        // JSON 응답이므로 뷰 반환 필요 없음
        return null;
    }
}
