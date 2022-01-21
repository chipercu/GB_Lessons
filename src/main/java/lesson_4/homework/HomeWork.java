package lesson_4.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HomeWork {

    public static int[][] place2 = new int[11][30];
    public static boolean[] cellCheck = {false, false, false, false, false, false, false, false, false, false};


    public static void main(String[] args) {

        System.out.println("Игра крестики и нолики");

        System.out.println("Вы начинаете первым");
        initializePlace();
        drawPlace();
        System.out.print("Введите цифру в какую ячейку поставить \"Х\" :");
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            if (checkWin()) {
                return;
            }
            push(selectCell(sc), true);
            //computerMedium();
            push(new ComputerAI(place2, cellCheck).computerMedium(), false);
            drawPlace();
            if (checkWin()) {
                return;
            }
            System.out.print("Введите цифру в какую ячейку поставить \"Х\" :");
        }
    }

    public static int selectCell(Scanner scanner) {
        int id = 0;
        while (id < 1 || id > 10) {
            try {
                id = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Только цифры от 1 до 9!!");
                scanner.next();
            }
        }
        return id;
    }

    public static void computerMedium() {
        int cell = 3;
        int[] arr = {0, place2[1][5], place2[5][5], place2[9][5], place2[1][15], place2[5][15], place2[9][15], place2[1][24], place2[5][24], place2[9][24]};
        List<Integer> stage = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            if (arr[i] > 0) {
                stage.add(arr[i]);

            }
        }
        if (stage.size() == 1 && arr[5] == 3) {
            cell = Rnd.getInt(1, 4);
            if (cell == 1) {
                cell = 1;
            } else if (cell == 2) {
                cell = 3;
            } else if (cell == 3) {
                cell = 7;
            } else if (cell == 4) {
                cell = 9;
            }
        } else if (stage.size() == 1 && (arr[1] == 3 || arr[3] == 3 || arr[7] == 3 || arr[9] == 3)) {
            cell = Rnd.getInt(1, 5);
            if (cell == 1) {
                cell = 2;
            } else if (cell == 2) {
                cell = 4;
            } else if (cell == 3) {
                cell = 6;
            } else if (cell == 4) {
                cell = 8;
            } else if (cell == 5) {
                cell = 5;
            }
        } else if (stage.size() >= 2) {
            cell = Rnd.getInt(1, 9);
            while (cellCheck[cell]) {
                cell = Rnd.getInt(1, 9);
            }
        }

        push(cell, false);
    }

    public static boolean checkWin() {
        int[] arr = {0, place2[1][5], place2[5][5], place2[9][5], place2[1][15], place2[5][15], place2[9][15], place2[1][24], place2[5][24], place2[9][24]};
        if ((arr[1] + arr[2] + arr[3] == 9) ||
                (arr[4] + arr[5] + arr[6] == 9) ||
                (arr[7] + arr[8] + arr[9] == 9) ||
                (arr[1] + arr[4] + arr[7] == 9) ||
                (arr[2] + arr[5] + arr[8] == 9) ||
                (arr[3] + arr[6] + arr[9] == 9) ||
                (arr[1] + arr[5] + arr[9] == 9) ||
                (arr[3] + arr[5] + arr[7] == 9)
        ) {
            System.out.println("Поздравляю с победой !! ");
            return true;
        } else if (
                (arr[1] + arr[2] + arr[3] == 12) ||
                        (arr[4] + arr[5] + arr[6] == 12) ||
                        (arr[7] + arr[8] + arr[9] == 12) ||
                        (arr[1] + arr[4] + arr[7] == 12) ||
                        (arr[2] + arr[5] + arr[8] == 12) ||
                        (arr[3] + arr[6] + arr[9] == 12) ||
                        (arr[1] + arr[5] + arr[9] == 12) ||
                        (arr[3] + arr[5] + arr[7] == 12)
        ) {
            System.out.println("Компютер выйграл!! ");
            return true;
        } else if (arr[1] + arr[2] + arr[3] + arr[4] + arr[5] + arr[6] + arr[7] + arr[8] + arr[9] > 30) {
            System.out.println("Ничья!!");
            return true;
        }
        return false;
    }

    public static void push(int id, boolean player) {
        if (id == 1) {
            place2[1][5] = player ? 3 : 4;
            cellCheck[1] = true;
        } else if (id == 4) {
            place2[5][5] = player ? 3 : 4;
            cellCheck[4] = true;
        } else if (id == 7) {
            place2[9][5] = player ? 3 : 4;
            cellCheck[7] = true;
        } else if (id == 2) {
            place2[1][15] = player ? 3 : 4;
            cellCheck[2] = true;
        } else if (id == 5) {
            place2[5][15] = player ? 3 : 4;
            cellCheck[5] = true;
        } else if (id == 8) {
            place2[9][15] = player ? 3 : 4;
            cellCheck[8] = true;
        } else if (id == 3) {
            place2[1][24] = player ? 3 : 4;
            cellCheck[3] = true;
        } else if (id == 6) {
            place2[5][24] = player ? 3 : 4;
            cellCheck[6] = true;
        } else if (id == 9) {
            place2[9][24] = player ? 3 : 4;

            cellCheck[9] = true;
        }
    }

    public static void initializePlace() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 30; j++) {
                if (j == 10 || j == 19) {
                    place2[i][j] = 1;
                }
                if (i == 3 || i == 7) {
                    place2[i][j] = 2;
                }
                if ((i == 0 || i == 4 || i == 8) && (j == 0 || j == 11 || j == 20)) {
                    place2[i][j] = 5;
                }
            }
        }
    }

    public static void drawPlace() {
        int boxId = 1;
        System.out.println();
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 30; j++) {
                if (place2[i][j] == 0) {
                    System.out.print(" ");
                } else if (place2[i][j] == 1) {
                    System.out.print("|");
                } else if (place2[i][j] == 2) {
                    System.out.print("_");
                } else if (place2[i][j] == 3) {
                    System.out.print("X");
                } else if (place2[i][j] == 4) {
                    System.out.print("O");
                } else if (place2[i][j] == 5) {
                    System.out.print(boxId);
                    boxId++;
                }
            }
            System.out.println();
        }
    }

    static class Rnd {
        public static int getInt(int v1, int v2) {
            double rnd = Math.random();
            return (int) ((rnd * (v2 - v1)) + v1);
        }
    }

}
