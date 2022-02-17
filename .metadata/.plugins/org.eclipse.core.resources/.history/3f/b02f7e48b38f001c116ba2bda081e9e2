package pe.edu.upc.order.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upc.order.queue.entity.OrderQueueEntity;
import pe.edu.upc.order.entity.OrderEntity;
import pe.edu.upc.order.queue.ConfigQueue;
import pe.edu.upc.order.repository.OrderRepository;
import pe.edu.upc.order.response.ResponseHandler;

@RestController
@RequestMapping("/passport/v1")
public class OrderController {

	@Autowired
	private OrderRepository appointmentRepository;
	
	@Autowired
	private RabbitTemplate template;

	@CrossOrigin(origins = "*")
	@PostMapping("/appointment")
	public ResponseEntity<?> createAppointment(@Validated @RequestBody OrderEntity appointment) {

		OrderEntity appointmentResult = new OrderEntity();

		appointmentResult = appointmentRepository.save(appointment);

		return ResponseHandler.generateResponse("La solicitud ha sido registrada satisfactoriamente",
				HttpStatus.CREATED, appointmentResult);
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/create-order")
	public ResponseEntity<?> createOrder(@Validated @RequestBody OrderQueueEntity appointment) {
		
		template.convertAndSend(ConfigQueue.EXCHANGE, ConfigQueue.ROUTING_KEY, appointment);
		
		return ResponseHandler.generateResponse("La solicitud ha sido registrada. Le confirmaremos su número de solicitud mediante correo electrónico",
				HttpStatus.CREATED, null);
	}
}

