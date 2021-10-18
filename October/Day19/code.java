package Day19;

//191. Number of 1 Bits
//https://leetcode.com/problems/number-of-1-bits/

class answer{
    public int hammingWeight(int n) {
        
        int ones = 0;
        
        while(n!=0)
        {
            ones += n & 1;
            n = n >>> 1;
        }
        return ones;
    }
}

//190. Reverse Bits
//https://leetcode.com/problems/reverse-bits/submissions/

class revBits{
    public int reverseBits(int n) {
        
        int rev=0;
        
        for(int i=0;i<32;i++)
        {
            rev= (rev << 1) | (n & 1);         
            n = n >> 1;                  
        }
        return rev;
    }
}

//136. Single Number
//https://leetcode.com/problems/single-number/submissions/

class XORforDuplicate{
    public int singleNumber(int[] nums) {
        
        int res = 0;
        
        for(int ele : nums)
        {
            res = res^ele;
        }
        
        return res;        
    }
}

//116. Populating Next Right Pointers in Each Node
//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/submissions/

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};


class popRight{
    public Node connect(Node root) {
        
        Node black = root;
        
        while(black != null && black.left != null)
        {
            Node dummy = black;
            
            while(true)
            {
                dummy.left.next = dummy.right;
                
                if(dummy.next == null) break;
                
                dummy.right.next = dummy.next.left;
                
                dummy = dummy.next;
            }
            black = black.left;
        }
        return root;
    }
}