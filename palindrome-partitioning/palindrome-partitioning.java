class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> al = new ArrayList<>();
        helper(s, ans, al);
        return ans;
    }
    public static void helper(String str, List<List<String>> ans, List<String> al) {
		if(str.length() == 0){
		    ans.add(new ArrayList<>(al));
		    return;
		}
		for(int i = 0 ; i < str.length() ; i++){
		    String pal = str.substring(0, i + 1);
		    if(isPalindrome(pal)){
		        String ros = str.substring(i + 1);
                al.add(pal);
		        helper(ros, ans, al);
                al.remove(al.size() - 1);
		    }
		}
		
	}
	public static boolean isPalindrome(String s){
	    int i = 0 ; 
	    int j = s.length() - 1;
	    while(i < j){
	        char a = s.charAt(i);
	        char b = s.charAt(j);
	        if(a != b) return false;
	        i++;
	        j--;
	    }
	    return true;
	}
}