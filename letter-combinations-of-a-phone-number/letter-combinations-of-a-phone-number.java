class Solution {
    static String[] phone= {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0){
            return ans;
        }
        helper(digits, "", ans);
        return ans;
    }
    public static void helper(String s, String asf, List<String> ans){
        if(s.length() == 0){
            ans.add(asf);
            return;
        }
        char ch = s.charAt(0);
        String ros = s.substring(1);
        int indx = Integer.parseInt(String.valueOf(ch));
        String str = phone[indx - 2];
        for(int i = 0 ; i < str.length() ; i++){
            helper(ros, asf + str.charAt(i), ans);
        }
    }
}