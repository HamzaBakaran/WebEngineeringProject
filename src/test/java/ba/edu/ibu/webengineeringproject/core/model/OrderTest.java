package ba.edu.ibu.webengineeringproject.core.model;

import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
@Test
    void shoudCreateNewOrder(){
    Order order1=new Order();
    Order order2=new Order();

   //System.out.println(order1.getOrderDate());

    Assertions.assertNotNull(order1);
    Assertions.assertNotNull(order2);


    }

}