package ch15_interface.ex01;

// Interface1을 구현하는 클래스로 사용
public class Impl1 implements Interface1 {

    @Override
    public void method1() {
        System.out.println("Impl1.method1");
    }
}
