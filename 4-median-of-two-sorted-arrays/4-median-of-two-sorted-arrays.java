class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        int n1 = a.length ; 
        int n2 = b.length ;
        if(n1 > n2){
            int[] temp = a;
            a = b;
            b = temp;
            
            int temp2 = n1;
            n1 = n2;
            n2 = temp2;
        }
        int lo = 0;
        int hi = n1;
        int te = n1 + n2;
        while(lo <= hi){
            int ali = lo + (hi - lo) / 2;
            int bli = (te + 1) / 2 - ali;
            int alm1 = ali == 0 ? Integer.MIN_VALUE : a[ali - 1];
            int al = ali == n1 ? Integer.MAX_VALUE : a[ali];
            int blm1 = bli == 0 ? Integer.MIN_VALUE : b[bli - 1];
            int bl = bli == n2 ? Integer.MAX_VALUE : b[bli];
            
            if(alm1 <= bl && blm1 <= al){
                double median = 0.0;
                if(te % 2 == 0){
                    median = (Math.max(alm1, blm1) + Math.min(al, bl)) / 2.0;
                }
                else{
                    median = Math.max(alm1, blm1);
                }
                return median;
            }
            else if(blm1 > al){
                lo = ali + 1;
            }
            else{
                hi = ali - 1;
            }
        }
        return 0.0;
    }
}