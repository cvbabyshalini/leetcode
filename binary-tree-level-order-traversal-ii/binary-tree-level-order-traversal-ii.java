/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> l = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        if(root == null){
            return l;
        }
        q.add(root);
        while(q.size()>0){
            int sz = q.size();
            for(int i = 1; i <= sz; i++){
                TreeNode rn = q.remove();
                al.add(rn.val);
                if(rn.left!=null)
                    q.add(rn.left);
                if(rn.right!=null)
                    q.add(rn.right);
            }
            l.add(al);
            al = new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = l.size()-1;i>=0;i--){
            ans.add(l.get(i));
        }
        return ans;
    }
}