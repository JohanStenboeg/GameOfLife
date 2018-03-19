package HanYo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
//Setting up the arrays. Declareing variables.
private static int WORLD_SIZE_X = 15, WORLD_SIZE_Y = 10;

private Cell[][] arrayH = new Cell[WORLD_SIZE_X][WORLD_SIZE_Y];
private int lifeCycles;
private Game world;
private int round;

//Making the game constructor.
private Game(){
    round = 0;
    for(int y = 0; y < WORLD_SIZE_Y; y++){
    for (int x = 0; x < WORLD_SIZE_X; x++){
        Random randomGenerator = new Random();
        int r = randomGenerator.nextInt(2);
        Cell cell = new Cell();
        cell.setName("X" + x + "Y" + y);
        if(r == 0) {
            cell.setAlive(false);
        }else {
            cell.setAlive(true);
        }
        arrayH[x][y] = cell;

        }
    }
    }
    //Making an initialize method.
    public static Game initialize(){
    Game world = new Game();
    return world;
    }
    //Making game update method. Where it checks all surrounding positions for dead or alive cells.
    //Clockwise, starting with North.
    public Game update(){
        round++;
        int yMax = this.arrayH.length;
        int xMax = this.arrayH[0].length;
        for(int y = 0; y < yMax; y++){
            for(int x = 0; x < xMax; x++){
                List neighborList = new ArrayList();

                //CHEKING N
                if (y > 0){
                    if (arrayH[x][y-1].isAlive()){
                        neighborList.add("N");
                    }
                }

                //CHEKING NE
                if (x < WORLD_SIZE_X - 1 && y > 0){
                    if (arrayH[x+1][y-1].isAlive()){
                        neighborList.add("NE");
                    }
                }

                //CHEKING E
                if (x < WORLD_SIZE_X - 1){
                    if (arrayH[x+1][y].isAlive()){
                        neighborList.add("E");
                    }
                }

                //CHEKING SE
                if (x < WORLD_SIZE_X - 1 && y < WORLD_SIZE_Y - 1){
                    if (arrayH[x + 1][y + 1].isAlive()){
                        neighborList.add("SE");
                    }
                }

                //CHEKING S
                if (y < WORLD_SIZE_Y - 1){
                    if (arrayH[x][y + 1].isAlive()){
                        neighborList.add("S");
                    }
                }

                //CHEKING SW
                if (y < WORLD_SIZE_Y - 1 && x > 0){
                    if (arrayH[x - 1][y + 1].isAlive()){
                        neighborList.add("SW");
                    }
                }

                //CHEKING W
                if (x > 0){
                    if (arrayH[x - 1][y].isAlive()){
                        neighborList.add("W");
                    }
                }

                //CHEKING NW
                if ((x > 0) && (y > 0)){
                    if (arrayH[x + 1][y - 1].isAlive()){
                        neighborList.add("NW");
                    }
                }
                arrayH[x][y].setLivingNeighbours(neighborList.size());
                arrayH[x][y].setNeighborList((java.awt.List) neighborList);

            }
        }
        for (int y = 0; y < yMax; y++){
            for(int x = 0; x < xMax; x++){
                String result = arrayH[x][y].update();
            }
        }
        return world;



    }
    //Getters and setters

    public static int getWorldSizeX() {
        return WORLD_SIZE_X;
    }

    public static void setWorldSizeX(int worldSizeX) {
        WORLD_SIZE_X = worldSizeX;
    }

    public static int getWorldSizeY() {
        return WORLD_SIZE_Y;
    }

    public static void setWorldSizeY(int worldSizeY) {
        WORLD_SIZE_Y = worldSizeY;
    }

    public Cell[][] getArrayH() {
        return arrayH;
    }

    public void setArrayH(Cell[][] arrayH) {
        this.arrayH = arrayH;
    }

    public int getLifeCycles() {
        return lifeCycles;
    }

    public void setLifeCycles(int lifeCycles) {
        this.lifeCycles = lifeCycles;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }
}
