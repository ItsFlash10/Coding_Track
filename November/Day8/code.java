package Day8;

//96. Unique Binary Search Trees
//https://leetcode.com/problems/unique-binary-search-trees/

class catTreeSol{
    public int numTrees(int n) 
    {        
        return catalanCalc(n);
    }
    
    //Catalan Calculator (utility fxn)[Using DP]
    int catalanCalc(int n)
    {
        int catalan[] = new int[n+1];
        catalan[0] = catalan[1] = 1;
        
        for(int i=2;i<=n;++i)
        {
            catalan[i] = 0;
            for(int j=0;j<i;++j)
                catalan[i] += catalan[j]*catalan[i-j-1];
        }
        return catalan[n];    
    }
}
