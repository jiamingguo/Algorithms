package Medium.DesignTicTacToe_348;

public class TicTacToe {
    // there's a stupid version, on GitHub...very straight forward thought

    int[] rows, cols;
    int diagonal, antiDiagonal;
    int n;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.rows = new int[n];
        this.cols = new int[n];
        this.n = n;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int add = player==1?1:-1;
        rows[row] += add;
        cols[col] += add;

        if (row == col){
            diagonal += add;
        }

        if (row + col == n-1){
            antiDiagonal += add;
        }

        if (Math.abs(rows[row]) == n ||
                Math.abs(cols[col]) == n ||
                Math.abs(diagonal) == n ||
                Math.abs(antiDiagonal) == n
                ) {
            return player;
        } else {
            return 0;
        }

    }

}