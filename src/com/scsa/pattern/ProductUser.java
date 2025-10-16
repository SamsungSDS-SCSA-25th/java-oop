package com.scsa.pattern;

import com.scsa.pattern.dao.ProductDAO;
import com.scsa.pattern.vo.Product;

import java.util.List;

public class ProductUser {

    public static void main(String[] args) {

        ProductDAO dao = new ProductDAO();

        Product product = new Product("C0001", "아메리카노", 1000);

        // 상품 저장
        dao.insert(product);

        // 상품 목록 조회
        List<Product> allProducts = dao.findAll();
        for (Product p : allProducts) {
            System.out.println(p);
        }



    }

}
