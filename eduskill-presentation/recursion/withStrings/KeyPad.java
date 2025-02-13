import java.util.ArrayList;

public class KeyPad {

    // array representing the keypad
    static String[] arr = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    static ArrayList<String> printKPC(String numStr) {
        if (numStr.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        char first_char = numStr.charAt(0);
        String subStr = numStr.substring(1);

        // arraylist returned from the substring
        ArrayList<String> sAns = printKPC(subStr);

        ArrayList<String> ans = new ArrayList<>();

        // change the first_char to integer to create an index
        int idx = first_char - '0';

        // get a string of elements from the keypad using the above index
        String str = arr[idx];

        // for every char in the string from the keypad
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // join it with every element of returned arraylist from the substring
            for (int j = 0; j < sAns.size(); j++) {
                String sub = sAns.get(j);
                String newSub = ch + sub;
                ans.add(newSub);
            }

        }

        // return the arraylist with all combinations
        return ans;
    }

    public static void main(String[] args) {
        String str = "24";
        ArrayList<String> ans = printKPC(str);

        System.out.println(ans);
    }
}
