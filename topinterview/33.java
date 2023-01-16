class Solution {
    public int search(int[] nums, int target) {
        
        return searchIndex(nums,target);
    }

    private int searchIndex(int[] nums, int target){
        int leftIdx = 0, rightIdx = nums.length-1;
        int midIdx = (rightIdx+leftIdx)/2;
        int result = -1;
        int leftVal = nums[leftIdx], rightVal = nums[rightIdx], midVal = nums[midIdx];

        if(target > rightVal && target<leftVal){
            return -1;
        }

        while(true){
            if(midVal == target){
                return midIdx;
            }
            if(rightVal == target){
                return rightIdx;
            }
            if(leftVal == target){
                return leftIdx;
            }

            // System.out.println("left:"+leftVal);
            // System.out.println("mid:"+midVal);
            // System.out.println("right:"+rightVal);

            if(midIdx == rightIdx && midIdx == leftIdx){
                break;
            }

            //한쪽은 무조건 정상적인 asending order이므로 그 쪽을 찾아서 비교한다
            boolean isAsendingMidToRight = isAscendingMidToRight(rightVal,midVal);

            if(isAsendingMidToRight){
                if(midVal<target && target < rightVal){
                    leftIdx = midIdx + 1;
                    midIdx = (leftIdx+rightIdx)/2;

                    if(leftIdx>rightIdx){
                       break;
                    }

                    leftVal = nums[leftIdx]; midVal = nums[midIdx]; rightVal = nums[rightIdx];                            
                }
                else{
                    rightIdx = midIdx - 1;
                    midIdx = (leftIdx+rightIdx)/2;

                    if(leftIdx>rightIdx){
                       break;
                    }

                    leftVal = nums[leftIdx]; midVal = nums[midIdx]; rightVal = nums[rightIdx];        
                }
            }
            else{
                if(target>leftVal && target < midVal){
                    rightIdx = midIdx - 1;
                    midIdx = (leftIdx+rightIdx)/2;

                    if(leftIdx>rightIdx){
                       break;
                    }

                    leftVal = nums[leftIdx]; midVal = nums[midIdx]; rightVal = nums[rightIdx];        
                }
                else{
                    leftIdx = midIdx + 1;
                    midIdx = (leftIdx+rightIdx)/2;
                    if(leftIdx>rightIdx){
                       break;
                    }

                    leftVal = nums[leftIdx]; midVal = nums[midIdx]; rightVal = nums[rightIdx];    
                }
            }
        }

        return -1;
    }

    private boolean isAscendingMidToRight(int rightVal, int midVal){
        if(rightVal > midVal){
            return true;
        }
        else{
            return false;
        }
    }

    
}
