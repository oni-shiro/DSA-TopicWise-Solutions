class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}
//User function Template for Java
class Solution {
    
    private void topoSort(int node,List<List<Pair>> adjList,int[] vis, Stack<Integer> st){
        vis[node] = 1;
        for(Pair nei : adjList.get(node)){
            int currNode = nei.first;
            if(vis[currNode]==0){
                topoSort(currNode,adjList,vis,st);
            }
        }
        st.push(node);
        
        
    }
	public int[] shortestPath(int n,int m, int[][] edges) {
		//Code here
		//create the adj list with weight;
		int[] shortesPath = new int[n];
		List<List<Pair>> adjList = new ArrayList<>();
		for(int i = 0;i<n;i++){
		    adjList.add(new ArrayList<>());
		}
		for(int i = 0;i<m;i++){
		    int u = edges[i][0];
		    int v = edges[i][1];
		    int wt = edges[i][2];
		    adjList.get(u).add(new Pair(v,wt));
		}
		int[] vis = new int[n];
		Stack<Integer> st = new Stack<>();
		for(int curr = 0;curr<n;curr++){
		    if(vis[curr]==0){
		        topoSort(curr,adjList,vis,st);
		    }
		}
// 		System.out.println("st"+ st);
		//next step - initialize the ans shortesPath
		Arrays.fill(shortesPath,(int)1e9);
		//as zero is src
		shortesPath[0] = 0;
		while(!st.isEmpty()){
		    int peek = st.pop();
		    for(Pair nei: adjList.get(peek)){
		        int v = nei.first;
		        int wt = nei.second;
		        int wtIfPathTaken = shortesPath[peek] + wt;
		        int currPath = shortesPath[v];
		        //keep the stored one or update the curr val;
		        shortesPath[v] = Math.min(currPath,wtIfPathTaken);
		    }
		}
		//filling the unreachable cells with -1, uncessary logic wise-> just
		//to pass the test cases
		for (int i = 0; i < n; i++) {
            if (shortesPath[i] == 1e9) shortesPath[i] = -1;
        }
		return shortesPath;
	}
}