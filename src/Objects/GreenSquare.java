package Objects;

import Objects.Pieces.Player;
import Objects.Pieces.pawn;
import Objects.Pieces.*;

import java.awt.*;
import Runner.*;

import static Runner.Chess.*;

public class GreenSquare extends Square{
    private boolean flag;

    public GreenSquare(int row, int col) {
        super(row, col);
    }
    public GreenSquare(int row, int col,boolean flag) {
        super(row, col);
        this.flag=flag;
    }

    @Override
    public int getRow() {
        return super.getRow();
    }
    public int getCol() {
        return super.getCol();
    }

    public void paintGreen(int lastI, int lastJ){
        int row=getRow();
        int col=getCol();
        if (logicBoard[lastI][lastJ] instanceof pawn && ((pawn) logicBoard[lastI][lastJ]).getPlayer()==WhitePlayer && row==0){
                logicBoard[row][col]=pieceFactory.makeQueen(row,col,WhitePlayer);
        }else if(logicBoard[lastI][lastJ] instanceof pawn && ((pawn) logicBoard[lastI][lastJ]).getPlayer()==BlackPlayer && row==7){
                logicBoard[row][col]=pieceFactory.makeQueen(row,col,BlackPlayer);
        }else {
            Image img = btnBoard[lastI][lastJ].getImage();
            btnBoard[row][col].setImage(img);
            logicBoard[row][col] =logicBoard[lastI][lastJ];
            logicBoard[row][col].setCol(col);
            logicBoard[row][col].setRow(row);
        }

        btnBoard[row][col].setBackground(getColor(row,col));
        //remove the original player
        btnBoard[lastI][lastJ].setImage(null);
        btnBoard[lastI][lastJ].repaint();
        logicBoard[lastI][lastJ] = new Free(lastI,lastJ);

        //pass the turn to the other player
        turn=(turn==2) ? 1: 2;

        if (flag){
            if (row==7&&col==6 && ((Player)logicBoard[row][col]).getPlayer()==WhitePlayer  ){
                Image img = btnBoard[7][7].getImage();
                btnBoard[7][5].setImage(img);
                logicBoard[7][5] =logicBoard[7][7];
                logicBoard[7][5].setCol(5);
                logicBoard[7][5].setRow(7);
                btnBoard[7][5].setBackground(new Color(224, 220, 220));
                //remove the original player
                btnBoard[7][7].setImage(null);
                btnBoard[7][7].repaint();
                logicBoard[7][7] = new Free(7,7);
            }

            if (row==7&&col==2 && ((Player)logicBoard[row][col]).getPlayer()==WhitePlayer  ){
                Image img = btnBoard[7][0].getImage();
                btnBoard[7][3].setImage(img);
                logicBoard[7][3] =logicBoard[7][0];
                logicBoard[7][3].setCol(3);
                logicBoard[7][3].setRow(7);
                btnBoard[7][3].setBackground(new Color(224, 220, 220));
                //remove the original player
                btnBoard[7][0].setImage(null);
                btnBoard[7][0].repaint();
                logicBoard[7][0] = new Free(7,0);
            }

            if (row==0&&col==5 && ((Player)logicBoard[row][col]).getPlayer()==BlackPlayer  ){
                Image img = btnBoard[0][7].getImage();
                btnBoard[0][4].setImage(img);
                logicBoard[0][4] =logicBoard[0][7];
                logicBoard[0][4].setCol(4);
                logicBoard[0][4].setRow(0);
                btnBoard[0][4].setBackground(new Color(224, 220, 220));
                //remove the original player
                btnBoard[0][7].setImage(null);
                btnBoard[0][7].repaint();
                logicBoard[0][7] = new Free(0,7);
            }

            if (row==0&&col==1 && ((Player)logicBoard[row][col]).getPlayer()==BlackPlayer  ){
                Image img = btnBoard[0][0].getImage();
                btnBoard[0][2].setImage(img);
                logicBoard[0][2] =logicBoard[0][0];
                logicBoard[0][2].setCol(2);
                logicBoard[0][2].setRow(0);
                btnBoard[0][2].setBackground(new Color(224, 220, 220));
                //remove the original player
                btnBoard[0][0].setImage(null);
                btnBoard[0][0].repaint();
                logicBoard[0][0] = new Free(7,0);
            }


        }

        if (logicBoard[row][col] instanceof king){
        ((king)logicBoard[row][col]).setHasMoved(true);
        }
        if (logicBoard[row][col] instanceof rook){
            ((rook)logicBoard[row][col]).setHasMoved(true);
        }
    }

    @Override
    public String toString() {
        return "G";
    }
}
