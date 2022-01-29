// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]arr,int n, int m) {
    if(m > arr.length)
        return -1;
    int sum = 0;
    int max = Integer.MIN_VALUE;
    for(int val : arr){
        sum += val;
        max = Math.max(val, max);
    }
    int lo = max;
    int hi = sum;
    int burden = Integer.MAX_VALUE;
    while(lo <= hi){
        int mid = lo + (hi - lo) / 2;
        if(isBurdenPossible(arr, mid, m) == true){
            burden = mid;
            hi = mid - 1;
        }
        else{
            lo = mid + 1;
        }
    }
    return burden;
  }
  private static boolean isBurdenPossible(int[] pages, int burden, int m){
    int student = 1;
    int sum = 0;
    for(int i = 0 ; i < pages.length ; i++){
        sum += pages[i];
        if(sum > burden){
            student++;
            sum = pages[i];
        }
    }
    return student <= m;
  }
};