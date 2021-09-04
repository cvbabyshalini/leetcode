class Solution {
    private static int dipIndex(char[] arr){
        int idx = arr.length - 2;
        while(idx >= 0 && arr[idx] >= arr[idx + 1]){
            idx--;
        }
        return idx;
    }
    private static int ceilIndex(char[] arr, int idx){
        for(int i = arr.length - 1; i >=0; i--){
            if(arr[i] > arr[idx]){
                return i;
            }
        }
        return -1;
    }
    private static void swap(char[] arr, int left, int right){
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
    private static void reverse(char[] arr, int idx){
        int left = idx;
        int right = arr.length - 1;
        while(left < right){
            swap(arr, left, right);
            left++;
            right--;
        }
    }
    public static String nextGreaterElement_(String str){
        if(str.length() == 1){
            return "-1";
        }
        char[] arr = str.toCharArray();
        int dipIdx = dipIndex(arr);
        if(dipIdx == -1){
            return "-1";
        }
        int ceilIdx = ceilIndex(arr, dipIdx);
        swap(arr, dipIdx, ceilIdx);
        reverse(arr, dipIdx + 1);
        return String.valueOf(arr);
    }
    public int nextGreaterElement(int n) {
        String str = n + "";
        String ans = nextGreaterElement_(str);
        
        long res = Long.parseLong(ans);
        if(res <= Integer.MAX_VALUE){
            return (int)res;
        }
        else{
            return -1;
        }
    }
}