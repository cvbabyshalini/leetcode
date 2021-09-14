class Solution {
    public List<Integer> getRow(int rowindex) {
        List<Integer> l = new ArrayList<>();
        long val = 1;
        for(int i = 0; i <= rowindex ; i++){
           l.add((int)val);
            val = val * (rowindex-i)/(i + 1);
        }
        return l;
    }
}