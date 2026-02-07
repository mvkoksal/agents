package edu.grinnell.csc207.agents;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Environment {

    public ArrayList<String> environment;
    
    public Environment() {
        environment = new ArrayList<>();
    }

    public void readEnvironment() throws IOException {

        File file = new File("env.txt");
        System.err.println(file.getAbsolutePath());
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter("");


        while(scanner.hasNext()) {
            String character = scanner.next();
            environment.add(character);
        }

        scanner.close();
    }

    public void printEnvironment() {
        // for (int row=0; row < 25; row++) {
        //     for (int col=0; col < 25; col++) {
        //         System.out.printf(environment.get(25*row+col));
        //     }
        // }
        //System.out.println(environment.size());
    }



    public static void main(String[] args) throws IOException {
        Environment env = new Environment();
        env.readEnvironment();
        env.printEnvironment();
    }


}
