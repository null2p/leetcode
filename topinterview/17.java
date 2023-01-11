class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length()==0){
            return result;
        }
        result.add("");
        
        List<String> alphabetList = getStringList(digits);

        for(String alphabets : alphabetList){
            List<String> tmp = new ArrayList<>();
            //tmp.add("");
            for(char c : alphabets.toCharArray()){
                for(String element : result){
                    element += c;
                    tmp.add(element);
                }
            }
            result = tmp;
        }
        
        return result;

    }

    private List<String> getStringList(String digits){
        List<String> phone = new ArrayList<>();
        phone.add("");
        phone.add("");
        phone.add("abc");
        phone.add("def");
        phone.add("ghi");
        phone.add("jkl");
        phone.add("mno");
        phone.add("pqrs");
        phone.add("tuv");
        phone.add("wxyz");

        List<String> result = new ArrayList<>();
        for(int i = 0 ; i < digits.length() ; i++){
            result.add(phone.get(Character.digit(digits.charAt(i),10)));
        }

        return result;
    }
}
