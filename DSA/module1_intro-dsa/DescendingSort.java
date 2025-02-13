import java.util.Arrays;

public class DescendingSort {
    public static void main(String[] args) {
        String [] st = {"a", "abc", "aaaa", "az", "aaa"};

        Arrays.sort(st, (a, b) -> {
            return a.length() - b.length();
        });

        for(int i=0; i<st.length; i++) {
            System.out.print(st[i] + " ");
        }
    }
}
