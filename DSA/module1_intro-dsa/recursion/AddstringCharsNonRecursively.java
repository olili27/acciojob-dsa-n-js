public class AddstringCharsNonRecursively {
    public static void main(String[] args) {
        String st = "148148148";
        System.out.println(sum(st));
    }

    static int sum(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            String ch = String.valueOf(str.charAt(i));
            int digit = Integer.parseInt(ch);
            sum += digit;
        }
        return sum;
    }
}
