package HanYo;

import java.awt.*;


public class Cell {

    //Declareing variables
    private int livingNeighbours;
    private boolean alive;
    private String name;
    private List neighborList;
    private int round;

    //Making the cell constructor
    public Cell() {
        livingNeighbours = -1;
        List neighborList = new List();
    }

    //What happens on game update
    public String update() {

        //If the cells alive, its alive.
        String cellStatus = "dead";
        if (alive) {
            cellStatus = "alive";
        }
        String status = "No changes.";

        //If 3 living neighbours it stays alive.
        if (!alive && (livingNeighbours == 3)) {
            alive = true;
            status = "Cell, James Cell reporting for duty";
        }
// if 2 living neighbours it stays alive.
        if (!alive && (livingNeighbours == 2)) {
            alive = true;
            status = "Cell lives another day";
        }
        if (!alive && (livingNeighbours == 3)) {
            alive = true;
            status = "Cell lives another day";
        }
        //If less than 2 it dies.
        if ((livingNeighbours < 2)) {
            if (!alive) {
                status = "Stays dead, too lonely";
            }

        }
        //If more than 3 it dies
        if ((livingNeighbours > 3)) if (!alive) {
            status = "stays dead, can't handle so many stupid people";
        }
        round++;
        return "Round: " + round + " - Completed.";
    }


    //Getters and setters for the different variables.
    public int getLivingNeighbours() {
        return livingNeighbours;
    }

    public void setLivingNeighbours(int livingNeighbours) {
        this.livingNeighbours = livingNeighbours;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getNeighborList() {
        return neighborList;
    }

    public void setNeighborList(List neighborList) {
        this.neighborList = neighborList;
    }

}
