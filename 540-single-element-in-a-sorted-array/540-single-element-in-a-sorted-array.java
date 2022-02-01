class Solution {
    public int singleNonDuplicate(int[] arr) {
        int res = 0;
    int lo = 0 ; 
    int hi = arr.length - 1;
    while(lo <= hi){
        int mid = lo + (hi - lo) / 2;
        if(mid == 0 || mid == arr.length - 1){
            return arr[mid];
        }
        if(arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]){
            res = arr[mid];
            break;
        }
        else if(arr[mid] == arr[mid + 1]){
            if((hi - mid + 1) % 2 == 0){
                hi = mid - 1;
            }
            else{
                lo = mid;
            }
        }
        else{
            if((mid - lo + 1) % 2 == 0){
                lo = mid + 1;
            }
            else{
                hi = mid;
            }
        }
    }
    return res;
    }
}