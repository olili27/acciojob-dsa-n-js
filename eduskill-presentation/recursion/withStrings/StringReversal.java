public class StringReversal {
    static String reverseString(String str) {

        // basecase
        if(str.length() == 0) {
            return "";
        }

        // smaller problem
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        String str = "hello";
        System.out.println(reverseString(str));
    }
}