class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] num = new int[2];
        int i = 0;
        int j = numbers.length - 1;
        while(i < j){
            if(numbers[i] + numbers[j] == target){
                num[0] = i + 1;
                num[1] = j + 1;
                break;
            }
            else if(target > numbers[i] + numbers[j])
                i++;
            else
                j--;
        }
        return num;
    }
}