package org.example.expert.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class AdminInterceptor implements HandlerInterceptor {
    private final Logger logger = LoggerFactory.getLogger(AdminInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userRole = (String) request.getSession().getAttribute("userRole");
        Long userId = (Long) request.getAttribute("userId");
        String email = (String) request.getAttribute("email");
        // 어드민 권한 여무 확인하여 인증되지 않은 사용자 접근 차단
        //
        if (!"ADMIN".equals(userRole) || userId == null){
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "관리자 유저만 사용가능합니다.");
            return false;
        }
        // 인증성공시
        logger.info("관리자 접근 성공 ->  ID: {}, API 요청 시작시각: {}, URL: {}", userId, LocalDateTime.now(),  request.getRequestURI());
        return true; // 요청을 컨트롤러로 이양
    }

}
