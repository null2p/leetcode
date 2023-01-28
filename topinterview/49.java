class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> strMap = new HashMap<>();
        
        for(int i = 0; i< strs.length ; i++){

            String str = strs[i];
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String keyStr = String.valueOf(charArr);

            if(strMap.containsKey(keyStr)){
                strMap.get(keyStr).add(str);
            }
            else{
                strMap.put(keyStr,new ArrayList<>());
                strMap.get(keyStr).add(str);
            }
        }

        return new ArrayList<>(strMap.values());
    }
}
