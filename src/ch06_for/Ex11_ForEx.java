package ch06_for;

public class Ex11_ForEx {
    public static void main(String[] args) {
        /**
         * 별찍기
         * 출력
         * *
         * **
         * ***
         * ****
         * *****
         *
         * *****
         * ****
         * ***
         * **
         * *
         *
         */

        for (int i = 1; i <= 5; i++) { // 줄수, 별을 출력할 횟수
            for (int j = 1; j <= i; j++) { // 별을 줄수만큼 출력
                System.out.print("*");
            }
            System.out.println(); // 줄을 바꾸기 위한 용도
        }
    }
}













