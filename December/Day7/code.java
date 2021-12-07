package Day7;

//1290. Convert Binary Number in a Linked List to Integer
//https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class decToIntLL {
    public int getDecimalValue(ListNode head) {
        int ans=0;
        while(head!=null)
        {
            ans=2*ans+head.val;
            head=head.next;
        }
        return ans;
    }
}
