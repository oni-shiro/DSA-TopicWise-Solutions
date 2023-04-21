package Recurison;

public class WordSearch {

    //Word-Search :

    /*
    for every letter we have to check in the function
    and the recursion call happens for every cell to check if its
    possible to construct from any starting cell, once one call returns true break and return tryue
    else return false
    */

    public int n = 0;
    public int m = 0;
    public int len = 0;

    private boolean helper(int i,int j,int charId, char[][] board, 
    String word,int[][] vis){

        if(i<0 || i>=n || j<0 || j>=m || charId>=len || vis[i][j] == 1
        || word.charAt(charId)!=board[i][j]) return false;
        
        if(charId == len -1) return true;
        vis[i][j] = 1;
        boolean flag =  helper(i+1,j,charId+1,board,word,vis)
            || helper(i-1,j,charId+1,board,word,vis) 
            || helper(i,j+1,charId+1,board,word,vis)
            || helper(i,j-1,charId+1,board,word,vis);
        vis[i][j] = 0;
        return flag;

    }
    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        len = word.length();
        int[][] vis = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(helper(i,j,0,board,word,vis)) return true;
            }
        }
        return false;
    }
    
}
