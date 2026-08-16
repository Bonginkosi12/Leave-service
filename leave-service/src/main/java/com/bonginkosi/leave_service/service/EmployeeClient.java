package com.bonginkosi.leave_service.service;

import com.bonginkosi.leave_service.dto.EmployeeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "employee-service",
        url = "http://localhost:8080"
)
public interface EmployeeClient {
    @GetMapping("/users/{id}")
    EmployeeDto getEmployeeById(@PathVariable Integer id);

}
