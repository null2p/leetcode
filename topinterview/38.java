class Solution {
    public List<String> countList = new ArrayList<>();

    public String countAndSay(int n) {
        countList.add("1");
        countList.add("11");
        countList.add("21");
        countList.add("1211");

        if(countList.size() >= n){
            return countList.get(n-1);
        }
        else{
            for(int i = countList.size()-1; i <= n-2 ; i++){
                String nextResult = sayPrevResult(countList.get(i));
                countList.add(nextResult);
            }
        }
        return countList.get(n-1);
    }

    private String sayPrevResult(String prevResult){
        Character prevChar = prevResult.charAt(0);
        int count = 1;
        String result = "";

        for(int i = 1; i < prevResult.length() ; i++){
            Character charElement = prevResult.charAt(i);
            if(charElement == prevChar){
                count += 1;
            }
            else {
                result += String.valueOf(count) + prevChar.toString();
                count = 1;
            }
            
            if( i == prevResult.length() - 1){
                result += String.valueOf(count) + charElement.toString();
            }
            prevChar = charElement;
        }

        return result;
    }
}
