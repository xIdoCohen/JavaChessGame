package Objects;

import java.awt.*;

public abstract class Square {
    private int row;
    private int col;

    public boolean isThreatend() {
        return threatend;
    }

    public void setThreatend(boolean threatend) {
        this.threatend = threatend;
    }

    private boolean threatend;

    public Square(int row, int col) {
        this.row=row;
        this.col=col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
    public boolean inRange(int i,int j){
        return i>=0 && i<=7 && j>=0 &&j<=7;
    }
    public Color getColor(int i,int j){
        if((row % 2 == 0 && col % 2 == 0 || row % 2 == 1 && col % 2 == 1)){
            return (new Color(224, 220, 220));
        }
        else return new Color(52, 52, 52);
    }
}
