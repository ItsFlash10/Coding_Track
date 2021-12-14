//938. Range Sum of BST

class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        
          if (root == null)
        	return 0;
        int val = 0, left = 0, right = 0;
        if (root.val >= low && root.val <= high)
            val = root.val;
        if (root.val > low)
        	left = rangeSumBST(root.left, low, high);
        if (root.val < high)
        	right = rangeSumBST(root.right, low, high);
        return val + left + right;
        
    }
}
