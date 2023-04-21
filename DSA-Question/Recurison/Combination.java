package Recurison;

import java.util.ArrayList;
import java.util.List;

public class Combination {

    public void helper(int n,int k, List<List<Integer>> ans, List<Integer> ds,int it){ 
        if(ds.size()==k){
            ans.add(new ArrayList<>(ds));
            return;
        }
           
        for(int i = it;i<=n;i++){
            ds.add(i);
            helper(n,k,ans,ds,i+1);
            ds.remove(ds.size()-1);  
        }
       
     
    }
    public List<List<Integer>> combine(int n, int k) {
        List<Integer>ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        helper(n,k,ans,ds,1);
        return ans;
        
    }
    
}
