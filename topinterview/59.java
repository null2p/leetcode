class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int leftEnd = 0, rightEnd =n-1, upperEnd = 0, lowerEnd = n-1;
        int cur = 1;

        while(cur<=n*n){
            //L -> R
            for(int i = leftEnd; i<=rightEnd ; i++){
                result[upperEnd][i] = cur;
                cur += 1;
            }
            upperEnd +=1;

            //U -> D
            for(int i=upperEnd; i <= lowerEnd; i++){
                result[i][rightEnd] = cur;
                cur += 1;
            }
            rightEnd -= 1;

            //R -> L
            for(int i = rightEnd ; i>=leftEnd;i--){
                result[lowerEnd][i] = cur;
                cur += 1;
            }
            lowerEnd -=1;

            //D -> U
            for(int i=lowerEnd; i >= upperEnd; i--){
                result[i][leftEnd] = cur;
                cur += 1;
            }
            leftEnd += 1;

        }

        return result;
    }
}
