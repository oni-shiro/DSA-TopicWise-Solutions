import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int node;
    int parent;
    public Pair(int node,int parent){
        this.node = node;
        this.parent = parent;
    }
}
public class CycleUndirected {
    private boolean dfs(int node,int parent,int[] vis,ArrayList<ArrayList<Integer>> adj){
        vis[node] = 1;
        for(int adjNode : adj.get(node)){
            if(vis[adjNode]==0){
                vis[adjNode] = 1;
                if(dfs(adjNode,node,vis,adj) ==  true) return true;
            }else{
                //visited
                if(parent!=adjNode) return true;
                
            }
            
        }
        return false;
    }

    private boolean bfs(int st,ArrayList<ArrayList<Integer>> adj, int[] vis ){
        Queue<Pair> q = new LinkedList<>();
        vis[st] = 1;
        q.add(new Pair(st,-1));
        while(!q.isEmpty()){
            int node = q.peek().node;
            int parent = q.peek().parent;
            q.poll();
            for(int adjNode : adj.get(node)){
                if(vis[adjNode]==0){
                    vis[adjNode] = 1;
                    q.add(new Pair(adjNode,node));
                }else if(parent != adjNode){
                    //adjNode is not the node it came from
                    //means cycle exists
                    return true;
                }
            }
        }
        
        return false;
        
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        for(int i = 0;i<V;i++){
            if(vis[i]==0){
                //for every not-connected component  for the
                //starting node the parent will be -1
                if(dfs(i,-1,vis,adj) ==  true) return true;
            }    
        }
        return false;
    }
}
