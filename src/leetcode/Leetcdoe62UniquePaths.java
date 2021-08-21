package leetcode;

/**
 * 62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 */
public class Leetcdoe62UniquePaths {
    public static int uniquePaths(int m, int n) {

        if (m == 1 || n == 1) {
            return 1;
        }

//       防止越界，挑选小的

        int line = m >= n ? n : m;

        int count = (m - 1) + (n - 1);

//       阶乘公式，C((n - 1), count)
        long result = 1;

        for (int i = 1, j = count; i <= (line - 1); i++, j--) {
            result = result * j / i;
        }

        return (int) result;

    }

    ;

    public static long Factorial(int n) {
        long sum = 1;
        while (n >= 1) {
            sum = sum * n--;
        }
        return sum;
    }

    public static void main(String[] args) {

//        System.out.println(uniquePaths(23, 12));
//        System.out.println(Factorial(17));
//        System.out.println(Factorial(9));
//        System.out.println(Factorial(9));

        long result = 1;

//        int m = 23, n = 12;
//
//        int count = (m - 1) + (n - 1);
//
//        for (int i = n - 1; i >= 1; i--) {
//
//            result = result * (count / i);
//
//            System.out.println(count);
//            System.out.println(i);
//            System.out.println("------------");
//
//            count--;
//        }
//        System.out.println("-------");
//        System.out.println(result);

//        int m = 23, n = 12;
//
//        int count = 33;
//
//        for (int i = 1, j = count; i <= (n - 1); i ++, j --) {
//           result = result * j / i;
//        }
//        System.out.println(result);

        System.out.println(uniquePaths(2, 100));


    }
}
