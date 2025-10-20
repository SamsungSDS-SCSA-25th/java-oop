package com.scsa.pattern.dao;

import com.scsa.pattern.vo.Product;

public interface ProductDAO {

    /**
     * 저장소에 상품을 저장한다.
     * 저장할 상품의 상품번호가 이미 저장소에 있다면, "이미 저장된 상품입니다" 메시지를 출력하고 저장하지 않는다.
     */
    void insert(Product product);

    /**
     * 저장소에 저장된 상품을 모두 출력한다.
     * 저장소에 상품이 없으면, "DB에 상품이 없습니다"를 출력한다.
     */
    void findAll();

    /**
     * 상품번호를 통해, 해당 상품을 출력한다.
     * 해당번호의 상품이 없으면, "DB에 상품이 없습니다"를 출력한다.
     * @param productId
     */
    void findById(String productId);

    /**
     * 상품 저장소에서 특정 상품을 삭제한다.
     * 사용자로부터 상품번호를 입력받아 일치하는 상품을 삭제한다.
     * - 입력받은 상품번호가 저장소에 존재하면 해당 상품을 삭제하고, 삭제 완료 메시지를 출력한다.
     * - 입력받은 상품번호가 저장소에 존재하지 않으면 "상품번호가 존재하지 않습니다." 메시지를 출력한다.
     */
    void delete(String productId);

    /**
     * 시스템을 종료한다.
     */
    void exit();

}
