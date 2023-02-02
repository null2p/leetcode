class Solution {
    int i  = 0, j = 0;
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowSize = matrix.length, colSize = matrix[0].length, matSize= rowSize*colSize;
        int maxDown = rowSize, maxRight = colSize, maxLeft = -1, maxUp = 0;
        List<Integer> result = new ArrayList<>();

        while(true){
            goRight(matrix,result,maxRight);
            maxRight-=1;
            if(matSize <= result.size()){
                break;
            }
            goDown(matrix,result,maxDown);
            maxDown -=1;
            if(matSize <= result.size()){
                break;
            }
            goLeft(matrix,result,maxLeft);
            maxLeft+=1;
            if(matSize <= result.size()){
                break;
            }
            goUp(matrix,result,maxUp);
            maxUp+=1;
            if(matSize <= result.size()){
                break;
            }
        }
        return result;
    }

    private void goRight(int[][] matrix,List<Integer> result, int limit){
        for(;j<limit;j++){
            result.add(matrix[i][j]);
        }
        j-=1; i+=1;
    }
    private void goDown(int[][] matrix, List<Integer> result, int limit){
        for(;i<limit;i++){
            result.add(matrix[i][j]);
        }
        i-=1; j-=1;
    }
    private void goLeft(int[][] matrix, List<Integer> result, int limit){
        for(;j>limit;j--){
            result.add(matrix[i][j]);
        }
        j+=1; i-=1;
    }
    private void goUp(int[][] matrix, List<Integer> result, int limit){
        for(;i>limit;i--){
            result.add(matrix[i][j]);
        }
        i+=1; j+=1;
    }
}
