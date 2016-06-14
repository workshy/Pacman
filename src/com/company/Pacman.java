package com.company;

public class Pacman extends Player {
    private Point possition;
    private boolean state;
    public final String image;

    public Pacman(Point start) {
        this.possition = start;
        this.image = "P ";
        start.setContent(this.image);
        this.state = true;
    }

    public Point getPossition() {
        return this.possition;
    }

    public boolean getState() {
        return this.state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    protected boolean checkMove(Point point) {
        if ( this.state && point.getContent() != "[]" ) {
            return true;
        }

        return false;
    }

    private boolean checkCoordinates(int x, int y) {
        if (x >= 0 && x < 19 && y >= 0 && y < 19) {
            return true;
        }

        return false;
    }

    private void checkTreasure(Field field) {
        if ( field.treasure != null ) {
            if (!field.getTreasureFound() && possition == field.treasure) {
                field.setTreasureFound(true);
                field.setTemp(20);
                field.treasure.setContent(possition.getContent());
                field.treasure = null;
            }
        }
    }

    private void makeMove(Point point, Field field) {
        if (checkMove(point)) {
            possition.setContent("  ");
            possition = point;
            possition.setContent(this.image);
        }
        checkTreasure(field);
    }

    public void moveStraight(Field field) {
        if ( checkCoordinates(possition.getX() - 1, possition.getY())) {
            Point point = field.getField()[(possition.getX() - 1)][possition.getY()];
            makeMove(point, field);
        }
    }

    public void moveBack(Field field) {
        if (checkCoordinates(possition.getX() + 1, possition.getY())) {
            Point point = field.getField()[(possition.getX() + 1)][possition.getY()];
            makeMove(point, field);
        }
    }

    public void moveRight(Field field) {
        if (checkCoordinates(possition.getX(), possition.getY() + 1)) {
            Point point = field.getField()[possition.getX()][(possition.getY() + 1)];
            makeMove(point, field);
        }
    }

    public void moveLeft(Field field) {
        if (checkCoordinates(possition.getX(), possition.getY() - 1)) {
            Point point = field.getField()[possition.getX()][(possition.getY() - 1)];
            makeMove(point, field);
        }
    }
}
