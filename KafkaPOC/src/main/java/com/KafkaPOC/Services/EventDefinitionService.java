package com.KafkaPOC.Services;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
 
@Service
public class EventDefinitionService {
 
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String topic = "event-topic"; // The Kafka topic where messages are published
 
    public EventDefinitionService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
 
    public void createEvent(String eventMessage) {
        // Send the event to the Kafka topic
        kafkaTemplate.send(topic, eventMessage);
    }
}