class Solution {
    public String largestNumber(int[] nums) {
    String[] sarr = new String[nums.length];
    for(int i = 0 ; i < nums.length ; i++){
        sarr[i] = "" + nums[i];
    }
    Arrays.sort(sarr, (a, b) -> {
        long d1 = Long.parseLong(a + b);
        long d2 = Long.parseLong(b + a);
        if(d1 > d2)
            return 1;
        else if(d1 < d2)
            return -1;
        else
            return 0;
    });
    StringBuilder res = new StringBuilder();
    for(int i = sarr.length - 1 ; i >= 0 ; i--){
        res.append(sarr[i]);
    }
    String ans = res.toString();
    return ans.charAt(0) == '0' ? "0" : ans;
    }
}