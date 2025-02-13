public class Intro {
    static void func1() {
        func2();
        System.out.println("friends.");
    }

    static void func2() {
        func3();
        System.out.print("my ");
    }

    static void func3() {
        System.out.print("Hello ");
    }

    public static void main(String[] args) {
        func1();
    }
}
