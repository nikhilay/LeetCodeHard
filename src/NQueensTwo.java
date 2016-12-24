

/**
 * Created by Nikhil on 12/24/16.
 */

/**
 * Follow up for N-Queens problem.
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 */
public class NQueensTwo {
    class Position {
        int row;
        int col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    int ways = 0;

    public int totalNQueens(int n) {
        ;
        if (n == 0) return 0;
        Position[] positions = new Position[n];
        solveNQueens(0, n, positions);
        return ways;
    }

    private void solveNQueens(int row, int totalQueens, Position[] positions) {
        if (row == totalQueens) {
            ways++;
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
                solveNQueens(row + 1, totalQueens, positions);
            }

        }
    }
}
