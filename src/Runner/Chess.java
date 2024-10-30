package Runner;

import javax.swing.*;
import javax.swing.border.LineBorder;
import Objects.*;
import Objects.Pieces.Player;
import Objects.Pieces.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Objects;

public class Chess extends JFrame {

    public static boolean CHECKED;
    public static int turn;
    protected static int size=8;
    public static int BlackPlayer=1;
    public static int WhitePlayer=2;
    public static Square[][] logicBoard;
    public static myButton[][] btnBoard;

    public Chess(){
        menu();
        initBoard();
        setSize(700, 700);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    void menu(){

    }
    class AL implements ActionListener {

        private static Tuple lastIndex;
        private final int row;
        private final int col;
        public AL(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public void actionPerformed(ActionEvent e) {
            isChecked(turn);
            if (logicBoard[row][col] instanceof pawn){
                clearGreenAndRed();
                lastIndex=((pawn)logicBoard[row][col]).move();
            }
            if (logicBoard[row][col] instanceof knight){
                clearGreenAndRed();
                lastIndex=((knight)logicBoard[row][col]).move();
            }
            if (logicBoard[row][col] instanceof rook){
                clearGreenAndRed();
                lastIndex=((rook)( logicBoard[row][col])).move();
            }
            if (logicBoard[row][col] instanceof bishop){
                clearGreenAndRed();
                lastIndex=((bishop)( logicBoard[row][col])).move();
            }
            if (logicBoard[row][col] instanceof queen){
                clearGreenAndRed();
                lastIndex=((queen)( logicBoard[row][col])).move();
            }
            if (logicBoard[row][col] instanceof king){
                clearGreenAndRed();
                lastIndex=((king)( logicBoard[row][col])).move();
            }
            if (logicBoard[row][col] instanceof GreenSquare){
                ((GreenSquare) logicBoard[row][col]).paintGreen(lastIndex.getRow(),lastIndex.getCol());
                clearGreenAndRed();
            }
            if (logicBoard[row][col] instanceof RedSquare){
                ((RedSquare) logicBoard[row][col]).eliminate(lastIndex.getRow(), lastIndex.getCol());
                clearGreenAndRed();
            }
            if (logicBoard[row][col] instanceof Free){
                clearGreenAndRed();
            }
            printBoard();


        }
    }
    protected void printBoard(){
        for (int i=0;i<size;i++){
            for (int j=0;j<size;j++){
                System.out.print(logicBoard[i][j].toString()+" ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println(turn==2 ? "white ":"black");
    }
    protected void printThreats(){
        for (int i=0;i<size;i++){
            for (int j=0;j<size;j++){
                if(logicBoard[i][j].isThreatend()){
                    System.out.print("T"+" ");
                }else {
                    System.out.print("F"+" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    public void resetThreats(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                logicBoard[i][j].setThreatend(false);
            }
        }
    }
    protected void isChecked(int player) {
        int col = 0;
        int row;
        boolean flag=true;
        HashMap<Tuple,Boolean> temp = null;
        HashMap<Tuple,Boolean> checkLocation = null;
        for (row=0; row < size && flag ;row++)
            for (col = 0; col < size; col++) {
                if (logicBoard[row][col] instanceof king && ((king)logicBoard[row][col]).getPlayer() == player) {
                    flag=false;
                    row--;
                    break;

                }
            }

        resetThreats();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (logicBoard[i][j] instanceof Player && ((Player) logicBoard[i][j]).getPlayer() != player) {
                    temp=((Player) logicBoard[i][j]).checkTest(i,j);
                    if (temp!=null){
                        checkLocation=temp;
                    }
                }
            }
        }
        printThreats();

        if (logicBoard[row][col].isThreatend()){
            CHECKED=true;
            System.out.println("CHECKED");
            if (checkLocation != null) {
                for (Tuple cords : checkLocation.keySet()) {
                    System.out.println(cords);
                }
            }


        }

    }

    protected void clearGreenAndRed(){
        for (int i=0;i<size;i++){
            for (int j=0;j<size;j++){
                boolean b = i % 2 == 0 && j % 2 == 0 || i % 2 == 1 && j % 2 == 1;
                if (logicBoard[i][j] instanceof GreenSquare ){
                    if (b){
                        btnBoard[i][j].setBackground(new Color(224, 220, 220));
                    }
                    else {
                        btnBoard[i][j].setBackground(new Color(52, 52, 52));
                    }
                    logicBoard[i][j]=new Free(i,j);

                }
                if (logicBoard[i][j] instanceof RedSquare){
                    if (b){
                        btnBoard[i][j].setBackground(new Color(224, 220, 220));
                    }
                    else {
                        btnBoard[i][j].setBackground(new Color(52, 52, 52));
                    }
                    Player piece=((RedSquare) logicBoard[i][j]).getPiece();
                    logicBoard[i][j]=piece;
                }
            }
        }
    }
    void initBoard(){
        logicBoard=new Square[size][size];
        btnBoard=new myButton[size][size];
        setLayout(new GridLayout(size,size));
        turn=WhitePlayer;
        for (int row=0;row<size;row++) {
            for (int col = 0; col < size; col++) {
                if (row % 2 == 0 && col % 2 == 0 || row % 2 == 1 && col % 2 == 1) {
                    //white square
                    logicBoard[row][col] = new Free(row, col);
                    btnBoard[row][col] = new myButton(null);
                    btnBoard[row][col].setForeground(new Color(224, 220, 220));
                    btnBoard[row][col].setBackground(new Color(224, 220, 220));
                    btnBoard[row][col].setBorder(new LineBorder(Color.BLACK, 2));
                    btnBoard[row][col].addActionListener(new AL(row,col)); //new AL(row, j));
                    add(btnBoard[row][col]);
                    btnBoard[row][col].setFocusPainted(false);
                } else {
                    logicBoard[row][col] = new Free(row, col);
                    btnBoard[row][col] = new myButton(null);
                    btnBoard[row][col].setForeground(new Color(52, 52, 52));
                    btnBoard[row][col].setBackground(new Color(52, 52, 52));
                    btnBoard[row][col].setBorder(new LineBorder(Color.BLACK, 2));
                    btnBoard[row][col].addActionListener(new AL(row,col)); //new AL(row, j));
                    add(btnBoard[row][col]);
                    btnBoard[row][col].setFocusPainted(false);
                }

                //pawn maker
                if (row==1){
                    logicBoard[row][col]=pieceFactory.makePawn(row,col,1);
                }
                if (row==6){
                    logicBoard[row][col]=pieceFactory.makePawn(row,col,2);
                }
            }
        }
        //Rook maker->
        logicBoard[0][0]= pieceFactory.makeRook(0,0,1);
        logicBoard[0][7]= pieceFactory.makeRook(0,7,1);
        logicBoard[7][7]= pieceFactory.makeRook(7,7,2);
        logicBoard[7][0]= pieceFactory.makeRook(7,0,2);
        //Knight maker->
        logicBoard[0][1]= pieceFactory.makeKnight(0,1,1);
        logicBoard[0][6]= pieceFactory.makeKnight(0,6,1);
        logicBoard[7][6]= pieceFactory.makeKnight(7,6,2);
        logicBoard[7][1]= pieceFactory.makeKnight(7,1,2);

        //Bishop maker->
        logicBoard[0][2]= pieceFactory.makeBishop(0,2,1);
        logicBoard[0][5]= pieceFactory.makeBishop(0,5,1);
        logicBoard[7][5]= pieceFactory.makeBishop(7,5,2);
        logicBoard[7][2]= pieceFactory.makeBishop(7,2,2);
        //
        ////Queen maker->
        logicBoard[0][3]= pieceFactory.makeQueen(0,3,1);
        logicBoard[7][3]= pieceFactory.makeQueen(7,3,2);

        //King maker->
        logicBoard[0][4]= pieceFactory.makeKing(0,4,1);
        logicBoard[7][4]= pieceFactory.makeKing(7,4,2);
    }

    public static void main(String[] args) {
        new Chess();
    }
}