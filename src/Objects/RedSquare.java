package Objects;

import Runner.pieceFactory;
import Objects.Pieces.Player;
import Objects.Pieces.pawn;

import java.awt.*;

import static Runner.Chess.*;
import static Runner.Chess.turn;

public class RedSquare extends Square{

    private int player;

    public Player getPiece() {
        return piece;
    }

    private Player piece;

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public RedSquare(int row, int col, int player,Player piece) {
        super(row, col);
        this.player=player;
        this.piece=piece;
    }
    public RedSquare(int row, int col,Player piece) {
        super(row, col);
        this.piece=piece;
    }

    @Override
    public int getRow() {
        return super.getRow();
    }
    public int getCol() {
        return super.getCol();
    }
    public void eliminate(int lastI, int lastJ){
        int row=getRow();
        int col=getCol();
        if (logicBoard[lastI][lastJ] instanceof pawn && ((pawn) logicBoard[lastI][lastJ]).getPlayer()==WhitePlayer && row==0){
            logicBoard[row][col]= pieceFactory.options(turn,row,col);
        }else if(logicBoard[lastI][lastJ] instanceof pawn && ((pawn) logicBoard[lastI][lastJ]).getPlayer()==BlackPlayer && row==7){
            logicBoard[row][col]= pieceFactory.options(turn,row,col);
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

    }
    @Override
    public String toString() {
        return "X";
    }
}

