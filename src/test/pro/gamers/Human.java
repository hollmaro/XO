package test.pro.gamers;

import test.pro.GameMain;
import test.pro.ITException;
import test.pro.board.Board;
import java.util.Scanner;

/**
 * Created by lekhr on 18.05.2016.
 */
public class Human implements Gamer {

    public String humanName;
    Board board = new Board();
    Scanner scan = new Scanner(System.in);
    Robot robot = new Robot();

    @Override
    public void makeMove(int i){
        while (!GameMain.cellIsOccupied) {
            GameMain.column = 0;
            GameMain.row = 0;
            while (GameMain.row > 3 || GameMain.row < 1) {
                System.out.print("Your move !!!" + '\n' + "Type row number: ");
                GameMain.row = scan.nextInt();
                if (GameMain.row > 3 || GameMain.row < 1)
                    System.out.println("Should be number between 1 and 3 ! Try again");
            }
            while (GameMain.column > 3 || GameMain.column < 1) {
                System.out.print("Type column number: ");
                GameMain.column = scan.nextInt();
                if (GameMain.column > 3 || GameMain.column < 1)
                    System.out.println("Should be number between 1 and 3 ! Try again");
            }
            GameMain.cellIsOccupied = board.checkIfMoveIsPossible(GameMain.row - 1, GameMain.column - 1);
            if (GameMain.cellIsOccupied)
                board.board[GameMain.row - 1][GameMain.column - 1]= GameMain.x;
            else if(i == 2) {
                System.out.println("\nPlease notice that " + robot.getName() + " plays in smart-mode. \nDon't make mistake like this anymore!!! \n");
            }else
                System.out.println("Here is no empty place to move! Try another point! ");

        }
    }

    @Override
    public void setName(String name) throws  ITException{
        char[] ch =name.toCharArray();
        int count = 0;
        for (int i=0; i <name.length(); i++) {
            if (ch[i] == ' ') {
                count++;}
        }
        if(count==name.length() || name == "")throw new ITException("The name couldn't be empty on include just free space! ");
        humanName = name;
    }

    @Override
    public String getName() {
        return humanName;
    }
}
