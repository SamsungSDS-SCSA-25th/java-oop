package com.scsa.pattern.dao;

import com.scsa.pattern.vo.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Data Access Object
 */
public class ProductDAO {

    private static final Map<Integer, Product> products = new HashMap<>();
    private static int totalCnt = 0;

    /**
     * 저장소에 상품을 저장한다.
     * 저장할 상품의 상품번호가 이미 저장소에 있다면, "이미 저장된 상품입니다" 메시지를 출력하고 저장하지 않는다.
     * @param targetProduct
     */
    public void insert(Product targetProduct) {

        // validation
        for (Product tempProduct : products.values()) {
            if (tempProduct.equals(targetProduct)) {
                System.out.println("상품번호: " + targetProduct.getProductId() + "상품명: " + targetProduct.getProductName() + " -> 중복된 상품번호가 들어 갔습니다.");
                System.out.println("==================================");
                return;
            }
        }
        
        products.put(totalCnt, targetProduct);
        totalCnt++;

    }

    public List<Product> findAll() {

        List<Product> result = new ArrayList<>();
        for (int i = 0; i < totalCnt; i++) {
            result.add(products.get(i));
        }

        return result;
    }

}
