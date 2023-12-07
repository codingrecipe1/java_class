package ch09_array;

import java.util.Scanner;

public class Ex03_ArrayEx {
    public static void main(String[] args) {
        /**
         * 크기가 3인 정수형 배열을 선언하고
         * 실행 했을 때 스캐너로 정수값을 입력받아 배열에 저장
         * 배열에 저장된 값의 총합, 평균 계산
         */
        Scanner scanner = new Scanner(System.in);
        int[] numbers1 = new int[3];
        System.out.print("첫번째 값을 입력하세요");
        // 0번 인덱스
        numbers1[0] = scanner.nextInt();
        System.out.print("두번째 값을 입력하세요");
        // 1번 인덱스
        numbers1[1] = scanner.nextInt();
        System.out.print("세번째 값을 입력하세요");
        // 2번 인덱스
        numbers1[2] = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < numbers1.length; i++) {
            System.out.print(i + "번 인덱스 값을 입력하세요: ");
            numbers1[i] = scanner.nextInt();
            sum += numbers1[i];
        }
        System.out.println("sum = " + sum);
        System.out.println("평균 = " + sum / numbers1.length);
    }
}
