package comibm.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import comibm.demo.entity.Order;

@Service
public class OrderService {  //spring bean
	
	public String createOrder(Order order) {
		return "order created";
	}
	
	public List<Order>getOrders(){
		return new ArrayList<Order>();
	}
	
	public Order getOrder(int id) {
		return new Order();
	}

	public void updateOrder(int id) {
		// TODO Auto-generated method stub
		//return "order updated";
	}

	public void deleteOrder(int orderId) {
		// TODO Auto-generated method stub
		System.out.println("Order deleted");
	}
	

}
