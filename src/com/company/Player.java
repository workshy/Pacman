package com.company;

public abstract class Player {
    public Player() {}

    protected boolean checkMove(Point point) {
        return false;
    }

    private void moveStraight(Point[][] field) {}

    private void moveBack(Point[][] field) {}

    private void moveRight(Point[][] field) {}

    private void moveLeft(Point[][] field) {}

    protected void makeMove(Point point) {}

}
