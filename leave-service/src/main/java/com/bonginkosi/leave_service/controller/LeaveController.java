package com.bonginkosi.leave_service.controller;

import com.bonginkosi.leave_service.dto.LeaveDto;
import com.bonginkosi.leave_service.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee_leave")
public class LeaveController {

    @Autowired
    private final LeaveService leaveService;
    public LeaveController(LeaveService leaveService) {
        this.leaveService = leaveService;
    }

    @PostMapping
    public LeaveDto createLeave(@RequestBody LeaveDto leaveDto){
        return leaveService.createLeave(leaveDto);

    }


}
