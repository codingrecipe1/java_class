package ch04_if;

import java.util.Scanner;

public class Ex07_IfExample {

	public static void main(String[] args) {
		/**
		 * 성적 출력 예제 응용 입력값: 학년(year), 점수(score) 처리 - 1~3학년은 60점 이상이면 합격 - 4학년은 70점 이상이어야
		 * 합격
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.print("학년 입력: ");
		int year = scanner.nextInt();
		System.out.print("점수 입력: ");
		int score = scanner.nextInt();

		if (year >= 1 && year <= 4 && score >= 0 && score <= 100) {
			if (score >= 60) {
				if (year != 4) {
					// 1~3학년 합격
					System.out.println("합격");
				} else if (score >= 70) {
					// 4학년 합격
					System.out.println("합격");
				} else {
					// 위의 두 조건을 만족하지 않기 때문에 불합격
					System.out.println("불합격");
				}
			} else {
				System.out.println("불합격");
			}
		} else {
			System.out.println("점수, 학년 값이 입력 범위를 벗어났습니다.");
		}

	}

}
