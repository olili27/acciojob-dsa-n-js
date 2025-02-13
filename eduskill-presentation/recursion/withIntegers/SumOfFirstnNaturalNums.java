public class SumOfFirstnNaturalNums {
    static int nSum(int n) {
        if(n == 0) {
            return 0;
        }
        int sAns = nSum(n - 1);
        int ans = n + sAns;

        return ans;
    }

    public static void main(String[] args) {
        int sum = nSum(10);
        System.out.println(sum);
    }
}
