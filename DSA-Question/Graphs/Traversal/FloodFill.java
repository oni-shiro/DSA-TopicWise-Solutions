import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}
public class FloodFill {
    int[] dr = new int[]{-1,0,+1,0};
    int[] dc= new int[]{0,-1,0,+1};

    private void dfs(int[][] image,int r,int c,int color, int startingClr,int[][] vis,int n,int m){
        vis[r][c] = 1;
        image[r][c] = color;
        for(int i =0;i<4;i++){
            int nr = r +dr[i];
            int nc = c + dc[i];
            if(nr>=0 && nr<n && nc<m && nc>=0 ){
                if(vis[nr][nc]==0 && image[nr][nc] == startingClr){
                    dfs(image,nr,nc,color,startingClr,vis,n,m);
                }
            }
        }
    }

    private void bfs(int[][] image, int sr, int sc, int color,int[][] vis){
        int n = image.length;
        int m = image[0].length;
        Queue<Pair> q = new LinkedList<>();
        vis[sr][sc] = 1;
        int srcColor = image[sr][sc];
        q.offer(new Pair(sr,sc));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.first;
            int c = p.second;
            image[r][c] = color;
            for(int i = 0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr<n && nr>=0 && nc<m && nc>=0 && 
                vis[nr][nc]==0 && image[nr][nc] == srcColor ){
                    vis[nr][nc] = 1;
                    q.offer(new Pair(nr,nc));
                }
            }
        }


    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        int[][] vis = new int[n][m];
        bfs(image,sr,sc,color,vis);
        return image;

    }
}
