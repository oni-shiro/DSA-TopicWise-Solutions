class Solution {
    int n = 0,row = 0, col = 0;
    private boolean recur(char[][] board,boolean[][] visited,
                          String word, int index, int i, int j){
        if(i>=row ||i<0 || j>=col || j<0 || visited[i][j] || index>=n
          || word.charAt(index)!=board[i][j]) {
            return false;
        }
        if(index == n-1){
            return true;
        }
        
        visited[i][j] = true;
        boolean flag =  recur(board,visited,word,index+1,i+1,j)
            || recur(board,visited,word,index+1,i-1,j) 
            || recur(board,visited,word,index+1,i,j-1)
            || recur(board,visited,word,index+1,i,j+1);
        
        visited[i][j] = false;
        return flag;
        
    }
    public boolean exist(char[][] board, String word) {
        n = word.length();
        row = board.length;
        col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(recur(board,visited,word,0,i,j)) return true;
            }
        }
        return false;
    }
}