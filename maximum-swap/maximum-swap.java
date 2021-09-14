class Solution {
    public static void swap(char[] arr, int i , int index){
        char temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
    }
    public int maximumSwap(int n) {
        String num = n + "";
        char[] arr = num.toCharArray();
        int[] lastIndexOfDigit = new int[10];
        
        // travel and fill lastIndexOfDigit array
        for(int i = 0 ; i < arr.length ; i++){
            lastIndexOfDigit[arr[i] - '0'] = i;
        }
        
        // travel and find swapping point
        for(int i = 0 ; i < arr.length ; i++){
            int digit = arr[i] - '0';
            int index = i ; 
            for(int j = 9 ; j > digit ; j--){
                if(lastIndexOfDigit[j] > i){
                    index = lastIndexOfDigit[j];
                    break;
                }
            }
            if(index != i){
                swap(arr, i, index);
                break;
            }
        }
        num = String.valueOf(arr);
        return Integer.parseInt(num);
    }
}