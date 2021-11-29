package Day29;
import java.util.*;
  
//721. Accounts Merge
//https://leetcode.com/problems/accounts-merge/

class anSolGrphUnionFind {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        Map<String, String> owners = new HashMap<>();
        Map<String, String> parents = new HashMap<>();
        Map<String, TreeSet<String>> unions = new HashMap<>(); //use treemap here simply because the question requires the emails are returned in sorted order
        
        //init each email's parent to be itself
        for (List<String> account: accounts) 
        {
            for (int i = 1; i<account.size(); i++) 
            {
                String owner = account.get(0);
                String email = account.get(i);
                parents.put(email, email);
                owners.put(email, owner);
            }
        }
        
        //union each account's parent to be the first one in the list
        for (List<String> account: accounts) 
        {
            String p1 = find(parents, account.get(1));
            
            for (int i = 2; i<account.size(); i++) 
            {
                String p2 = find(parents, account.get(i));
                //union
                parents.put(p2, p1);
            }
        }
        
        //now combine the union sets
        for (List<String> account: accounts) 
        {
            String p1 = find(parents, account.get(1));
            
            if (!unions.containsKey(p1)) 
            {
                unions.put(p1, new TreeSet<>());
            }
            
            Set<String> emailSets = unions.get(p1);
            
            for (int i = 1; i<account.size(); i++) 
            {
                emailSets.add(account.get(i));
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        
        for (String p : unions.keySet()) 
        {
            List<String> emails = new ArrayList(unions.get(p));
            emails.add(0, owners.get(p));
            res.add(emails);
        }
        
        return res;
    }
    
    //find
    public String find(Map<String, String> parents, String node) 
    {
        while (!parents.get(node).equals(node)) 
        {
            parents.put(node, parents.get(parents.get(node))); //path compression
            node = parents.get(node);
        }
        return node;
    }
}
