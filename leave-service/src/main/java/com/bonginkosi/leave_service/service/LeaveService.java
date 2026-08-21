package com.bonginkosi.leave_service.service;

import com.bonginkosi.leave_service.dto.EmployeeDto;
import com.bonginkosi.leave_service.dto.LeaveDto;
import com.bonginkosi.leave_service.entity.Leave;
import com.bonginkosi.leave_service.enums.LeaveStatus;
import com.bonginkosi.leave_service.enums.LeaveType;
import com.bonginkosi.leave_service.event.EmployeeCreatedEvent;
import com.bonginkosi.leave_service.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveService {

    @Autowired
    private final LeaveRepository leaveRepository;
    public LeaveService(LeaveRepository leaveRepository) {
        this.leaveRepository = leaveRepository;
    }

    //Method(POST) to create a leave record for an employee
    public void createLeave(EmployeeCreatedEvent event) {
        Leave leave = new Leave();

        // Link the employee to the leave record
        leave.setEmployeeId(event.getId());

        // Leave information will be added later using PATCH
        leaveRepository.save(leave);
    }





}


