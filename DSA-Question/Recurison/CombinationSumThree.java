package Recurison;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumThree {
    public void helper(int start,int k, int n, List<Integer> st, List<List<Integer>> res){
        if(st.size() == k){
            if(n==0){
                 res.add(new ArrayList<>(st));
            }
           
            return;
        }
        for(int i = start;i<=9;i++){
            st.add(i);
            helper(i+1,k,n-i,st,res);
            st.remove(st.size()-1);

        }
    }
    
   public List<List<Integer>> combinationSum3(int k, int n) {
       List<List<Integer>> ansList = new ArrayList<>();
       List<Integer> st = new ArrayList<>();
       helper(1,k,n,st,ansList);
       return ansList;
   }
}
