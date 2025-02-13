public class Constructors {
    public static void main(String[] args) {
        Sample2 s =  new Sample2();
        Sample2 s2 =  new Sample2(2,3);
    }
}


class Sample2 {
    int a;
    int b;

    Sample2() {
        System.out.println("default constructor");
    }

    Sample2(int a2, int b2) {
        
        a = a2;
        b = b2;
        System.out.println("parameterised constructor");
    }
}