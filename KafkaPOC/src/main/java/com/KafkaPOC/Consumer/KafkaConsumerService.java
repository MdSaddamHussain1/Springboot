package com.KafkaPOC.Consumer;

import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Service;
 
import java.util.ArrayList;
import java.util.List;
 
@EnableKafka  // This is important to enable Kafka listeners
@Service
public class KafkaConsumerService {
    private final List<String> messages = new ArrayList<>();
 
    // Listen to Kafka messages
    @KafkaListener(topics = "event-topic", groupId = "event-group")
    public void listen(ConsumerRecord<String, String> record) {
        messages.add(record.value());  // Store consumed messages
    }
 
    public String getLatestMessage() {
        if (messages.isEmpty()) {
            return "No messages consumed yet.";
        }
        return messages.get(messages.size() - 1);
    }
 
    public List<String> getAllMessages() {
        return messages;
    }
}
