package Day2;
import java.util.*;

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

//350. Intersection of Two Arrays II
//https://leetcode.com/problems/intersection-of-two-arrays-ii/

class intrsecEle {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        //Alternately we can use "Arrays.copyOfRange(nums1, 0, k)" 
        //by adding the result in the first array it self basically using the 1st arrray 
        //as we stored it in the hashmap already. It'll save extra space used by the ArrayList
        ArrayList<Integer> temp = new ArrayList<>();   
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i<nums1.length; i++)
        {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0)+1);
        }
        
        for(int i = 0; i<nums2.length; i++)
        {
            if(map.containsKey(nums2[i]))
            {
                temp.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i])-1);
                if(map.get(nums2[i]) == 0)
                {
                    map.remove(nums2[i]);                    
                }
            }
        }
        
        int[] res = new int[temp.size()];
        int idx = 0;
        for(int i = 0; i<temp.size(); i++)
        {
            res[idx++] = temp.get(i);
        }
        return res;
    }
}