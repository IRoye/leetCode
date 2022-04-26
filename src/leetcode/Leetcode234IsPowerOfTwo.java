package leetcode;

public class Leetcode234IsPowerOfTwo {

    public static boolean isPowerOfTwo(int n) {
//  1. 特殊判断
        if (n == 1) return true;
        if (n == 0) return false;
        double n1 = n;
        while (n1 > 1) {
            n1 = n1 / 2;
        }
        System.out.println(n1);
        return n1 == 1;
    }

    public static void main(String[] args) {
        boolean test = isPowerOfTwo(5);
        System.out.printf(String.valueOf(test));
    }
}
