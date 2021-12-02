class Solution {
    
    public String countAndSay(int n) {
        //store compressed version for each integer upto n 
        String[] memo = new String[n];
        
        //base case i.e. countAndSay equivalent of n = 1
        memo[0] = "1";
        
		//for each i < n, we compute the compressed version of i - 1
        for(int i=1; i<n; i++){
            memo[i] = compress(memo[i-1].toCharArray());
        }
        
        return memo[n-1];
    }
    
    //build the compressed string
    public String compress(char[] c){
        int count = 1;
        StringBuilder ans = new StringBuilder();
        
        for(int i=1; i<c.length; i++){
            if(c[i] == c[i-1]){
                count++;
            }else{
                ans.append(count).append(c[i-1]);
                count = 1;
            }
        }
        
        ans.append(count).append(c[c.length-1]);
        return ans.toString();
    }
}