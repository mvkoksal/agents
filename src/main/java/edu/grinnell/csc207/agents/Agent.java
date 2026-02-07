package edu.grinnell.csc207.agents;
import java.util.Random;
import java.util.ArrayList;

public class Agent{
    int currentPos;
    int points;
    
    public Agent() {
        currentPos = 13;
        points = 0;
    }

    public int pickDirection(){
        Random random = new Random();
        int randomNum = random.nextInt(0,10);
        int randomDir = -1;
        if(randomNum == 0 || randomNum == 1) {
            //up
            randomDir = 0;
        } else if(randomNum == 2 || randomNum == 3 || randomNum == 4) {
            //down
            randomDir = 1;
        } else if (randomNum == 5 || randomNum == 6) {
            //left
            randomDir = 2;
        } else {
            //right
            randomDir = 3;
        }
        return randomDir;
    }

    public int canMove(ArrayList<String> environment, int dir) {
        if (dir == 0) { // up
            if (environment.get(currentPos - 26).equals("0") || currentPos - 26 < 0) {
                return -1;
            } else {
                return currentPos - 26;
            }
        } else if (dir == 1) { // down
            if (environment.get(currentPos + 26).equals("0") || currentPos + 26 > 648) {
                return -1;
            } else {
                return currentPos + 26;
            }
        } else if (dir == 2) { // left
            if (environment.get(currentPos - 1).equals("0") || environment.get(currentPos - 1).equals("\n")) {
                return -1;
            } else {
                return currentPos - 1;
            }
        } else { // right
            if (environment.get(currentPos + 1).equals("0") || environment.get(currentPos + 1).equals("\n")) {
                return -1;
            } else {
                return currentPos + 1;
            }
        }
    }

    public void move(ArrayList<String> environment) {
        int dir = pickDirection();
        int canmove = canMove(environment, dir);
        while (canmove != -1) {
            dir = pickDirection();
            canmove = canMove(environment, dir);
            currentPos = canmove;
        } 
    }
}
    
