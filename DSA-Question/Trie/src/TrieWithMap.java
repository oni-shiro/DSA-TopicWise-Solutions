import java.util.HashMap;
import java.util.Map;

class MapNode{
    Map<Character,MapNode> links;
    boolean isEndFlg;

    public MapNode(){
        this.links = new HashMap<>();
        this.isEndFlg = false;

    }

    boolean contains(char c){
        return links.containsKey(c);
    }
    MapNode get(char c){
        return links.get(c);
    }

    void put(char c){
        links.put(c,new MapNode());
    }
    boolean isEnd(){
        return this.isEndFlg;
    }
    void setEnd(){
        this.isEndFlg = true;
    }
}

public class TrieWithMap {

    MapNode root;
    public TrieWithMap(){
        this.root = new MapNode();
    }

    void insert(String word){
        MapNode temp = root;
        int n = word.length();
        for(int i = 0;i<n;i++){
            char c = word.charAt(i);
            if(!temp.contains(c)){
                temp.put(c);
            }
            temp = temp.get(c);
        }
        temp.setEnd();
    }

    boolean search(String word){
        return searchHelper(word, root,0);
    }

    private boolean searchHelper(String word, MapNode root, int idx) {
        int n = word.length();
        MapNode temp = root;
        for (int i = idx; i < n; i++) {
            char c = word.charAt(i);
            if(c=='.'){
                for(char ch : temp.links.keySet()){
                    MapNode next = temp.get(ch);
                    if(searchHelper(word,next,i+1)) return true;
                }
                return false;
            }
            if(!temp.contains(c)) return false;
            temp = temp.get(c);

        }
        return temp.isEnd();
    }
}
