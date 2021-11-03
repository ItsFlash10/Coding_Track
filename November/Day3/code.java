package Day3;

//129. Sum Root to Leaf Numbers
//https://leetcode.com/problems/sum-root-to-leaf-numbers/


//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { 
        this.val = val; 
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    
    int res = 0; //global varaible
    
    public int sumNumbers(TreeNode root) {
        
        if(root == null) return 0;
        
        DFS(root, 0);
        
        return res;   
    }
    
    void DFS(TreeNode root, int currVal)
    {
        if(root == null) return;
        
        currVal = currVal * 10 + root.val;
        
        if(root.left == null && root.right == null)
        {
            res += currVal;
            return;
        }
        
        DFS(root.left, currVal);
        DFS(root.right, currVal);
    }
}