package br.com.fiap.bolsafamilia.produtor;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(id = "kafka-consumer", topics = "bolsafamilia2")
    public void consumeMessage(String message) {

        System.out.println("Got message: " + message);
    }
}