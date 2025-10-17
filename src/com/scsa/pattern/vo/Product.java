package com.scsa.pattern.vo;

import java.util.Objects;

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

    /**
     * 현재변수와 매개변수의 상품번호가 같으면 true를 반환
     * 매개변수 null / Product 아님 / 상품번호 다르면 false를 반환
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Product product)) return false;
        return Objects.equals(productId, product.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(productId);
    }

}
