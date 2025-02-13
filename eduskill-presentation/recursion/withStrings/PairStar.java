public class PairStar {
    static String pairStar(String str) {

        if (str.length() == 0) {
            return "";
        }

        if (str.length() == 1) {
            return str;
        }

        char first = str.charAt(0);
        if (first == str.charAt(1)) {
            return first + "*" + pairStar(str.substring(1));
        }

        return first + pairStar(str.substring(1));
    }

    public static void main(String[] args) {
        String str = "hello";
        // String str = "xxyy";
        System.out.println(pairStar(str));
    }
}
