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
        if(root == null) 
            return 0;
        return Math.max(height(root.left),height(root.right))+1;
    }
    public static int diameterHelper(TreeNode root){
        if(root == null) 
            return 0;
        int left_maxdia = diameterHelper(root.left);
        int right_maxdia = diameterHelper(root.right);
        int myAns = height(root.left)+height(root.right)+1;
        return Math.max(myAns,Math.max(left_maxdia,right_maxdia));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return diameterHelper(root)-1;
    }
}