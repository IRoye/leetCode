package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leetcode59SpiralMatrixII {
    public int[][] generateMatrix(int n) {

        int matrix[][] = new int[n][n];
        traverse(0, n, n, 1, matrix);

        return matrix;

    }

    ;

    /**
     * @param index  索引，标识当前的起点，默认是0，也就是[0][0],之后的每一轮都是[index + 1][index + 1]
     * @param row    行，标识当前还剩下几行
     * @param column 列，标识当前还剩下几列
     * @param value  用于初始开始填充的值
     * @description: 递归调用，用于遍历每一层的顺时针节点
     */
    public static void traverse(int index, int row, int column, int value, int matrixArray[][]) {

        //   临界条件
        int rowLength = matrixArray.length;
        int columnLength = matrixArray[0].length;
        //  标识当前[index][index] 已经越界了或者是[index][index] == -1，表示当前之前的已经访问过，也已经无需遍历，到终点了，返回
        if (index > rowLength - 1 || index > columnLength - 1 || matrixArray[index][index] > 0) return;

        // 遍历第index行的各个列
        for (int i = index; i < column + index; i++) {
            if (matrixArray[index][i] > 0) return;
            matrixArray[index][i] = value;
            value++;
        }

        // 开始遍历右侧的列
        for (int j = index + 1; j < row + index; j++) {
//           避免上述遍历完成，这里依旧符合条件
            if (matrixArray[j][index + column - 1] > 0) return;
            matrixArray[j][index + column - 1] = value;
            value++;
        }

        for (int i = column + index - 2; i >= index; i--) {
            if (matrixArray[index + row - 1][i] > 0) return;
            matrixArray[index + row - 1][i] = value;
            value++;
        }

        // 开始遍历左侧的列
        for (int j = row + index - 2; j >= index + 1; j--) {
            if (matrixArray[j][index] > 0) return;
            matrixArray[j][index] = value;
            value++;
        }

        traverse(index + 1, row - 2, column - 2, value, matrixArray);


    }

    ;

    public static void main(String[] args) {
        int n = 1;

        int matrix[][] = new int[n][n];
        traverse(0, n, n, 1, matrix);

        for (int i = 0; i < n; i++)
            System.out.println(Arrays.toString(matrix[i]));

    }
}
