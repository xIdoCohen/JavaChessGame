package Objects.Pieces;

import Runner.Tuple;
import Objects.Free;

import java.util.ArrayList;
import java.util.HashMap;

import static Runner.Chess.*;

public class bishop extends Player{
    public bishop(int row, int col, int player) {
        super(row, col, player);
    }

    @Override
    public int getRow() {
        return super.getRow();
    }

    @Override
    public int getCol() {
        return super.getCol();
    }

    @Override
    public int getPlayer() {
        return super.getPlayer();
    }

    @Override
    public Tuple move() {
        int row=getRow();
            int col=getCol();
            int player=getPlayer();
            int currRow=row;
            int currCol=col;
            if (turn==player){
                while (inRange(++currRow,++currCol) &&logicBoard[currRow][currCol] instanceof Free){
                    paintGreen(currRow,currCol);
                }
                if (inRange(currRow,currCol)&& logicBoard[currRow][currCol] instanceof Player && ((Player) logicBoard[currRow][currCol]).getPlayer()!=player){
                    paintRed(currRow,currCol);
                }
                currRow=row;
                currCol=col;
                while (inRange(--currRow,++currCol) &&logicBoard[currRow][currCol] instanceof Free){
                    paintGreen(currRow,currCol);
                }
                if (inRange(currRow,currCol)&&logicBoard[currRow][currCol] instanceof Player && ((Player) logicBoard[currRow][currCol]).getPlayer()!=player){
                    paintRed(currRow,currCol);
                }
                currRow=row;
                currCol=col;
                while (inRange(++currRow,--currCol) &&logicBoard[currRow][currCol] instanceof Free){
                    paintGreen(currRow,currCol);
                }
                if (inRange(currRow,currCol)&&logicBoard[currRow][currCol] instanceof Player && ((Player) logicBoard[currRow][currCol]).getPlayer()!=player){
                    paintRed(currRow,currCol);
                }
                currRow=row;
                currCol=col;
                while (inRange(--currRow,--currCol) &&logicBoard[currRow][currCol] instanceof Free){
                    paintGreen(currRow,currCol);
                }
                if (inRange(currRow,currCol)&&logicBoard[currRow][currCol] instanceof Player && ((Player) logicBoard[currRow][currCol]).getPlayer()!=player){
                    paintRed(currRow,currCol);
                }
        }

        return new  Tuple(row,col);
    }

    @Override
    public HashMap<Tuple,Boolean> checkTest(int row, int col) {
        int currRow= row;
        int currCol= col;
        int player=getPlayer();
        logicBoard[row][col].setThreatend(true);
       HashMap<Tuple,Boolean> checkLocation=new HashMap<>();

        while (inRange(++currRow,++currCol) &&logicBoard[currRow][currCol] instanceof Free){
            logicBoard[currRow][currCol].setThreatend(true);
            checkLocation.put(new Tuple(currRow,currCol),true);
        }
        if (inRange(currRow,currCol)&& logicBoard[currRow][currCol] instanceof king && ((Player) logicBoard[currRow][currCol]).getPlayer()!=player){
            logicBoard[currRow][currCol].setThreatend(true);
            return checkLocation;
        }

        checkLocation=new HashMap<>();
        currRow= row;
        currCol= col;
        while (inRange(--currRow,++currCol) &&logicBoard[currRow][currCol] instanceof Free){
            logicBoard[currRow][currCol].setThreatend(true);
            checkLocation.put(new Tuple(currRow,currCol),true);
        }
        if (inRange(currRow,currCol)&&logicBoard[currRow][currCol] instanceof king && ((Player) logicBoard[currRow][currCol]).getPlayer()!=player){
            logicBoard[currRow][currCol].setThreatend(true);
            return checkLocation;

        }

        checkLocation=new HashMap<>();
        currRow= row;
        currCol= col;
        while (inRange(++currRow,--currCol) &&logicBoard[currRow][currCol] instanceof Free){
            logicBoard[currRow][currCol].setThreatend(true);
            checkLocation.put(new Tuple(currRow,currCol),true);
        }
        if (inRange(currRow,currCol)&&logicBoard[currRow][currCol] instanceof king && ((Player) logicBoard[currRow][currCol]).getPlayer()!=player){
            logicBoard[currRow][currCol].setThreatend(true);
            return checkLocation;
        }


        checkLocation=new HashMap<>();
        currRow= row;
        currCol= col;
        while (inRange(--currRow,--currCol) &&logicBoard[currRow][currCol] instanceof Free){
            logicBoard[currRow][currCol].setThreatend(true);
            checkLocation.put(new Tuple(currRow,currCol),true);
        }
        if (inRange(currRow,currCol)&&logicBoard[currRow][currCol] instanceof king && ((Player) logicBoard[currRow][currCol]).getPlayer()!=player){
            logicBoard[currRow][currCol].setThreatend(true);
            return checkLocation;
        }
        return null;
    }

    @Override
    public String toString() {
        return "B";
    }
}
