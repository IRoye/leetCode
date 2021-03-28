package leetcode;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * <p>
 * 进阶：
 * <p>
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * <p>
 * 最简单的办法，构建额外的空间，当前空间可以计算0所在的行列(i， j)，最后应用在额外的空间
 * <p>
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * <p>
 * 这个是?
 * <p>
 * 你能想出一个仅使用常量空间的解决方案吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-matrix-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MatrixWithZero {

    public static void setZeroes(int[][] matrix) {
//       1. 行数，列数
        int m = matrix.length;
        int n = matrix[0].length;

        boolean row0 = false;
        boolean col0 = false;

        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                row0 = true;
                break;
            }
        }

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                col0 = true;
                break;
            }
        }


//      2. 使用原地算法，那么使用当前的数组来保存。使用第0行和第0列
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }

//      3. 现在去根据第一行和第一列设置的数，去更新除了第一行和第一列之外的数。如果从0开始，那么记录的数据就没了。
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    System.out.printf("%d, %d", i, j);
                    System.out.println();
                    matrix[i][j] = 0;
                }
            }
        }

        // 4. 现在需要处理第一行和第一列剩下的数，如果之前有0的话，那么行/列都是需要设置为0的

        if (row0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }


        if (col0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }


    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println("-------------");

        setZeroes(matrix);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }


    }
}
