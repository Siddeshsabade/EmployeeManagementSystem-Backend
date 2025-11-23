package com.employee.controller;

import com.employee.model.Audit;
import com.employee.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/audit")
@CrossOrigin(origins = "http://localhost:4200")
public class AuditController {

    @Autowired
    private AuditService service;

    @GetMapping("/{id}")
    public List<Audit> getHistory(@PathVariable Long id) {
        return service.findByEmployee(id);
    }

    @GetMapping("/all")
    public List<Audit> getAllAudits() {
        return service.getAll();
    }
}

