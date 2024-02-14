//Filename: Roller.java
//Author: Keidy Lopez
//Description: roller class for lab 9

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Roller {
    public ArrayList<Integer> rolls = new ArrayList<Integer>();
    private ArrayList<Integer> rollResults = new ArrayList<Integer>();

    //-----------------//
    //   CONSTRUCTOR   //
    //-----------------//

    public Roller() {
    }

    //-------------------//
    //   OTHER METHODS   //
    //-------------------//

    //rolls a specified amount of die and returns the sum of all those rolls
    public int roll(int numDice) {
        int sum = 0;
        Random random = new Random();
        for (int i = 0; i < numDice; i++) {
            int die = random.nextInt(1, 6);
            sum += die;
            rolls.add(die);
        }
        rollResults.add(sum);
        return sum;
    }

    //returns average in rolls arraylist
    public int getAverage() {
        if (!rolls.isEmpty()) {
            double sum = 0;
            int size = rolls.size();
            for (int i : rolls) {
                sum += i;
            }
            int average = (int) Math.ceil(sum / rolls.size());
            return average;
        }
        //if arraylist is empty the default average is 0
        return 0;
    }

    public int getLastRoll() {
        if (!rollResults.isEmpty()) {
            int lastRoll = rollResults.get(rollResults.size() - 1);
            return lastRoll;
        }
        return 0;
    }

    public void saveToFile(String filename) {
        File fOutput = new File(filename);
        try {
            PrintStream fInput = new PrintStream(fOutput);
            for (int i : rolls) {
                fInput.print(i);
                fInput.print(",");
            }
            fInput.close();
        } catch (IOException exception) {
            System.out.print("Error occurred while processing the information");
            exception.printStackTrace();
            System.exit(1);
        }
    }

    public void readFile(String filename) {
        rolls.clear();
        File fOutput = new File(filename);
        try {
            Scanner fInput = new Scanner(fOutput);
            String arrayRolls = fInput.nextLine();
            String[] newRolls= arrayRolls.split(",");
            if(!(newRolls.length==0)){
                for(int i= 0;i<newRolls.length;i++){
                    rolls.add(Integer.valueOf(newRolls[i]));
                }

            }

            fInput.close();
        } catch (IOException exception) {
            System.out.print("Error occurred while processing the information");
            exception.printStackTrace();
            System.exit(1);

        }
    }

        public static void main (String[]args){
            Roller roller = new Roller();

            roller.roll(3);
            System.out.print(roller.rolls);
            roller.saveToFile("rolls.csv");

            roller.readFile("rolls.csv");
            System.out.print(roller.rolls);

        }
    }
