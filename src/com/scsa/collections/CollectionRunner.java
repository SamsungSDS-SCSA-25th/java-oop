package com.scsa.collections;

import java.util.*;

public class CollectionRunner {

    public static void main(String[] args) {

        arrayListPractice();
        hashSetPractice();

        hashMapPractice();

    }

    /**
     * ArrayList 실습
     */
    private static void arrayListPractice() {
        System.out.println("=====arrayListPractice=====");

        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(1)); // Integer 만들어서 넣기 (new 객체 만드는 것 금지! - 최적화때문)
        arrayList.add(2); // 오토박싱
        arrayList.remove(1); // index 기준으로 삭제

        System.out.println(arrayList.size());
        System.out.println(arrayList); // toString()이 @Override 되어 있음

        System.out.println();
    }

    /**
     * HashSet 실습
     */
    private static void hashSetPractice() {
        System.out.println("=====hashSetPractice=====");

        Set<Integer> hashSet = new HashSet<>();

        hashSet.add(Integer.valueOf(1)); // Integer 만들어서 넣기 (new 객체 만드는 것 금지! - 최적화때문)
        hashSet.add(2); // 오토박싱
        hashSet.remove(1); // 값을 직접 찾아서 삭제함 => arrayList와 다름!!!

        System.out.println(hashSet.size());
        System.out.println(hashSet); // toString()이 @Override 되어 있음

        System.out.println();
    }

    /**
     * HashMap 실습
     */
    private static void hashMapPractice() {
        System.out.println("=====hashMapPractice=====");

        Map<Integer, String> hashMap = new HashMap<>();

        hashMap.put(1, "One"); // 오토박싱
        hashMap.put(1, "one"); // => key가 hashCode()와 equals()이 같으면 덮어쓰기
        hashMap.put(2, "two");
        hashMap.put(3, "three");
        System.out.println(hashMap.size());
        System.out.println(hashMap); // toString()이 @Override 되어 있음

        hashMap.remove(1); // index는 없고, key값 기준으로 삭제
        System.out.println(hashMap.containsKey(1)); // 해당 키를 포함하고 있나? => false
        System.out.println(hashMap.containsKey(2)); // => true
        System.out.println(hashMap.size());
        System.out.println(hashMap);

        System.out.println(hashMap.get(2)); // key -> value 뽑기

        System.out.println(hashMap.keySet()); // key값 들
        System.out.println(hashMap.values()); // value값 들

        System.out.println();
    }

}
