package Runner;

import Objects.Pieces.*;
import javax.swing.*;
import java.awt.*;
public class pieceFactory {
    private static int type;
    public static Player options(int player,int row,int col) {

        String[] options = new String[]{"Queen", "Rook", "Knight", "Bishop", };
        int response = JOptionPane.showOptionDialog((Component)null, "    Choose a piece", "Which piece?", -1, 3, new ImageIcon(), options, options[0]);
        return switch (response) {
            case 0 -> makeQueen(row, col, player);
            case 1 -> makeRook(row, col, player);
            case 2 -> makeKnight(row, col, player);
            case 3 -> makeBishop(row, col, player);
            default -> null;
        };

    }
    public static pawn makePawn(int row,int col,int player){
        if (player==1){
            ImageIcon icon = new ImageIcon("src/photos/black_pawn.png");


            Image img = icon.getImage();
            Chess.btnBoard[row][col].setImage(img);
            return new pawn(row,col,1);
        }
        else {
            ImageIcon icon = new ImageIcon("src/photos/white_pawn.png");
            Image img = icon.getImage();
            Chess.btnBoard[row][col].setImage(img);
            return new pawn(row,col,2);
        }
    }

    public static rook makeRook(int row,int col,int player){
        if (player==1){
            ImageIcon icon = new ImageIcon("src/photos/black_rook.png");
            Image img = icon.getImage();
            Chess.btnBoard[row][col].setImage(img);
            return new rook(row,col,1);
        }
        else {
            ImageIcon icon = new ImageIcon("src/photos/white_rook.png");
            Image img = icon.getImage();
            Chess.btnBoard[row][col].setImage(img);
            return new rook(row,col,2);
        }
    }

    public static knight makeKnight(int row,int col,int player){
        if (player==1){
            ImageIcon icon = new ImageIcon("src/photos/black_knight.png");
            Image img = icon.getImage();
            Chess.btnBoard[row][col].setImage(img);
            return new knight(row,col,1);
        }
        else {
            ImageIcon icon = new ImageIcon("src/photos/white_knight.png");
            Image img = icon.getImage();
            Chess.btnBoard[row][col].setImage(img);
            return new knight(row,col,2);
        }
    }
    public static bishop makeBishop(int row,int col,int player){
        if (player==1){
            ImageIcon icon = new ImageIcon("src/photos/black_bishop.png");
            Image img = icon.getImage();
            Chess.btnBoard[row][col].setImage(img);
            return new bishop(row,col,1);
        }
        else {
            ImageIcon icon = new ImageIcon("src/photos/white_bishop.png");
            Image img = icon.getImage();
            Chess.btnBoard[row][col].setImage(img);
            return new bishop(row,col,2);
        }
    }
    public static queen makeQueen(int row,int col,int player){
        if (player==1){
            ImageIcon icon = new ImageIcon("src/photos/black_queen.png");
            Image img = icon.getImage();
            Chess.btnBoard[row][col].setImage(img);
            return new queen(row,col,1);
        }
        else {
            ImageIcon icon = new ImageIcon("src/photos/white_queen.png");
            Image img = icon.getImage();
            Chess.btnBoard[row][col].setImage(img);
            return new queen(row,col,2);
        }
    }
    public static king makeKing(int row,int col,int player){
        if (player==1){
            ImageIcon icon = new ImageIcon("src/photos/black_king.png");
            Image img = icon.getImage();
            Chess.btnBoard[row][col].setImage(img);
            return new king(row,col,1);
        }
        else {
            ImageIcon icon = new ImageIcon("src/photos/white_king.png");
            Image img = icon.getImage();
            Chess.btnBoard[row][col].setImage(img);
            return new king(row,col,2);
        }
    }


}
