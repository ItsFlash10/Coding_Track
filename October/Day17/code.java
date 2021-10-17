package Day17;
import java.util.*;

//437. Path Sum III
//https://leetcode.com/problems/path-sum-iii/submissions/

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

class countTree{
    int count = 0;
    ArrayList<Integer> list = new ArrayList<>();
    public int pathSum(TreeNode root, int sum) {
        
        getSum(root, sum);
        return count;
    }
    
    public void getSum(TreeNode root, int sum)
    {
        if(root == null) return;
        
        list.add(root.val);
        
        getSum(root.left, sum);
        getSum(root.right, sum);
        
        int temp = 0;
        
        for(int i = list.size() - 1; i >= 0; i--)
        {
            temp += list.get(i);
            if(temp == sum)
            {
                count++;                
            }
        }
        list.remove(list.size()-1);
    }
}