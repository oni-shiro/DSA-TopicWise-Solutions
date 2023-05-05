import java.util.*;

class Pair{
    int wt;
    int node;
    public Pair(int wt,int node){
        this.wt = wt;
        this.node = node;
    }
}
class Dijkstra {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        List<List<Pair>> adjList = new ArrayList<>();
        for(int i = 0;i<=n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i = 0;i<m;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adjList.get(u).add(new Pair(wt,v));
            adjList.get(v).add(new Pair(wt,u));
        }
        int src = 1;
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)-> a.wt == b.wt ? a.node-b.node : a.wt-b.wt);
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;
        int[] parent = new int[n+1];
        for(int i = 0;i<=n;i++){
            parent[i] = i;
        }
        //Pair(dist,node)
        pq.offer(new Pair(0,1));
        while(!pq.isEmpty()){
            int node = pq.peek().node;
            int dis = pq.peek().wt;
            pq.poll();
            for(Pair adj: adjList.get(node)){
                int adjNode = adj.node;
                int wt = adj.wt;
                int distIfPathTaken = dis+wt;
                if(distIfPathTaken<dist[adjNode]){
                    pq.offer(new Pair(distIfPathTaken,adjNode));
                    dist[adjNode] = distIfPathTaken;
                    parent[adjNode] = node;
                }
            }
        }
       
        List<Integer> path = new ArrayList<>();
        //if path not possible
        if(dist[n]==Integer.MAX_VALUE){
            path.add(-1);
            return path;
        }
        int curr = n;
        //1 is parent of 1 as it is src
        while(parent[curr]!=curr){
            path.add(curr);
            curr = parent[curr];
        }
        //have to add src as while loop terminated when reached src
        path.add(src);
        //reverse to get the right order;
        Collections.reverse(path);
        return path;
            
    }
}