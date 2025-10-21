package com.scsa.pattern.dao;

import com.scsa.pattern.exception.DuplicateIdException;
import com.scsa.pattern.vo.Product;

import java.io.*;
import java.util.*;

/**
 * 파일 기반 Data Access Object
 * 파일 저장소: C:\scsa202510\products.txt
 */
public class ProductDAOFile implements ProductDAO {

    private static final String FILE_PATH = "C:\\scsa202510\\products.txt";
    private static final String DELIMITER = ":";

    /**
     * 파일에서 모든 상품을 읽어서 Map으로 반환
     */
    private Map<String, Product> loadProductsFromFile() {
        Map<String, Product> products = new HashMap<>();
        File file = new File(FILE_PATH);

        // 파일이 없으면 빈 Map 반환
        if (!file.exists()) {
            return products;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(DELIMITER);
                if (parts.length == 3) {
                    String productId = parts[0].trim();
                    String productName = parts[1].trim();
                    Integer price = Integer.parseInt(parts[2].trim());
                    products.put(productId, new Product(productId, productName, price));
                }
            }
        } catch (IOException e) {
            System.err.println("파일 읽기 오류: " + e.getMessage());
        }

        return products;
    }

    /**
     * Map에 있는 모든 상품을 파일에 저장
     */
    private void saveProductsToFile(Map<String, Product> products) {
        File file = new File(FILE_PATH);

        // 디렉토리가 없으면 생성
        File directory = file.getParentFile();
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (Product product : products.values()) {
                String line = product.getProductId() + DELIMITER +
                        product.getProductName() + DELIMITER +
                        product.getPrice();
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("파일 쓰기 오류: " + e.getMessage());
        }
    }

    @Override
    public void insert(Product targetProduct) {
        Map<String, Product> products = loadProductsFromFile();

        // 중복 체크
        if (products.containsKey(targetProduct.getProductId())) {
            throw new DuplicateIdException("상품번호: " + targetProduct.getProductId() +
                    " 상품명: " + targetProduct.getProductName() + " -> 중복된 상품번호가 들어갔습니다.");
        }

        // 상품 추가
        products.put(targetProduct.getProductId(), targetProduct);

        // 파일에 저장
        saveProductsToFile(products);
    }

    @Override
    public void findAll() {
        Map<String, Product> products = loadProductsFromFile();

        // 상품이 없는 경우
        if (products.isEmpty()) {
            throw new NoSuchElementException("DB에 상품이 없습니다.");
        }

        // 모든 상품 출력
        for (Product product : products.values()) {
            System.out.println(product);
        }
        System.out.println("==================================");
    }

    @Override
    public void findById(String productId) {
        // 입력값 검증
        if (productId == null || productId.isBlank()) {
            throw new IllegalArgumentException("상품번호가 올바르지 않습니다.");
        }

        Map<String, Product> products = loadProductsFromFile();

        // 상품 검색
        Product product = products.get(productId);
        if (product != null) {
            System.out.println(product);
            System.out.println("==================================");
        } else {
            System.out.println("DB에 해당 상품번호의 상품이 없습니다.");
            System.out.println("==================================");
        }
    }

    @Override
    public void delete(String productId) {
        Map<String, Product> products = loadProductsFromFile();

        // 상품 삭제
        Product removedProduct = products.remove(productId);

        if (removedProduct != null) {
            // 파일에 저장
            saveProductsToFile(products);
            System.out.println("상품이 삭제되었습니다.");
            System.out.println("==================================");
        } else {
            System.out.println("상품번호가 존재하지 않습니다.");
            System.out.println("==================================");
        }
    }

    @Override
    public void exit() {
        System.out.println("시스템을 종료합니다.");
    }

}