
//create a trie
//insert the substring, if the curr character does not exists
//increase the cnt,
//basically we add substrings starting from every character if
//it exists we dont increase the cnt

import java.util.HashMap;
import java.util.Map;
//https://www.codingninjas.com/codestudio/problems/count-distinct-substrings_985292?leftPanelTab=0
class Node{
    Map<Character,Node> links;
    boolean isEndFlag;

    public Node(){
        this.links = new HashMap<>();
        this.isEndFlag = false;

    }
    boolean contains(char c){
        return links.containsKey(c);
    }
    Node get(char c){
        return links.get(c);
    }

    void put(char c){
        links.put(c,new Node());
    }
    boolean isEnd(){
        return this.isEndFlag;
    }
    void setEnd(){
        this.isEndFlag = true;
    }

}
class Trie{

    Node root;
    int uniqCnt;
    public Trie(){
        this.root = new Node();
        this.uniqCnt = 0;
    }

    void insert(String word){
        Node temp = root;
        int n = word.length();
        for(int i = 0;i<n;i++){
            char c = word.charAt(i);
            if(!temp.contains(c)){
                //increasing the cnt if doesnot exists
                this.uniqCnt++;
                temp.put(c);
            }
            temp = temp.get(c);
        }
        temp.setEnd();
    }


}
public class CountDistinctSubstrings {
    public static int countDistinctSubstrings(String s)
    {
        Trie t = new Trie();
        int n = s.length();
        for(int i = 0;i<n;i++){
            for(int j = i;j<n;j++){
                String substr = s.substring(i,j+1);
                // System.out.print(" "+ substr);
                t.insert(substr);


            }
        }
        return t.uniqCnt+1;
    }
}
