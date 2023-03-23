public class DisjointSetImpl {

    private int[] rank;
    private int[] parent;
    private int[] size;
    public DisjointSetImpl(int n){
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
