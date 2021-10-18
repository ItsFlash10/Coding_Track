package Day18;

//733. Flood Fill
//https://leetcode.com/problems/flood-fill/

class fillFlood{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image[sr][sc] == newColor) return image;
        
        int rows = image.length;
        int cols = image[0].length;
        int source = image[sr][sc];
        
        dfs(image, sr, sc, newColor, rows, cols, source);
        
        return image;
    }
    
    void dfs(int[][] image, int sr, int sc, int newColor, int rows, int cols, int source)
    {
        if(sr<0 || sr >= rows || sc < 0 || sc >= cols) return;
        
        else if(image[sr][sc] != source) return;
        
        image[sr][sc] = newColor;
        
        //top
        dfs(image, sr-1, sc, newColor, rows, cols, source);
        //right
        dfs(image, sr, sc+1, newColor, rows, cols, source);
        //down
        dfs(image, sr+1, sc, newColor, rows, cols, source);
        //left
        dfs(image, sr, sc-1, newColor, rows, cols, source);
    }
}
