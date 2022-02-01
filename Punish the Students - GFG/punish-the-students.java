// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            double avg = sc.nextDouble ();
            int[] roll = new int[n];
            int[] marks = new int[n];
            
            for (int i = 0; i < n; ++i)
                roll[i] = sc.nextInt ();
                
            for (int i = 0; i < n; ++i)
                marks[i] = sc.nextInt ();

    		System.out.println (new Solution().shouldPunish (roll, marks, n, avg));
        }
        
    }
}

// Contributed By: Pranay Bansal// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int shouldPunish (int arr[], int marks[], int n, double avg)
    {
        int count = 0;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    count += 2;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
        
        int sum = 0;
        for(int val : marks)
            sum += val;
        double newAvg = (sum - count) / arr.length;
        if(newAvg >= avg)
            return 1;
        else
            return 0;
    }
}