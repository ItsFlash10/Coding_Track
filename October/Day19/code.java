package Day19;
import java.util.*;

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

//542. 01 Matrix
//https://leetcode.com/problems/01-matrix/

class sol{
    public int[][] updateMatrix(int[][] mat) {
        
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i = 0; i<mat.length; i++)
        {
            for(int j = 0; j<mat[0].length; j++)
            {
                if(mat[i][j] == 0)
                {
                    queue.add(new int[]{i,j});
                }
                    
                else
                {
                    mat[i][j] = -1;
                }
            }
        }
        
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        
        int dis = 0;
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            dis++;
            
            while(size-- > 0)
            {
                int[] cell = queue.poll();
                
                for(int[] dir : dirs)
                {
                    int r = cell[0] + dir[0];
                    int c = cell[1] + dir[1];
                    
                    if(r<0 || c<0 || r==mat.length || c ==mat[0].length || mat[r][c] != -1)
                        continue;
                    
                    mat[r][c] = dis;
                    queue.add(new int[] {r,c});
                }
            }
        }
        return mat;        
    }
}

//994. Rotting Oranges
//https://leetcode.com/problems/rotting-oranges/submissions/

class rottenOranges {
    public int orangesRotting(int[][] grid) {
        
        if(grid == null || grid.length == 0) return -1;
        
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i = 0; i<rows; i++)
        {
            for(int j = 0; j<cols; j++)
            {
                if(grid[i][j] == 2)
                {
                    DFSOranges(grid, i, j, rows, cols, 2);
                }
            }
        }
        int minutes = 2;
        
        for(int[] ro : grid)
        {
            for(int cell : ro)
            {
                if(cell == 1) return -1;
                
                minutes = Math.max(minutes, cell);
            }
        }
        
        
        return minutes - 2;
    }
    
    void DFSOranges(int[][] grid, int i, int j, int rows, int cols, int mins)
    {
        if(i<0 || j<0 || i>= rows || j>=cols || (1 < grid[i][j] && grid[i][j] < mins) || grid[i][j] == 0) return;
        
        grid[i][j] = mins;
        
        DFSOranges(grid, i+1, j, rows, cols, mins + 1);
        DFSOranges(grid, i-1, j, rows, cols, mins + 1);
        DFSOranges(grid, i, j+1, rows, cols, mins + 1);
        DFSOranges(grid, i, j-1, rows, cols, mins + 1);
    }   
}

//77. Combinations
//https://leetcode.com/problems/combinations/

class generateSubS{
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> subsets = new ArrayList<>();
        
        genSubsets(subsets, new ArrayList<Integer>(), 1, n, k);
        return subsets;
    }
    
    void genSubsets(List<List<Integer>> subsets, ArrayList<Integer>current , int start, int n, int k)
    {
        if(k==0) 
        {
			subsets.add(new ArrayList<Integer>(current));
			return;
		}
        
		for(int i=start;i<=n;i++) 
        {
			current.add(i);
			genSubsets(subsets, current, i+1, n, k-1);
			current.remove(current.size()-1);
        }
    }
}

//198. House Robber
//https://leetcode.com/problems/house-robber/submissions/

class houseRobber {
    public int rob(int[] nums) {
        
        if(nums.length == 0) return 0;
        
        int[] dp = new int[nums.length+1];
        
        dp[0] = 0;
        dp[1] = nums[0];
        
        for(int i = 1; i<nums.length; i++)
        {
            dp[i+1] = Math.max(dp[i], dp[i-1] + nums[i]);
        }
        
        return dp[nums.length];
    }
}

//496. Next Greater Element I
//https://leetcode.com/problems/next-greater-element-i/submissions/

class NGRinDifffArray {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int[] res = new int[nums1.length];
        int idx = 0;
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums2)
        {
            while(!st.isEmpty() && st.peek() < num)
            {
                map.put(st.pop(), num); // MAP: (Num, its NGR)
            }
            st.push(num);
        }
        
        for(int num : nums1)
        {
            res[idx++] = map.getOrDefault(num, -1);            
        }
        return res;
    }
}

//169. Majority Element
//https://leetcode.com/problems/majority-element/submissions/

class majorEle {
    public int majorityElement(int[] nums) {
        
        int element = 0;
        int count = 0;
        
        for(int i = 0; i<nums.length; i++)
        {
            if(count == 0)
            {
                element = nums[i];
            }
            
            if(nums[i] == element)
            {
                count++;
            }
            else 
            {
                count--;
            }
        }
        return element;
    }
}