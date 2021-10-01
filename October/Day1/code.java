package Day1;

//Longest Common Subsequence Recursive method

class LCS{
    
    static int stringLength(String text1 , String text2, int m, int n)
    {
        if(m == 0 || n == 0) return 0;
        
        if(text1.charAt(m-1) == text2.charAt(n-1))
        {
            return 1 + stringLength(text1, text2, m-1, n-1);
        }
        else
        {
            return Math.max(stringLength(text1, text2, m-1, n), stringLength(text1, text2, m, n-1));
        }

    }
    static int longestCommonSubsequence(String text1, String text2) {
        
        int m = text1.length();
        int n = text2.length();

       return  stringLength(text1, text2, m, n);       
    }
}


//Delete without head pointer 
//https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1/?track=md-linkedlist&batchId=144

class Node
{
	int data ;
	Node next;
	Node(int d)
	{
		data = d;
		next = null;
	}
}

//Function to delete a node without any reference to head pointer.
class delNode
{
    void deleteNode(Node del)
    {
         del.data = del.next.data; //copy next element to the node to be delted 
         del.next = del.next.next; //point the node next to the element next to the node to be delted
    }                              // 2->3->4  ==>  2->4  when 3 is to be deleted
}

//https://practice.geeksforgeeks.org/problems/pairwise-swap-of-nodes-in-linkelist/1/?track=md-linkedlist&batchId=144
//Pairwise swap of nodes in LinkeList
//24. Swap Nodes in Pairs
//https://leetcode.com/problems/swap-nodes-in-pairs/submissions/

class Swap
{
    //Function to swap elements pairwise.
    public static Node pairwise_swap(Node node)
    {
        Node temp = new Node(0);
        temp.next = node;
        Node curr = temp;
        
        while(curr.next != null && curr.next.next != null)
        {
            Node firstNode = curr.next;
            Node secondNode = curr.next.next;
            firstNode.next = secondNode.next;
            curr.next = secondNode;
            curr.next.next = firstNode;
            curr = curr.next.next;
        }
        return temp.next;

        // //recursive method
        // if(head != null && head.next != null)
        // {
        //     int temp = head.val;
        //     head.val = head.next.val;
        //     head.next.val = temp;

        //     swapPairs(head.next.next);
        // }
        
        // return head;
    }   
}