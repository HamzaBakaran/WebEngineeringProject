package ba.edu.ibu.webengineeringproject.rest.controllers;

import ba.edu.ibu.webengineeringproject.core.model.Order;
import ba.edu.ibu.webengineeringproject.core.service.OrderService;
import ba.edu.ibu.webengineeringproject.rest.dto.OrderRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService=orderService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/")
    public ResponseEntity<List<Order>> getOrders() {
        return ResponseEntity.ok(orderService.findAllOrders());
    }
    @RequestMapping(method = RequestMethod.POST, path = "/register")
    public ResponseEntity<Order> register(@RequestBody OrderRequestDTO order) {
        return ResponseEntity.ok(orderService.addOrder(order));
    }
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<Optional<Order>> getOrderById(@PathVariable String id) {
        return ResponseEntity.ok(orderService.findById(id));
    }
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<Order> updateUser(@PathVariable String id, @RequestBody OrderRequestDTO order) {
        return ResponseEntity.ok(orderService.updateOrder(id,order));
    }
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable String id) {
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
