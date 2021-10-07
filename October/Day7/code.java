package Day7;
import java.util.*;

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

//13. Roman to Integer
//https://leetcode.com/problems/roman-to-integer/

class romToInt{
    public int romanToInt(String s) {
        
        int res  = 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        for(int i = 0; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            
            if(ch == 'V' || ch =='X')
            {
                if(i > 0 && s.charAt(i-1) == 'I')
                {
                    res -= 2;
                }
            }
            
            if(ch == 'L' || ch =='C')
            {
                if(i > 0 && s.charAt(i-1) == 'X')
                {
                    res -= 20;
                }
            }
            
            if(ch == 'D' || ch =='M')
            {
                if(i > 0 && s.charAt(i-1) == 'C')
                {
                    res -= 200;
                }
            }
            
            res += map.get(ch);
        }
        return res;
        
    }
}

//61. Rotate List
//https://leetcode.com/problems/rotate-list/submissions/

//Definition for singly-linked list.
 class ListNode{
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

class rotateLL{
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head == null || head.next == null || k == 0) return head;
        
        int len = 1;
        ListNode temp = head;
        while(temp.next != null)
        {
            len++;
            temp = temp.next;
        }
        
        k = k % len;
        k = len - k;
        
        temp.next = head;
        while(k-- > 0) temp = temp.next;
        
        head = temp.next;
        temp.next = null;
        
        return head;
    }
}

//83. Remove Duplicates from Sorted List
//https://leetcode.com/problems/remove-duplicates-from-sorted-list/

class delDup{
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode curr = head;
        
        while(curr != null && curr.next != null)
        {
            if(curr.val == curr.next.val)
            {
                curr.next = curr.next.next;                                
            }
            else
            {
                curr = curr.next;
            }
        }
        return head;        
    }
}