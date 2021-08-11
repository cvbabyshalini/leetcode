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
    public static int height(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(height(root.left),height(root.right))+1;
    }
    public static boolean helper(TreeNode root){
        if(root == null){
            return true;
        }
        return (helper(root.left) && helper(root.right) && Math.abs(height(root.left)-height(root.right))<=1);
    }
    public boolean isBalanced(TreeNode root) {
        return helper(root);
    }
}