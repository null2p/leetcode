class Solution {
    int[][] pascal;
    public int uniquePaths(int m, int n) {
        pascal = getPascal();
        m = m-1; n = n-1;
        if(n > m){
            int tmp = m;
            m = n;
            n = tmp;
        }

        if(n==0){
            return 1;
        }
        else if(n==1){
            return m+1;
        }

        if(m+n <= 5){
            return pascal[m+n][n];
        }
        else{
            return pascal(m+n,n);
        }
    }

    private  int pascal(int total, int n){
        // System.out.println("total = "+total+", n = "+n);
        if(n == 1 || total-n ==1){
            return total;
        }

        if(total<=5){
            return pascal[total][n];
        }
        

        return pascal(total-1,n) + pascal(total-1,n-1);
    }

    private int[][] getPascal(){
        List<int[]> pascal = new ArrayList<>();
        pascal.add(new int[]{1,0,0,0,0,0});
        pascal.add(new int[]{1,1,0,0,0,0});
        pascal.add(new int[]{1,2,1,0,0,0});
        pascal.add(new int[]{1,3,3,1,0,0});
        pascal.add(new int[]{1,4,6,4,1,0});
        pascal.add(new int[]{1,5,10,10,5,1});

        return pascal.toArray(new int[pascal.size()][]);
    }


    private int oldMethod(int m, int n){
        m = m-1; n = n-1;
        if(n > m){
            int tmp = m;
            m = n;
            n = tmp;
        }
        int totalMove = m+n;
        long numer = 1, denom = 1;
        for(int i = n; i>0 ; i--){
            numer = numer*totalMove;
            denom = denom*i;
            totalMove -=1;
        }

        return Long.valueOf(numer/denom).intValue();
    }
}
