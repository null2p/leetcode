class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set> colSetList = makeColSetList();
        List<Set> blockSetList = makeBlockSetList();

        for(int i = 0; i < 9 ; i++){
            char[] rowBoard = board[i];
            Set<Character> rowSet = new HashSet<>();

            for(int j = 0; j < 9 ; j ++){
                char element = rowBoard[j];
                if(element=='.'){
                    continue;
                }
                //row 검증
                if(rowSet.contains(element)){
                    return false;
                }
                rowSet.add(element);
                //col 검증
                Set<Character> colSet = colSetList.get(j);
                if(colSet.contains(element)){
                    System.out.println(element);
                    return false;
                }
                colSet.add(element);
                colSetList.set(j,colSet);
                //block 검증
                int blockIndex = getBlockIndex(i,j);
                Set<Character> blockSet = blockSetList.get(blockIndex);
                if(blockSet.contains(element)){
                    return false;
                }
                blockSet.add(element);
                blockSetList.set(blockIndex,blockSet);
            }
        }
        return true;
    }

    private List<Set> makeColSetList(){
        List<Set> colSetList = new ArrayList<>();
        for(int i = 0; i < 9; i ++ ){
            Set<Character> colSet = new HashSet<>();
            colSetList.add(colSet);
        }
        return colSetList;
    }
    private List<Set> makeBlockSetList(){
        List<Set> blockSetList = new ArrayList<>();
        for(int i = 0; i < 9; i ++ ){
            Set<Character> blockSet = new HashSet<>();
            blockSetList.add(blockSet);
        }
        return blockSetList;
    }
    //i가 row, j가 column이다
    private int getBlockIndex(int i, int j){
        return (i/3)*3 + j/3;
    }

}
