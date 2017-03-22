package Medium.DesignTicTacToe_348;

/**
 * Created by gjm19_000 on 3/22/2017.
 */
public class DesignTicTacToe_348 {
    char [][] board;
    char [] chessPiece = new char[]{'X','O'};
    int status = 0;
    int n;
    /** Initialize your data structure here. */
    public DesignTicTacToe_348(int n) {
        this.board = new char[n][n];
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
        if (status == 0){
            board[row][col] = chessPiece[player-1];
        }

        status = checkStatus();

        return status;

    }

    public int checkStatus(){
        char start = 'a';
        int count = 0;

        // scan rows
        for (int i=0;i<n;i++){
            count = 0;
            for (int j=0;j<n;j++){
                if (j==0){
                    start = board[i][j];
                } else{
                    if (board[i][j] == start && (start=='X'||start=='O')){
                        count++;
                    } else {
                        break;
                    }
                }
            }
            if (count == n-1){
                if (start == 'X'){
                    return 1;
                } else {
                    return 2;
                }
            }
        }

        // scan columns
        for (int i=0;i<n;i++){
            count = 0;
            for (int j=0;j<n;j++){
                if (j==0){
                    start = board[j][i];
                } else{
                    if (board[j][i] == start && (start=='X'||start=='O')){
                        count++;
                    } else {
                        break;
                    }
                }
            }
            if (count == n-1){
                if (start == 'X'){
                    return 1;
                } else {
                    return 2;
                }
            }
        }

        // scan diagonal 1
        count = 0;
        for (int i=0,j=0;i<n;i++, j++){
            if (i==0){
                start = board[i][j];
            } else{
                if (board[j][i] == start && (start=='X'||start=='O')){
                    count++;
                } else {
                    break;
                }
            }
        }
        if (count == n-1){
            if (start == 'X'){
                return 1;
            } else {
                return 2;
            }
        }

        // scan diagonal 2
        count = 0;

        for (int i=n-1,j=0;j<n;i--, j++){
            if (j==0){
                start = board[i][j];
            } else{
                if (board[i][j] == start && (start=='X'||start=='O')){
                    count++;
                } else {
                    break;
                }
            }
        }
        if (count == n-1){
            if (start == 'X'){
                return 1;
            } else {
                return 2;
            }
        }

        return 0;
    }
}
