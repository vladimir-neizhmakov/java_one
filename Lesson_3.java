package ru.geekbrains.java_one.lesson_1;

import java.util.Random;
import java.util.Scanner;

public class Lesson_3 {
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '_';

    private static int fieldSizeX;
    private static int fieldSizeY;
    private static int symbolCount; // добавил переменную количества подряд идущих символов
    private static char[][] field;

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    //добавил метод инициализации игры
    private static void initGame() {
        do {
            System.out.println("Введите размер игрового поля X на Y и количество подряд идущих символов Z (1 < Z <= X,Y) через пробел >>> X Y Z >>> ");
            fieldSizeX = SCANNER.nextInt();
            fieldSizeY = SCANNER.nextInt();
            symbolCount = SCANNER.nextInt();
            if ((symbolCount > fieldSizeX) || (symbolCount > fieldSizeY)) System.out.println("Количество подряд идущих символов не может быть больше размера игрового поля, повторите ввод");
            if (symbolCount <= 1) System.out.println("Количество подряд идущих символов не может быть меньше или равна 1");
        } while ((symbolCount > fieldSizeX) || (symbolCount > fieldSizeY) || (symbolCount <= 1));
    }

    private static void initField() {
//        fieldSizeY = 3;
//        fieldSizeX = 3;
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    private static void printField() {
        System.out.println("------");
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                System.out.print(field[y][x] + "|");
            }
            System.out.println();
        }
    }

    private static boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >=0 && y < fieldSizeY;
    }

    private static boolean isEmptyCell(int x, int y) {
        return field[y][x] == DOT_EMPTY;
    }

    private static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Введите координаты хода X и Y (от 1 до 3) через пробел >>> ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isValidCell(x, y) || !isEmptyCell(x, y));
        field[y][x] = DOT_HUMAN;
    }

    private static void aiTurn() {
        int x;
        int y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(x, y));
        field[y][x] = DOT_AI;

    }

    private static boolean isFieldFull() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == DOT_EMPTY) return false;
            }
        }
        return true;
    }


    //проверяем есть ли последовательность количества символов по Y (строки)
    private static boolean checkValueY(char c){
        boolean value=true;
        for (int y = 0; y < fieldSizeY; y++) {
            value=true;
            for (int i = 0; i < symbolCount; i++) {
                value = value && field[y][i] == c;
            }
            if (value) return value;
        }
        return value;
    }

    //проверяем есть ли последовательность количества символов по X (столбцы)
    private static boolean checkValueX(char c){
        boolean value=true;
        for (int x = 0; x < fieldSizeX; x++) {
            value=true;
            for (int i = 0; i < symbolCount; i++) {
                value = value && field[i][x] == c;
            }
            if (value) return value;
        }
        return value;
    }

    //проверяем последовательность количества символов по диагоналям Left
    private static boolean checkValueDiagLeft(char c){
        boolean value=true;
        for (int y = 0; y < fieldSizeY-symbolCount ; y++) {
            value=true;
            for (int x = 0; x < fieldSizeX-symbolCount; x++) {
                value=true;
                for (int i = 0; i < symbolCount ; i++) {
                    value = value && field[i+y][i+x]==c;
                }
                if (value) return value;
            }
            if (value) return value;
        }
        return value;
    }

    //проверяем последовательность количества символов по диагоналям Right
    private static boolean checkValueDiagRight(char c){
        boolean value=true;
        for (int y = 0; y < fieldSizeY-symbolCount ; y++) {
            value=true;
            for (int x = 0; x < fieldSizeX-symbolCount; x++) {
                value=true;
                for (int i = 0; i < symbolCount ; i++) {
                    value = value && field[i+y][field.length-1-i-x]==c;
                }
                if (value) return value;
            }
            if (value) return value;
        }
        return value;

    }

    private static boolean checkWin(char c) {


        if (checkValueY(c)) return true;
        if (checkValueX(c)) return true;
        if (checkValueDiagLeft(c)) return true;
        if (checkValueDiagRight(c)) return true;

/*
        if (field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
        if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
        if (field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;

        if (field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
        if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
        if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;


        if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
        if (field[0][2] == c && field[1][1] == c && field[2][0] == c) return true;
*/
        return false;
    }

    public static void main(String[] args) {
//        while (true) {
        playOneRound();
//            System.out.println("Play again?");
//            if (SCANNER.next().equals("no"))
//                break;
//        }
    }

    private static void playOneRound() {
        initGame();
        initField();
        printField();
        while (true) {
            humanTurn();
            printField();
            if (checkWin(DOT_HUMAN)) {
                System.out.println("Выиграл игрок!");
                break;
            }
            if (isFieldFull()) {
                System.out.println("Ничья!");
                break;
            }
            aiTurn();
            printField();
            if (checkWin(DOT_AI)) {
                System.out.println("Выиграл компьютер!");
                break;
            }
            if (isFieldFull()) {
                System.out.println("Ничья!");
                break;
            }
        }
    }
}
