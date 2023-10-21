package ba.edu.ibu.webengineeringproject.core.service;

import ba.edu.ibu.webengineeringproject.core.exceptions.repository.ResourceNotFoundException;
import ba.edu.ibu.webengineeringproject.core.model.Order;
import ba.edu.ibu.webengineeringproject.core.repository.OrderRepository;
import ba.edu.ibu.webengineeringproject.rest.dto.OrderRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private  final OrderRepository orderRepository;

    public OrderService (OrderRepository orderRepository) {
        this.orderRepository=orderRepository;
    }
    public List<Order> findAllOrders() {
        List<Order> orders =orderRepository.findAll();

        return orders;

    }
    public Optional<Order> findById(String id) {
        Optional<Order> order=orderRepository.findById(id);
        if (order.isEmpty()){
            throw new ResourceNotFoundException("The order with the given ID does not exist.");
        }
        return Optional.of(order.get());

    }
    public Order addOrder(OrderRequestDTO payload){
        Order order=orderRepository.save(payload.toEntity());
        return order;

    }
    public Order updateOrder(String id,OrderRequestDTO payload){
        Optional<Order>order=orderRepository.findById(id);
        if (order.isEmpty()) {
            throw new ResourceNotFoundException("The user with the given ID does not exist.");
        }
        Order updatedorder= payload.toEntity();
        updatedorder.setId(order.get().getId());
        updatedorder=orderRepository.save(updatedorder);
        return updatedorder;
    }
    public void deleteOrder(String id){
        Optional<Order> order=orderRepository.findById(id);
        order.ifPresent(orderRepository::delete);
    }
}
