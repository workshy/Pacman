package com.company;


public class Field {

    private final int size;
    private Point[][] field;
    public final Point enter;
    public final Point exit;
    public Point treasure;
    private boolean treasureFound;
    private int temp;

    public Field () {
        this.size = 19;
        this.field = new Point[size][size];
        fillField();
        this.enter = field[(size-1)/ 2][0] = new Point((size-1)/ 2, 0, "  ");
        this.exit = field[(size-1)/ 2][size-1] = new Point((size-1)/ 2, size-1, "  ");
        this.treasure = null;
        this.treasureFound = false;
        this.temp = 0;
    }

    public boolean getTreasureFound() {
        return treasureFound;
    }

    public void setTreasureFound(boolean bool) {
        this.treasureFound = bool;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int num) {
        this.temp = num;
    }

    private void createWalls() {
        for ( int i = 0; i < this.size; i++ ) {
            for ( int j = 0; j < this.size; j++ ) {
                if ( (i == 0 || i == this.size -1 || j == 0 || i == this.size -1 || j == this.size -1) && field[i][j] == null ) {
                    field[i][j] = new Point(i, j, "[]");
                }
            }
        }
        for ( int i = 4; i < 15; i++ ) {
            for ( int j = 4; j < 15; j++ ) {
                if ( (i == 8 && (j == 8 || j == 10)) || (i == 10 && (j == 8 || j == 10)) ) {
                    field[i][j] = new Point(i, j, "[]");
                }
                if ( (i == 4 || i == 14) && (j < 8 || j > 10) ) {
                    field[i][j] = new Point(i, j, "[]");
                }
                if ( (i < 8 || i > 10) && (j == 4 || j == 14) ) {
                    field[i][j] = new Point(i, j, "[]");
                }
            }
        }

    }

    public void fillField() {
        createWalls();

        for ( int i = 0; i < size; i++ ) {
            for ( int j = 0; j < size; j++ ) {
                if ( field[i][j] == null ) {
                    field[i][j] = new Point(i, j, ". ");
                }
            }
        }
    }

    public int getSize() {
        return this.size;
    }

    public Point[][] getField() {
        return this.field;
    }

    public void show() {
        for ( int i = 0; i < this.size; i++ ) {
            for ( int j = 0; j < this.size; j++  ) {
                System.out.print(field[i][j].getContent());
            }
            System.out.println();
        }
    }

    public boolean isEmpty () {
        for ( int i = 0; i < size; i++ ) {
            for ( int j = 0; j < size; j++ ) {
                if ( field[i][j].getContent() == ". " ) {
                    return false;
                }
            }
        }

        return true;
    }

}
