package com.scsa.singleton;

public class Singleton {

    /**
     * 싱글톤 패턴
     * 전역에서 객체를 새로 만들지 않고, 하나의 객체를 참조하도록 하는 디자인 패턴
     * 1. private static으로 인스턴스 만들기
     * 2. 생성자 private으로 막아두기
     * 3. 인스턴스는 밖에서 getInstance로만 가능하게 함
     */

    private static Singleton instance = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return instance;
    }

}
