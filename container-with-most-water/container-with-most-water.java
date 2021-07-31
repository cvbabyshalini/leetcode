class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n-1;
        int max = 0;
        while(left < right){
            int leftH = height[left];
            int rightH = height[right];
            int minHeight = Math.min(leftH , rightH);
            max = Math.max(max , minHeight*(right-left));
            
            if(leftH < rightH){
                left++;
            }
            else
                right--;
        }
        return max;
        
    }
}