package config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic cabLocationTopic() {
        // Define a topic with 3 partitions and a replication factor of 1 (for single-node Kafka setup)
        return TopicBuilder.name("cab-location")
                           .partitions(3)        // Number of partitions (adjust as needed)
                           .replicas(1)           // Replication factor (adjust as needed)
                           .build();
    }
}
