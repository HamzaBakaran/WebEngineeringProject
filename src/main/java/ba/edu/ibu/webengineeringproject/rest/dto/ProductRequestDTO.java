package ba.edu.ibu.webengineeringproject.rest.dto;

import ba.edu.ibu.webengineeringproject.core.model.Product;
import ba.edu.ibu.webengineeringproject.core.model.User;
import ba.edu.ibu.webengineeringproject.core.model.enums.ProductType;

import java.util.Date;

public class ProductRequestDTO {
    private String name;
    private ProductType productType;
    private Double costPrice;
    private Double sellingPrice;
    private String url;
    private Integer quantity;

    public ProductRequestDTO(){}
    public ProductRequestDTO(Product product) {

        this.name=product.getName();
        this.productType=product.getProductType();
        this.costPrice=product.getCostPrice();
        this.sellingPrice= product.getSellingPrice();
        this.url= product.getUrl();
        this.quantity= product.getQuantity();

    }
    public Product toEntity(){
        Product product =new Product();

        product.setName(name);
        product.setProductType(productType);
        product.setCostPrice(costPrice);
        product.setSellingPrice(sellingPrice);
        product.setUrl(url);
        product.setQuantity(quantity);

        return product;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

