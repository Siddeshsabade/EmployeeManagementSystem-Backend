package com.employee.dao;

import com.employee.model.Audit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuditDao extends JpaRepository<Audit, Long> {
    List<Audit> findByEmployeeId (Long employeeId);
}
