package Day22;

//450. Delete Node in a BST
//https://leetcode.com/problems/delete-node-in-a-bst/

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

class TreeSolBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root == null) return null;
        
        if(key > root.val)
        {
            root.right = deleteNode(root.right, key);
        }
        
        else if(key < root.val)
        {
            root.left = deleteNode(root.left, key);
        }
        
        else
        {
            if(root.left != null && root.right != null)
            {
                int leftMax = max(root.left);
                root.val = leftMax;
                root.left = deleteNode(root.left, leftMax);
                return root;
            }
            else if(root.left != null)
            {
                return root.left;                
            }
            else if(root.right != null)
            {
                return root.right;                
            }
            else
            {
                return null;
            }
        }
        return root;
    }
    public static int max(TreeNode node)
    {
        if(node.right != null)
        {
            return max(node.right);
        }
        else
        {
            return node.val;
        }
    }
}