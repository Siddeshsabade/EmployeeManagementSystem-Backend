package com.employee.service;

import com.employee.dao.AuditDao;
import com.employee.model.Audit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditService {

    private final AuditDao auditDao;

    public AuditService(AuditDao auditRepo) {
        this.auditDao = auditRepo;
    }

    public List<Audit> findByEmployee(Long employeeId) {
        return auditDao.findByEmployeeId(employeeId);
    }

    public List<Audit> getAll() {
        return auditDao.findAll();
    }

    public Audit save(Audit entry) {
        return auditDao.save(entry);
    }
}

