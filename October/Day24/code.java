package Day24;

//222. Count Complete Tree Nodes
//https://leetcode.com/problems/count-complete-tree-nodes/


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

class totalNodes {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        //left extreme call from the current root
        int leftLevel = 1;
        TreeNode l = root.left;
        
        while(l != null)
        {
            l = l.left;
            leftLevel++;
        }
        //right extreme call from the current root
        int rightLevel = 1;
        TreeNode r = root.right;
        
        while(r != null)
        {
            r = r.right;
            rightLevel++;
        }
        //since nodes = (2^No. of levels) - 1
        if(leftLevel == rightLevel) return (int)Math.pow(2, leftLevel) -1;
        
        return 1+countNodes(root.left)+countNodes(root.right);  
    }
}
