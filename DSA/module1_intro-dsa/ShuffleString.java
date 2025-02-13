import java.util.Scanner;

public class ShuffleString {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String st = s.next();
        int [] arr = new int [n];

        for(int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        char [] ar2 = new char [n];

        for(int i = 0; i < n; i++) {
            ar2[arr[i]] = st.charAt(i);
        }

        String st2 = "";

        for(int i = 0; i < n; i++) {
            st2 += ar2[i];
        }
        System.out.println(st2);

    }
}
