import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        int[][] map = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
        int randX;
        int randY;
        int playerX;
        int playerY;
        int loot = 0;
        int findCount = (int) (1 + (Math.random() * 4));
        Scanner input = new Scanner(System.in);
        // Place coins in map
        for (int i = findCount; i > 0; i--) {
            randX = (int) (Math.random() * 4);
            randY = (int) (Math.random() * 4);
            if (map[randX][randY] > 0) {
                while (map[randX][randY] > 0) {
                    randX = (int) (Math.random() * 4);
                    randY = (int) (Math.random() * 4);

                }
            }
            map[randX][randY] = (int) (map[randX][randY] + (Math.random() * 10) + 1);
        }
        System.out.println("in this 5x5 grid there are hidden coins");
        while (findCount > 0) {
            System.out.println("enter X coordinate");
            playerX = input.nextInt() - 1;
            System.out.println("enter Y coordinate");
            playerY = input.nextInt() - 1;

            if (map[playerX][playerY] > 0) {
                System.out.println("you found " + map[playerX][playerY] + "coins");
                loot = (loot + map[playerX][playerY]);
                map[playerX][playerY] = -1;
                findCount = findCount - 1;
            } else if (map[playerX][playerY] == 0) {
                System.out.println("you didn't find anything at those coordinates");
                map[playerX][playerY] = -1;
            } else {
                System.out.println("you already checked these coordinates");
            }


        }
        System.out.println("you found all the loot! you got " + loot + "coins");
    }
}



