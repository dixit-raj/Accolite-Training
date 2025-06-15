package com.example.UrbanClone.service;
import com.example.UrbanClone.entity.AuditLog;
import com.example.UrbanClone.repository.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class AuditLogService {

    @Autowired
    private AuditLogRepository auditRepo;
    public void log(String action, String user, String details) {
        AuditLog log = new AuditLog();
        log.setAction(action);
        log.setPerformedBy(user);
        log.setDetails(details);
        log.setTimestamp(LocalDateTime.now());
        auditRepo.save(log);

    }

}

