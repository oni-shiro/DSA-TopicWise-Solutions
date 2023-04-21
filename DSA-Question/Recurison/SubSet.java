package Recurison;

import java.util.ArrayList;
import java.util.List;

public class SubSet {
    public int n = 0;
    private void helper(int i, int[] nums, 
    List<Integer> ds, List<List<Integer>> ans){
        if(i == n){
            ans.add(new ArrayList<>(ds));
            return;
        }
        ds.add(nums[i]);
        helper(i+1,nums,ds,ans);
        //remove and not pick
        ds.remove(ds.size() -1);
        helper(i+1,nums,ds,ans);

    }
    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        helper(0,nums,ds,ans);
        return ans;

        
    }
    
}
