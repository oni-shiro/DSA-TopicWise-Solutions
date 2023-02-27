class Tuple{
    int first;
    int second;
    int third;
    public Tuple(int a,int b,int c){
        this.first = a;
        this.second = b;
        this.third = c;
    }
}

class Pair{
    int first;
    int second;
    public Pair(int a,int b){
        this.first = a;
        this.second = b;
    }
}
class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    List<List<Pair>> adjList = new ArrayList<>();
	    for(int i = 0;i<V;i++){
	        adjList.add(new ArrayList<>());
	    }
	    for(int[] arr:edges){
	        int u = arr[0];
	        int v = arr[1];
	        int wt = arr[2];
	        adjList.get(u).add(new Pair(v,wt));
	        adjList.get(v).add(new Pair(u,wt));
	    }
	    int mstSum = 0;
	    int[] vis = new int[V];
	    //(wt,node,parnt)
	    PriorityQueue<Tuple> pq = new PriorityQueue<>(
	        (a,b)->a.first==b.first ? a.second-b.second: a.first-b.first);
	    pq.offer(new Tuple(0,0,-1));
	    
	    while(!pq.isEmpty()){
	        Tuple peek = pq.poll();
	        int node = peek.second;
	        int parent = peek.third;
	        int wt = peek.first;
	        if(vis[node]==1) continue;
	        mstSum+=wt;
	        vis[node]=1;
	        for(Pair p: adjList.get(node)){
	            int adjNode = p.first;
	            int adjWt = p.second;
	            if(vis[adjNode]==0){
	                pq.offer(new Tuple(adjWt , adjNode,node));
	            }
	        }
	    }
	    return mstSum;
	    
	}
}