
class Node{
    Node[] links;
    boolean isEndFlag;

    public Node(){
        this.links = new Node[26];
        this.isEndFlag = false;
    }
    boolean contains(char c){
        return this.links[c-'a']!=null;
    }
    Node get(char c){
        if(this.contains(c)){
            return this.links[c-'a'];
        }
        return null;
    }
    void put(char c){
        Node newNode = new Node();
        links[c-'a'] =  newNode;
    }
    boolean isEnd(){
        return this.isEndFlag;
    }
    void setEnd(){
        this.isEndFlag = true;
    }
}

public class TrieImplOne {
    Node root;


    public TrieImplOne(){
        this.root = new Node();

    }

    void insert(String word){
        Node temp = root;
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
        Node temp = root;
        int n = word.length();
        for(int i = 0;i<n;i++) {
            char c = word.charAt(i);
            if(!temp.contains(c)) return false;
        }

        return temp.isEnd();
    }

    boolean startsWith(String word){
        Node temp = root;
        int n = word.length();
        for(int i = 0;i<n;i++) {
            char c = word.charAt(i);
            if(!temp.contains(c)) return false;
        }
        return true;
    }
}
