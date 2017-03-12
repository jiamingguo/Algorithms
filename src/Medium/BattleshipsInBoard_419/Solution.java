package Medium.BattleshipsInBoard_419;

/**
 * Created by gjm19_000 on 3/11/2017.
 */
public class Solution {
    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;

        // go through the whole chess board
        // find the top-left 'X' of each ship
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(board[i][j]=='X'){
                    if (i>0&&board[i-1][j]=='X') continue;
                    if (j>0&&board[i][j-1]=='X') continue;
                    count++;
                }
            }
        }

        return count;
    }
}
