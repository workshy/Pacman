package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import static java.lang.Thread.*;

public class Main {
    public static void startGame() throws InterruptedException {
        System.out.println("PACMAN");
        System.out.println();
        System.out.println("Сharacters:");
        System.out.println();
        System.out.println("\"P \" - pacman(your character)");
        System.out.println("\"G \" - ghost(enemy)");
        System.out.println();
        System.out.println("Keys:");
        System.out.println();
        System.out.println("\"w + Enter\" - move straight");
        System.out.println("\"z + Enter\" - move back");
        System.out.println("\"s + Enter\" - move right");
        System.out.println("\"a + Enter\" - move left");
        System.out.println();
        System.out.println("Bonus:");
        System.out.println();
        System.out.println("\"<>\" - treasure(take it, and ghosts are vulnerable)");
        System.out.println();
        System.out.println("Are you ready?");
        System.out.println("Press Enter");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("GOOD LUCK!");
        sleep(5000);
    }

    public static void isWon(Pacman pacman, Field field) {
        if (pacman.getState() && field.isEmpty() && pacman.getPossition() == field.exit) {
            System.out.println("Congratulations!");
            System.out.println("You won!");
        }
    }

    public static void isLost(Pacman pacman){
        if (!pacman.getState()) {
            System.out.println("Sorry!");
            System.out.println("You lost..");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        startGame();

        Field field = new Field();
        Ghost ghost2 = null;
        Ghost ghost1 = null;
        Pacman pacman = new Pacman(field.enter);
        int count = 0;

        Scanner scanner = new Scanner(System.in);

        field.show();

        while (pacman.getState()) {
            char c;
            c = scanner.next().charAt(0);

            switch (c) {
                case 'w':
                    pacman.moveStraight(field);
                    field.show();
                    count++;
                    break;
                case 'z':
                    pacman.moveBack(field);
                    field.show();
                    count++;
                    break;
                case 'a':
                    pacman.moveLeft(field);
                    field.show();
                    count++;
                    break;
                case 's':
                    pacman.moveRight(field);
                    field.show();
                    count++;
                    break;

            }

            if ( count == 6 ) {
                ghost1 = new Ghost(field.enter);
            }

            if ( count > 6 && count % 2 == 0 ) {
                if ( !field.getTreasureFound() ) {
                    ghost1.move(pacman, field);
                } else {
                    ghost1.escape(pacman, field);
                    if ( field.getTemp() <= 0 ) {
                        field.setTreasureFound(false);
                    }
                }
            }

            if ( count == 12 ) {
                ghost2 = new Ghost(field.enter);
            }

            if ( count > 12 && count % 2 == 0 ) {
                if ( !field.getTreasureFound() ) {
                    ghost2.move(pacman, field);
                } else {
                    ghost2.escape(pacman, field);
                    if ( field.getTemp() <= 0 ) {
                        field.setTreasureFound(false);
                    }
                }
            }

            if ( count == 24 ) {
                field.treasure = field.getField()[(field.getSize()-1)/ 2][(field.getSize()-1)/ 2] = new Point((field.getSize()-1)/ 2, (field.getSize()-1)/ 2, "<>");
            }

            if ( field.getTreasureFound() ) {
                field.setTemp((field.getTemp() - 1));
            }

            isWon(pacman, field);
        }
        isLost(pacman);

        return;
    }
}
