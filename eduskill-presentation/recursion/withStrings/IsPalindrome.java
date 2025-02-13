public class IsPalindrome {
    static boolean isPalindrome(String str) {

        //when to stop calling
        if(str.length() == 0 || str.length() == 1) {
            return true;
        }

        // shrink the problem space
        if(str.charAt(0) == str.charAt(str.length() - 1)) {
            return isPalindrome(str.substring(1, str.length() - 1));
        }

        return false;
    }

    public static void main(String[] args) {
        String str = "racecar";
        System.out.println(isPalindrome(str));
    }
}
