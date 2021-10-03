class Solution {
    public int rob_sp(int[] nums){
	// Regular House Robber Solution Code
        int N = nums.length;
        if(N==1){
            return nums[0];
        }
        if(N==2){
            return nums[1]>nums[0]?nums[1]:nums[0];
        }
        if(N==3){
            return nums[1]>(nums[0]+nums[2])?nums[1]:(nums[0]+nums[2]);
        }
        else{
            int dp[] = new int[N];
            dp[0] = nums[0];
            dp[1] = nums[1];
            dp[2] = nums[0]+nums[2];
            for(int i=3; i<N; i++){
                if(dp[i-2]>dp[i-3]){
                    dp[i] = dp[i-2]+nums[i];
                }else{
                    dp[i] = dp[i-3]+nums[i];
                }
            }
            return (dp[N-1]>dp[N-2])?dp[N-1]:dp[N-2];
        }
    }
    
    public int rob(int[] nums) {
      int N = nums.length;
        if(N<=3){
            int max = -999999;
            for(int i=0; i<N; i++){
                max = nums[i]>max?nums[i]:max;
            }
            return max;
        }
        else{
		//finding the regular solution for 2 different set of houses
            int arr1[] = Arrays.copyOfRange(nums, 0, N-1);
            int arr2[] = Arrays.copyOfRange(nums, 1, N);
            int res1 = rob_sp(arr1);
            int res2 = rob_sp(arr2);
			//finding the max between them
            return res1>res2?res1:res2;
			//this is the final result
        } 
    }
}