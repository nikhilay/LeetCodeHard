import java.util.LinkedList;
import java.util.List;

/**
 * Created by Nikhil on 12/24/16.
 */

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate
 * a queen and an empty space respectively.
 */
public class NQueens {

    class Position {
        int row;
        int col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new LinkedList<>();
        if (n == 0) return result;
        Position[] positions = new Position[n];
        solveNQueens(0, n, positions, result);
        return result;
    }

    private void solveNQueens(int row, int totalQueens, Position[] positions, List<List<String>> result) {
        if (row == totalQueens) {
            List<String> list = new LinkedList<>();
            for (int r = 0; r < totalQueens; r++) {
                StringBuilder sb = new StringBuilder();
                for (int c = 0; c < totalQueens; c++) {
                    if (positions[r].row == r && positions[r].col == c) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            result.add(list);
            return;
        }

        for (int col = 0; col < positions.length; col++) {
            boolean isItSafe = true;
            for (int queen = 0; queen < row; queen++) {
                if (positions[queen].col == col || positions[queen].row - positions[queen].col == row - col
                        || positions[queen].row + positions[queen].col == row + col) {
                    isItSafe = false;
                    break;
                }

            }

            if (isItSafe) {
                positions[row] = new Position(row, col);
                solveNQueens(row + 1, totalQueens, positions, result);
            }

        }
    }
}
