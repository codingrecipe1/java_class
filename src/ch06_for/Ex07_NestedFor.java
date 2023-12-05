package ch06_for;

public class Ex07_NestedFor {
    public static void main(String[] args) {
        /**
         * 중첩 for문
         */
        System.out.println("바깥 for문 시작");
        for (int i = 1; i <= 2; i++) {
            System.out.println("안쪽 for문 시작");
            for (int j = 1; j <= 3; j++) {
                System.out.print("j = " + j);
                System.out.println("   i = " + i);
            }
            System.out.println("안쪽 for문 종료");
        }
        System.out.println("바깥 for문 종료");
    }
}
