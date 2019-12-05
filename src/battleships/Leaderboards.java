
package battleships;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;


public class Leaderboards {
    
    public static Random rand = new Random();
    
    public static void CheckBoards(){
        Scanner inputFile = null;
        
        try {
            inputFile = new Scanner (new File("res/All.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found: "+e);
            System.exit(-1);
        }
        try {
            inputFile = new Scanner (new File("res/Easy.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found: "+e);
            System.exit(-1);
        }
        try {
            inputFile = new Scanner (new File("res/Hard.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found: "+e);
            System.exit(-1);
        }
        
        try {
            inputFile = new Scanner (new File("res/Medium.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found: "+e);
            System.exit(-1);
        }
        
        
    }
    
    
    public static void WriteToBoards(String name, int score, String Difficulty) throws IOException{
        FileWriter writeToFile = null;
        PrintWriter printToFile = null;
        try {
            writeToFile = new FileWriter ("res/All.txt",true);
            printToFile = new PrintWriter(writeToFile);
        } catch (IOException e) {
            System.out.println("File not found: "+e);
            System.exit(-1);
        }
        printToFile.println(score + " " + name + " " + Difficulty);
        printToFile.close();
        writeToFile.close();
        if("e".equals(Difficulty)){
            try {
                writeToFile = new FileWriter ("res/Easy.txt",true);
                printToFile = new PrintWriter(writeToFile);
            } catch (IOException e) {
                System.out.println("File not found: "+e);
                System.exit(-1);
            }
            printToFile.println(score + " - " + name );
            printToFile.close();
            writeToFile.close();
        }else if ("m".equals(Difficulty)){
            try {
                writeToFile = new FileWriter ("res/Medium.txt",true);
                printToFile = new PrintWriter(writeToFile);
            } catch (IOException e) {
                System.out.println("File not found: "+e);
                System.exit(-1);
            }
            printToFile.println(score + " - " + name );
            printToFile.close();
            writeToFile.close();
        }else if ("h".equals(Difficulty)){
            try {
                writeToFile = new FileWriter ("res/Hard.txt",true);
                printToFile = new PrintWriter(writeToFile);
            } catch (IOException e) {
                System.out.println("File not found: "+e);
                System.exit(-1);
            }
            printToFile.println(score + " - " + name );
            printToFile.close();
            writeToFile.close();
        }
        
    }
    
}
