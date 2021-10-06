package Day7;


//Partition a Linked List around a given value
//https://practice.geeksforgeeks.org/problems/partition-a-linked-list-around-a-given-value/1/?track=md-linkedlist&batchId=144#

// User function Template for Java
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}


class Solution {
    public static Node partition(Node node, int x) {
        
        Node afterHead = new Node(0);
        Node after = afterHead;
        Node equalHead = new Node(0);
        Node equal = equalHead;
        Node beforeHead = new Node(0);
        Node before = beforeHead;
        
        while(node != null)
        {
            if(node.data < x)
            {
                before.next = node;
                before = before.next;
            }
            else if(node.data == x)
            {
                equal.next = node;
                equal = equal.next;
            }
            else
            {
                after.next = node;
                after = after.next;
            }
            node = node.next;
        }
        
        if(equalHead.next != null)
        {
            before.next = equalHead.next;
            equal.next = afterHead.next;
        }
        else
        {
            before.next = afterHead.next;
        }
        after.next = null;
        
        return beforeHead.next;
    }
}