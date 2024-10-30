package Runner;

public class Tuple {
    private int row;
    private int col;

    public Tuple() {

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
    public Tuple(int row, int col)
    {
        this.row=row;
        this.col=col;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Tuple)
        {
            return this.col== ((Tuple) obj).col && this.row==((Tuple) obj).row;
        }
        return false;
    }

    @Override
    public String toString() {
        return "["+this.row +","+this.col+"]";
    }
}
