package Day9;
import java.util.*;

//1178. Number of Valid Words for Each Puzzle
//https://leetcode.com/problems/number-of-valid-words-for-each-puzzle/

class ltHard {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        
        for(int i = 0; i<26; i++)
        {
            map.put((char)('a' + i), new ArrayList<>());
        }
        
        for(String word : words)
        {
            int mask = 0;
            
            for(char ch : word.toCharArray())
            {
                int bit = ch - 'a';
                mask = mask | ((1<<bit));
            }
            
            HashSet<Character> unique = new HashSet<>();
            for(char ch : word.toCharArray())
            {
                if(unique.contains(ch)) continue;
                
                unique.add(ch);
                map.get(ch).add(mask);
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        
        for(String puzzle : puzzles)
        {
            int pMask = 0;
            
            for(char ch : puzzle.toCharArray())
            {
                int bit = ch - 'a';
                pMask = pMask | ((1<<bit));
            }
            
            char firstCh = puzzle.charAt(0);
            ArrayList<Integer> wordsToCheck = map.get(firstCh);
            int count = 0;
            
            for(int wMask : wordsToCheck)
            {
                if((wMask & pMask) == wMask) count++;
            }
            
            res.add(count);
        }
        return res;           
    }
}