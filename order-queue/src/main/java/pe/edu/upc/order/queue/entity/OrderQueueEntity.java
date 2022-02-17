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

	public Integer id;
	public String nationalId;
	public String email;
	public String campus;
	public Date applicationDate;
	
}
