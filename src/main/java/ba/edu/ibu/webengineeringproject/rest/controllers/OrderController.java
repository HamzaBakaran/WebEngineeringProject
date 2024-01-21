package ba.edu.ibu.webengineeringproject.rest.controllers;

import ba.edu.ibu.webengineeringproject.core.model.Order;
import ba.edu.ibu.webengineeringproject.core.service.OrderService;
import ba.edu.ibu.webengineeringproject.rest.dto.OrderCustomDTO;
import ba.edu.ibu.webengineeringproject.rest.dto.OrderRequestDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
@SecurityRequirement(name = "JWT Security")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService=orderService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/")
    @PreAuthorize("hasAnyAuthority( 'ADMIN','WORKER')")
    public ResponseEntity<List<Order>> getOrders() {
        return ResponseEntity.ok(orderService.findAllOrders());
    }
    @RequestMapping(method = RequestMethod.GET, path = "/getAllCustom")
    @PreAuthorize("hasAnyAuthority( 'ADMIN','WORKER')")
    public ResponseEntity<List<OrderCustomDTO>> getCustomOrders() {
        return ResponseEntity.ok(orderService.findAllCustom());
    }
    @RequestMapping(method = RequestMethod.POST, path = "/register")
    @PreAuthorize("hasAnyAuthority( 'ADMIN','WORKER')")
    public ResponseEntity<Order> register(@RequestBody OrderRequestDTO order) {
        return ResponseEntity.ok(orderService.addOrder(order));
    }
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    @PreAuthorize("hasAnyAuthority( 'ADMIN','WORKER')")
    public ResponseEntity<Optional<Order>> getOrderById(@PathVariable String id) {
        return ResponseEntity.ok(orderService.findById(id));
    }
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    @PreAuthorize("hasAnyAuthority( 'ADMIN','WORKER')")
    public ResponseEntity<Order> updateUser(@PathVariable String id, @RequestBody OrderRequestDTO order) {
        return ResponseEntity.ok(orderService.updateOrder(id,order));
    }
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @PreAuthorize("hasAnyAuthority( 'ADMIN','WORKER')")
    public ResponseEntity<Void> deleteOrder(@PathVariable String id) {
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @RequestMapping(method = RequestMethod.GET, path = "/countOrders")
    @PreAuthorize("hasAnyAuthority( 'ADMIN','WORKER')")
    public Map<String, Long> countOrders() {
        long totalOrders = orderService.countTotalOrders();

        Map<String, Long> response = new HashMap<>();
        response.put("totalOrders", totalOrders);

        return response;
    }
}
