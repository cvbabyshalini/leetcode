class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] arr = new int[nums.length-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0 ; i < k ; i++){
            
            // if last ele in deque is less than nums[i] then remove
            while(dq.size() > 0 && nums[dq.getLast()] < nums[i])
                dq.removeLast();
            
            dq.addLast(i);
        }
        arr[0] = nums[dq.getFirst()];
        int m = 1;
        for(int i = k ; i < nums.length ; i++){
            
            // if last ele in deque is less than nums[i] then remove
            while(dq.size() > 0 && nums[dq.getLast()] < nums[i])
                dq.removeLast();
            
            dq.addLast(i);
            
            // if 1st ele in deque is not in the curr slide then remove
            if(dq.getFirst() <= i-k)
                dq.removeFirst();
            
            arr[m] = nums[dq.getFirst()];
            m++;
        }
        return arr;
    }
}