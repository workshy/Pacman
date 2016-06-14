package com.company;

public class Ghost extends Player {
    private Point prevPossition;
    private boolean state;
    private String temp;
    protected Point possition;
    public String image;

    public Ghost(Point start) {
        this.possition = start;
        this.prevPossition = start;
        this.state = true;
        this.temp = start.getContent();
        this.image = "G ";
        start.setContent(this.image);
    }

    public Point getPossition() {
        return this.possition;
    }

    public Point getPrevPossition() {
        return this.prevPossition;
    }

    @Override
    protected boolean checkMove(Point point) {
        if (!this.state || point.getContent() == "[]" || point.getContent() == "G " ||
                point.getX() < 0 || point.getX() > 18 || point.getY() < 0 || point.getY() > 18) {
            return false;
        }

        return true;
    }

    protected void makeMove(Point point) {
        possition.setContent(prevPossition.getContent());
        prevPossition = possition;
        prevPossition.setContent(temp);
        temp = point.getContent();
        possition = point;
        possition.setContent(this.image);
    }

    private void isAlive(Pacman pacman, Field field) {
        if ( this.possition == pacman.getPossition() && this.state ) {
            if ( field.getTreasureFound() ) {
                this.state = false;
            } else {
                pacman.setState(false);
            }
        }
    }

    private void moveStraight(Field field) {
        makeMove(field.getField()[(possition.getX() - 1)][possition.getY()]);
    }

    private void moveBack(Field field) {
        makeMove(field.getField()[(possition.getX() + 1)][possition.getY()]);
    }

    private void moveRight(Field field) {
        makeMove(field.getField()[(possition.getX())][possition.getY() + 1]);
    }

    private void moveLeft(Field field) {
        makeMove(field.getField()[(possition.getX())][possition.getY() - 1]);
    }

    public void move(Pacman pacman, Field field) {
        if (this.possition.getX() > pacman.getPossition().getX() ) {
            if (checkMove(field.getField()[possition.getX() - 1][possition.getY()])) {
                moveStraight(field);
            } else if (checkMove(field.getField()[possition.getX()][possition.getY() + 1])) {
                moveRight(field);
            } else if (checkMove(field.getField()[possition.getX()][possition.getY() - 1])) {
                moveLeft(field);
            } else if (checkMove(field.getField()[possition.getX() + 1][possition.getY()])){
                moveBack(field);
            }
        } else if (this.possition.getX() < pacman.getPossition().getX()) {
            if (checkMove(field.getField()[possition.getX() + 1][possition.getY()])) {
                moveBack(field);
            } else if (checkMove(field.getField()[possition.getX()][possition.getY() - 1])) {
                moveLeft(field);
            } else if (checkMove(field.getField()[possition.getX()][possition.getY() + 1])) {
                moveRight(field);
            } else if (checkMove(field.getField()[possition.getX()][possition.getY() + 1])) {
                moveRight(field);
            }
        } else {
            if (this.possition.getY() > pacman.getPossition().getY()) {
                if (checkMove(field.getField()[possition.getX()][possition.getY() - 1])) {
                    moveLeft(field);
                } else if (checkMove(field.getField()[possition.getX() - 1][possition.getY()])) {
                    moveStraight(field);
                } else if (checkMove(field.getField()[possition.getX() + 1][possition.getY()])) {
                    moveBack(field);
                } else if (checkMove(field.getField()[possition.getX()][possition.getY() + 1])) {
                    moveRight(field);
                }
            } else if (this.possition.getY() < pacman.getPossition().getY()) {
                if (checkMove(field.getField()[possition.getX()][possition.getY() + 1])) {
                    moveRight(field);
                } else if (checkMove(field.getField()[possition.getX() - 1][possition.getY()])) {
                    moveStraight(field);
                } else if (checkMove(field.getField()[possition.getX() + 1][possition.getY()])) {
                    moveBack(field);
                } else if (checkMove(field.getField()[possition.getX()][possition.getY() - 1])) {
                    moveLeft(field);
                }
            }
        }

        isAlive(pacman, field);
    }

    public void escape(Pacman pacman, Field field) {
        if (this.possition.getX() > pacman.getPossition().getX() ) {
            if (checkMove(field.getField()[possition.getX() + 1][possition.getY()])){
                moveBack(field);
            } else if (checkMove(field.getField()[possition.getX()][possition.getY() + 1])) {
                moveRight(field);
            } else if (checkMove(field.getField()[possition.getX()][possition.getY() - 1])) {
                moveLeft(field);
            } else if (checkMove(field.getField()[possition.getX() - 1][possition.getY()])) {
                moveStraight(field);
            }
        } else if (this.possition.getX() < pacman.getPossition().getX()) {
            if (checkMove(field.getField()[possition.getX() - 1][possition.getY()])) {
                moveStraight(field);
            } else if (checkMove(field.getField()[possition.getX()][possition.getY() + 1])) {
                moveRight(field);
            } else if (checkMove(field.getField()[possition.getX()][possition.getY() - 1])) {
                moveLeft(field);
            } else if (checkMove(field.getField()[possition.getX() + 1][possition.getY()])){
                moveBack(field);
            }
        } else {
            if (this.possition.getY() > pacman.getPossition().getY()) {
                if (checkMove(field.getField()[possition.getX()][possition.getY() + 1])) {
                    moveRight(field);
                } else if (checkMove(field.getField()[possition.getX() - 1][possition.getY()])) {
                    moveStraight(field);
                } else if (checkMove(field.getField()[possition.getX() + 1][possition.getY()])) {
                    moveBack(field);
                } else if (checkMove(field.getField()[possition.getX()][possition.getY() - 1])) {
                    moveLeft(field);
                }
            } else if (this.possition.getY() < pacman.getPossition().getY()) {
                if (checkMove(field.getField()[possition.getX()][possition.getY() - 1])) {
                    moveLeft(field);
                } else if (checkMove(field.getField()[possition.getX() - 1][possition.getY()])) {
                    moveStraight(field);
                } else if (checkMove(field.getField()[possition.getX() + 1][possition.getY()])) {
                    moveBack(field);
                } else if (checkMove(field.getField()[possition.getX()][possition.getY() + 1])) {
                    moveRight(field);
                }
            }
        }

        isAlive(pacman, field);
    }


}
