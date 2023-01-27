class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> idxSet = new HashSet<>();
        List<Integer> intList = new ArrayList<>();
        getPermute(nums,idxSet,intList, result);
        return result;
    }

    private void getPermute(int[] nums, Set<Integer> idxSet, List<Integer> intList, List<List<Integer>> result){
        
        if(intList.size() == nums.length){
            result.add(new ArrayList<>(intList));
            return ;
        }

        for(int i = 0; i<nums.length; i++){
            if(idxSet.contains(nums[i])){
                continue;
            }
            else{
                idxSet.add(nums[i]);
                intList.add(nums[i]);
                getPermute(nums, idxSet,intList,result);
                idxSet.remove(nums[i]);
                intList.remove(intList.size()-1);
            }
        }
    }
}
