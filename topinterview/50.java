class Solution {
    public double myPow(double x, int n) {
        double result = 1;
        x = n < 0 ? 1/x : x;
        n = n < 0 ? -n : n ;

        if(n==0||x==1){
            return 1;
        }

        while(n > 0){
            if(n % 2 == 1){
                result = result*x;
            }
            x = x*x;
            n = n>>1;
        }

        return result;
    }
}
