// concatenate a number k-times
class Concat{
    public static void main(String[] args) {
        int num = 9;
        int k = 25;
        System.out.println(concat(num, k));
    }

    static String concat(int num, int k) {
        String str = String.valueOf(num);
        if(k == 1) {
            return str;
        }
        return str + concat(num, k - 1);
    }
}