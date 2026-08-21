package com.bonginkosi.leave_service.entity;

import com.bonginkosi.leave_service.enums.LeaveStatus;
import com.bonginkosi.leave_service.enums.LeaveType;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "employee_leave")
public class Leave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "employee_id")
    private Integer employeeId;

    @Enumerated(EnumType.STRING)
    @Column(name = "leave_type")
    private LeaveType leaveType;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "reason", length = 500)
    private String reason;

    @Enumerated(EnumType.STRING)
    @Column(name = "leaveStatus")
    private LeaveStatus leaveStatus;


    public Leave() {
    }

    public Leave(Integer id, Integer employeeId, LeaveType leaveType, LocalDate startDate, LocalDate endDate, String reason, LeaveStatus leaveStatus) {
        this.id = id;
        this.employeeId = employeeId;
        this.leaveType = leaveType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.leaveStatus = leaveStatus;
    }

    //Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public LeaveType getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LeaveStatus getLeaveStatus() {
        return  leaveStatus;
    }

    public void setLeaveStatus(LeaveStatus  leaveStatus) {
        this.leaveStatus = leaveStatus ;
    }

}