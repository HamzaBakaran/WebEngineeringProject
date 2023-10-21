package ba.edu.ibu.webengineeringproject.core.model;


import ba.edu.ibu.webengineeringproject.core.model.enums.ProductType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Product {
    @Id
    private String id;
    private String name;
    private ProductType productType;
    private Double costPrice;
    private Double sellingPrice;
    private String url;
    private Date addedDate = new Date();
    private Integer quantity;


    public Product(String id, String name, ProductType productType, Double costPrice, Double sellingPrice, String url, Date addedDate, Integer quantity) {
        this.id = id;
        this.name = name;
        this.productType = productType;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.url = url;
        this.addedDate = addedDate;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

