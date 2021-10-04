package Day4;
import java.util.*;

//36. Valid Sudoku
//https://leetcode.com/problems/valid-sudoku/

class validateSudoku {
    public boolean isValidSudoku(char[][] board) {
        
        HashSet<String> set = new HashSet<>();
        
        for(int row = 0; row<9; row++)
        {
            for(int col = 0; col<9; col++)
            {
                if(board[row][col] != '.')
                {
                    //check for row
                    if(!set.add("row"+row+board[row][col])) return false;
                    //check for col
                    if(!set.add("col"+col+board[row][col])) return false;
                    //check for box posi
                    if(!set.add("box"+ row/3 +col/3+board[row][col])) return false;
                }
            }
        }
        return true;
    }
}