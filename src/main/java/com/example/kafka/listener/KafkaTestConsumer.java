package com.example.kafka.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaTestConsumer {

    @KafkaListener(topics = "teste")
    public void consumir(String mensagem) {
        System.out.println("Mensagem recebida: " + mensagem);
    }
}