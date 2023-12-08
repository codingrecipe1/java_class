package ch09_array;

public class Ex07_ArrayEx {
    public static void main(String[] args) {
        int[] num = {3, 2, 1, 5, 4};
        int temp = 0; // swap을 위한 중간 저장용 변수

        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i]);
        }

        // 중첩 for를 이용하여 정렬하기
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                if (num[i] > num[j]) {
                    temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
        }

        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i]);
        }
    }
}
