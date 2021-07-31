class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int i = 0 ;
        int j = 0;
        int[] idx = new int[nums1.length];
        while(i<nums1.length && j<nums2.length){
            if(nums1[i] == nums2[j]){
                idx[i] = j ;
                i++;
                j = 0;
            }
            else
                j++;
        }
        int nge[] = new int[nums2.length];
        Stack<Integer> st = new Stack<>();
        for(int k = nums2.length - 1 ; k >= 0 ; k--){
            while(st.size()>0 && st.peek()<nums2[k])
                    st.pop();
            if(st.size()==0)
                nge[k] = -1;
            else
                nge[k] = st.peek();
            st.push(nums2[k]);
        }
        for(int l = 0 ; l < idx.length ; l++){
            int k = idx[l];
            idx[l] = nge[k];
        }
        return idx;
        
    }
}