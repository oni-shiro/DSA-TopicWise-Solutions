package Recurison;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    private void helper(int[] nums, List<List<Integer>> ans, List<Integer> ds,boolean[] flag, int n){
        
        //base
        if(ds.size()== n){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = 0;i<n;i++){
            if(!flag[i]){
                ds.add(nums[i]);
                flag[i] = !flag[i];
                helper(nums,ans,ds,flag,n);
                //backtrack
                flag[i] = !flag[i];
                ds.remove(ds.size()-1);
            }
            
        }
        return;    
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        int n = nums.length;
        boolean[] flag = new boolean[n];
        helper(nums,ans,ds,flag,n);
        
        return ans;
    }
}
