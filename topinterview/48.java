class Solution {
    public void rotate(int[][] matrix) {
        int rowLen = matrix.length, colLen = matrix[0].length;  
        int[] newIdx;

        int i = 0;
        int endJ = colLen-1, startJ = 0;
        while(true){
            for(int j = startJ; j < endJ ; j++){
                changeFourCorners(i,j,matrix);
            }
            if(startJ >= endJ){
                break;
            }
            i +=1; endJ -=1; startJ +=1;
        }
        
    }

    private void changeFourCorners(int i, int j, int[][] matrix){
        int before = matrix[i][j];

        for(int rot =0 ; rot<4 ; rot++){
            int[] newIdx;
            newIdx = getNewIndex(i,j,matrix);

            int after = matrix[newIdx[0]][newIdx[1]];
            matrix[newIdx[0]][newIdx[1]] = before;
            
            before = after;
            i = newIdx[0]; j = newIdx[1];
        }
    }

    private int[] getNewIndex(int i, int j, int[][] matrix){
        int newX, newY;
        // 1. translate to coordinate
        int rowLen = matrix.length, colLen = matrix[0].length;
        newX = j-(colLen)/2; newY = i - (rowLen)/2;

        // 2. rotate 90 degree
        int tmp = newX;
        newX = -newY;
        newY = tmp;

        // 3. translate to matrix index
        tmp = newX;
        newX = newY + (rowLen)/2; 
        newY = tmp + (colLen-1)/2;

        return new int[]{newX, newY};
    }
}
