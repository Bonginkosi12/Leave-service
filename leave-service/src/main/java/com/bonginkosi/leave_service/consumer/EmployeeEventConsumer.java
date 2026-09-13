// Receives message from Producer through RabbitMQ
package com.bonginkosi.leave_service.consumer;

import com.bonginkosi.leave_service.event.EmployeeCreatedEvent;
import com.bonginkosi.leave_service.service.LeaveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeEventConsumer {

    @Autowired
    private final LeaveService leaveService;
    public EmployeeEventConsumer(LeaveService leaveService) {
        this.leaveService = leaveService;
    }

    private static final Logger log =
            LoggerFactory.getLogger(EmployeeEventConsumer.class);

    @RabbitListener(queues = "leave.queue")
    public void consumeEmployeeCreated(EmployeeCreatedEvent event) {

        log.info("Received Employee Created Event: {}", event);

        // Create initial leave record here
       leaveService. createLeave(event);
    }
}
