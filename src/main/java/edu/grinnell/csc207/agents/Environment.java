package edu.grinnell.csc207.agents;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Environment {

    public ArrayList<String> environment;
    
    public Environment() {
        environment = new ArrayList<>();
    }

    public void readEnvironment() throws IOException {
        Scanner scanner = new Scanner(new File("env.txt"));

        while(scanner.hasNext()) {
            String character = scanner.next();
            environment.add(character);
            System.out.println(character);
        }

        scanner.close();
    }

    public void printEnvironment() {
        for (int row=0; row < 25; row++) {
            for (int col=0; col < 25; col++) {
                System.out.printf(environment.get(25*row+col));
            }
        } 
    }


    public static void main(String[] args) throws IOException {
        Environment env = new Environment();
        env.readEnvironment();
        env.printEnvironment();
    }


}
