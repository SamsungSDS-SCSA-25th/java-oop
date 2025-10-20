package com.scsa.pattern;

import com.scsa.pattern.dao.ProductDAOHashMap;
import com.scsa.pattern.vo.Product;

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

            System.out.println("작업을 선택하세요: 1-상품추가, 2-상품전체조회, 3-상품번호로 조회, 4-상품삭제, 9-종료");
            System.out.print("작업구분: ");
            int num = scanner.nextInt();

            try {
                // 1-상품추가 / 상품번호가 겹치면 안된다
                if (num == 1) {
                    add(store);
                } else if (num == 2) { // 2-상품전체조회
                    findAll(store);
                } else if (num == 3) { // 3-상품번호로 조회
                    findById(store);
                } else if (num == 4) { // 4-상품삭제 / 삭제하려는 상품이 없습니다.
                    delete(store);
                } else if (num == 9) { // 9-종료
                    exit(store);
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

    private static void add(ProductDAOHashMap store) {

        Scanner scanner = new Scanner(System.in);

        // 입력값 받기
        System.out.println(">>상품추가작업<<");
        System.out.print("상품번호: ");
        String productId = scanner.nextLine();
        System.out.print("상품명: ");
        String productName = scanner.nextLine();
        System.out.print("가격: ");
        Integer productPrice = Integer.parseInt(scanner.nextLine());

        // Product 객체 만들기
        Product targetProduct = new Product(productId, productName, productPrice);

        store.insert(targetProduct);

        System.out.println("상품이 추가되었습니다.");
        System.out.println("==================================");

    }

    private static void findAll(ProductDAOHashMap store) {

        System.out.println(">>상품전체조회작업<<");

        store.findAll();
    }

    private static void findById(ProductDAOHashMap store) {

        System.out.println(">>상품번호로 조회작업<<");

        Scanner scanner = new Scanner(System.in);

        System.out.print("상품번호 입력: ");
        String next = scanner.nextLine();

        store.findById(next);
    }

    private static void delete(ProductDAOHashMap store) {

        Scanner scanner = new Scanner(System.in);

        // 입력값 받기
        System.out.println(">>상품삭제작업<<");
        System.out.print("상품번호: ");
        String productId = scanner.nextLine();

        store.delete(productId);
    }

    private static void exit(ProductDAOHashMap store) {
        store.exit();
    }

}
