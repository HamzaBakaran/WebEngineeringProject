package ba.edu.ibu.webengineeringproject.core.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;

public class Product {
    @Id
    private Long id; // Use a Long instead of Integer if the ID can be null

    @NotBlank
    private String name;

    @Positive
    @NotNull
    private Double price;

    @Positive
    @NotNull
    private Double sellingPrice;

    private String url;

    @Positive
    @NotNull
    private Integer quantity;

    public Product(Long id, String name, Double price, Double sellingPrice, String url, Integer quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sellingPrice = sellingPrice;
        this.url = url;
        this.quantity = quantity;
    }

    public Product(int id,String test, double v, int i, String url, int i1) {
    }

    // Getters and setters for all fields

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }
}

