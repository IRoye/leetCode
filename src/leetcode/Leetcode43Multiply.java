package leetcode;

/**
 * 43. 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class Leetcode43Multiply {

    public static String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) return "0";

        if (num1.length() == 1 && num2.length() == 1) {
            return String.valueOf((num1.charAt(0) - '0') * (num2.charAt(0) - '0'));
        }

        char[] num1Chars = num1.toCharArray();
        char[] num2Chars = num2.toCharArray();


        String sum = "0";

        for (int i = num2Chars.length - 1; i >= 0; i--) {
//           乘数
            int b = num2Chars[i] - '0';
//          保存当前的进位，供下一位使用
            int storeCarry = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = num1Chars.length - 1; j >= 0; j--) {
                int a = num1Chars[j] - '0';
                int current = a * b + storeCarry;
                storeCarry = current / 10;
                if (j == 0) {
                    sb.insert(0, current);
                } else {
                    sb.insert(0, current % 10);
                }
            }
            //               累加
//          这里需要进行补零
            for (int k = 0; k < num2Chars.length - (i + 1); k++) {
                sb.append('0');
            }
            sum = addToOne(sum, sb.toString());
//            System.out.println("sum:");
//            System.out.println(sum);

        }
        return String.valueOf(sum);
    }

    public static String addToOne(String num1, String num2) {


        int i = num1.length() - 1;

        int j = num2.length() - 1;

        int carry = 0;

        StringBuilder sb = new StringBuilder();
//       carry 这里很重要，漏掉了。当两个串的长度是一样的，但是末尾需要进位的时候，那儿还是需要再继续走一轮的。
        while (i >= 0 || j >= 0 || carry != 0) {
            int a = 0;
            int b = 0;
            int sum = 0;
            if (i >= 0) {
                a = num1.charAt(i) - '0';
            }

            if (j >= 0) {
                b = num2.charAt(j) - '0';
            }

            // 累加

            sum = a + b + carry;

            sb.insert(0, sum % 10);

            carry = sum / 10;

            i--;
            j--;
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        // 预期结果："121 932 631 112 635 269"

        // 1010 101 010 101 010 100 000 000

        // 10101118227457710010635269
//      "  121932631112635269"
        // 119326311112635269


        String result = multiply("123456789", "987654321");


//        String result = addToOne("987654312", "1111111010");

        System.out.println(result);
////
//        System.out.println(result);
//        String num1 = "6888";
//        String num2 = "49200";
//
//        System.out.println(num1);
//        System.out.println(num2);
//        System.out.println("---");
//
//        int i = num1.length() - 1;
//
//        int j = num2.length() - 1;
//
//        int carry = 0;
//
//        StringBuilder sb = new StringBuilder();
//
//        while (i >= 0 || j >= 0) {
//            int a = 0;
//            int b = 0;
//            int sum = 0;
//            if (i >= 0) {
//                a = num1.charAt(i) - '0';
//            }
//
//            if (j >= 0) {
//                b = num2.charAt(j) - '0';
//            }
//
//            // 累加
//
//            sum = a + b;
//
//            // 余数
//            int left = sum % 10 + carry;
//
//            //  进位
//            if (a + b >= 10) {
//                carry = sum / 10;
//            } else {
//                carry = 0;
//            }
//
//            sb = sb.append(left);
//
//            i--;
//            j--;
//        }
        long a = 123456789,
                b = 2469135780l,
                c = 37037036700L,
                d = 493827156000L,
                e = 6172839450000L,
                f = 74074073400000L,
                g = 864197523000000L,
                h = 9876543120000000L,
                i = 111111110100000000L;

        System.out.println(a + b + c + d + e + f + g + h + i);


    }
}
