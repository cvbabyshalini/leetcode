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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> al = new ArrayList<>();
        inorder(root, al);
        if(k > al.size() || k < 0)
            return -1;
        return al.get(k - 1);
    }
    public void inorder(TreeNode node, ArrayList<Integer> ans){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            ans.add(node.val);
            return;
        }
        inorder(node.left, ans);
        ans.add(node.val);
        inorder(node.right, ans);
    }
}