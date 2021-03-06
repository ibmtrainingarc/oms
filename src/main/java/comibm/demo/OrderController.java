package comibm.demo;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import comibm.demo.entity.Order;
import comibm.demo.service.OrderService;

@RestController
public class OrderController { //frontend
	@Autowired    //used for DI
	OrderService orderService;  //DI
	@PostMapping("/order")
	@ResponseStatus(code=HttpStatus.CREATED)
	String createOrder(@RequestBody @Valid Order order , BindingResult bindingResult) {
		validateModel(bindingResult);
		System.out.println(order);
		return orderService.createOrder(order);
	}
	
	@GetMapping("/order")
	List<Order> getOrders() {
		return orderService.getOrders();
	}
	/**
	 * method to search for an order
	 * @param orderId
	 * @return
	 * return a matching order
	 */
	
	@GetMapping("/order/{id}")
	Optional<Order> getOrder( @PathVariable("id") String orderId) {
		 return orderService.getOrder(orderId);
	}
	
	private void validateModel(Errors bindingResult) {
		if(bindingResult.hasErrors()) {
			throw new IllegalArgumentException("Something went wrong, please retry!");
		}
	}

	@PutMapping("/order/{id}")
	void updateOrder(@RequestBody @Valid Order order, @PathVariable("id") String orderId, BindingResult bindingResult ) {
		validateModel(bindingResult);
		order.setId(orderId);
		orderService.updateOrder(order);

	}

	@DeleteMapping("/order/{id}")
	void deleteOrder(@PathVariable("id") int orderId, HttpRequest httpRequest) {
		System.out.println(httpRequest.getHeaders());
		System.out.println(orderId);
		orderService.deleteOrder(orderId);

	}

}
