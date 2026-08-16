package com.bonginkosi.leave_service.service;

import com.bonginkosi.leave_service.dto.EmployeeDto;
import com.bonginkosi.leave_service.dto.LeaveDto;
import com.bonginkosi.leave_service.entity.Leave;
import com.bonginkosi.leave_service.event.EmployeeCreatedEvent;
import com.bonginkosi.leave_service.repository.LeaveRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveService {

    @Autowired
    private final LeaveRepository leaveRepository;
    private final EmployeeClient employeeClient;
    public LeaveService(LeaveRepository leaveRepository, EmployeeClient employeeClient) {
        this.leaveRepository = leaveRepository;
        this.employeeClient = employeeClient;
    }

    //Method(POST) to create a leave record for an employee
    public LeaveDto createLeave(LeaveDto leaveDto){
        // Verify that the employee exists
        EmployeeDto employee;

        try {
            employee = employeeClient.getEmployeeById(leaveDto.getEmployeeId());
        } catch (FeignException.NotFound ex) {
            throw new RuntimeException(
                    "User with ID " + leaveDto.getEmployeeId() + " was not found."
            );
        }

        //Creating a leave record for the employee
        Leave leave = new Leave();
        leave.setLeaveType(leaveDto.getLeaveType());
        leave.setStartDate(leaveDto.getStartDate());
        leave.setEndDate(leaveDto.getEndDate());
        leave.setStatus(leaveDto.getStatus());
        leave.setReason(leaveDto.getReason());
        leave.setEmployeeId(employee.getId());
        leaveRepository.save(leave);

        return leaveDto;
    }

}


