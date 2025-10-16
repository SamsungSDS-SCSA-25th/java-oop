package com.scsa.pattern.vo;

/**
 * ValueObject
 */
public class Product {

    private String productId;
    private String productName;
    private Integer price;

    public Product() {}

    public Product(String productId, String productName, Integer price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "상품번호:'" + productId + '\'' +
                ", 상품명:'" + productName + '\'' +
                ", 가격:" + price;
    }

}
