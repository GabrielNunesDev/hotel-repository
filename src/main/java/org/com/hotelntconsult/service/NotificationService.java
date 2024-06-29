package org.com.hotelntconsult.service;

import org.com.hotelntconsult.config.RabbitMQConfig;
import org.com.hotelntconsult.model.Reservation;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendConfirmationMessage(Reservation reservation) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, reservation);
        System.out.println("Mensagem de confirmação enviada para a fila: " + reservation.getCustomerName());
    }
}