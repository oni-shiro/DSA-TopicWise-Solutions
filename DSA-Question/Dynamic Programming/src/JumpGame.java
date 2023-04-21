public class JumpGame {

    //recursive
    static int helper(int[] arr,int n,int id){
        int minPath = (int)1e9; //as of now cant reach
        if(id>=n-1) return 0; //have reached
        if(arr[id]==0) return Integer.MAX_VALUE; //not picking
        for(int i = 1;i<=arr[id];i++){
            minPath = Math.min(1+helper(arr,n,id+i),minPath);
        }
        return minPath;
    }

    //memoized implementation
    static int helper(int[] arr,int n,int id, int[] dp){
        int minPath = (int)1e9; //as of now cant reach
        if(id>=n-1) return 0; //have reached
        if(arr[id]==0) return dp[id]= (int)1e9; //not picking
        if(dp[id]!=-1) return dp[id];
        for(int i = 1;i<=arr[id];i++){
            minPath = Math.min(1+helper(arr,n,id+i,dp),minPath);
        }
        return dp[id]= minPath;
    }

    //main method
    static int minJumps(int[] arr){
        // your code here
        int[] dp = new int[arr.length];
        Arrays.fill(dp,-1);
        int path = helper(arr,arr.length,0,dp);
        return path==(int)1e9?-1:path;
    }

    
    
}
