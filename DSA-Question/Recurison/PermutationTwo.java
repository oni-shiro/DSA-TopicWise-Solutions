package Recurison;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


//similar to permone but store the list in hashset and then at final just make
//a arraylist out of it
public class PermutationTwo {
    private void helper(int n, int[] nums, int[] vis,List<Integer> ds,Set<List<Integer>> hashSet){
        if(ds.size() == n){
            hashSet.add(new ArrayList<>(ds));
            return;
        }
        for(int i = 0;i<n;i++){
            if(vis[i]==0){
                vis[i] =1;
                ds.add(nums[i]);
                helper(n,nums,vis,ds,hashSet);
                ds.remove(ds.size()-1);
                vis[i] =0;
            }   
        }

    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> hashSet = new HashSet<>();
        int[] vis = new int[n];
        List<Integer> ds=  new ArrayList<>();
        
        helper(n,nums,vis,ds,hashSet);
        List<List<Integer>> ans = new ArrayList<>(hashSet);
        return ans;


    }
}
