import java.util.TreeMap;

class NodeTwo{
    NodeTwo[] links;
    int cntPref;
    int endsWith;

    public NodeTwo(){
        this.links = new NodeTwo[26];
        this.cntPref = 0;
        this.endsWith = 0;
    }
    boolean contains(char c){
        return this.links[c-'a']!=null;
    }
    NodeTwo get(char c){
        if(this.contains(c)){
            return this.links[c-'a'];
        }
        return null;
    }
    void put(char c){
        NodeTwo newNode = new NodeTwo();
        links[c-'a'] =  newNode;
    }
    int getCntPref(){
        return this.cntPref;
    }
    int getEndsWith(){
        return this.endsWith;
    }
    void increaseCntPref(){
        this.cntPref++;
    }
    void increaseEndsWith(){
        this.endsWith++;
    }
    void decreaseCntPref(){
        this.cntPref--;
    }
    void decreaseEndsWith(){
        this.endsWith--;
    }
}

public class TrieImplTwo {

    NodeTwo root;
    public TrieImplTwo(){
        this.root = new NodeTwo();
    }

    void insert(String word){
        NodeTwo temp = root;
        int n = word.length();
        for(int i = 0;i<n;i++){
            char c = word.charAt(i);
            if(!temp.contains(c)){
                temp.put(c);
            }
            temp = temp.get(c);
            temp.increaseCntPref();;
        }
        temp.increaseEndsWith();
    }
    int countWordsEqualTo(String word){
        NodeTwo temp = root;
        int n = word.length();
        for(int i = 0;i<n;i++) {
            char c = word.charAt(i);
            if(!temp.contains(c)) return 0;
            temp = temp.get(c);
        }
        return temp.getEndsWith();
    }

    int startsWith(String word){
        NodeTwo temp = root;
        int n = word.length();
        for(int i = 0;i<n;i++) {
            char c = word.charAt(i);
            if(!temp.contains(c)) return 0;
            temp = temp.get(c);
        }
        return temp.getCntPref();
    }
    void erase(String word){
        NodeTwo temp = root;
        int n = word.length();
        for(int i = 0;i<n;i++) {
            char c = word.charAt(i);
            if(!temp.contains(c)) return; // no character found for starting c
            temp.decreaseCntPref();
            temp = temp.get(c);
        }
        temp.decreaseEndsWith();
    }
}
