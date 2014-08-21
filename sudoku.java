/* Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
A partially filled sudoku which is valid.
Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.*/

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(9!=board.length ||9!=board[0].length)
            return false;
        HashSet<Character> record=new HashSet<Character>();
        //check row 
        for(int i=0;i<9;++i){
            for(int j=0;j<9;++j){
                if(board[i][j]!='.' && record.contains(board[i][j]))
                    return false;
                else
                    record.add(board[i][j]);
            }
            record.clear();
        }
        //check column 
        for(int i=0;i<9;++i){
            for(int j=0;j<9;++j){
                if(board[j][i]!='.' && record.contains(board[j][i]))
                    return false;
                else
                    record.add(board[j][i]);
            }
            record.clear();
        }
        //check 3*3 box
        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                for(int a=i;a<i+3;++a){
                    for(int b=j;b<j+3;++b){
                        if(board[a][b]!='.' && record.contains(board[a][b]))
                            return false;
                        else
                            record.add(board[a][b]);
                    }
                }
                record.clear();
            }
        }
        return true;
    }
}

/* Follow up:
Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.*/

public class Solution {
    public void solveSudoku(char[][] board) {
        if(null==board || 9!=board.length ||9!=board[0].length)
            return;
        helper(board,0,0);
    }
    public boolean helper(char[][] board,int i, int j){
        if(j>=9)
            return helper(board,i+1,0);
        if(9==i)
            return true;
        if(board[i][j]=='.'){
            for(int k=1;k<=9;++k){
                board[i][j]=(char)(k+'0');
                if(isValid(board,i,j)){
                    if(helper(board,i,j+1))
                        return true;
                }
                board[i][j]='.';
            }
        }
        else{
            return helper(board,i,j+1);
        }
        return false;
    }
    public boolean isValid(char[][] board, int i, int j){
        for(int k=0;k<9;++k){
            if(i!=k && board[i][j]==board[k][j])
                return false;
            if(j!=k && board[i][j]==board[i][k])
                return false;
        }
        for(int row=i/3*3;row<i/3*3+3;++row){
            for(int col=j/3*3;col<j/3*3+3;++col){
                if(row!=i && col!=j && board[row][col]==board[i][j])
                    return false;
            }
        }
        return true;
    }
}
