package comibm.demo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import comibm.demo.entity.Order;

public interface OrderRepository extends MongoRepository<Order,String> {

}
