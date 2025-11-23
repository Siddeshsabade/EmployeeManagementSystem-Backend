package com.employee.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor

public class Audit {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    private String action;
    private Long employeeId;

    private String details;

    private LocalDateTime time;

    @Override
    public String toString() {
        return "Audit{" +
                "id=" + id +
                ", action='" + action + '\'' +
                ", employeeId=" + employeeId +
                ", details='" + details + '\'' +
                ", time=" + time +
                '}';
    }

    public Audit(String action, Long employeeId, String details) {
        this.action = action;
        this.time = LocalDateTime.now();
        this.details = details;
        this.employeeId = employeeId;
    }
}
