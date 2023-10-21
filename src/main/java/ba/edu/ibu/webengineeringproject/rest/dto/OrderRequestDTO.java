package ba.edu.ibu.webengineeringproject.rest.dto;

import ba.edu.ibu.webengineeringproject.core.model.Order;
import ba.edu.ibu.webengineeringproject.core.model.OrderItem;

import java.util.Date;
import java.util.List;

public class OrderRequestDTO {
    private List<OrderItem> productIds;

    public OrderRequestDTO(){}
    public OrderRequestDTO(Order order){
        this.productIds=order.getProductIds();

    }
    public Order toEntity(){
        Order order= new Order();

        order.setProductIds(productIds);

        return order;
    }


    public List<OrderItem> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<OrderItem> productIds) {
        this.productIds = productIds;
    }


}
