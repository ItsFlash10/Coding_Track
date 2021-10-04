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