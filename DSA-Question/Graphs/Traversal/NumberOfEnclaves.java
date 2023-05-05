
/*
edge notes which are 1 and conver them to zeroes

the connected components will be converted to zero and only the middlenones will
remain
*/

// Using BFS

import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int r;
    int c;
    public Pair(int r,int c){
        this.r  = r;
        this.c = c;
    }
}
public class NumberOfEnclaves {
    public int n = 0;
    public int m = 0;
    int[] dr = new int[]{-1,0,+1,0};
    int[] dc = new int[]{0,-1,0,+1};
    
    public int numEnclaves(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int totalCnt = 0;
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]==1 && (i == 0 || i==n-1 || j == 0|| j==m-1)){
                    q.offer(new Pair(i,j));
                    vis[i][j] = true;
                }
            }
        }
        while(!q.isEmpty()){
            Pair curr = q.peek();
            q.poll();
            int r = curr.r;
            int c =  curr.c;
            grid[r][c] = 0;
            for(int i = 0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr<n && nr>=0 && nc<m && nc>=0
                && grid[nr][nc] == 1 && !vis[nr][nc]){
                    q.offer(new Pair(nr,nc));
                    vis[nr][nc] = true;
                }
            }
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 1) totalCnt++;
            }
        }
        return totalCnt;
    }
}
