public class DecimalToBinary {
    static String decimalToBinary(int decimal, String binaryStr) {
        if(decimal == 0) {
            return binaryStr;
        }

        binaryStr = decimal % 2 + binaryStr;
        return decimalToBinary(decimal / 2, binaryStr);
    }

    public static void main(String[] args) {
        int decimal = 8;
        System.out.println(decimalToBinary(decimal, ""));
    }
}
