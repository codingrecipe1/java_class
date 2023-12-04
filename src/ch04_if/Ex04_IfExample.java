package ch04_if;

import java.util.Scanner;

public class Ex04_IfExample {

	public static void main(String[] args) {
		/**
		 * 중첩 if문을 적용한 학점 출력 100점을 초과하거나 0점 미만의 점수를 입력하면 '입력범위를 초과하였습니다.' 출력 0~100 점 사이의
		 * 값을 입력했다면 앞의 예제에서 했던 학점 출력을 진행함. 단, 각 조건마다 학점값을 출력하는 것이 아니라 학점 출력을 위한 print
		 * 문장은 한번만 사용
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.print("점수: ");
		int score = scanner.nextInt();

//		if (0 < score < 100) // x

//		if (score > 100 || score < 0) {
//			System.out.println("입력범위를 초과하였습니다.");
//		} else {
//			// 학점 처리 
//		}

		String grade = "";
		if (score <= 100 && score >= 0) {
			// 학점 처리
			if (score >= 90) {
//				System.out.println("A");
				grade = "A";
			} else if (score >= 80) {
//				System.out.println("B");
				grade = "B";
			} else if (score >= 70) {
//				System.out.println("C");
				grade = "C";
			} else if (score >= 60) {
//				System.out.println("D");
				grade = "D";
			} else {
//				System.out.println("F");
				grade = "F";
			}
		} else {
			System.out.println("입력범위를 초과하였습니다.");
		}

		System.out.println("학점은 " + grade + "입니다.");

	}

}
