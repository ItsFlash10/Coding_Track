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

//104. Maximum Depth of Binary Tree
//https://leetcode.com/problems/maximum-depth-of-binary-tree/

class depthOfBST{
    public int maxDepth(TreeNode root) {
        
        if(root == null) return 0; //no.of nodes at leaf
        
        int leftTreeDepth = maxDepth(root.left);
        int rightTreeDepth = maxDepth(root.right);
        
        return Math.max(leftTreeDepth, rightTreeDepth) + 1;
    }
}

//111. Minimum Depth of Binary Tree
//https://leetcode.com/problems/minimum-depth-of-binary-tree/

class minDepOfBST {
    public int minDepth(TreeNode root) {
        
        if(root == null) return 0;
	    
	    int leftDepth = minDepth(root.left);
	    int rightDepth = minDepth(root.right);
	    
        //checking for skew binary tree, i.e., jab ek hi side ho saare nodes
	    if(leftDepth == 0 || rightDepth == 0) return Math.max(leftDepth, rightDepth) + 1;
	    
	    return Math.min(leftDepth, rightDepth) + 1;
    }
}

//14. Longest Common Prefix
//https://leetcode.com/problems/longest-common-prefix/


class prefixFinding{
    public String longestCommonPrefix(String[] strs) {
        
        String prefix = "";
        
        prefix = strs[0];
        
        for(int i = 1; i<strs.length; i++)
        {
            while(strs[i].indexOf(prefix) != 0)
            {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;        
    }
}
