class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] nsr = new int[heights.length];
        int[] nsl = new int[heights.length];
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = heights.length - 1 ; i >= 0 ; i--){
            
            // pop all greater elements
            while(st.size() > 0 && heights[st.peek()]>=heights[i])
                st.pop();
            
            // update ans
            if(st.size() == 0)
                nsr[i] = heights.length;
            else
                nsr[i] = st.peek();
            
            // push curr idx in stack
            st.push(i);
        }
        st = new Stack<>();
        for(int i = 0 ; i <= heights.length - 1 ; i++){
            
            // pop all greater elements
            while(st.size() > 0 && heights[st.peek()]>=heights[i])
                st.pop();
            
            // update ans
            if(st.size() == 0)
                nsl[i] = -1;
            else
                nsl[i] = st.peek();
            
            // push curr idx in stack
            st.push(i);
        }
        
        int ans = 0;
        for(int i = 0 ; i <= heights.length - 1 ; i++){
            ans = Math.max(ans, heights[i]*(nsr[i]-nsl[i]-1));
        }
        
        return ans;
        
    }
}