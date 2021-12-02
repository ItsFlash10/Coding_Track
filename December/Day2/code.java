package Day2;

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
 
class odEvLL {
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
