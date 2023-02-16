class Solution {
    public boolean canJump(int[] nums) {
        int numSize = nums.length;
        boolean[] dp = new boolean[numSize];
        return travel(nums,dp,0);
    }

    private boolean travel(int[] nums, boolean[] dp, int i){
        int maxJump = nums[i];
        dp[i] = true;
        if(i==nums.length -1){
            return true;
        }

        for(int jump = 1; jump <= maxJump; jump ++){
            if (i+jump >= nums.length){
                return false;
            }

            if ( dp[i+jump] == false){
                if(travel(nums, dp, i+jump)){
                    return true;
                }
            }
        }

        return false;
    }
}
