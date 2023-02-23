class Solution {
    public String minWindow(String s, String t) {
        if(s.length() == t.length()){
            if(s.equals(t)){
                return s;
            };
        }
        else if(s.length() < t.length()){
            return "";
        }

        Map<Character,Integer> tMap = makeMap(t);

        List<Integer> tIdx = new ArrayList<>();
        int tSize = t.length();

        int left = 0, right = s.length(), tCount = 0;
        
        String result = "";
        int resultSize = s.length();

        for(int i = 0 ; i < s.length() ; i++){
            Character sChar = s.charAt(i);
            // System.out.println("s : "+sChar+", idx :"+i);

            if(tMap.get(sChar) == null){
                continue;
            }
            else{
                tIdx.add(i);

                //init left
                if(tCount == 0){
                    // System.out.println("INIT");
                    left = i;
                    tIdx.remove(0);
                }

                if(tMap.get(sChar) != null){

                    if(tMap.get(sChar)>0){
                        tCount+=1;
                    }
                    
                    if(right == i){
                        tIdx.remove(tIdx.size()-1);
                    }
                    else{
                        tMap.put(sChar,tMap.remove(sChar)-1);
                    }
                    //if it satisfies substring, set the location of right cursor
                    if(tCount == tSize){
                        right = i;

                        //if the size of substring is min, get result String 
                        if(right - left + 1 <= resultSize){
                            result = s.substring(left,right+1);
                            resultSize = right - left + 1;
                            // System.out.println("new result : "+result);
                        }
                        //reset tMap(key, value) on left cursor
                        // System.out.print("reset Left : "+s.charAt(left)+" at "+left);

                        tMap.put(s.charAt(left),tMap.remove(s.charAt(left))+1);

                        // System.out.print("(tMap value : "+tMap.get(s.charAt(left))+")");

                        if(tMap.get(s.charAt(left)) >= 1){
                            tCount-=1;
                        }
                        else{
                            // System.out.print("!i is restored!");
                            i-=1;
                        }
                        
                        if(tIdx.size()>0){
                            left = tIdx.remove(0);
                            // System.out.print(" ---> new Left :"+s.charAt(left)+" at "+left);
                            // System.out.println("(tMap value : "+tMap.get(s.charAt(left))+")");

                        }

                        // System.out.println("------tMap-----");
                        // System.out.print(" a.get : "+tMap.get('a'));
                        // System.out.print(", c.get : "+tMap.get('c'));
                        // System.out.println(", e.get : "+tMap.get('e'));
                        // System.out.println("---------------");
                    }

                }
            }
        }
        
        return result;
    }
    private Map<Character,Integer> makeMap(String t){
        Map<Character,Integer> tMap = new HashMap<>();
        for(int i = 0 ; i < t.length(); i++){
            if(tMap.get(t.charAt(i))==null){
                tMap.put(t.charAt(i),1);
            }
            else{
                tMap.put(t.charAt(i),tMap.remove(t.charAt(i))+1);
            }
        }
        return tMap;
    }
}
