package Objects.Pieces;

import Runner.Tuple;
import Objects.*;

import java.awt.*;
import java.util.HashMap;

import static Runner.Chess.*;

public abstract class Player extends Square implements  Moveable{

    private final int player;
    public Player(int row,int col,int player){
        super(row,col);
        this.player=player;
    }
    public int getRow(){
        return super.getRow();
    }
    public int getCol(){
        return super.getCol();
    }
    public int getPlayer(){
        return this.player;
    }
    @Override
    public boolean inRange(int i, int j) {
        return super.inRange(i, j);
    }
    public abstract Tuple move();
    public void paintRed(int row,int col,int player){
        btnBoard[row][col].setBackground(Color.red);
        Player piece= (Player) logicBoard[row][col];
        logicBoard[row][col]=new RedSquare(row,col,player,piece);
    }
    public void paintRed(int row,int col){
        btnBoard[row][col].setBackground(Color.red);
        Player piece= (Player) logicBoard[row][col];
        logicBoard[row][col]=new RedSquare(row,col,piece);
    }
    public  void paintGreen(int row,int col){
        logicBoard[row][col] =new GreenSquare(row,col);
        btnBoard[row][col].setBackground(Color.GREEN);
    }
    public void paintGreen(int row,int col,boolean flag){
        logicBoard[row][col] =new GreenSquare(row,col,flag);
        btnBoard[row][col].setBackground(Color.GREEN);
    }
    public abstract HashMap<Tuple,Boolean> checkTest(int i, int j);
}
