package test.pro;

import test.pro.board.Board;
import test.pro.gamers.Gamer;
import test.pro.gamers.Human;
import test.pro.gamers.Robot;
import java.util.Scanner;

/**
 * Created by lekhr on 17.05.2016.
 */
public class GameMain {

    public static int easyOrHard;
    boolean sign = false;
    public static int row;
    public static int column;
    public static int move = 0;
    public static char x = 'X';
    public static char o = 'O';
    Scanner scan = new Scanner(System.in);
    public static boolean cellIsOccupied =false;

    Board boardMain = new Board();
    Gamer gamerHuman = new Human();
    Robot gamerRobot = new Robot();

    public static void main(String[] args) {

        GameMain gameMain = new GameMain();
    }
    public GameMain () {

        while (true) {
            System.out.println("Type your name : ");
            try {
                gamerHuman.setName(scan.nextLine());
                break;
            } catch (ITException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            System.out.println("Type robot name : ");
            try {
                gamerRobot.setName(scan.nextLine());
                break;
            } catch (ITException e) {
                System.out.println(e.getMessage());
            }
        }
        chooseGameLevel();
        System.out.println("Here is board for this play! ");
        boardMain.drawBoard();
        //Game's moves
        while(sign!=true) {
            move++;
            System.out.println("\nMove: " + move);
            cellIsOccupied =false;
            if(move%2!=0) {
                gamerHuman.makeMove(easyOrHard);
            }else {
                gamerRobot.makeMove(easyOrHard);
            }
            boardMain.drawBoard();
            ifGameIsOver();
        }

    }

    public void chooseGameLevel(){
        System.out.print("Choose game level : (1- easy, 2- hard) : ");
        scan = new Scanner(System.in);
        easyOrHard = scan.nextInt();
    }

    public boolean ifGameIsOver(){
        // Is this end of the game?
        if (move > 4){
            for (int k = 0; k < 3; k++){
                if (boardMain.board[k][0] == boardMain.board[k][1] && boardMain.board[k][1] == boardMain.board[k][2] && boardMain.board[k][2]!='*') sign = true;
                if (boardMain.board[0][k] == boardMain.board[1][k] && boardMain.board[1][k] == boardMain.board[2][k] && boardMain.board[2][k]!='*') sign = true;
                if (boardMain.board[0][0] == boardMain.board[1][1] && boardMain.board[1][1] == boardMain.board[2][2] && boardMain.board[2][2]!='*') sign = true;
                if (boardMain.board[0][2] == boardMain.board[1][1] && boardMain.board[1][1] == boardMain.board[2][0] && boardMain.board[2][0]!='*') sign = true;
            }
        }
        //Winner checking
        if (sign == true) {
            System.out.println("In this game winner is: ");
            char result = (move % 2 != 0) ? x : o;
            if (result == x) {
                System.out.println("****" + gamerHuman.getName() + " ****");
            } else {
                System.out.println("****" + gamerRobot.getName() + " ****");
            }
        } else if (move == 9) {
            sign = true;
            System.out.println("Oops... There is no winner! ");
        }
        return sign;
    }
}



