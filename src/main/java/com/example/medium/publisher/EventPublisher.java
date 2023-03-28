package com.example.medium.publisher;

import com.example.medium.config.MessagingConfig;
import com.example.medium.dtos.UpdateEventRequest;
import com.example.medium.dtos.requests.CreateEventRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/event/order")
public class EventPublisher {

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/create")
    public void sendCreateEvent(@RequestBody CreateEventRequest request){
        template.convertAndSend(MessagingConfig.EXCHANGE, "order_received", request);
    }

    @PostMapping("/start-delivery")
    public void sendStartDeliveryEvent(@RequestBody UpdateEventRequest request) {
        template.convertAndSend(MessagingConfig.EXCHANGE, "delivery_started", request);
    }

    @PostMapping("/finish-delivery")
    public void sendFinishStartDelivery(@RequestBody UpdateEventRequest request){
        template.convertAndSend(MessagingConfig.EXCHANGE, "order_finished", request);
    }

    @GetMapping("/order/{trackingId}")
    public Object sendGetOrderEvent(@PathVariable String trackingId){
        Object response = (Object) template.convertSendAndReceive(MessagingConfig.EXCHANGE, "get_order", trackingId);
        return response;
    }

}
