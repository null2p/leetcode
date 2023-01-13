class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        String tmp = "(";
        result.add(tmp);
        leftList.add(1);
        rightList.add(0);

        for(int i = 1; i < 2*n ; i++){
            List<String> tmpResult = new ArrayList<>();
            List<Integer> tmpLeft = new ArrayList<>();
            List<Integer> tmpRight = new ArrayList<>();

            int j = 0;
            for(String element : result){
                int left = leftList.get(j);
                int right = rightList.get(j);                 
                String tmpElement;

                // System.out.println(element);
                // System.out.println(left);
                // System.out.println(right);

                if(left<n){
                    tmpElement = element + "(";
                    tmpResult.add(tmpElement);
                    tmpLeft.add(left + 1);
                    tmpRight.add(right);
                }

                if( left > right && right <n ){
                    tmpElement = element + ")";
                    tmpResult.add(tmpElement);
                    tmpLeft.add(left);
                    tmpRight.add(right + 1);
                }
                j+=1;
            }
            result = tmpResult;
            leftList = tmpLeft;
            rightList = tmpRight;
        }
        return result;
    }
}
