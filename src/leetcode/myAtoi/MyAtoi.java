package leetcode.myAtoi;

/**
 * 最大值：  2147483647
 * 最小值： -2147483648
 */
public class MyAtoi {
    public static int myAtoi(String str) {
        // 清除空格
        str = str.trim();
        char temp[] = str.toCharArray();
        long result = 0;
        int sign = 0;
        for (int i = 0; i < temp.length; i++) {
            char current = temp[i];
            int actual = 0;
            // 首字母不是数组，正负号
            if (i == 0 && !Character.isDigit(current)) {
                if (current == '+') {
                    sign = 1;
                    continue;
                }
                if (current == '-') {
                    sign = -1;
                    continue;
                }
                return 0;
            }
            if (!Character.isDigit(current) && i >= 1 && Character.isDigit(temp[i - 1])) {
                if (sign == 0) sign = 1;
                return (int) result *sign;
            }
            if (current == '+') {
                if (!Character.isDigit(temp[i - 1]) && temp[i - 1] != ' ') return 0;
                sign = 1;
                continue;
            }
            if (current == '-') {
                if (!Character.isDigit(temp[i - 1]) && temp[i - 1] != ' ') return 0;
                sign = -1;
                continue;
            }
            if (current == ' ') {
                if (!Character.isDigit(temp[i - 1])) return 0;
            }
            if (Character.isDigit(current)) {
                actual = current - '0';
                result = result * 10 + actual;
                if ((sign == 1 || sign == 0) && result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                // 这样判断的原因是：用Int表示的值，小于
                if (sign == -1 && -1 * result < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }
        }
        if (sign == 0) sign = 1;
        return (int) result * sign;
    }

    public static void main(String[] args) {
//        int result = myAtoi("+-2");
//        System.out.println(result);
//
        int result2 = myAtoi("   -42");
//        System.out.println(result2);
//////
//        int result3 = myAtoi("4193 with words");
//        System.out.println(result3);
//
//        int result4 = myAtoi("words and 987");
//        System.out.println(result4);
//
//        int result5 = myAtoi( "-91283472332");
//        System.out.println(result5);

        int result6 = myAtoi( "  -0012a42");
        System.out.println(result6);

//        int result7 = myAtoi("2147483648");
////        System.out.println(result7);

        int result8 = myAtoi("0-1");
        System.out.println(result8);


    }
}
