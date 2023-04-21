package Recurison;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumTwo {

    public void helper(int[] arr, int i, int target, List<Integer> st, List<List<Integer>> res){
        int n = arr.length;
        int prev = -1;
        if( target == 0){
             res.add(new ArrayList<>(st)); 
             return;   
        }
        if(i>=n){
            return;
        }
        for(int k = i; k<n;k++){
            if(arr[k]<=target){
                if(arr[k]== prev){
                    continue;
                }
                st.add(arr[k]);
                helper(arr,k+1,target-arr[k], st, res);
                st.remove(st.size()-1); 
                prev = arr[k];
            }
         
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> st = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates,0,target,st, ansList);
        return ansList;
    }
    
}
