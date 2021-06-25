class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        else{
            int rev = 0;
            int y = x;
            while(x!=0){
                int r = x%10;
                rev = rev*10 + r;
                x = x/10;
            }
            if(rev==y)
                return true;
            else
                return false;
        }
      
        
    }
}