package com.company;

public class Point {
    private int x;
    private int y;
    private String content;

    public Point(int x, int y, String content) {
        this.x = x;
        this.y = y;
        this.content = content;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.content = null;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
