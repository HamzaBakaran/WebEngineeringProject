package ba.edu.ibu.webengineeringproject.core.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document
public class Order {
    @Id
    private String id;
    private List<OrderItem> productIds;
    private Date orderDate = new Date();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<OrderItem> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<OrderItem> productIds) {
        this.productIds = productIds;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
