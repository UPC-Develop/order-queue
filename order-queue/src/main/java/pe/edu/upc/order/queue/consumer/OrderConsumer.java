package pe.edu.upc.order.queue.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.upc.order.queue.entity.OrderQueueEntity;
import pe.edu.upc.order.entity.OrderEntity;
import pe.edu.upc.order.queue.ConfigQueue;
import pe.edu.upc.order.repository.OrderRepository;

@Component
public class OrderConsumer {

	@Autowired
	private OrderRepository appointmentRepository;
	
	@RabbitListener(queues = ConfigQueue.QUEUE)
	public void consumerAppointmentQueue(OrderQueueEntity appointmentQueue) {
		
		OrderEntity appointment = new OrderEntity();
		
		appointment.nationalId = appointmentQueue.nationalId;
		appointment.email = appointmentQueue.email;
		appointment.campus = appointmentQueue.campus;
		appointment.applicationDate = appointmentQueue.applicationDate;
		
		appointmentRepository.save(appointment);
	}
	
}
