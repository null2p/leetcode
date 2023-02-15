class Solution {
    int rowSize;
    int colSize;
    boolean isCol;
    boolean isRow;

    public void setZeroes(int[][] matrix) {
        rowSize = matrix.length;
        colSize = matrix[0].length;
        isCol = isCol(matrix);
        isRow = isRow(matrix);
        
        findZeros(matrix);
        setZerosInside(matrix);
        setZerosBorder(matrix);
    }

    private boolean isCol(int[][] matrix){
        for(int i = 0 ; i < colSize; i++){
            if(matrix[0][i] == 0){
                return true;
            }
        }
        return false;
    }
    private boolean isRow(int[][] matrix){
        for(int i = 0 ; i < rowSize; i++){
            if(matrix[i][0] == 0){
                return true;
            }
        }
        return false;
    }

    private void findZeros(int[][] matrix){
        for(int i = 0 ; i < rowSize ; i++){
            for(int j = 0; j<colSize ; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0; matrix[0][j] = 0;
                }
            }
        }
    }

    private void setZerosInside(int[][] matrix){
        for(int i = 1 ; i < rowSize ; i++){
            if(matrix[i][0]==0){
                for(int j = 1; j<colSize ; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int j = 1 ; j < colSize ; j ++){
            if(matrix[0][j]==0){
                for(int i = 1; i<rowSize ; i++){
                    matrix[i][j] = 0;
                }
            }
        }
    }
    private void setZerosBorder(int[][] matrix){
        if(isCol){
            for(int j = 0 ; j < colSize ; j ++){
                    matrix[0][j] = 0;
            }
        }
        if(isRow){
            for(int j = 0 ; j < rowSize ; j ++){
                    matrix[j][0] = 0;
            }
        }
    }
}
