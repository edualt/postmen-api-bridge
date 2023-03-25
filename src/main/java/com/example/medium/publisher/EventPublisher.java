package com.example.medium.publisher;

import com.example.medium.config.MessagingConfig;
import com.example.medium.dtos.CreateEventRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class EventPublisher {

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/event")
    public String sendEvent(@RequestBody CreateEventRequest eventRequest){
        //restaurantservice
        //paymentservice
        String event = (String) template.convertSendAndReceive(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, eventRequest);
        return event;
    }
}
