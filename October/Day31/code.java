package Day31;

//430. Flatten a Multilevel Doubly Linked List
//https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/

// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};


class Solution {
    public Node flatten(Node head) {
        Node curr = head;
        while(curr!=null){
            if(curr.child != null){
                Node tail = findTail(curr.child);
                if(curr.next != null){
                    curr.next.prev=tail;
                }
                
                tail.next = curr.next;
                curr.next =curr.child;
                curr.child.prev = curr;
                curr.child =null;
            }
            curr = curr.next;
        }
        return head;
    }
    
    public Node findTail(Node child){
        while(child.next != null){
            child=child.next;
        }
        return child;
    }
}