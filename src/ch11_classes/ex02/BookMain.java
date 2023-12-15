package ch11_classes.ex02;

import java.util.Scanner;

public class BookMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean run = true;
        int selectNo = 0;
        // bookService 클래스 객체 선언
        BookService bookService = new BookService();

        while (run) {
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("1.도서등록 | 2.도서목록 | 3.도서조회(id) | 4.도서조회(제목) | 5.가격수정 | 6.도서삭제 | 7.도서검색 | 0.종료");
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.print("선택> ");
            selectNo = scan.nextInt();
            if (selectNo == 1) {
                // 호출하는 문장 작성
                bookService.save();
            } else if (selectNo == 2) {
                // 호출하는 문장 작성
                bookService.findAll();
            } else if (selectNo == 3) {
                // 호출하는 문장 작성
                bookService.findById();
            } else if (selectNo == 4) {
                // 호출하는 문장 작성
                bookService.findByTitle();
            } else if (selectNo == 5) {
                // 호출하는 문장 작성
                bookService.update();
            } else if (selectNo == 6) {
                // 호출하는 문장 작성
                bookService.delete();
            } else if (selectNo == 7) {
                // 호출하는 문장 작성
                bookService.search();
            } else if (selectNo == 0) {
                run = false;
            }
        }
    }
}
