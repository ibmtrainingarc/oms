package comibm.demo.service;

import org.springframework.stereotype.Service;

import comibm.demo.entity.Order;

@Service
public class OrderService {  //spring bean
	
	public String createOrder(Order order) {
		return "order created";
	}

}
