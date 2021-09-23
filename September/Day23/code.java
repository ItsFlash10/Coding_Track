package Day23;

//node for linked list
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

//Add two numbers represented by linked lists
//https://practice.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/0/?track=md-linkedlist&batchId=144


class Solution{
    static Node reverseList(Node head)
    {
        Node newHead = null;
        
        while(head != null)
        {
            Node next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;  
    }
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second){
        
        Node res = new Node(0);
        Node temp = res;
        int carry = 0;
        first = reverseList(first);
        second = reverseList(second);
        
        while(first != null || second != null || carry == 1)
        {
            int sum = 0;
            if(first != null)
            {
                sum += first.data;
                first = first.next;
            }
            
            if(second != null)
            {
                sum += second.data;
                second = second.next;
            }
            
            sum += carry;
            carry = sum/10;
            Node node = new Node(sum%10);
            temp.next = node;
            temp = temp.next;
        }
        return reverseList(res.next);
    }
}

//Reverse a linked list
//https://practice.geeksforgeeks.org/problems/reverse-a-linked-list/1/?track=md-linkedlist&batchId=144

class revLL
{
    //Function to reverse a linked list.
    Node reverseList(Node head)
    {
        Node newHead = null;
        
        while(head != null)
        {
            Node next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;  
    }
}

//Finding middle element in a linked list
//https://practice.geeksforgeeks.org/problems/finding-middle-element-in-a-linked-list/1#

class middleEle
{
    int getMiddle(Node head)
    {
         Node slow = head;
         Node fast = head;
         
         while(fast != null && fast.next != null)
         {
             slow = slow.next;
             fast = fast.next.next;
         }
         
         return slow.data;
    }
}

//Merge two sorted linked lists
//https://practice.geeksforgeeks.org/problems/merge-two-sorted-linked-lists/1/?track=md-linkedlist&batchId=144

class LinkedList
{
    //Function to merge two sorted linked list.
    Node sortedMerge(Node head1, Node head2) {
        
        if(head1 == null) return head2;
        if(head2 == null) return head1;
        
        if(head1.data > head2.data)
        {
            Node temp = head1;
            head1 = head2;
            head2 = temp;
        }
        
        Node res = head1;
        while(head1 != null && head2 != null)
        {
            Node temp = null;
            while(head1 != null && head1.data <= head2.data)
            {
                temp = head1;
                head1 = head1.next;
            }
            temp.next = head2;
            
            //swap
            Node tmp = head1;
            head1 = head2;
            head2 = tmp;
        }
        return res;
   } 
}