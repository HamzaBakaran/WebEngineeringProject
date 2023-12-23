package ba.edu.ibu.webengineeringproject.core.repository;

import ba.edu.ibu.webengineeringproject.core.model.Order;
import ba.edu.ibu.webengineeringproject.core.model.Product;
import ba.edu.ibu.webengineeringproject.rest.dto.OrderCustomDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;
    @Test
    void shouldReturnAllOrdersCustom(){
        List<OrderCustomDTO> orders =orderRepository.findAllCustom();
        Assertions.assertNotNull(orders);

    }
    @Test
    void shouldReturnAllOrders(){
        List<Order> orders =orderRepository.findAll();
        Assertions.assertNotNull(orders);

    }
    @Test
    void shouldCountAllOrders(){
        long orders =orderRepository.countTotalOrders();
        Assertions.assertNotNull(orders);

    }
}