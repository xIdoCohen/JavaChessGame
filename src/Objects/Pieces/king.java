package Objects.Pieces;

import Runner.Tuple;
import Objects.Free;
import Objects.GreenSquare;

import java.awt.*;
import java.util.HashMap;

import static Runner.Chess.*;

public class king extends Player{

    public king(int row, int col, int player) {
        super(row, col, player);
        hasCastled=false;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }
    private boolean hasCastled;
    private boolean hasMoved;
    @Override
    public int getPlayer() {
        return super.getPlayer();
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
    public Tuple move() {
        int row=getRow();
        int col=getCol();
        int player=getPlayer();
        if (turn==player){
            for(int i=row-1;i<=row+1;i++){
                for(int j=col-1;j<=col+1;j++){
                    if (inRange(i,j)&& logicBoard[i][j] instanceof Free && (i!=row || j!=col) && !logicBoard[i][j].isThreatend()){
                            paintGreen(i,j);
                    }
                    if (inRange(i,j)&& logicBoard[i][j] instanceof Player && player!=((Player)logicBoard[i][j]).getPlayer() && (i!=row || j!=col) &&logicBoard[i][j].isThreatend()){
                             paintRed(i,j);
                    }
                }
            }
            //castle
            if (turn==WhitePlayer){
                if (logicBoard[7][6] instanceof Free && logicBoard[7][7] instanceof rook && !hasMoved && !((rook) logicBoard[7][7]).isHasMoved()){
                    if (row==7 && col==4){
                        paintGreen(7,6,true);
                    }
                }
                if (logicBoard[7][2] instanceof Free && logicBoard[7][1] instanceof Free && logicBoard[7][0] instanceof rook &&!hasMoved&& !((rook)logicBoard[7][0]).isHasMoved()){
                    if (row==7 && col==4){
                        paintGreen(7,2,true);
                    }
                }
            }else {
                if (logicBoard[0][5] instanceof  Free&&logicBoard[0][6] instanceof Free && logicBoard[0][7] instanceof rook && !hasMoved && !((rook) logicBoard[0][7]).isHasMoved()){
                    if (row==0 && col==3){
                        paintGreen(0,5,true);
                    }
                }
                if (logicBoard[0][1] instanceof Free && logicBoard[0][0] instanceof rook &&!hasMoved&& !((rook)logicBoard[0][0]).isHasMoved()){
                    if (row==0 && col==3){
                        paintGreen(0,1,true);
                    }
                }
            }
        }
        return new Tuple(row,col);

    }

    @Override
    public HashMap<Tuple,Boolean> checkTest(int row, int col) {
        int r=row;
        int c=col;
        logicBoard[r][c].setThreatend(true);
            for (int i = r - 1; i <= r + 1; i++) {
                for (int j = c - 1; j <= c + 1; j++) {
                    if (inRange(i, j) && logicBoard[i][j] instanceof Free && (i != r || j != c)) {
                        logicBoard[i][j].setThreatend(true);
                    }
                }
            }
            return null;
    }

    @Override
    public String toString() {
        return "K";
    }
}
