package pe.edu.upc.order.queue.consumer;

import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.upc.order.queue.entity.OrderQueueEntity;
import pe.edu.upc.order.entity.OrderEntity;
import pe.edu.upc.order.entity.ProductOrderCompositeEntity;
import pe.edu.upc.order.entity.ProductOrderEntity;
import pe.edu.upc.order.queue.ConfigQueue;
import pe.edu.upc.order.repository.OrderRepository;
import pe.edu.upc.order.repository.ProductOrderRepository;

@Component
public class OrderConsumer {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductOrderRepository productOrderRepository;
	
	@RabbitListener(queues = ConfigQueue.QUEUE)
	public void consumerOrderQueue(List<OrderQueueEntity> orderQueueEntityList) {
		
		
				
		for (OrderQueueEntity item : orderQueueEntityList) {
			
			OrderEntity orderEntity = new OrderEntity();
			OrderEntity resultEntity = new OrderEntity();
			
			orderEntity.order_date = item.order_date;
			orderEntity.customer_id = item.customer_id;
			orderEntity.booking_date = item.booking_date;
			orderEntity.status = item.status;
			orderEntity.sub_total = item.unit_price * item.quantity;
			orderEntity.total_tax = orderEntity.sub_total * 0.18;
			orderEntity.total = orderEntity.sub_total + orderEntity.total_tax;
			orderEntity.active = 1;
			
			resultEntity = orderRepository.save(orderEntity);
						
			productOrderRepository.save(new ProductOrderEntity( new ProductOrderCompositeEntity(item.product_id, resultEntity.order_id),
					item.unit_price, item.discount, item.quantity, item.start_hour, item.end_hour));
		}
		
		//productOrderRepository.save(productOrderEntity);
	}
	
}
