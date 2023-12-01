package ch03_scanner;

// java.util 패키지에 소속된 Scanner 클래스를 가져옴. 
import java.util.Scanner;

public class Ex01_Scanner {

	public static void main(String[] args) {
		// scanner 라는 이름의 Scanner 클래스 객체 선언 
		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자를 입력하세요: ");
		int num1 = scanner.nextInt();		
		System.out.println(num1);

	}

}
