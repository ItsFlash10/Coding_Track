package Day11;
import java.util.*;

//232. Implement Queue using Stacks
//https://leetcode.com/problems/implement-queue-using-stacks/

class MyQueue {
    
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public MyQueue() {
        
    }

    public void push(int x) {
        while(!s1.isEmpty())
        {
            s2.push(s1.pop());
        }
        
        s1.push(x);
        
        while(!s2.isEmpty())
        {
            s1.push(s2.pop());   
        }
    }

    public int pop() {
        return s1.pop();                
    }

    public int peek() {
        return s1.peek();        
    }

    public boolean empty() {
        if(s1.size() == 0)
        {
            return true;
        }
        return false;
    }
}

//Next Permutation
//https://practice.geeksforgeeks.org/problems/next-permutation5226/1

class nextPerm{
    static List<Integer> nextPermutation(int N, int arr[]){
        
        ArrayList<Integer> res = new ArrayList<>();
        int pivotIdx = findPivot(arr) - 1;
        if(pivotIdx != -1)
        {
            int nextGreaterEleIdx = idxOfNxtGrEle(arr, arr[pivotIdx]);
            swap(arr, pivotIdx, nextGreaterEleIdx);
        }
        reverse(arr, pivotIdx+1);
        
        for(int i = 0; i < arr.length; i++)
        {
            res.add(arr[i]);
        }
        return res;
        
    }
    
    static int idxOfNxtGrEle(int[] arr, int n)
    {
        for(int i = arr.length-1; i>=0; i--)
        {
            if(arr[i] > n)
            {
                return i;
            }
        }
        return -1;
    }
    
    static int findPivot(int[] arr)
    {
        for(int i = arr.length-1; i > 0; i--)
        {
            if(arr[i] > arr[i-1])
            {
                return i;
            }
        }
        return 0;
    }
    
    static void swap(int[] arr, int a, int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    static void reverse(int[] arr, int start)
    {
        int end = arr.length - 1;
        
        while(start < end)
        {
            swap(arr, start++, end--);
        }
    }
}