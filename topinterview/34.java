class Solution {
    public int[] searchRange(int[] nums, int target) {
        int size = nums.length;
        int[] result = {-1,-1};
        result[0] = findLeftTarget(nums,target);
        result[1] = findRightTarget(nums,target);

        return result;
    }

    private int findLeftTarget(int[] nums, int target){
        int size = nums.length;
        int result = -1;
        if(size == 0){
            return result;
        }
        int left = 0, right = size-1, mid = (left+right)/2;
        
        while(left <= right){
            mid = (left+right)/2;
            if(nums[mid] == target){
                result = mid;
            }

            if(nums[mid] >= target){
                right = mid -1;
            }
            else{
                left = mid + 1;
            }
        }

        return result;
    }
    private int findRightTarget(int[] nums, int target){
        int size = nums.length;
        int result = -1;
        if(size == 0){
            return result;
        }
        int left = 0, right = size-1, mid = (left+right)/2;
        
        while(left <= right){
            mid = (left+right)/2;
            if(nums[mid] == target){
                result = mid;
            }

            if(nums[mid] > target){
                right = mid -1;
            }
            else{
                left = mid + 1;
            }
        }

        return result;
    }
}
