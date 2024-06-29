package org.com.hotelntconsult.listener;

import org.com.hotelntconsult.config.RabbitMQConfig;
import org.com.hotelntconsult.model.Reservation;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReservationMessageListener {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void handleMessage(Reservation reservation) {
        System.out.println("Processando reserva: " + reservation.getCustomerName());
        // Simulando de envio de e-mail
        System.out.println("Enviando e-mail de confirmação para " + reservation.getCustomerName());
    }
}