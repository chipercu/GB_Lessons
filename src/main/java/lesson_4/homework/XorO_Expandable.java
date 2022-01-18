package lesson_4.homework;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class XorO_Expandable {

    public static char[][] gameBird;
    public static int birdSize = 5;
    public static final char POINT_X = 'X';
    public static final char POINT_O = 'Ο';
    public static final char POINT_EMPTY = '◦';
    public static Player player = new Player("user_123");
    public static Scanner SCANNER = new Scanner(System.in);
    public static Random RANDOM = new Random();
    public static int computerWinCount;


    public static void main(String[] args) {
        System.out.println("Game Start! Ваш никнайм \"" + player.getName() + "\", хотите его поменять?, (y/n)");
        player.changeNickName();

        while (nextGame()){
            initBird();
            newGame();
        }
    }
    /**
     * метод потвержедния новой игры
     * @return
     */
    public static boolean nextGame(){
        System.out.println("Счет : " + player.getName() + " - " + player.getScore() + "| Computer - " + computerWinCount);
        System.out.print("Начать новую игру?, (y/n)");
        return SCANNER.next().equalsIgnoreCase("y");
    }
    /**
     * запуск новой партии игры
     */
    public static void newGame(){
        do {
            drawBird();
            playerTurn();
            if (checkWin(POINT_X)){
                drawBird();
                System.out.println("Вы выйграли!!");
                player.setScore(player.getScore() + 1);
                break;
            }
            if (checkIfBirdIsFull()){
                System.out.println("Ничья!");
                break;
            }
            drawBird();
            computerTurn(POINT_X);
            if (checkWin(POINT_O)){
                drawBird();
                System.out.println("Компютер выйграл!!");
                computerWinCount++;
                break;
            }
            if (checkIfBirdIsFull()){
                System.out.println("Ничья!");
                break;
            }
        }while (true);
    }

    /**
     * проверка на ничью
     * @return
     */
    public static boolean checkIfBirdIsFull(){
        for (int i = 0; i < gameBird.length; i++) {
            for (int j = 0; j < gameBird[i].length; j++) {
                if (gameBird[i][j] == POINT_EMPTY){
                    return false;
                }
            }

        }

        return true;
    }

    /**
     * метод проверки выйгрышных комбинаций
     * @param point
     * @return
     */
    public static boolean checkWin(char point){
        for (int i = 0; i < gameBird.length; i++) {
            if (gameBird[i][0] == point && gameBird[i][1] == point && gameBird[i][2] == point && gameBird[i][3] == point)
                return true;
            if (gameBird[i][1] == point && gameBird[i][2] == point && gameBird[i][3] == point && gameBird[i][4] == point)
                return true;
        }
        for (int i = 0; i < gameBird.length; i++) {
            if (gameBird[0][i] == point && gameBird[1][i] == point && gameBird[2][i] == point && gameBird[3][i] == point)
                return true;
            if (gameBird[1][i] == point && gameBird[2][i] == point && gameBird[3][i] == point && gameBird[4][i] == point)
                return true;
        }
        if (gameBird[0][0] == point && gameBird[1][1] == point && gameBird[2][2] == point && gameBird[3][3] == point){return true;}
        if (gameBird[0][1] == point && gameBird[1][2] == point && gameBird[2][3] == point && gameBird[3][4] == point){return true;}
        if (gameBird[1][0] == point && gameBird[2][1] == point && gameBird[3][2] == point && gameBird[4][3] == point){return true;}
        if (gameBird[1][1] == point && gameBird[2][2] == point && gameBird[3][3] == point && gameBird[4][4] == point){return true;}
        if (gameBird[3][0] == point && gameBird[2][1] == point && gameBird[1][2] == point && gameBird[0][3] == point){return true;}
        if (gameBird[3][1] == point && gameBird[2][2] == point && gameBird[1][3] == point && gameBird[0][4] == point){return true;}
        if (gameBird[4][0] == point && gameBird[3][1] == point && gameBird[2][2] == point && gameBird[1][3] == point){return true;}
        if (gameBird[4][1] == point && gameBird[3][2] == point && gameBird[2][3] == point && gameBird[1][4] == point){return true;}
        return false;
    }

    /**
     * ход компютера / код можно упростить (рефакторить:), но уже не успеваю!)
     * @param point
     */
    public static void computerTurn(char point){
        int x = RANDOM.nextInt(birdSize) - 1;
        int y = RANDOM.nextInt(birdSize) - 1;
        while (!isValidPoint(x, y)){
            x = RANDOM.nextInt(birdSize) - 1;
            y = RANDOM.nextInt(birdSize) - 1;
        }
        for (int i = 0; i < gameBird.length; i++) {

            if (gameBird[i][0] == point && gameBird[i][1] == point) {
                if (isValidPoint(2, i)) {
                    x = 2;
                    y = i;
                }
                gameBird[y][x] = POINT_O;
                return;
            }
            if (gameBird[i][1] == point && gameBird[i][2] == point){
                if (isValidPoint(3, i)) {
                    x = 3;
                    y = i;
                }else if (isValidPoint(0, i)){
                    x = 0;
                    y = i;
                }
                gameBird[y][x] = POINT_O;
                return;
            }
            if (gameBird[i][2] == point && gameBird[i][3] == point){
                if (isValidPoint(4, i)) {
                    x = 4;
                    y = i;
                }else if (isValidPoint(1, i)){
                    x = 1;
                    y = i;
                }
                gameBird[y][x] = POINT_O;
                return;
            }
            if (gameBird[i][3] == point && gameBird[i][4] == point){
                if (isValidPoint(2, i)) {
                    x = 2;
                    y = i;
                    gameBird[y][x] = POINT_O;
                    return;
                }
            }
        }
        //TODO
        for (int i = 0; i < gameBird.length; i++) {

            if (gameBird[0][i] == point && gameBird[1][i] == point) {
                if (isValidPoint(i, 2)) {
                    x = i;
                    y = 2;
                }
                gameBird[y][x] = POINT_O;
                return;
            }
            if (gameBird[1][i] == point && gameBird[2][i] == point){
                if (isValidPoint(i, 3)) {
                    x = i;
                    y = 3;
                }else if (isValidPoint(i, 0)){
                    x = i;
                    y = 0;
                }
                gameBird[y][x] = POINT_O;
                return;
            }
            if (gameBird[2][i] == point && gameBird[3][i] == point){
                if (isValidPoint(i, 4)) {
                    x = i;
                    y = 4;
                }else if (isValidPoint(i, 1)){
                    x = i;
                    y = 1;
                }
                gameBird[y][x] = POINT_O;
                return;
            }
            if (gameBird[3][i] == point && gameBird[4][i] == point){
                if (isValidPoint(2, i)) {
                    x = 2;
                    y = i;
                }
                gameBird[y][x] = POINT_O;
                return;
            }
        }
        System.out.println(y + " " + x);
        gameBird[y][x] = POINT_O;
    }


    /**
     * метод запрашивает у игрока куда поставить Х на сетке в формате координат x,y.
     */
    public static void playerTurn(){
        int x;
        int y;
        do {
            System.out.print("ВВедите координаты: ");
            x = SCANNER.nextInt();
            y = SCANNER.nextInt();
        }
        while (!isValidPoint(x, y));
        gameBird[y][x] = POINT_X;
    }

    /**
     * проверка, правельно ли игрок указал координаты, координаты не должни быть меньше нуля или больше размера поля.
     * так же проверяется не зането ли выброные координаты уже другим значением.
     * @param x
     * @param y
     * @return
     */
    public static boolean isValidPoint(int x, int y){
        if (x < 0 || y < 0 || x >= gameBird.length || y >= gameBird.length){
            return false;
        }
        return gameBird[y][x] == POINT_EMPTY;
    }

    /**
     * инициализация игровго поля
     */
    public static void initBird(){
        gameBird = new char[birdSize][birdSize];
        for (int i = 0; i < gameBird.length; i++) {
            Arrays.fill(gameBird[i], POINT_EMPTY);
        }
    }

    /**
     * метод отрисовывает игровое поле в консоль
     */
    public static void drawBird(){
        for (int i = 0; i < gameBird.length; i++) {
            if (i == 0){
                System.out.print("  0 ");
            }else {
                System.out.print( i + " ");
            }

        }
        System.out.println();
        for (int i = 0; i < gameBird.length; i++) {
            System.out.print(i  + " ");
            for (int j = 0; j < gameBird[i].length; j++){
                System.out.print(gameBird[i][j] + " ");
            }
            System.out.println();
        }

    }


    /**
     * Класс игрок !
     */
    public static class Player{
        private  String name;
        private  int score;

        public Player(String name) {
            this.name = name;
        }

        /**
         * метод для смены никнейма игрока
         */
        public void changeNickName() {
            if (SCANNER.next().equalsIgnoreCase("y")){
                System.out.print("Enter new nickname: ");
                player.setName();
            }
        }
        public String getName() {
            return name;
        }

        public void setName() {
            this.name = SCANNER.next();
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }

}
