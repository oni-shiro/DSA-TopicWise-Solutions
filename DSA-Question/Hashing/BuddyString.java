
//question : https://leetcode.com/problems/buddy-strings/

public class BuddyString {
    
    public boolean buddyStrings(String s, String goal) {
        int n = s.length();
        int m = goal.length();
        //length is different
        if(n!=m) return false;
        //create the frequency arr for both string
        int[] charFreqCnt = new int[26];
        int[] charFreqCntTwo = new int[26];
        for(int i = 0;i<n;i++){
            charFreqCnt[s.charAt(i)-'a']++;
        }

        for(int i = 0;i<m;i++){
            charFreqCntTwo[goal.charAt(i)-'a']++;
        }

        //if number of character does not matches swap will not work
        for(int i=0;i<26;i++){
            if(charFreqCnt[i]!=charFreqCntTwo[i]) return false;
        }
        //if both are identical string, then for s if there are any character duplicated we can just
        // swap them to get the same string i.e. "aa", "aa"
        if(s.equals(goal)){
            for(int i = 0;i<26;i++){
                if (charFreqCnt[i] >=2 ) return true;
            }
        }
        //cnt the mismatches at any given index
        int misMatchCnt = 0;
        for(int i = 0;i<n;i++){
            if(s.charAt(i)!= goal.charAt(i)) misMatchCnt++;
        }
        //cnt of mismatch can only be two then only we can swap once to make them identical
        if(misMatchCnt==2) return true;
        return false;
    }
}
