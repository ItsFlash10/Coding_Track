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