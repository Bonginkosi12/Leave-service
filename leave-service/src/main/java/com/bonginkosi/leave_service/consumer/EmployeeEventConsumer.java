package com.bonginkosi.leave_service.consumer;

import com.bonginkosi.leave_service.event.EmployeeCreatedEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class EmployeeEventConsumer {

    @RabbitListener(queues = "leave.queue")
    public void consumeEmployeeCreated(EmployeeCreatedEvent event) {

        System.out.println(
                "Employee created: " + event.getId()
        );

        System.out.println(
                "Employee name: " + event.getName()
        );

        System.out.println(
                "Employee age: " + event.getAge()
        );

        System.out.println(
                "Employee email: " + event.getEmail()
        );
        System.out.println(
                "Employee mobileNumbers: " + event.getMobileNumbers()
        );

        System.out.println(
                "Employee role: " + event.getRole()
        );

        System.out.println(
                "Employee employmentType: " + event.getEmploymentType()
        );

        System.out.println(
                "Employee department: " + event.getDepartment()
        );


        // Create initial leave record here
       //leaveService.createLeaveForEmployee(event);
    }
}
