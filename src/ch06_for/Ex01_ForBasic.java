package ch06_for;

public class Ex01_ForBasic {
    public static void main(String[] args) {
        // 0 ~ 3 출력
        for (int i = 0; i < 4; i++) {
            System.out.println("i = " + i);
        }
        // 0 ~ 4 출력
        for (int i = 0; i <= 4; i++) {
            System.out.println("i = " + i);
        }

        // 반복변수 초기값이 조건을 만족하지 않는다면
        for (int i = 10; i <= 4; i++) {
            System.out.println("보이나요?");
            System.out.println("i = " + i);
        }

        // 반복문 종료 후에도 반복변수를 사용하려면
        int j = 0;
        for (j = 0; j < 3; j++) {
            System.out.println("j = " + j);
        }
        System.out.println("반복문 종료 후 j = " + j);


    }
}
