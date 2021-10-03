package Day3;
import java.util.*;

//55. Jump Game(Daily Challenege)
//https://leetcode.com/problems/jump-game/

class jumpGame{
    public boolean canJump(int[] nums) {
        int maxReachable = nums[0];
        
        for(int i = 0; i<nums.length; i++)
        {
            if(maxReachable < i)
            {
                return false;
            }
            maxReachable = Math.max(maxReachable, i+nums[i]);
        }
        return true;
    }
}

//566. Reshape the Matrix
//https://leetcode.com/problems/reshape-the-matrix/

class reshapeMatrix{
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        
        int row = mat.length;
        int col = mat[0].length;
        
        if((row*col) != (r*c)) return mat;
 
        int res[][] = new int[r][c];
        int rowNum = 0;
        int colNum = 0;
     
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                res[rowNum][colNum] = mat[i][j];
                colNum++;
                if(colNum == c)
                {
                    colNum = 0;
                    rowNum++;
                }
            }
        }
        return res; 
    }
}

//118. Pascal's Triangle
//https://leetcode.com/problems/pascals-triangle/submissions/

class pascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        
        ArrayList<List<Integer>> res = new ArrayList<>();
        
        for(int i = 0; i<numRows; i++)
        {
            ArrayList<Integer> ans = new ArrayList<>();
            for(int j = 0; j<=i; j++)
            { 
                if(j == 0 || j == i)
                {
                    ans.add(1);
                }
                else
                {
                    ans.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
                }
            }
            res.add(ans);
        }
        return res;
    }
}

//Detect Loop in linked list
//https://practice.geeksforgeeks.org/problems/detect-loop-in-linked-list/1/?track=md-linkedlist&batchId=144

//Node is defined as
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

class loopcheck{
    public static boolean detectLoop(Node head){
        
        //Optimised  //intution: nodeA(fast) -> nodeB (slow) 
        //[Take any positions, the pointers will ulitmately come as mentioned after certain iteration] 
        Node slow = head;
        Node fast = head;
        
        while(fast.next != null && fast.next.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            
            if(fast == slow)
            {
                return true;
            }
        }
        return false;
        
        
        // //Brute Force
        // HashSet<Node> set = new HashSet<>();
        
        // Node dummy = new Node(0);
        // dummy.next = head;
        // while(dummy!=null)
        // {
        //     if(!set.contains(dummy))
        //     {
        //         set.add(dummy);
        //     }
        //     else
        //     {
        //         return true;
        //     }
        //     dummy = dummy.next;
        // }
        // return false;
    }
}

//Remove loop in Linked List
//https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1/?track=md-linkedlist&batchId=144

class rmv
{
    //Function to remove a loop in the linked list.
    public static void removeLoop(Node node){
        
        if (node == null || node.next == null)
            return;

        Node slow = node, fast = node;

        slow = slow.next;
        fast = fast.next.next;

        while (fast != null && fast.next != null) 
        {
            if (slow == fast)
                break;

            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow == fast) 
        {
            slow = node;
            if (slow != fast) 
            {
                while (slow.next != fast.next) 
                {
                    slow = slow.next;
                    fast = fast.next;
                }
                fast.next = null; 
            }
            else 
            {
                while(fast.next != slow) 
                {
                    fast = fast.next;
                }
                fast.next = null;
            }
        }
    }
}