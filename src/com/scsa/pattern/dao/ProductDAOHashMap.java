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
    public void insert() {

        Scanner scanner = new Scanner(System.in);

        // 1. 입력값 받기
        System.out.println(">>상품추가작업<<");
        System.out.print("상품번호: ");
        String productId = scanner.next();
        System.out.print("상품명: ");
        String productName = scanner.next();
        System.out.print("가격: ");
        Integer productPrice = scanner.nextInt();

        // 2. Product 객체 만들기
        Product targetProduct = new Product(productId, productName, productPrice);

        // 3. validation
        for (Product tempProduct : products.values()) {
            if (tempProduct.equals(targetProduct)) {
                throw new DuplicateIdException("상품번호: " + targetProduct.getProductId() +
                        "상품명: " + targetProduct.getProductName() + " -> 중복된 상품번호가 들어갔습니다.");
            }
        }

        // 4. store에 저장
        products.put(totalCnt, targetProduct);
        totalCnt++;

        System.out.println("상품이 추가되었습니다.");
        System.out.println("==================================");

    }

    @Override
    public void findAll() {

        System.out.println(">>상품전체조회작업<<");

        // 1. 상품 찾아서 List에 넣기
        List<Product> result = new ArrayList<>();
        boolean flag = false;
        for (int i = 0; i < totalCnt; i++) {
            result.add(products.get(i));
            flag = true;
        }

        // 2. validation
        if (!flag) {
            System.out.println("DB에 상품이 없습니다.");
            System.out.println("==================================");
            return;
        }

        // 3. 출력
        for (Product product : result) {
            System.out.println(product);
        }
        System.out.println("==================================");

    }

    @Override
    public void findById(String productId) {

        System.out.println(">>상품번호로 조회작업<<");

        // 1. 상품 찾아서 List에 넣기
        boolean flag = false;
        for (int i = 0; i < totalCnt; i++) {
            if (productId.equals(products.get(i).getProductId())) {

                // 3. 출력
                System.out.println(products.get(i));
                System.out.println("==================================");

                flag = true;
                break;
            }
        }

        // 2. validation
        if (!flag) {
             System.out.println("DB에 상품이 없습니다.");
             System.out.println("==================================");
             return;
        }

    }

    @Override
    public void delete() {

        Scanner scanner = new Scanner(System.in);

        // 1. 입력값 받기
        System.out.println(">>상품삭제작업<<");
        System.out.print("상품번호: ");
        String productId = scanner.next();

        // 2. validation + 삭제
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
