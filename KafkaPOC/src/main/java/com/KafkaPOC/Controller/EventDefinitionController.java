package com.KafkaPOC.Controller;


import com.KafkaPOC.Consumer.KafkaConsumerService;
import com.KafkaPOC.Services.EventDefinitionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import java.util.Map;
 
@RestController
@RequestMapping("/event-definition")
public class EventDefinitionController {
 
    @Autowired
    private EventDefinitionService eventDefinitionService;
 
    @Autowired
    private KafkaConsumerService kafkaConsumerService;
 
    /**
     * Create a new Event Definition.
     */
    @PostMapping
    public ResponseEntity<String> createEventDefinition(@RequestBody String requestBody) {
        try {
            eventDefinitionService.createEvent(requestBody);
            String latestMessage = kafkaConsumerService.getLatestMessage(); // Fetch latest consumer message
            return ResponseEntity.status(201).body("Event created. Latest consumer response: " + latestMessage);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating event: " + e.getMessage());
        }
    }
 
    /**
     * Read the latest consumed message from Kafka.
     */
    @GetMapping("/consumer/latest")
    public ResponseEntity<String> getLatestConsumerMessage() {
        String latestMessage = kafkaConsumerService.getLatestMessage();
        return ResponseEntity.ok("Latest consumed message: " + latestMessage);
    }
 
    /**
     * Read all consumed messages from Kafka.
     */
    @GetMapping("/consumer/all")
    public ResponseEntity<Map<String, Object>> getAllConsumerMessages() {
        Map<String, Object> response = Map.of(
                "messageCount", kafkaConsumerService.getAllMessages().size(),
                "messages", kafkaConsumerService.getAllMessages()
        );
        return ResponseEntity.ok(response);
    }
}