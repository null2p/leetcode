class Solution {
    public void sortColors(int[] nums) {
        Map<Integer,Integer> colorMap = new HashMap<>();

        for(int num : nums){
            if(colorMap.get(num)==null){
                colorMap.put(num,1);
            }
            else{
                colorMap.put(num, colorMap.remove(num)+1);
            }
        }
        int zeroIdx = colorMap.get(0) == null ? 0 : colorMap.get(0);
        int oneIdx = (colorMap.get(1) == null ? 0 : colorMap.get(1)) + zeroIdx;
        int twoIdx = (colorMap.get(2) == null ? 0 : colorMap.get(2)) + oneIdx;

        for(int i = 0; i < zeroIdx ; i++){
            nums[i] = 0;
        }
        for(int i = zeroIdx; i < oneIdx ; i++){
            nums[i] = 1;
        }
        for(int i = oneIdx; i < twoIdx ; i++){
            nums[i] = 2;
        }
    }
}
