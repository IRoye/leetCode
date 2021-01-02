package leetcode;

/**
 * @description: 867. 转置矩阵
 *
 * 输入：[[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 */
public class MetrixInverse {
    public int[][] transpose(int[][] A) {
        int b[][] = new int [A[0].length][A.length];

        int columnLength = A[0].length;
        for (int i = 0; i < columnLength; i++) {
            b[i] = getFirstColumn(A, i);
        }
        return b;
    };
    public static int [] getFirstColumn(int [][] array, int index) {
      // 1. 计算列数
      int length = array[0].length;
      int column[] = new int[array.length];
      for (int i = 0; i < array.length; i++) {
        column[i] = array[i][index];
        System.out.println(column[i]);
      }
      return column;
    };
    public static void main(String[] args) {
        int a[][] = {{1,2,3}, {4,5,6}};
        int b[][] = new int [a[0].length][a.length];

        int columnLength = a[0].length;
        for (int i = 0; i < columnLength; i++) {
            b[i] = getFirstColumn(a, i);
        }
    }
}
