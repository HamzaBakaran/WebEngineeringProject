package ba.edu.ibu.webengineeringproject.core.model;

public class OrderItem {
    private String product_id;
    private int quantity;
    private double unit_price;

    public OrderItem(String product_id, int quantity, double unit_price) {
        this.product_id = product_id;
        this.quantity = quantity;
        this.unit_price = unit_price;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }
}
