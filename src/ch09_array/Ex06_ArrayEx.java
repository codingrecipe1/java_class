package ch09_array;

import java.util.Scanner;

public class Ex06_ArrayEx {
    public static void main(String[] args) {
        /**
         * 크기가 5인 정수형 배열을 선언하고
         * 스캐너로 배열에 값을 저장한 뒤
         * 입력된 값 중에서 가장 큰 값을 출력
         */
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];
        // 최댓값을 담기 위한 변수
        int max = 0;
        // 배열에 값 저장
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("숫자 입력: ");
            numbers[i] = scanner.nextInt();
            if (max < numbers[i]) {
                max = numbers[i];
            }
        }

        // 최댓값 찾기
//        for (int i = 0; i < numbers.length; i++) {
//            if (max < numbers[i]) {
//                max = numbers[i];
//            }
//        }
        System.out.println("max = " + max);
    }
}
