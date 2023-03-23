package Arrays;
//https://leetcode.com/problems/rotate-image/description/
public class RotateMatrix {
    public void transpose(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0;i<n;i++){
            for(int j=i;j<m;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] =temp;
            }
        }
    }
    
    public void reverse(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0;i<n;i++){
            // for(int j=0;j<m;j++){
            //     int temp = matrix[i][m-j-1];
            //     matrix[i][m-j-1] = matrix[j][i];
            //     matrix[j][i] =temp;
            // }
            int j = 0;
            int k = m-1;
            while(j<k){
                int temp = matrix[i][j];
                matrix[i][j] =  matrix[i][k];
                matrix[i][k] = temp;
                j++;
                k--;
            }
        }
    }

    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }
}
