package test.pro.gamers;

import test.pro.GameMain;
import test.pro.ITException;
import test.pro.board.Board;

/**
 * Created by lekhr on 18.05.2016.
 */
public class Robot implements Gamer {

    Board board = new Board();
    private static String robotName;

    public int numberOfRowOrCell() {
        int max = 3, min = 1;
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    @Override
    public void makeMove(int easyHard) {
        if(easyHard == 2){
            makeSmartMove();
        }else if(easyHard == 1){
            GameMain.cellIsOccupied = false;
            while (!GameMain.cellIsOccupied) {
                GameMain.row = 0;
                GameMain.column = 0;
                GameMain.row = numberOfRowOrCell();
                GameMain.column = numberOfRowOrCell();
                GameMain.cellIsOccupied = board.checkIfMoveIsPossible(GameMain.row - 1, GameMain.column - 1);
                if (GameMain.cellIsOccupied) {
                    System.out.println("Robot's move :");
                    Board.board[GameMain.row - 1][GameMain.column - 1] = GameMain.o;}
            }
        }
    }

    public void makeSmartMove() {
        boolean smartFlag = false;
        GameMain.cellIsOccupied = false;
        while (!GameMain.cellIsOccupied) {
            GameMain.row = 0;
            GameMain.column = 0;
            char masXO[] = {GameMain.o, GameMain.x};
            //choosing the cell
            while (!smartFlag) {
                //Check is somebody's next step can bring him victory
                for (int i = 0; i < masXO.length; i++) {
                    for (int k = 0; k < 3; k++) {
                        if (Board.board[k][0] == Board.board[k][1] && Board.board[k][1] == masXO[i] && Board.board[k][2] == '*'){
                            Board.board[k][2] = GameMain.o;
                            smartFlag = true;
                            break;}
                        if (Board.board[0][k] == Board.board[1][k] && Board.board[1][k] == masXO[i] && Board.board[2][k] == '*'){
                            Board.board[2][k] = GameMain.o;
                            smartFlag = true;
                            break;}
                        if (Board.board[k][2] == Board.board[k][1] && Board.board[k][1] == masXO[i] && Board.board[k][0] == '*'){
                            Board.board[k][0] = GameMain.o;
                            smartFlag = true;
                            break;}
                        if (Board.board[2][k] == Board.board[1][k] && Board.board[1][k] == masXO[i] && Board.board[0][k] == '*'){
                            Board.board[0][k] = GameMain.o;
                            smartFlag = true;
                            break;}
                        if (Board.board[2][k] == Board.board[0][k] && Board.board[0][k] == masXO[i] && Board.board[1][k] == '*'){
                            Board.board[1][k] = GameMain.o;
                            smartFlag = true;
                            break;}
                        if (Board.board[k][2] == Board.board[k][0] && Board.board[k][0] == masXO[i] && Board.board[k][1] == '*'){
                            Board.board[k][1] = GameMain.o;
                            smartFlag = true;
                            break;}

                    }
                    if (!smartFlag) {
                        if (Board.board[1][1] == Board.board[0][0] && Board.board[1][1] == masXO[i] && Board.board[2][2] == '*'){
                            Board.board[2][2] = GameMain.o;
                            smartFlag = true;
                            break;}
                        if (Board.board[0][2] == Board.board[1][1] && Board.board[1][1] == masXO[i] && Board.board[2][0] == '*'){
                            Board.board[2][0] = GameMain.o;
                            smartFlag = true;
                            break;}
                        if (Board.board[1][1] == Board.board[2][0] && Board.board[1][1] == masXO[i] && Board.board[0][2] == '*'){
                            Board.board[0][2] = GameMain.o;
                            smartFlag = true;
                            break;}
                        if (Board.board[1][1] == Board.board[2][2] && Board.board[1][1] == masXO[i] && Board.board[0][0] == '*'){
                            Board.board[0][0] = GameMain.o;
                            smartFlag = true;
                            break;}
                        if (Board.board[0][0] == Board.board[2][2] && Board.board[1][1] == masXO[i] && Board.board[1][1] == '*'){
                            Board.board[1][1] = GameMain.o;
                            smartFlag = true;
                            break;}
                        if (Board.board[0][2] == Board.board[2][0] && Board.board[2][0] == masXO[i] && Board.board[1][1] == '*'){
                            Board.board[1][1] = GameMain.o;
                            smartFlag = true;
                            break;}
                    }
                }break;
            }break;
        }if(!smartFlag){
            makeMove(1);}
    }

    @Override
    public void setName(String name) throws ITException {
        char[] ch = name.toCharArray();
        int count = 0;
        for (int i = 0; i < name.length(); i++) {
            if (ch[i] == ' ') {
                count++;
            }
        }
        if (count == name.length() || name == "")
            throw new ITException("The name couldn't be empty on include just free space! ");
        robotName = name;
    }

    @Override
    public String getName() {
        return robotName;
    }
}
