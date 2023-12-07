package ch08_string;

public class Ex01_String {
    public static void main(String[] args) {
        String str1 = "안녕";
        String str2 = "안녕";
        String str3 = new String("안녕");
        // str1, str2 같은지
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str1.equals(str3));

    }
}
