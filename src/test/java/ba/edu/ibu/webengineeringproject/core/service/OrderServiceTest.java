package ba.edu.ibu.webengineeringproject.core.service;

import ba.edu.ibu.webengineeringproject.core.model.Order;
import ba.edu.ibu.webengineeringproject.core.model.Product;
import ba.edu.ibu.webengineeringproject.core.model.enums.ProductType;
import ba.edu.ibu.webengineeringproject.core.repository.OrderRepository;
import ba.edu.ibu.webengineeringproject.core.repository.ProductRepository;
import ba.edu.ibu.webengineeringproject.rest.dto.OrderRequestDTO;
import ba.edu.ibu.webengineeringproject.rest.dto.ProductRequestDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@AutoConfigureMockMvc
@SpringBootTest
class OrderServiceTest {
    @MockBean
    OrderRepository orderRepository;
    @Autowired
    OrderService orderService;
    @Test
    public void shouldReturnOrderWhenCreated() {
        OrderRequestDTO orderRequestDTO = new OrderRequestDTO();
        Order order = new Order();
        order.setProductIds(new ArrayList<>());

        Mockito.when(orderRepository.save(ArgumentMatchers.any(Order.class))).thenReturn(order);

        Order savedOrder = orderService.addOrder(orderRequestDTO);
        Assertions.assertEquals(order, savedOrder);

    }
    @Test
    public void shouldFindOrderById() {
        String orderId = "1";
        Order order = new Order();
        order.setId(orderId);
        order.setProductIds(new ArrayList<>());

        Mockito.when(orderRepository.findById(orderId)).thenReturn(Optional.of(order));

        Optional<Order> foundOrder = orderService.findById(orderId);
        Assertions.assertTrue(foundOrder.isPresent());
        Assertions.assertEquals(orderId, foundOrder.get().getId());
    }
    @Test
    public void shouldDeleteOrder() {
        String orderId = "1";
        Order existingOrder = new Order();
        existingOrder.setId(orderId);
        existingOrder.setProductIds(new ArrayList<>());

        Mockito.when(orderRepository.findById(orderId)).thenReturn(Optional.of(existingOrder));

        orderService.deleteOrder(orderId);

        Mockito.verify(orderRepository, Mockito.times(1)).delete(existingOrder);
    }

}