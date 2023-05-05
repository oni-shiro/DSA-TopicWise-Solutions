import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfProvinces {



    //space = visited arr(n) + recursion stack(n)
    //time - creating adjList(n*m) + calling functon (n) + bfs/dfs(n + deg) where deg = 2*edges   


    
    private void dfs(List<List<Integer>> adjList,int[] vis,int root){

        vis[root] = 1;
        for(int adj:adjList.get(root)){
            if(vis[adj]==0){
                dfs(adjList,vis,adj);
            }
        }
    }
    private void bfs(List<List<Integer>> adjList,int[] vis,int root){
        

        Queue<Integer> q = new LinkedList<>();
        vis[root] = 1;
        q.offer(root);
        while(!q.isEmpty()){
            int peek = q.poll();
            for(int adj: adjList.get(peek)){
                if(vis[adj]==0){
                    q.offer(adj);
                    vis[adj] = 1;
                }
            }
        }

    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int m = isConnected[0].length;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(isConnected[i][j]==0 || i==j) continue;
                adjList.get(i).add(j);
                adjList.get(j).add(i);
            }
        }
        int[] vis  = new int[n];
        int numOfProvince = 0;
        for(int i = 0;i<n;i++){
            if(vis[i]==0){
                bfs(adjList,vis,i);
                numOfProvince++;
            }
        }
        return numOfProvince;
        


    }
    
}
