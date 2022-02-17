package pe.edu.upc.order.queue.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderQueueEntity {

	public Integer order_id;
	public Date order_date;
	public Integer customer_id;
	public Date booking_date;
	public String status;
	public Integer product_id;
	public double unit_price;
	public double discount;
	public Integer quantity;
	public Date start_hour;
	public Date end_hour;
}
