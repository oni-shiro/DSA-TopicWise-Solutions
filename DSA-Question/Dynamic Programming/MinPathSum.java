import java.util.Arrays;


//https://leetcode.com/problems/minimum-path-sum/description/
public class MinPathSum {

    /*
    memoization and Recursion
    recursion:
    t -> o(2^totalCells) = o(2^(n*m))
    s -> o(n*m) (stack space)

    memo:
    t -> o(n*m)
    s-> o(n*m) + o(n*m)(memo dp)
     */
    private int helper(int[][] grid, int r, int c, int n,int m,int[][] dp){
        if(r>=n || c>=m) return Integer.MAX_VALUE; // not to consider this path
        if(r== n-1 && c == m-1){
            return dp[r][c] = grid[r][c];
        }
        if(dp[r][c]!=-1) return dp[r][c];
        int down = helper(grid,r+1,c,n,m,dp);
        int right = helper(grid,r,c+1,n,m,dp);
        return dp[r][c] = grid[r][c] + Math.min(down,right);
    }
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return helper(grid, 0,0,n,m,dp);
    }

    /*
    Tabulation
    t -> o(n*m)
    s-> o(n*m) (only the tabulation dp)
     */
    public int minPathSumTab(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                int down = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;
                if(i==0 && j==0){
                    dp[i][j] = grid[i][j];
                }else{
                    if(i>0){
                        down = dp[i-1][j];
                    }
                    if(j>0){
                        right = dp[i][j-1];
                    }
                    dp[i][j] = grid[i][j] + Math.min(down,right);
                }

            }
        }
        return dp[n-1][m-1];
    }

    /*
    Space Optimization
    t -> o(n*m)
    s-> o(m) + o(m) ~ o(m)
     */

    public int minPathSumSpaceOpt(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] prev = new int[m];
        Arrays.fill(prev,Integer.MAX_VALUE); //-1 row , unreachable
        for(int i = 0;i<n;i++){
            int[] curr = new int[m];
            for(int j = 0;j<m;j++){
                if(i==0 && j==0){
                    curr[j]  = grid[i][j];
                }else{
                    int down = prev[j];
                    int right = (j>0)?curr[j-1]:Integer.MAX_VALUE;
                    curr[j] = grid[i][j] + Math.min(down,right)  ;
                }
            }
            prev = curr;
        }

        return prev[m-1];

    }
}
