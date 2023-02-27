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
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if(findWord(i,j,board,1,word,visited)){
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
    
        visited[i][j] = true;

        if(board.length>1){
            if(i==0){ //down
                if(word.charAt(charIdx)==board[i+1][j]){
                    if(visited[i+1][j]==false){
                        // System.out.println("down");
                        return findWord(i+1,j,board,charIdx+1,word,visited);
                    }
                }
            }
            else if(i==board.length-1){ //up
                if(word.charAt(charIdx)==board[i-1][j]){
                    if(visited[i-1][j]==false){
                        // System.out.println("up");
                        return findWord(i-1,j,board,charIdx+1,word,visited);
                    }
                }
            }
            else{ //up and down
                if(word.charAt(charIdx)==board[i+1][j]){
                    if(visited[i+1][j]==false){
                        // System.out.println("down");
                        return findWord(i+1,j,board,charIdx+1,word,visited);
                    }
                }
                if(word.charAt(charIdx)==board[i-1][j]){
                    if(visited[i-1][j]==false){
                        // System.out.println("up");
                        return findWord(i-1,j,board,charIdx+1,word,visited);
                    }
                }
            }
        }

        if(board[0].length>1){
            if(j==0){ //right
                if(word.charAt(charIdx)==board[i][j+1]){
                    // System.out.println("right");
                    if(visited[i][j+1]==false){
                        return findWord(i,j+1,board,charIdx+1,word,visited);
                    }
                }
            }
            else if(j==board[0].length-1){ //left
                if(word.charAt(charIdx)==board[i][j-1]){
                    // System.out.println("left");
                    if(visited[i][j-1]==false){
                        return findWord(i,j-1,board,charIdx+1,word,visited);
                    }
                }
            }
            else{ //right and left
                if(word.charAt(charIdx)==board[i][j+1]){
                    // System.out.println("right");
                    if(visited[i][j+1]==false){
                       return findWord(i,j+1,board,charIdx+1,word,visited);
                    }
                }
                if(word.charAt(charIdx)==board[i][j-1]){
                    if(visited[i][j-1]==false){
                        // System.out.println("left");
                        return findWord(i,j-1,board,charIdx+1,word,visited);
                    }
                }
            }
        }

        // System.out.println("NOPE");
        return false;
    }
}
