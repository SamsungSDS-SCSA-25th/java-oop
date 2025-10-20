package com.scsa.pattern;

import com.scsa.pattern.dao.ProductDAOHashMap;

import java.util.Arrays;
import java.util.Scanner;

public class ProductUser {

    public static void main(String[] args) {

//        ProductDAO store = new ProductDAO();

//        Product americano = new Product("C0001", "아메리카노", 1800);
//        Product cafelatte = new Product("C0001", "카페라떼", 2900);
//        Product lemonade = new Product("C0002", "레몬에이드", 3500);

        // 상품 저장
//        dao.insert(americano);
//        dao.insert(cafelatte);
//        dao.insert(lemonade);

        // 상품 목록 조회
//        List<Product> allProducts = dao.findAll();
//        for (Product p : allProducts) {
//            System.out.println(p); // 상품번호: xxxxx, 상품명: xxxxxx, 가격: xxxxx 출력
//        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("프로그램 시작");
        System.out.println("===================================");

        ProductDAOHashMap store = new ProductDAOHashMap();

        while (true) {

            System.out.println("작업을 선택하세요: 1-상품추가, 2-상품전체조회, 3-상품삭제, 9-종료");
            System.out.print("작업구분: ");
            int num = scanner.nextInt();

            try {
                // 1-상품추가 / 상품번호가 겹치면 안된다
                if (num == 1) {
                    store.insert();
                } else if (num == 2) { // 2-상품전체조회
                    store.findAll();
                } else if (num == 3) { // 3-상품삭제 / 삭제하려는 상품이 없습니다.
                    store.delete();
                } else if (num == 9) { // 9-종료
                    store.exit();
                    break;
                } else {
                    System.out.println("올바른 값을 입력하십시오.");
                }
            } catch (RuntimeException e) { // catch로 잡아서 밖으로 컴파일에러가 발생하지 않는다.
                System.out.println(e.getMessage());
                System.out.println(Arrays.toString(e.getStackTrace()));
            }
        }

        System.out.println("===================================");
        System.out.println("프로그램 종료");

    }

}
