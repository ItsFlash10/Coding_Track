package Day13;
import java.util.*;

//Flattening a Linked List
//https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/0/?track=md-linkedlist&batchId=144

// Node class  used in the program
class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}

class GfG
{
    Node flatten(Node root)
    {
        if(root == null || root.next == null) return root;
        
        //recu to reach the last node
        root.next = flatten(root.next);
        
        //merge
        root = mergeLL(root, root.next);
        
        return root;
        
    }
    
    Node mergeLL(Node l1, Node l2)
    {
        Node temp = new Node(0);
        Node res = temp;
        
        while(l1 != null && l2 != null)
        {
            if(l1.data < l2.data)
            {
                temp.bottom = l1;
                temp = temp.bottom;
                l1 = l1.bottom;
            }
            else
            {
                temp.bottom = l2;
                temp = temp.bottom;
                l2 = l2.bottom;
            }
        }
        if(l1 != null) temp.bottom = l1;
        else temp.bottom = l2;
        return res.bottom;
    }
}

//54. Spiral Matrix
//https://leetcode.com/problems/spiral-matrix/

class spiralPrint{
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        ArrayList<Integer> res = new ArrayList<>();
        
        int top = 0;
        int down = n-1;
        int left = 0;
        int right = m-1;
        
        int dir = 0;  //this wil give the direction of progress
        
        while(right >= left  && top <= down)
        {
            if(dir == 0)  //left to right
            {
                for(int i = left; i<=right; i++)
                {
                    res.add(matrix[top][i]);                    
                }
                top++;
            }
            else if(dir == 1) //top to bottom 
            {
                for(int i = top; i<=down; i++)
                {
                    res.add(matrix[i][right]);                    
                }
                right--;
            }
            else if(dir == 2) //right to left
            {
                for(int i = right; i>=left; i--)
                {
                    res.add(matrix[down][i]);                    
                }
                down--;
            }
            else if(dir == 3) //bottom to up
            {
                for(int i = down; i>=top; i--)
                {
                    res.add(matrix[i][left]);                    
                }
                left++;
            }
            dir = (dir+1)%4; //point to remember for changing direction
        }
        return res;  
    }
}

//25. Reverse Nodes in k-Group
//https://leetcode.com/problems/reverse-nodes-in-k-group/submissions/

//Definition for singly-linked list.
 class ListNode
 {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class revKGrp{
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head == null || k == 1) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode curr = dummy;
        ListNode nex = dummy;
        
        int count = 0;
        
        while(curr.next != null)
        {
            curr = curr.next;
            count++;
        }
        
        while(count >= k)
        {
            curr = prev.next;
            nex = curr.next;
                
            for(int i = 1; i<k; i++)
            {
                curr.next = nex.next;
                nex.next = prev.next;
                prev.next = nex;
                nex = curr.next;
            }
            count -= k;
            prev = curr;
        }
        return dummy.next;
    }
}
