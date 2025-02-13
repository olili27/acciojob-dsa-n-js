public class NaturalNumbers {
    static int sumOfNatural(int n) {
        
        int sum = 0;

        for(int i = 1; i <= n; i++) {
            sum += 1;
        }

        return sum;
    }
    public static void main(String[] args) {
        System.out.println(sumOfNatural(5));
    }
}
