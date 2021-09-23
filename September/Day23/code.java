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