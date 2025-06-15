package com.example.UrbanClone.interceptor;
import com.example.UrbanClone.service.AuditLogService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuditLogInterceptor implements HandlerInterceptor {

    @Autowired
    private AuditLogService auditLogService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String user = request.getUserPrincipal() != null ? request.getUserPrincipal().getName() : "ANONYMOUS";
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String details = method + " " + uri;
        auditLogService.log("API_CALL", user, details);
        return true;

    }

}

