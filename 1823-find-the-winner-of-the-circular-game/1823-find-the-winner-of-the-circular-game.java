class Solution {
    public static int solution(int n, int k){
        if(n == 1)
            return 0;
        int y = solution(n - 1, k);
        int x = (y + k) % n;
        return x;
    }
    public int findTheWinner(int n, int k) {
        return solution(n, k) + 1;
    }
}