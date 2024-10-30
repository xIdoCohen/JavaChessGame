package Objects.Pieces;
import Runner.*;
import Objects.Free;

import java.util.ArrayList;
import java.util.HashMap;

import static Runner.Chess.*;

public class pawn extends Player{
    public pawn(int row,int col,int player){
        super(row,col,player);
    }

    @Override
    public int getCol() {
        return super.getCol();
    }
    public int getRow(){
        return super.getRow();
    }
    public int getPlayer(){
        return super.getPlayer();
    }

    @Override
    public boolean inRange(int i, int j) {
        return super.inRange(i, j);
    }
    @Override
    public Tuple move() {
        int ogRow=getRow();
        int ogCol=getCol();
        int row=getRow();
        int col=getCol();
        if (turn==WhitePlayer&&turn==getPlayer()){
            boolean flag=false;
            if (inRange(--row,col) &&logicBoard[row][col] instanceof Free){
                paintGreen(row,col);
                flag=true;
            }
            row=ogRow;
            col=ogCol;
            if (inRange(--row,--col) && logicBoard[row][col] instanceof Player && ((Player) logicBoard[row][col]).getPlayer()!=getPlayer()){
                paintRed(row,col,BlackPlayer);
            }
            row=ogRow;
            col=ogCol;
            if (inRange(--row,++col) && logicBoard[row][col] instanceof Player && ((Player) logicBoard[row][col]).getPlayer()!=getPlayer()){
                paintRed(row,col,BlackPlayer);
            }
            row=ogRow;
            col=ogCol;
            if (row==6&&flag){// beginning move
                if (inRange(row-=2,col) &&logicBoard[row][col] instanceof Free){
                    paintGreen(row,col);
                }
            }
        } else if ((turn==BlackPlayer && turn==getPlayer())) {
            boolean flag=false;
            if (inRange(++row,col)&&logicBoard[row][col] instanceof Free){
                paintGreen(row,col);
                flag=true;
            }
            row=ogRow;
            col=ogCol;
            if (inRange(++row,--col) && logicBoard[row][col] instanceof Player && ((Player) logicBoard[row][col]).getPlayer()!=getPlayer()){
                paintRed(row,col,WhitePlayer);
            }
            row=ogRow;
            col=ogCol;
            if (inRange(++row,++col) && logicBoard[row][col] instanceof Player && ((Player) logicBoard[row][col]).getPlayer()!=getPlayer()){
                paintRed(row,col,WhitePlayer);
            }
            row=ogRow;
            col=ogCol;
            if (row==1 &&flag){ // beginning move
                if (inRange(row+=2,col)&&logicBoard[row][col] instanceof Free){
                    paintGreen(row,col);
                }

            }
        }
        return new Tuple(ogRow,ogCol);
    }
    public HashMap<Tuple,Boolean> checkTest(int row, int col) {
        int currRow=row;
        int currCol=col;
        int player=getPlayer();
        logicBoard[currRow][currCol].setThreatend(true);
        HashMap<Tuple,Boolean> checkLocation=new HashMap<>();
        if (player==BlackPlayer){
            if (inRange(++row,--col) && (logicBoard[row][col] instanceof king )) {
                logicBoard[row][col].setThreatend(true);
                checkLocation.put(new Tuple(row,col),true);
                return checkLocation;
            }
            checkLocation=new HashMap<>();
            row=currRow;
            col=currCol;
            if (inRange(++row,++col) && logicBoard[row][col] instanceof king ) {
                logicBoard[row][col].setThreatend(true);
                checkLocation.put(new Tuple(row,col),true);
                return checkLocation;
            }

        }else {
            if (inRange(--row,--col) && (logicBoard[row][col] instanceof king )) {
                logicBoard[row][col].setThreatend(true);
                checkLocation.put(new Tuple(row,col),true);
                return checkLocation;
            }
            checkLocation=new HashMap<>();
            row=currRow;
            col=currCol;
            if (inRange(--row,++col) && logicBoard[row][col] instanceof king ) {
                logicBoard[row][col].setThreatend(true);
                checkLocation.put(new Tuple(row,col),true);
                return checkLocation;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        return "1";
    }
}
