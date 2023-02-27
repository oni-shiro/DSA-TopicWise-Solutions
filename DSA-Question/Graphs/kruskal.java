class DisjointSet {

    private int[] rank;
    private int[] parent;
    private int[] size;
    public DisjointSet(int n){
        //doing n+1 to incorporate 1 based idx
        this.rank = new int[n+1];
        this.parent = new int[n+1];
        this.size = new int[n+1];
        for(int i = 0;i<=n;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int findUltimateParent(int node){
        if(node == this.parent[node]){
            //it is ultimate parent
            return node;
        }
        //store before returning to do path compression
        return parent[node] = findUltimateParent(parent[node]);
    }
    public void unionByRank(int u,int v){
        int pU = parent[u];
        int pV = parent[v];
        if(pU==pV){
            //in same component
            return;
        }
        if(rank[pU]<rank[pV]){
            parent[pU] = pV;
        }else if(rank[pV]<rank[pU]){
            parent[pV] = pU;
        }else{
            //both equal add any to any
            //adding v to u and rank pU++
            parent[pV] = pU;
            rank[pU]++;

        }
    }

    public void unionBySize(int u,int v){
        int pU = parent[u];
        int pV = parent[v];
        if(pU==pV){
            //in same component
            return;
        }
        if(size[pU]<size[pV]){
            parent[pU] = pV;
            size[pV] += size[pU];
        }else{
            parent[pV] = pU;
            size[pU] += size[pV];

        }
    }
}
class Tuple{
    int first;
    int second;
    int third;
    public Tuple(int first,int second,int third){
        this.first=first;
        this.second = second;
        this.third = third;
    }
}

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    List<Tuple> data = new ArrayList<>();
	    for(int[] e:edges){
	        int u = e[0];
	        int v = e[1];
	        int wt = e[2];
	        //wt,e,v
	        data.add(new Tuple(wt,u,v));
	    }
	    int mstSum = 0;
	    Collections.sort(data,((a,b)->a.first-b.first));
	    DisjointSet ds = new DisjointSet(V);
	    for(int i = 0;i<data.size();i++){
	        int wt = data.get(i).first;
	        int u = data.get(i).second;
	        int v = data.get(i).third;
	        if(ds.findUltimateParent(u)!=ds.findUltimateParent(v)){
	            mstSum += wt;
	            ds.unionBySize(u,v);//rank works also
	        }
	    }
	    return mstSum;
	    
	}
}