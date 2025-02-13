import java.util.ArrayList;

public class GetAllSubsequences {
    static ArrayList<String> getAllSubs(String str) {

        // if the str is an empty string
        if(str.length() == 0) {
            ArrayList <String> base_arrayList = new ArrayList<>();
            base_arrayList.add("");
            return base_arrayList;
        }

        // get first char of str
        char first_char = str.charAt(0);

        // get the rest of the sub-string from str -> without the first char
        String subStr = str.substring(1);

        // get the returned arraylist
        ArrayList <String> sAns = getAllSubs(subStr);

        // create a new arraylist
        ArrayList<String> ans = new ArrayList<>();

        // copy every element of the returned arraylist
        for(int i = 0; i < sAns.size(); i++) {
            String elem = sAns.get(i);
            ans.add(elem);
        }

        // add the first_char to every element copied the returned arraylist
        for(int i = 0; i < sAns.size(); i++) {
            String sub = sAns.get(i);
            String newSUb = first_char + sub;
            ans.add(newSUb);
        }

        return ans;
    }

    public static void main(String[] args) {
        String str = "abc";
        ArrayList <String> ans = getAllSubs(str);
        System.out.println(ans);
    }
}
