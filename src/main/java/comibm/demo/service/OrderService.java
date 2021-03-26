package comibm.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comibm.demo.entity.Order;
import comibm.demo.repo.OrderRepository;

@Service
public class OrderService {  //spring bean
	@Autowired
	OrderRepository orderRepository;
	public String createOrder(Order order) {
		Order savedOrder = orderRepository.save(order);
		return savedOrder.getId();
	}
	
	public List<Order>getOrders(){
		return orderRepository.findAll();
	}
	
	public Optional<Order> getOrder(String id) {
		return orderRepository.findById(id);
	}

	public void updateOrder(Order order) {
		// TODO Auto-generated method stub
		//return "order updated";
		orderRepository.save(order);
	}

	public void deleteOrder(int orderId) {
		// TODO Auto-generated method stub
		System.out.println("Order deleted");
	}
	

}
