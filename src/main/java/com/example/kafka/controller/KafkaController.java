
package com.example.kafka.controller;

import com.example.kafka.service.KafkaProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private final KafkaProducerService producerService;

    public KafkaController(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/send")
    public ResponseEntity<Void> enviar(
            @RequestBody KafkaMessageRequest request) {

        producerService.enviarMensagem(
                request.key(),
                request.mensagem()
        );

        return ResponseEntity.accepted().build();
    }

    public record KafkaMessageRequest(
            String key,
            String mensagem
    ) {}
}
