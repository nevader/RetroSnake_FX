package pl.s24825;

public class Settings {

    private int columns = 12;
    private int rows = columns;
    private int speed = 120;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }


    public void setColumns(int columns) {
        this.columns = columns;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
}
