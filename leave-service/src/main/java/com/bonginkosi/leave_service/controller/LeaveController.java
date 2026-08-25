package com.bonginkosi.leave_service.controller;

import com.bonginkosi.leave_service.dto.LeaveDto;
import com.bonginkosi.leave_service.event.EmployeeCreatedEvent;
import com.bonginkosi.leave_service.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee_leave")
public class LeaveController {

    @Autowired
    private final LeaveService leaveService;
    public LeaveController(LeaveService leaveService) {
        this.leaveService = leaveService;
    }

    //PATCH Endpoint
    @PatchMapping("/{id}")
    public LeaveDto updateLeave(@PathVariable Integer id,@RequestBody LeaveDto leaveDto){
        return leaveService.updateLeave(id, leaveDto);
    }


}
