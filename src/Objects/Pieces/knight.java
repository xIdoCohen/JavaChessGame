package Objects.Pieces;

import Runner.Tuple;
import Objects.Free;

import java.util.ArrayList;
import java.util.HashMap;

import static Runner.Chess.*;

public class knight extends Player{
    public knight(int row, int col, int player) {
        super(row, col, player);
    }

    @Override
    public Tuple move() {
        int ogRow=getRow();
        int ogCol=getCol();
        int row=getRow();
        int col=getCol();
        int player=getPlayer();
        if (turn==getPlayer()){
            if (inRange(row-=2,col-=1)&&logicBoard[row][col] instanceof Free){
                paintGreen(row,col);
            }
            row=ogRow;
            col=ogCol;
            if (inRange(row-=2,col+=1)&&logicBoard[row][col] instanceof Free){
                paintGreen(row,col);
            }
            row=ogRow;
            col=ogCol;
            if (inRange(row-=2,col-=1)&&logicBoard[row][col] instanceof Player && player!= ((Player) logicBoard[row][col]).getPlayer() ){
                paintRed(row,col);
            }
            row=ogRow;
            col=ogCol;
            if (inRange(row-=2,col+=1)&&logicBoard[row][col] instanceof Player && player!= ((Player) logicBoard[row][col]).getPlayer() ){
                paintRed(row,col);
            }
            row=ogRow;
            col=ogCol;

            //left side
            if (inRange(row-=1,col-=2)&&logicBoard[row][col] instanceof Free){
                paintGreen(row,col);
            }
            row=ogRow;
            col=ogCol;
            if (inRange(row+=1,col-=2)&&logicBoard[row][col] instanceof Free){
                paintGreen(row,col);
            }
            row=ogRow;
            col=ogCol;
            if (inRange(row-=1,col-=2)&&logicBoard[row][col] instanceof Player && player!= ((Player) logicBoard[row][col]).getPlayer() ){
                paintRed(row,col);
            }
            row=ogRow;
            col=ogCol;
            if (inRange(row+=1,col-=2)&&logicBoard[row][col] instanceof Player && player!= ((Player) logicBoard[row][col]).getPlayer() ){
                paintRed(row,col);
            }
            row=ogRow;
            col=ogCol;

            //right side
            if (inRange(row-=1,col+=2)&&logicBoard[row][col] instanceof Free){
                paintGreen(row,col);
            }
            row=ogRow;
            col=ogCol;
            if (inRange(row+=1,col+=2)&&logicBoard[row][col] instanceof Free){
               paintGreen(row,col);
            }
            row=ogRow;
            col=ogCol;
            if (inRange(row-=1,col+=2)&&logicBoard[row][col] instanceof Player && player!= ((Player) logicBoard[row][col]).getPlayer() ){
                paintRed(row,col);
            }
            row=ogRow;
            col=ogCol;
            if (inRange(row+=1,col+=2)&&logicBoard[row][col] instanceof Player && player!= ((Player) logicBoard[row][col]).getPlayer() ){
                paintRed(row,col);
            }
            row=ogRow;
            col=ogCol;

            //down side
            if (inRange(row+=2,col-=1)&&logicBoard[row][col] instanceof Free){
               paintGreen(row,col);
            }
            row=ogRow;
            col=ogCol;
            if (inRange(row+=2,col+=1)&&logicBoard[row][col] instanceof Free){
                paintGreen(row,col);
            }
            row=ogRow;
            col=ogCol;
            if (inRange(row+=2,col+=1)&&logicBoard[row][col] instanceof Player && player!= ((Player) logicBoard[row][col]).getPlayer() ){
                paintRed(row,col);
            }
            row=ogRow;
            col=ogCol;
            if (inRange(row+=2,col-=1)&&logicBoard[row][col] instanceof Player && player!= ((Player) logicBoard[row][col]).getPlayer() ){
                paintRed(row,col);
            }
            row=ogRow;
            col=ogCol;

        }
        //up side
        return new Tuple(ogRow,ogCol);
    }
    public HashMap<Tuple,Boolean> checkTest(int ogrow, int ogcol) {
        int row= ogrow;
        int col= ogcol;
        int player=getPlayer();
        HashMap<Tuple,Boolean> checkLocation=new HashMap<>();

        logicBoard[row][col].setThreatend(true);

        if (inRange(row-=2,col-=1)&&logicBoard[row][col] instanceof Free){
            logicBoard[row][col].setThreatend(true);
            checkLocation.put(new Tuple(row,col),true);
            return checkLocation;
        }
        checkLocation=new HashMap<>();
        row= ogrow;
        col= ogcol;
        if (inRange(row-=2,col-=1)&&logicBoard[row][col] instanceof king && player!= ((Player) logicBoard[row][col]).getPlayer() ){
            logicBoard[row][col].setThreatend(true);
            checkLocation.put(new Tuple(row,col),true);
            return checkLocation;
        }
        checkLocation=new HashMap<>();
        row= ogrow;
        col= ogcol;
        if (inRange(row-=2,col+=1)&&logicBoard[row][col] instanceof Free){
            logicBoard[row][col].setThreatend(true);
            checkLocation.put(new Tuple(row,col),true);
            return checkLocation;
        }
        checkLocation=new HashMap<>();
        row= ogrow;
        col= ogcol;
        if (inRange(row-=2,col+=1)&&logicBoard[row][col] instanceof king && player!= ((Player) logicBoard[row][col]).getPlayer() ){
            logicBoard[row][col].setThreatend(true);
            checkLocation.put(new Tuple(row,col),true);
            return checkLocation;
        }
        checkLocation=new HashMap<>();
        row= ogrow;
        col= ogcol;
        //left side
        if (inRange(row-=1,col-=2)&&logicBoard[row][col] instanceof Free){
            logicBoard[row][col].setThreatend(true);
            checkLocation.put(new Tuple(row,col),true);
            return checkLocation;
        }
        checkLocation=new HashMap<>();
        row= ogrow;
        col= ogcol;
        if (inRange(row-=1,col-=2)&&logicBoard[row][col] instanceof king && player!= ((Player) logicBoard[row][col]).getPlayer() ){
            logicBoard[row][col].setThreatend(true);
            checkLocation.put(new Tuple(row,col),true);
            return checkLocation;
        }
        checkLocation=new HashMap<>();
        row= ogrow;
        col= ogcol;
        if (inRange(row+=1,col-=2)&&logicBoard[row][col] instanceof Free){
            logicBoard[row][col].setThreatend(true);
            checkLocation.put(new Tuple(row,col),true);
            return checkLocation;
        }
        checkLocation=new HashMap<>();
        row= ogrow;
        col= ogcol;
        if (inRange(row+=1,col-=2)&&logicBoard[row][col] instanceof king && player!= ((Player) logicBoard[row][col]).getPlayer() ){
            logicBoard[row][col].setThreatend(true);
            checkLocation.put(new Tuple(row,col),true);
            return checkLocation;
        }
        checkLocation=new HashMap<>();
        row= ogrow;
        col= ogcol;
        //right side
        if (inRange(row-=1,col+=2)&&logicBoard[row][col] instanceof Free){
            logicBoard[row][col].setThreatend(true);
            checkLocation.put(new Tuple(row,col),true);
            return checkLocation;
        }
        checkLocation=new HashMap<>();
        row= ogrow;
        col= ogcol;
        if (inRange(row-=1,col+=2)&&logicBoard[row][col] instanceof king && player!= ((Player) logicBoard[row][col]).getPlayer() ){
            logicBoard[row][col].setThreatend(true);
            checkLocation.put(new Tuple(row,col),true);
            return checkLocation;
        }
        checkLocation=new HashMap<>();
        row= ogrow;
        col= ogcol;
        if (inRange(row+=1,col+=2)&&logicBoard[row][col] instanceof Free){
            logicBoard[row][col].setThreatend(true);
            checkLocation.put(new Tuple(row,col),true);
            return checkLocation;
        }
        checkLocation=new HashMap<>();
        row= ogrow;
        col= ogcol;
        if (inRange(row+=1,col+=2)&&logicBoard[row][col] instanceof king && player!= ((Player) logicBoard[row][col]).getPlayer() ){
            logicBoard[row][col].setThreatend(true);
            checkLocation.put(new Tuple(row,col),true);
            return checkLocation;
        }
        checkLocation=new HashMap<>();
        row= ogrow;
        col= ogcol;
        //down side
        if (inRange(row+=2,col-=1)&&logicBoard[row][col] instanceof Free){
            logicBoard[row][col].setThreatend(true);
            checkLocation.put(new Tuple(row,col),true);
            return checkLocation;
        }
        checkLocation=new HashMap<>();
        row= ogrow;
        col= ogcol;
        if (inRange(row+=2,col-=1)&&logicBoard[row][col] instanceof king && player!= ((Player) logicBoard[row][col]).getPlayer() ){
            logicBoard[row][col].setThreatend(true);
            checkLocation.put(new Tuple(row,col),true);
            return checkLocation;
        }
        checkLocation=new HashMap<>();
        row= ogrow;
        col= ogcol;
        if (inRange(row+=2,col+=1)&&logicBoard[row][col] instanceof Free){
            logicBoard[row][col].setThreatend(true);
            checkLocation.put(new Tuple(row,col),true);
            return checkLocation;
        }
        checkLocation=new HashMap<>();
        row= ogrow;
        col= ogcol;
        if (inRange(row+=2,col+=1)&&logicBoard[row][col] instanceof king && player!= ((Player) logicBoard[row][col]).getPlayer() ){
            logicBoard[row][col].setThreatend(true);
            checkLocation.put(new Tuple(row,col),true);
            return checkLocation;
        }
        //up side
        return null;
    }

    @Override
    public String toString() {
        return "S";
    }
}
