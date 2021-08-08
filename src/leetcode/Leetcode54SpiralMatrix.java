package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */
public class Leetcode54SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;

        List<Integer> matrixList = new LinkedList();

        traverse(0, rowLength, columnLength, matrixList, matrix);

        return matrixList;

    }

    ;

    /**
     * @param index  索引，标识当前的起点，默认是0，也就是[0][0],之后的每一轮都是[index + 1][index + 1]
     * @param row    行，标识当前还剩下几行
     * @param column 列，标识当前还剩下几列
     * @param matrix 用于盛放已经遍历完的节点值
     * @description: 递归调用，用于遍历每一层的顺时针节点
     */
    public static void traverse(int index, int row, int column, List<Integer> matrix, int matrixArray[][]) {

        //   临界条件
        int rowLength = matrixArray.length;
        int columnLength = matrixArray[0].length;
        //  标识当前[index][index] 已经越界了或者是[index][index] == -1，表示当前之前的已经访问过，也已经无需遍历，到终点了，返回
        if (index > rowLength - 1 || index > columnLength - 1 || matrixArray[index][index] == -102) return;

        // 遍历第index行的各个列
        for (int i = index; i < column + index; i++) {
            if (matrixArray[index][i] == -1) return;
            matrix.add(matrixArray[index][i]);
//           打个tag
            matrixArray[index][i] = -102;
        }

        // 开始遍历右侧的列
        for (int j = index + 1; j < row + index; j++) {
//           避免上述遍历完成，这里依旧符合条件
            if (matrixArray[j][index + column - 1] == -102) return;
            matrix.add(matrixArray[j][index + column - 1]);
            matrixArray[j][index + column - 1] = -102;
        }

        for (int i = column + index - 2; i >= index; i--) {
            if (matrixArray[index + row - 1][i] == -102) return;
            matrix.add(matrixArray[index + row - 1][i]);
            matrixArray[index + row - 1][i] = -102;
        }

        // 开始遍历左侧的列
        for (int j = row + index - 2; j >= index + 1; j--) {
            if (matrixArray[j][index] == -102) return;
            matrix.add(matrixArray[j][index]);
            matrixArray[j][index] = -102;
        }

        System.out.println(matrix);
        traverse(index + 1, row - 2, column - 2, matrix, matrixArray);


    }

    ;

    public static void main(String[] args) {


        List<Integer> matrixList = new LinkedList();
        int matrix[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int matrix2[][] = {
                {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}
        };

        int matrix3[][] = {
                {2, 5}, {8, 4}, {0, -1}
        };
        traverse(0, 3, 2, matrixList, matrix3);
    }
}
