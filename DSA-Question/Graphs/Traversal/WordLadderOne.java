import java.util.*;

class Pair{
    String word;
    int level;
    public Pair(String word,int level){
        this.word = word;
        this.level = level;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int n = wordList.size();
        //creating the unique set
        Set<String> hs = new HashSet<>(wordList);
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord,1));
        int minLevel = 0;
        while(!q.isEmpty()){
            String curr = q.peek().word;
            int level = q.peek().level;
            if(curr.equals(endWord)){
                minLevel = level;
            }
            q.poll();
            for(int j = 0;j<curr.length();j++){
                char[] toChar = curr.toCharArray();
                char currChar = toChar[j];
                for(char c = 'a';c<='z';c++){
                    currChar = c;
                    toChar[j] = currChar;
                    String toCheck = String.valueOf(toChar);
                    if(hs.contains(toCheck)){
                        q.offer(new Pair(toCheck,level+1));
                        hs.remove(toCheck);
                    }
                }
            }
        }
        return minLevel;
    }
}