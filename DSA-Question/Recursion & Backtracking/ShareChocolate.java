
//Question : https://leetcode.com/problems/fair-distribution-of-cookies/

/**
we will maintain a k size array for the child
for each child we will add one bag, calculate the max unfairness, after reaching end will comeback and backtrack from the prev one and add to the next one, this way at a given stage the unfairness will be minimum
[8,15,10,20,8], k = 2
[0,0] -> unf = Intmax
[8,0] -> 8;
[23,0] -> 23
..
[61,0] unf = 61 (all element added for 0th child)
//backtrack
[53,8] -> unf = 53
..
at a stage
it will be 
[31,30] - unf = 31 (ans)


 */


public class ShareChocolate {
    int getMaxFromArray(int[] arr){
        int max =0;
        for(int it:arr){
            max = Math.max(it,max);
        }
        return max;
    }
    private void solve(int i,int[] cookies, int[] childs, int k,int n,int[] unf){
        if(i>=n){
            //update the minimum possible unfairness
            unf[0] = Math.min(unf[0], getMaxFromArray(childs));
            return;
        }
        for(int j = 0;j<k;j++){
            // start for one child, keep adding , call for next cookies
            childs[j] += cookies[i];
            solve(i+1,cookies,childs,k,n,unf);
            //once reached end, substract for that j and call for J+1 for same i
            childs[j] -= cookies[i];
        }
    }
    public int distributeCookies(int[] cookies, int k) {
        int[] childs = new int[k];
        int n = cookies.length;
        int[] unf = new int[1];
        unf[0] = Integer.MAX_VALUE;
        solve(0,cookies, childs,k,n,unf);
        return unf[0];
        
    }
    
}
