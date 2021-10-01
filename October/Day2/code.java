package Day2;

//234. Palindrome Linked List
//https://leetcode.com/problems/palindrome-linked-list/

//Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public boolean isPalindrome(ListNode head) {
        
        if(head == null || head.next == null)  return true;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null) //.next and .next.next used insted of head and head.next
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slow.next = reverseList(slow.next);
        
        slow = slow.next;
        
        while(slow != null)
        {
            if(head.val != slow.val)
            {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
        
        
    }
    ListNode reverseList(ListNode head)
    {
        ListNode newHead = null;
        
        while(head != null)
        {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
