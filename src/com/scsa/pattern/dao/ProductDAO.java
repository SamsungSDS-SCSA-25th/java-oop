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

    public void insert(Product product) {
        products.put(totalCnt, product);
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
