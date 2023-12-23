package ba.edu.ibu.webengineeringproject.core.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemTest {
    @Test
    void shouldCreateNewOrderItem(){
        OrderItem oi1 = new OrderItem("someId",2);
        Assertions.assertEquals("someId",oi1.getProduct_id());


}
}