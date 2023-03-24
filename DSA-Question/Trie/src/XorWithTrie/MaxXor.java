package XorWithTrie;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//https://www.codingninjas.com/codestudio/problems/maximum-xor_973113?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_tries_videos&leftPanelTab=0

/**
 * leetcode question : https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/description/
 * note : for leetcode using map will give TLE for one test case
 * we optimise it by using 2 size arr as links
 */
class Node{
    Map<Integer, Node> links; // will have 0,1
    public Node(){
        this.links = new HashMap<>();
    }
    boolean contains(int bit){
        return links.containsKey(bit);
    }
    Node get(int bit){
        return links.get(bit);
    }
    void put(int bit){
        links.put(bit,new Node());
    }
}

class Trie{
    Node root;
    public Trie(){
        root = new Node();
    }

    void insert(int num){
        Node temp = root;
        //100001,
        //for binary 0 starts from right so to get the left most
        //we have to right shift it 31 times (as int is 32 bit)
        for(int i = 31;i>=0;i--){
            int bit = (num>>i)&1; //gets the last bit out
            if(!temp.contains(bit)){
                temp.put(bit);
            }
            temp = temp.get(bit);
        }
    }

    int getMax(int k){
        Node temp = root;
        int max = 0;
        for(int i = 31;i>=0;i--){
            int bit = (k>>i)&1;
            //now at best we want the complementary
            int complement = 1-bit; // if bit = 0 then 1 if 1 then 0
            if(temp.contains(complement)){
                //then we can turn on the ith bit
                //1<<i creates the bit mask
                //then doing or will turn 0 to 1
                max = max | 1<<i;
                //if we found the bit then move down that path
                temp = temp.get(complement);

            }else{
                //otherwise we move down the same path as before
                temp = temp.get(bit);
            }

        }
        return max;
    }
}
public class MaxXor {
    public static int maxXOR(int n, int m, ArrayList<Integer> arr1, ArrayList<Integer> arr2)
    {
        Trie trie = new Trie();
        for(int it:arr1){
            trie.insert(it);
        }
        int absMax= 0;
        for(int num:arr2){
            absMax = Math.max(absMax, trie.getMax(num));
        }
        return absMax;
    }
}
