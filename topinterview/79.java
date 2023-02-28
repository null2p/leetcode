class Solution {
    // List<Boolean> visited = ArrayList<>();
    public boolean exist(char[][] board, String word) {

        if(word.length() > board.length * board[0].length){
            return false;
        }

        if(word.length()==1){
            for(int i = 0; i < board.length ; i++){
                for(int j = 0 ; j < board[0].length; j++){
                    if (board[i][j] == word.charAt(0)){
                        return true;
                    }
                }
            }
            return false;
        }

        for(int i = 0; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean[][] visited = new boolean[board.length+1][board[0].length+1];
                    // visited[i][j] = true;
                    if(findWord(i,j,board,0,word,visited)){
                        return true;
                    }
                    else{
                        continue;
                    }
                }
            }
        }
        
        return false;
    }

    private boolean findWord(int i, int j, char[][] board, int charIdx, String word, boolean[][] visited){
        if(charIdx == word.length()){
            return true;
        }
        if(i<0 || j<0 || i==board.length||j==board[0].length || visited[i][j]==true){
            return false;
        }

        if(word.charAt(charIdx)!=board[i][j]){
            return false;
        }
        visited[i][j] = true;
        // System.out.println("i : "+i+", j : "+j+", word : "+word.charAt(charIdx));

        if (findWord(i+1,j,board,charIdx+1,word,visited)){
            return true;
        }
        else {
            // visited[i+1][j] = false;
        }

        if (findWord(i-1,j,board,charIdx+1,word,visited)){
            return true;
        }
        else if(i > 0){
            // visited[i-1][j] = true;
        }

        if (findWord(i,j+1,board,charIdx+1,word,visited)){
            return true;
        }
        else {
            // visited[i][j+1] = true;
        }

        if (findWord(i,j-1,board,charIdx+1,word,visited)){
            return true;
        }
        else if(j>0){
            // visited[i][j-1] = true;
        }
        // System.out.println("NOPE");
        return false;
    }
}
