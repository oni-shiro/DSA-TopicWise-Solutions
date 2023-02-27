public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        DisjointSet ds = new DisjointSet(7);
        ds.unionBySize(1,2);
        ds.unionBySize(2,3);
        ds.unionBySize(4,5);
        ds.unionBySize(5,6);
        if(ds.findUltimateParent(1)== ds.findUltimateParent(7)){
            System.out.println("same");
        }else{
            System.out.println("not Same");
        }
        ds.unionBySize(3,7);
        if(ds.findUltimateParent(1)== ds.findUltimateParent(7)){
            System.out.println("same");
        }else{
            System.out.println("not Same");
        }
    }
}