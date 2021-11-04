package Day4;

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

//404. Sum of Left Leaves
//https://leetcode.com/problems/sum-of-left-leaves/

class leafSum {
    public int sumOfLeftLeaves(TreeNode root) {
        
        if(root == null) return 0;
        
        if(root.left != null && root.left.left == null && root.left.right == null)
        {
            return root.left.val + sumOfLeftLeaves(root.right);
        }
        
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
