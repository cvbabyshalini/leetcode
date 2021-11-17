class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> l = new ArrayList<>();
        helper(n, 0, 0, "", l);
        return l;
    }
    public static void helper(int n, int open, int close, String s, List<String> l){
        if(open == n && close == n){
            l.add(s);
            return;
        }
        if(open < n){
            helper(n, open + 1, close, s + "(", l);
        }
        if(close < open){
            helper(n, open, close + 1, s + ")", l);
        }
    }
}