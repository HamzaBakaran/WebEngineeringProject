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

import java.util.Date;

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

    }

}