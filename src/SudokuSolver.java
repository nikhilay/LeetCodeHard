/**
 * Created by Nikhil on 1/30/17.
 */


/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'.
 * You may assume that there will be only one unique solution.
 */

/**
 * Inspired from
 *https://discuss.leetcode.com/topic/11327/straight-forward-java-solution-using-backtracking/2
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        solve(board);
    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValidBoard(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }

        }
        return true;
    }

    private boolean isValidBoard(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] != '.' && board[row][i] == c) return false;
            if (board[i][col] != '.' && board[i][col] == c) return false;
            if (board[(3 * (row / 3)) + i / 3][(3 * (col / 3)) + i % 3] != '.' && board[(3 * (row / 3)) + i / 3][(3 * (col / 3)) + i % 3] == c)
                return false;
        }
        return true;

    }
}
