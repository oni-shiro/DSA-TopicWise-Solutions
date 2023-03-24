package XorWithTrie;

import java.util.ArrayList;
import java.util.List;

//https://www.codingninjas.com/codestudio/problems/max-xor-queries_1382020?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_tries_videos&leftPanelTab=0
//leetcode : https://leetcode.com/problems/maximum-xor-with-an-element-from-array/description/
//Note : same optimization of using 2size arr instead of map

class Tuple{
    int first;
    int second;
    int third;
    public Tuple(){
    }
}
public class MaxXorQueries {

    public static ArrayList<Integer> maxXorQueries(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> queries) {
        // Write your code here.
        Trie trie = new Trie();
        arr.sort((a,b) -> a-b);
        int n = arr.size();
        ArrayList<Integer> ans = new ArrayList<>();
        //initalizing the ans with zeros to be replaced letter
        for(int i = 0;i<queries.size();i++){
            ans.add(0);
        }
        List<Tuple> offlineQueries = new ArrayList<>();
        //t(x,a,i)
        for(int i = 0;i<queries.size();i++){
            Tuple t = new Tuple();
            t.first = queries.get(i).get(0);
            t.second = queries.get(i).get(1);
            t.third = i;
            offlineQueries.add(t);
        }

        //sort the offlineQueries
        offlineQueries.sort((a,b)-> a.second - b.second);
        int arrId = 0;

        for(Tuple t:offlineQueries){
            int xi = t.first;
            int ai = t.second;
            int queryId = t.third;

            while(arrId<n && arr.get(arrId)<= ai){
                trie.insert(arr.get(arrId));
                arrId++;
            }
            //reached the highest element we can get
            if(arrId==0){
                //we could nt start
                ans.set(queryId, -1);
            }else{
                ans.set(queryId, trie.getMax(xi));
            }

        }
        return ans;

    }
}
