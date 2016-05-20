package test.pro.board;

import test.pro.GameMain;

/**
 * Created by lekhr on 18.05.2016.
 */
public class Board {


    static public char[][] board = {
            {'*', '*', '*'},
            {'*', '*', '*'},
            {'*', '*', '*'}
    };

    public void drawBoard(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();

        }
    }
    public boolean checkIfMoveIsPossible(int x, int y){
        boolean check;
        if (board[x][y]== GameMain.x || board[x][y]== GameMain.o) {
            check = false;
        }else check = true;
        return check;
    }
}
