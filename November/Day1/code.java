package Day1;

//130. Surrounded Regions
//https://leetcode.com/problems/surrounded-regions/

class surRegions {
    public void solve(char[][] board) {

        if(board.length==0)return;
        
        int rows = board.length;
        int cols = board[0].length;
     
        for(int i = 0; i < cols; i++)
        {
            DFS(board, 0, i, rows, cols);//for first row
            DFS(board, rows-1, i, rows, cols);//for last row
        }
        
        for(int i=0;i<rows;i++)
        {
            DFS(board, i, 0, rows, cols);//for first col
            DFS(board, i, cols-1, rows, cols);//for last col
        }
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++)
                if(board[i][j] == 'O')board[i][j] = 'X';
                else if(board[i][j] == 'P')board[i][j] = 'O';
                
    }
    
    void DFS(char[][] board, int r, int c, int rsize, int csize)
    {        
        if(r<0||c<0||r==rsize||c==csize||board[r][c]!='O')return;
        
        board[r][c] = 'P';
        
        DFS(board, r+1, c, rsize, csize);
        DFS(board, r, c+1, rsize, csize);
        DFS(board, r-1, c, rsize, csize);
        DFS(board, r, c-1, rsize, csize);
    }
}
