package ch10_class.ex07;

import java.util.Scanner;

public class Calculator {
    Scanner scanner = new Scanner(System.in);
    /**
     * 덧셈 메서드
     * method name: sum
     * parameter: int 타입 2개
     * return: x
     * 실행내용
     *  - 매개변수로 전달 받은 2개 값의 합을 출력
     */
    /**
     *
     * @param num1
     * @param num2
     */
    public void sum(int num1, int num2) {
        System.out.println("합계: " + (num1 + num2));
    }

    /**
     * 뺄셈 메서드
     * method name: sub
     * parameter: int 타입 2개
     * return: x
     * 실행내용
     *  - 매개변수로 전달 받은 2개 값의 차를 출력
     */
    public void sub(int num1, int num2) {
        int result = num1 - num2;
        System.out.println("result = " + result);
    }

    /**
     * 곱셈 메서드
     * method name: mul
     * parameter: int 타입 2개
     * return: int 타입
     * 실행내용
     *  - 매개변수로 전달 받은 2개 값의 곱 결과를 리턴
     */
    /**
     *
     * @param num1
     * @param num2
     * @return
     */
    public int mul(int num1, int num2) {
        int result = num1 * num2;
        return result;
    }

    /**
     * 나눗셈 메서드
     * method name: div
     * parameter: 없음
     * return: int 타입
     * 실행내용
     *  - 스캐너로 나눗셈에 필요한 정수 2개를 입력받음
     *  - 나눗셈 결과를 리턴
     */
    public int div() {
        System.out.print("첫번째 숫자: ");
        int num1 = scanner.nextInt();
        System.out.print("두번째 숫자: ");
        int num2 = scanner.nextInt();
        int result = num1 / num2;
        return result;
    }
}
