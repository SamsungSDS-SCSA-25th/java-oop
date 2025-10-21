package com.scsa.pattern.dao;

import com.scsa.pattern.exception.DuplicateIdException;
import com.scsa.pattern.vo.Product;

import java.util.*;

/**
 * Data Access Object
 */
public class ProductDAOHashMap implements ProductDAO {

    private static final Map<Integer, Product> products = new HashMap<>();
    private static int totalCnt = 0;

    @Override
    public void insert(Product targetProduct) {

        // validation
        for (Product tempProduct : products.values()) {
            if (tempProduct.equals(targetProduct)) {
                throw new DuplicateIdException("상품번호: " + targetProduct.getProductId() +
                        "상품명: " + targetProduct.getProductName() + " -> 중복된 상품번호가 들어갔습니다.");
            }
        }

        // store에 저장
        products.put(totalCnt, targetProduct);
        totalCnt++;

    }

    @Override
    public void findAll() {

        // 1. 상품 찾아서 List에 넣기
        List<Product> result = new ArrayList<>();
        boolean flag = false;
        for (int i = 0; i < totalCnt; i++) {
            result.add(products.get(i));
            flag = true;
        }

        // 2. validation
        if (!flag) {
            throw new NoSuchElementException("DB에 상품이 없습니다.");
//            System.out.println("DB에 상품이 없습니다.");
//            System.out.println("==================================");
//            return;
        }

        // 3. 출력
        for (Product product : result) {
            System.out.println(product);
        }
        System.out.println("==================================");

    }

    @Override
    public void findById(String productId) {

        if (productId == null || productId.isBlank()) {
            throw new IllegalArgumentException("상품번호가 올바르지 않습니다.");
//            System.out.println("상품번호가 올바르지 않습니다.");
//            System.out.println("==================================");
//            return;
        }

        for (int i = 0; i < totalCnt; i++) {
            Product p = products.get(i);
            if (p == null) continue; // null 안전
            if (productId.equals(p.getProductId())) {
                System.out.println(p);
                System.out.println("==================================");
                return; // 찾으면 즉시 종료
            }
        }

        System.out.println("DB에 해당 상품번호의 상품이 없습니다.");
        System.out.println("==================================");

    }

    @Override
    public void delete(String productId) {

        // validation + 삭제
        for (int key : products.keySet()) {
            Product tempProduct = products.get(key);
            if (tempProduct.getProductId().equals(productId)) {
                products.remove(key);
                System.out.println("상품이 삭제되었습니다.");
                System.out.println("==================================");
                return;
            }
        }

        System.out.println("상품번호가 존재하지 않습니다.");
        System.out.println("==================================");
    }

    @Override
    public void exit() {
        System.out.println("시스템을 종료합니다.");
    }

}
