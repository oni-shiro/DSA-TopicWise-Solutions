package Recurison;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public void helper(int[] arr, int i, int target, List<Integer> st, List<List<Integer>> res){
        int n = arr.length;
        if( target == 0){
             res.add(new ArrayList<>(st)); 
             return;   
        }
        if(i>=n){
            return;
        }
        //pick
        if(arr[i]<=target){
            st.add(arr[i]);
        helper(arr,i,target-arr[i], st, res);
        //backtrack and delete the entry for notpick call
        st.remove(st.size()-1);    
        }
        //notpick
        helper(arr,i+1,target, st, res);   
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> st = new ArrayList<>();
        helper(candidates,0,target,st, ansList);
        return ansList;
    }
    
}
