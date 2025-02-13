package intro;
public class Start {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;

        int sum = sum(a, b);
        System.out.print("this is the sum: ");
        System.out.println(sum);
    }

    static int sum(int a, int b) {
        printSomething();

        int sum = a + b;
        return sum;
    }

    static void printSomething() {
        System.out.println("hi");

        int a = 5;
        System.out.println(a);

        a++;
        System.out.println(a);

        a--;
        System.out.println(a);

        a = 11;
        System.out.println(a);
    }
}