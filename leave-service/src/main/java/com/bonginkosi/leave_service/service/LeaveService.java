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

    //Method to update the leave record
    public LeaveDto updateLeave(Integer id, LeaveDto leaveDto) {
        Leave leave = leaveRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Leave record not found"));

        if(leaveDto.getLeaveType() != null){
            leave.setLeaveType(leaveDto.getLeaveType());
        }

        if(leaveDto.getLeaveStatus() != null){
            leave.setLeaveStatus(leaveDto.getLeaveStatus());
        }

        if(leaveDto.getStartDate() != null){
            leave.setStartDate(leaveDto.getStartDate());
        }

        if(leaveDto.getEndDate() != null){
            leave.setEndDate(leaveDto.getEndDate());
        }

        if(leaveDto.getReason() != null){
            leave.setReason(leaveDto.getReason());
        }
        leaveRepository.save(leave);

        return new LeaveDto(
            leave.getLeaveType(),
            leave.getLeaveStatus(),
            leave.getStartDate(),
            leave.getEndDate(),
            leave.getReason()
        );

    }





}


