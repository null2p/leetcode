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
        int left = 0, right = 0, tCount = 0;
        String result = "";
        int resultSize = s.length();

        for(int i = 0 ; i < s.length() ; i++){
            Character sChar = s.charAt(i);
            if(tMap.get(sChar) == null){
                continue;
            }
            else{
                tIdx.add(i);

                //init left
                if(tCount == 0){
                    left = i;
                    // tCount += 1;
                    tIdx.remove(0);
                }

                //exclude duplicated counting
                if(tMap.get(sChar) > 0){
                    tCount+=1;
                    tMap.put(sChar,tMap.remove(sChar)-1 );
                    //if it is, set the location of right cursor
                    if(tCount >= tSize){
                        right = i;

                        //if the size of substring is min, get result String 
                        if(right - left + 1 <= resultSize){
                            result = s.substring(left,right+1);
                            // System.out.println(result);
                        }
                        //reset tMap key, value which is based on left cursor
                        tMap.put(s.charAt(left),tMap.remove(s.charAt(left))+1);
                        if(tIdx.size()>0){
                            left = tIdx.remove(0);
                        }

                        tCount-=1;
                    }
                }
                else if(tMap.get(sChar)==0){ // if we met duplicated sChar, reset left cursor
                    if( s.charAt(tIdx.get(0)) != sChar){
                        left = tIdx.remove(0);
                    }
                    else{
                        tIdx.remove(0);
                        left = i;
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
