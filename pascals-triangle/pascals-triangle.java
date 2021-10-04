class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for(int rowindex = 0; rowindex < numRows; rowindex++){
            List<Integer> l = new ArrayList<>();
            long val = 1;
            for(int i = 0; i <= rowindex ; i++){
                l.add((int)val);
                val = val * (rowindex-i)/(i + 1);
            }
            list.add(l);
        }
        return list;
    }
}