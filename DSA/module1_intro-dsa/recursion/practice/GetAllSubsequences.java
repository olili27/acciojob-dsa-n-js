import java.util.ArrayList;

public class GetAllSubsequences{
    public static void main(String[] args) {
        String str = "abc";
        ArrayList <String> answer = getSubsequences(str);

        for(int i = 0; i < answer.size(); i++) {
            String subsequence = answer.get(i);
            System.out.print(subsequence + " ");
        }
    }

    static ArrayList <String> getSubsequences(String str) {

        if(str.length() == 0) {
            ArrayList <String> base_answer = new ArrayList<>();
            base_answer.add("");
            return base_answer;
        }

        // get the first character of the string "str"
        char first_char = str.charAt(0);

        // get the rest of the characters of the string without the first character
        String smaller_string = str.substring(1);

        // faith
        ArrayList <String> smaller_answer = getSubsequences(smaller_string);

        ArrayList <String> answer = new ArrayList<>();

        // copy elements from the smaller_answer arrayList to the answer arrayList
        for(int i = 0; i < smaller_answer.size(); i++) {
            String sub_string = smaller_answer.get(i);
            answer.add(sub_string);
        }

        // add the first_char to every element of the smaller_answer arrayList, and add the resultant string to the answer arrayList
        for(int i = 0; i < smaller_answer.size(); i++) {
            String sub_string_withFirstChar = first_char + smaller_answer.get(i);
            answer.add(sub_string_withFirstChar);
        }

        return answer;
    }
}