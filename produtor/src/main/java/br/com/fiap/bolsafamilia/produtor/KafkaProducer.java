package br.com.fiap.bolsafamilia.produtor;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private KafkaTemplate<String, String> kafkaProducer;

    public KafkaProducer(KafkaTemplate<String, String> kafkaProducer) {

        this.kafkaProducer = kafkaProducer;
    }
    public void send(String message) {
        kafkaProducer.send("bolsafamilia2", message);
    }
}
