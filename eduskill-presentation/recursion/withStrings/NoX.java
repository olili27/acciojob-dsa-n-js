public class NoX {
    static String noX(String str) {

        if (str.length() == 0) {
            return "";
        }

        char c = str.charAt(0);

        if (c != 'x') {
            return c + noX(str.substring(1));
        }

        return noX(str.substring(1));

    }

    public static void main(String[] args) {
        String str = "xaaax";
        // String str = "xaxb";
        // String str = "xxx";

        System.out.println(noX(str));
    }
}
