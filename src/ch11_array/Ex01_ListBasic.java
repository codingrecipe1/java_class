package ch11_array;

import java.util.ArrayList;
import java.util.List;

public class Ex01_ListBasic {
    public static void main(String[] args) {
        // 정수를 담는 intList 선언
        List<Integer> intList = new ArrayList<>();
        // ArrayList<Integer> intList2 = new ArrayList<>();
        // List<Integer> intList3 = new List<>(); // x
        // 10 이라는 데이터 추가
        System.out.println(intList.add(10));
        System.out.println("intList.size() = " + intList.size());
        intList.add(10000);
        // 1번 인덱스에 999를 추가
        intList.add(1, 999);
        System.out.println("intList.size() = " + intList.size());
        // 0번 인덱스에 담긴 데이터 출력
        System.out.println("intList.get(0) = " + intList.get(0));
        System.out.println("intList.get(1) = " + intList.get(1));
        System.out.println("intList.get(2) = " + intList.get(2));
        // remove()
        intList.remove(1);
        System.out.println("intList.get(0) = " + intList.get(0));
        System.out.println("intList.get(1) = " + intList.get(1));
//        System.out.println("intList.get(2) = " + intList.get(2));

        // String을 담는 strList 선언
        List<String> strList = new ArrayList<>();
        strList.add("안녕");
        strList.add(1, "hello");
        System.out.println("strList.get(0) = " + strList.get(0));
        System.out.println("strList.get(1) = " + strList.get(1));
        String str1 = strList.get(1);
        System.out.println("str1 = " + str1);

        // for문을 이용하여 intList 에 담긴 데이터를 모두 출력
        for (int i = 0; i < intList.size(); i++) {
            System.out.println("intList = " + intList.get(i));
        }

        // for each
        for (Integer a: intList) {
            System.out.println("a = " + a);
        }

        intList.forEach(a -> {
            System.out.println("a = " + a);
        });

        // for문을 이용하여 strList 에 담긴 데이터를 모두 출력
        for (int i = 0; i < strList.size(); i++) {
            System.out.println("strList = " + strList.get(i));
        }

        // for each
        for (String bb: strList) {
            System.out.println("bb = " + bb);
        }

        strList.forEach(bb -> {
            System.out.println("bb = " + bb);
        });
    }
}
