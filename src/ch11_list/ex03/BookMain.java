package ch11_list.ex03;

import java.util.ArrayList;
import java.util.List;

public class BookMain {
    public static void main(String[] args) {
        // Book 객체를 담기위한 bookList 객체 선언
        List<Book> bookList = new ArrayList<>();

        // 기본생성자로 Book 객체(book1) 생성 후 bookList에 추가
        Book book1 = new Book();
//        book1.setId(1L);
        book1.setBookTitle("내가 한 말을 내가 오해하지 않기로 함");
        book1.setBookAuthor("문상훈");
        book1.setBookPrice(19800);
        book1.setBookPublisher("위너스북");
        bookList.add(book1);

        // 매개변수 생성자로 Book 객체(book2) 생성 후 bookList에 추가
        Book book2 = new Book("마흔에읽는 쇼펜하우어", "강용수", 17000, "유노북스");
        bookList.add(book2);

        Book book3 = new Book("트렌드 코리아 2024", "김난도", 19000, "미래의창");
        bookList.add(book3);

        // for를 이용하여 bookList의 전체 데이터 출력
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println("bookList = " + bookList.get(i));
        }

        // for each를 이용하여 bookList의 전체 데이터 출력
        for (Book book: bookList) {
            System.out.println("book = " + book);
        }

        // list의 0번 인덱스에 담긴 책의 가격을 50000으로 변경
        bookList.get(0).setBookPrice(50000);

        // list의 1번 인덱스에 담긴 출판사의 제목을 "안녕출판사"로 변경
        bookList.get(1).setBookPublisher("안녕출판사");

        // for를 이용하여 bookList의 전체 데이터 출력
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println("bookList = " + bookList.get(i));
        }

        // for each를 이용하여 bookList의 전체 데이터 출력
        for (Book book: bookList) {
            System.out.println("book = " + book);
        }
    }
}
