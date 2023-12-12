package ch10_class.ex5;

public class BookMain {
    public static void main(String[] args) {
        // 책 정보는 시중에 있는 실제 책으로 해봅시다.

        // 기본생성자로 객체 만들고 필드값 채우기
        Book book1 = new Book();
        book1.bookTitle = "마흔에 읽는 쇼펜하우어";
        book1.bookAuthor = "강용수";
        book1.bookPublisher = "유노북스";
        book1.isbn = "123123213";
        book1.bookPrice = 17000;

        // 매개변수 2개 있는 생성자로 객체 만들고 필드값 채우기
        Book book2 = new Book("기자유감", "이기주");
        book2.bookPublisher = "메디치미디어";
        book2.isbn = "43545645654";
        book2.bookPrice = 17000;

        // 모든 매개변수 있는 생성자로 객체 만들고 필드값 채우기
        Book book3 = new Book("세이노의 가르침", "세이노", "데이원", "4098098302", 7200);
        book3.bookPrice = 6000;
    }
}
