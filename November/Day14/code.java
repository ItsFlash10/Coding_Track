package Day14;

//1286. Iterator for Combination
//https://leetcode.com/problems/iterator-for-combination/

class CombinationIterator 
{

    PriorityQueue<String> pq = new PriorityQueue<>();
    public CombinationIterator(String characters, int combinationLength) 
    {
        generateComb(characters, combinationLength, 0, new StringBuilder());
    }
    
    public String next() 
    {
        return pq.poll();
    }
    
    public boolean hasNext() 
    {
        return !pq.isEmpty();
    }
    private void generateComb(String ch, int len, int st, StringBuilder sb)
    {
        if(len == 0)
        {
            pq.add(sb.toString());
            return;
        }
        for(int i=st; i<=ch.length()-len; i++)
        {
            sb.append(ch.charAt(i));
            generateComb(ch, len-1, i+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
