class Solution {
    public List<Integer> lexicalOrder(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 1 ; i <= 9 ; i++){
            printlex(i, n , ans);
        }
        return ans;
    }
    public static void printlex(int i , int n , ArrayList<Integer> ans){
        if(i > n){
            return;
        }
        ans.add(i);
        for(int j = 0 ; j <= 9 ; j++){
            printlex(i * 10 + j, n, ans);
        }
    }
}