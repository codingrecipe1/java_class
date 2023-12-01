package ch04_if;

import java.util.Scanner;

public class Ex02_IfExample {

	public static void main(String[] args) {
		/**
		 * 성적 출력하기 
		 * 자바점수(javaScore)가 60점 이상이면 합격, 아니면 불합격이라고 출력하기 
		 * 자바점수는 미리 점수를 입력해놓고 실행함. 
		 */
		int javaScore = 100;
		Scanner scanner = new Scanner(System.in);
		System.out.print("점수를 입력하세요: ");
		javaScore = scanner.nextInt();
		if (javaScore >= 60) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}

	}

}
