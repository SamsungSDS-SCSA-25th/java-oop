package com.scsa.pattern;

import com.scsa.pattern.dao.ProductDAO;
import com.scsa.pattern.vo.Product;

import java.util.List;

public class ProductUser {

    public static void main(String[] args) {

        ProductDAO dao = new ProductDAO();

        Product americano = new Product("C0001", "아메리카노", 1800);
        Product cafelatte = new Product("C0001", "카페라떼", 2900);

        Product lemonade = new Product("C0002", "레몬에이드", 3500);

        // 상품 저장
        dao.insert(americano);
        dao.insert(cafelatte);
        dao.insert(lemonade);

        // 상품 목록 조회
        List<Product> allProducts = dao.findAll();
        for (Product p : allProducts) {
            System.out.println(p); // 상품번호: xxxxx, 상품명: xxxxxx, 가격: xxxxx 출력

        }
    }
}
