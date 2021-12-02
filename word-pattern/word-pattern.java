class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        String[] sarr = s.split("\\s");
        if(pattern.length() != sarr.length)
            return false;
        for(int i = 0 ; i < pattern.length() ; i++){
            char ch = pattern.charAt(i);
            if(map.containsKey(ch)){
                if(map.get(ch).equals(sarr[i]))
                   continue;
                else
                   return false;
            }
            else{
                if(map.containsValue(sarr[i]))
                    return false;
                map.put(ch, sarr[i]);
            }
        }
        return true;
    }
}