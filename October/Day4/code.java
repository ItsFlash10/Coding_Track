package Day4;
import java.util.*;

//36. Valid Sudoku
//https://leetcode.com/problems/valid-sudoku/

class validateSudoku {
    public boolean isValidSudoku(char[][] board) {
        
        HashSet<String> set = new HashSet<>();
        
        for(int row = 0; row<9; row++)
        {
            for(int col = 0; col<9; col++)
            {
                if(board[row][col] != '.')
                {
                    //check for row
                    if(!set.add("row"+row+board[row][col])) return false;
                    //check for col
                    if(!set.add("col"+col+board[row][col])) return false;
                    //check for box posi
                    if(!set.add("box"+ row/3 +col/3+board[row][col])) return false;
                }
            }
        }
        return true;
    }
}

//328. Odd Even Linked List
//https://leetcode.com/problems/odd-even-linked-list/


//Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class rearrange {
    public ListNode oddEvenList(ListNode head) {
        
        if(head == null) return head; //boundary case
        
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode even = head.next;
        
        while(evenHead != null && evenHead.next != null)
        {
            oddHead.next = oddHead.next.next;
            evenHead.next = evenHead.next.next;
            oddHead = oddHead.next;
            evenHead = evenHead.next;
        }
        oddHead.next = even;
    
        return head;       
    }
}

//463. Island Perimeter
//https://leetcode.com/problems/island-perimeter/

class calcPerim{
    public int islandPerimeter(int[][] grid) {
        
        int perimeter = 0;
        
        for(int i = 0; i<grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 1)
                {
                    perimeter += 4;
                    
                    if(i > 0 && grid[i-1][j] == 1) perimeter -= 2;
                    
                    if(j > 0 && grid[i][j-1] == 1) perimeter -= 2;
                }
            }
        }
        return perimeter;
    }
}

//148. Sort List
//https://leetcode.com/problems/sort-list/

class Solution {
    public ListNode sortList(ListNode head) {
        
        if(head == null || head.next == null) return head;
        
        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null)
        {
            temp = slow;     
            slow = slow.next;
            fast = fast.next.next;
        }
        temp.next = null;
        
        ListNode lsh = sortList(head);
        ListNode rsh = sortList(slow);
        
        return merge(lsh, rsh);
    }
    
    static ListNode merge(ListNode l1, ListNode l2)
    {
        ListNode sortedTmp = new ListNode(0);
        ListNode curr = sortedTmp;
        
        while(l1 != null && l2 != null)
        {
            if(l1.val < l2.val)
            {
                curr.next = l1;
                l1 = l1.next;
            }
            else
            {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        
        if(l1 != null)
        {
            curr.next = l1;
            l1 = l1.next;
        }
        
        if(l2 != null)
        {
            curr.next = l2;
            l2 = l2.next;
        }
        
        return sortedTmp.next;
    }
}