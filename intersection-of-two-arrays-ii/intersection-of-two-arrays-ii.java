class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1); // First sort the array
        Arrays.sort(nums2); // Similar this one as well
        
        int i = 0; // "i" will point at nums1
        int j = 0; // "j" will point at nums2
        int k = 0; // "k" will point at nums1 and helps in getting the intersection answer; 
        
        while(i < nums1.length && j < nums2.length){ // Loop will run until "i" & "j" doesn't reach the array boundary; 
            if(nums1[i] < nums2[j]){ // Check if nums1 value is less then nums2 value;
                i++; // Increment "i"
            }
            else if(nums1[i] > nums2[j]){ // Check if nums2 value is less then nums1 value;
                j++; // Increment "j"
            }
            else{ // Check if nums1 value is equals to nums2 value;
                nums1[k++] = nums1[i++]; // Dump into nums1 and increment k, increment i & increment j as well;
                j++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k); // Only return nums1 0th index to kth index value, because that's will be our intersection;
    }
}