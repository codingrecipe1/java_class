package ch09_array;

import java.util.Scanner;

public class Ex09_ArrayEx {
    public static void main(String[] args) {
        // 스캐너 객체를 선언한다.
        Scanner scan = new Scanner(System.in);
        // boolean 타입의 run 변수를 선언해서 true를 대입한다.
        boolean run = true;
        // int 타입의 studentNum 변수를 선언해서 0을 대입한다.
        int studentNum = 0;
        int selectNo = 0;

        int[] scores = null; // scores라는 배열 이름만 선언

        while (run) {
            System.out.println("--------------------------------------------------------------");
            System.out.println("1.학생수입력 | 2.점수입력 | 3.점수목록 | 4.분석 | 5.종료");
            System.out.println("--------------------------------------------------------------");
            System.out.print("선택> ");
            selectNo = scan.nextInt();
            // 전역변수이긴 하지만 while문이 실행될 때마다 다시 선언되어 배열로 활용 불가
//            int[] scores = null;
            if (selectNo == 1) {
                // 학생수 입력 받고 해당 수 크기를 갖는 배열로 선언
                System.out.print("학생수>");
                studentNum = scan.nextInt();
                // 입력받은 학생수만큼의 크기를 갖는 배열 객체로 선언(new)
                scores = new int[studentNum];
                // 지역변수로 선언하면 else if 에서는 사용 불가
//                int[] scores = new int[studentNum];
            } else if (selectNo == 2) {
                // 배열에 점수 데이터 저장
                for (int i = 0; i < scores.length; i++) {
                    System.out.print((i + 1) + "번 학생 점수: ");
                    scores[i] = scan.nextInt();
                }
            } else if (selectNo == 3) {
                // 저장된 데이터 출력
                for (int i = 0; i < scores.length; i++) {
                    System.out.println((i + 1) + "번 학생 점수: " + scores[i]);
                }
            } else if (selectNo == 4) {
                // 최댓값, 평균값 계산 및 출력
                int sum = 0, max = 0;
                double avg = 0.0;
                for (int i = 0; i < scores.length; i++) {
                    if (max < scores[i]) {
                        max = scores[i];
                    }
                    sum += scores[i];
                }
                avg = sum / scores.length;
                avg = (double) sum / scores.length;
                System.out.println("최고점수: " + max);
                System.out.println("평균점수: " + avg);

                // 내림차순 정렬 및 출력
                int temp = 0;
                for (int i = 0; i < scores.length; i++) {
                    for (int j = i + 1; j < scores.length; j++) {
                        if (scores[i] < scores[j]) {
                            temp = scores[i];
                            scores[i] = scores[j];
                            scores[j] = temp;
                        }
                    }
                }
                for (int i = 0; i < scores.length; i++) {
                    System.out.println((i + 1) + "등: " + scores[i]);
                }
            } else if (selectNo == 5) {
                // 종료
                run = false;
            }
        }
    }
}

