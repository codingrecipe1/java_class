package ch14_inheritance.ex01;

public class ChildClass extends ParentClass {
    public ChildClass() {
        System.out.println("자식 기본생성자");
    }

    // 메서드 재정의
    @Override
    public void hello() {
        System.out.println("ChildClass.hello");
    }


}
