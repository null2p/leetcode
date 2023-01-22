class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();
        getSubset(result, tmpList, nums, 0);
        return result;
    }

    private void getSubset(List<List<Integer>> result, List<Integer> tmpList, int[] nums, int start){
        result.add(new ArrayList<>(tmpList));
        System.out.println(tmpList);
        for(int i = start; i < nums.length; i++){
            tmpList.add(nums[i]);
            getSubset(result, tmpList, nums, i+1);
            tmpList.remove(tmpList.size()-1);
        }
    }
}
