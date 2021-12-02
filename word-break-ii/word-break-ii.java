class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        helper(s, "", ans, wordDict);
        return ans;
    }
    public static void helper(String str, String asf, List<String> ans, List<String> dict){
        if(str.length() == 0){
		    ans.add(asf.substring(0, asf.length() - 1));
		    return;
		}
		for(int i = 0 ; i < str.length() ; i++){
		    String pal = str.substring(0, i + 1);
		    if(dict.contains(pal)){
		        String ros = str.substring(i + 1);
		        helper(ros, asf + pal + " ", ans, dict);
		    }
		}
    }
}