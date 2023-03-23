

class Trie{
    Node root;
    public  Trie(){
        this.root = new Node();
    }
    void insert(String word){
        Node temp = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if(!temp.contains(c)){
                temp.put(c);
            }
            temp = temp.get(c);

        }
        temp.setEnd();
    }

    boolean checkIfPrefixAlsoWord(String word){
        Node temp = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if(!temp.contains(c)) return false; //letter is not present
            temp = temp.get(c); //move to ref trie
            if(!temp.isEnd()) return false; //it is not end
        }
        return true;
    }


}
public class CompleteString {
    public String completeString(int n, String[] a) {
        // Write your code here.
        Trie trie = new Trie();
        for(String s:a){
            trie.insert(s);
        }
        String complete = "";
        for(String word:a){
            int len = word.length();
            if(trie.checkIfPrefixAlsoWord(word)){
                if(len> complete.length()){
                    complete = word;
                }else if(len==complete.length() && word.compareTo(complete)<0){
                    complete = word;
                }
            }
        }
        if(complete.equals("")) return "None";
        return complete;

    }
}
