package Arrays;

import java.util.Arrays;

public class SetMatrixZero {
    //tc - o(n*m)
    //sc  - o(m) -> using two col size arrs
    //initial approach
    public void setZeroes(int[][] matrix) {
        int n = matrix.length; // row
        int m = matrix[0].length; // col
        int[] rowsArr = new int[n];
        int[] colsArr = new int[m];
        Arrays.fill(rowsArr, -1);
        Arrays.fill(colsArr, -1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    rowsArr[i] = 0;
                    colsArr[j] = 0;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rowsArr[i] == 0 || colsArr[j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    //optimized approach
    
    
}
