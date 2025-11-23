package com.employee.service;

import com.employee.dao.AuditDao;
import com.employee.dao.EmployeeDao;
import com.employee.model.Audit;
import com.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private AuditDao auditDao;

    public Employee addEmployee(Employee e) {
        Employee saved = employeeDao.save(e);
        auditDao.save(new Audit("ADD", saved.getId(), saved.toString()));
        return saved;
    }

    public Employee updateEmployee(Long id, Employee newData) {
        Employee old = employeeDao.findById(id).orElseThrow();

        old.setName(newData.getName());
        old.setEmail(newData.getEmail());
        old.setSalary(newData.getSalary());

        Employee updated = employeeDao.save(old);
        auditDao.save(new Audit("UPDATE", updated.getId(), updated.toString()));

        return updated;
    }

    public void deleteEmployee(Long id) {
        Employee old = employeeDao.findById(id).orElseThrow();
        employeeDao.deleteById(id);
        auditDao.save(new Audit("DELETE", id, old.toString()));
    }

    public List<Employee> list() {
        return employeeDao.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeDao.findById(id).orElse(null);
    }
}

