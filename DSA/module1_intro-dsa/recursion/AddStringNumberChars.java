public class AddStringNumberChars {
    public static void main(String[] args) {
        String str = "39";
        System.out.println(addChars(str));
    }

    static int addChars(String str) {
        int num = Integer.parseInt(str);
        // int digit  = num % 10;
        if(str.length() == 1 ){
            return num;
        }
        int digit  = num % 10;
        num = num / 10;
        str = String.valueOf(num);
        return digit + addChars(str);
    }
}
