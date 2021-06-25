class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> s = new ArrayList<Integer>();
        for(int i = 0; i < nums1.length; i++)
            s.add(nums1[i]);
        for(int i = 0; i < nums2.length; i++)
            s.add(nums2[i]);
        Collections.sort(s);
        int size = s.size();
        if(size%2!=0){
            int sz = size/2;
            double val = (double)(s.get(sz));
            return val;
        }
        else{
             int sz = size/2;
             int add = s.get(sz)+s.get(sz-1);
             double val = (double)add/2;
                return val;
        }
        
    }
}