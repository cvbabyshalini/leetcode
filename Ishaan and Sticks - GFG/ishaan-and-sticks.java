// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Complete obj = new Complete();
		    ArrayList<Integer> ans;
		    ans = obj.square(arr, sizeOfArray);
		    for(int i: ans)
		        System.out.print(i + " ");
		    System.out.println();
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Complete{
    
   
    // Function for finding maximum and value pair
    public static ArrayList<Integer> square (int arr[], int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
    for(int val : arr){
        map.put(val, map.getOrDefault(val, 0) + 1);
    }
    int count = 0;
    int maxArea = 0;
    int dup = 0;
    for(int val : map.keySet()){
        if(map.get(val) >= 4){
            dup = maxArea;
            maxArea = Math.max(maxArea, val * val);
            if(dup != maxArea){
                count = 0;
                while(map.get(val) >= 4){
                count++;
                map.put(val, map.get(val) - 4);
                }
            }
        }
    }
    ArrayList<Integer> al = new ArrayList<>();
    if(maxArea == 0){
        al.add(-1);
        return al;
    }
    al.add(maxArea);
    al.add(count);
    return al;
    }
    
    
}


