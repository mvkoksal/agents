package edu.grinnell.csc207.agents;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Environment {

    public ArrayList<String> environment;
    
    public Environment() {
        environment = new ArrayList<>();
    }

    public void readEnvironment() throws IOException {

        File file = new File("env.txt");
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter("");


        while(scanner.hasNext()) {
            String character = scanner.next();
            environment.add(character);
        }

        scanner.close();
    }

    public void printEnvironment() {
        for (int i = 0; i < environment.size(); i++) {
            System.out.printf(environment.get(i));
        }
    }



    public static void main(String[] args) throws IOException {
        int moveCounter = 0;
        int test = 2;
        Environment env = new Environment();

        ArrayList<Agent> agents = new ArrayList<>();
        Agent agent1 = new Agent(13);
        Agent agent2 = new Agent(636);
        Agent agent3 = new Agent(413);
        agents.add(agent1);
        agents.add(agent2);
        agents.add(agent3);


        env.readEnvironment();
        for(int i=0; i<agents.size(); i++){
            env.environment.set(agents.get(i).currentPos, "I");
        }
        
        env.printEnvironment();
        System.out.printf("\n--------------------------\n");



        while(agent1.points == 0 || agent2.points == 0 || agent3.points == 0) {
            moveCounter++;

            for(int i=0; i<agents.size(); i++){
                if (agents.get(i).canMoveAtAll(env.environment)){
                    agents.get(i).move(env.environment, test, i);
                    if (agents.get(i).points < 1) {
                        agents.get(i).numMoves++;
                    }
                }
            }

            
        }

        System.out.printf("\n--------------------------\n");

        env.printEnvironment();
        
        System.out.printf("\nTotal iterations: " + moveCounter + "\n");

        System.out.printf("\nAgent 1 ate " + agent1.points + " food");
        System.out.printf("\nAgent 2 ate " + agent2.points + " food");
        System.out.printf("\nAgent 3 ate " + agent3.points + " food");
        System.out.printf("\nThe total number of food eaten was " + (agent1.points + agent2.points + agent3.points) + " food");
        System.out.printf("\nThe average number of food eaten was " + (agent1.points + agent2.points + agent3.points) / 3.0 + " food\n");


        System.out.printf("\nThe optimal number of moves for agent 1 was 8");
        System.out.printf("\nThe optimal number of moves for agent 2 was 11");
        System.out.printf("\nThe optimal number of moves for agent 3 was 6\n");

        int[] moves = new int[3];
        for(int i=0; i<agents.size(); i++){
            moves[i] = agents.get(i).numMoves;
            System.out.printf("\nAgent " + (i + 1) + " moved " + agents.get(i).numMoves +  " times");
        }
        Arrays.sort(moves);

        System.out.printf("\nThe total number of moves was " + (agent1.numMoves + agent2.numMoves + agent3.numMoves) + " moves");
        System.out.printf("\nThe average number of moves was " + (agent1.numMoves + agent2.numMoves + agent3.numMoves) / 3.0 + " moves");
        System.out.printf("\nThe median number of moves was " + moves[1] + " moves\n");
    }


}
