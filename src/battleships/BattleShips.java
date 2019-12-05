
package battleships;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class BattleShips {
    // if you dont want to go through everything i put i list of what i used here:
    // Classes
    // for loops
    // while loops
    // try catch
    // 2D arrays
    // switch case checks
    // methods 
    // unit.sleep
    // file writing (saving scores)
    
    // if you want to see the board with the location of the ships: uncomment lines 716 - 734
  
    public static void main(String[] args) throws Exception {
        
        //program wont run unless the leaderboard files are present
        Leaderboards.CheckBoards();
        
        Scanner input = new Scanner (System.in);
        Random rand = new Random();
        String[][] board = new String[10][10];
        String[][] ships = new String[10][10];
        Integer[][] ShipNumber = new Integer[10][10];
        
        
        
        
        int shipNum  = 0;
        
        int six = 0;
        int four = 0; 
        int three = 0;
        int two = 0;
        
        
        printwithdelay("Welcome to ",TimeUnit.MILLISECONDS, 500);
        System.out.println("Battle ships! ");
        printwithdelay("  ",TimeUnit.MILLISECONDS, 1000);
          System.out.println("");
        
        //assigning the spaces for shipnumber array------
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                ShipNumber[i][j]=0;
            }
        }
        
        
        //drawing board--------------------------
        for(int i = 0; i < 10; ++i) {
            System.out.print(" " + i + "  ");
        }

        System.out.println();
        
        for(int i = 0; i < 10; ++i) {
            for(int j = 0; j < 10; ++j) {
                board[i][j] = "| | ";
                System.out.print(board[i][j]);
            }

            System.out.print(" " + i);
            System.out.println("");
        }
        System.out.println("");
        System.out.println("");
        //-----------------------------------------
        
        System.out.println("This is your board ^");
        printwithdelay(" ",TimeUnit.MILLISECONDS,2000);
        System.out.println();
        System.out.println("This is a single player game agaisnt the computers board");
        printwithdelay(" ",TimeUnit.MILLISECONDS,3000);
        System.out.println("");
        System.out.println("Would you like it to be on (h):hard, (m):medium or (e):easy ?");
        printwithdelay(" ",TimeUnit.MILLISECONDS,1000);
        System.out.println("(awarded points will differ on difficulty)");
        printwithdelay(" ",TimeUnit.MILLISECONDS,500);
        
        


        int Difficulty = 0;
        String pointsawarded; 
        OUTER:
        while (true) {
            System.out.println("");
            System.out.print("Difficulty = ");
            String answer = input.next();
            System.out.println("");
            if (null == answer) {
                System.out.println("Incorrect input please try again...");
            } else {
                switch (answer) {
                    case "h":
                        Difficulty++;
                        pointsawarded="h";
                        break OUTER;
                    case "m":
                        Difficulty+=2;
                        pointsawarded="m";
                        break OUTER;
                    case "e":
                        Difficulty+=4;
                        pointsawarded="e";
                        break OUTER;
                    default:
                        System.out.println("Incorrect input please try again...");
                        break;
                }
            }
        }
        
        
        
        
        int hit = 1;
        int sink = 5;
        
        
        if(null != pointsawarded)switch (pointsawarded) {
            case "e":
                break;
            case "m":
                hit*=2;
                sink*=2;
                break;
            case "h":
                sink*=3;
                hit*=3;
                break;
            default:
                break;
        }
        
        
        
        
        
        //creating the invisible board with the boats to be drawn on
        
        
        for (int i = 0; i < 10; i++) {
//            System.out.print(" " + i + "  ");
        }
        System.out.println("");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                ships[i][j] = "| | ";
//                System.out.print(ships[i][j]);
            }
//            System.out.print(" " + i);
//            System.out.println("");
        }
        
        //creating 1 1x6 ----------------------
        int sixgoes = Difficulty*1;
        for (int i = 0; i < sixgoes; i++) {
            
            while (true){
                boolean breaking = false;
                int num2 = rand.nextInt(10);
                int num1 = rand.nextInt(10);
                int orientation  = rand.nextInt(2);
                if( orientation == 0 ){
                   
                    
                    ShipNumber[num2][num1] =shipNum;
                    int numEnd=num2+5;
                    int check = 1;
                    if(numEnd>9){
                        --check;
                        numEnd-=10;
                    }
                    if(numEnd>9 || numEnd<0){
                    }else{
                        if(check==1){
                            //checking that is isnt overwriting any other ships 
                            for (int j = num2; j < numEnd+1; j++) {
                                if(!"| | ".equals(ships[j][num1])){
                                    breaking=true;
                                }
                            }
                            //--------------------------------------------------
                            if(!breaking){
                                ++shipNum;
                                ShipNumber[num2][num1] =shipNum;
                                ships[num2][num1] = "|6| " ;
                                for (int j = num2+1; j < numEnd+1; j++) {
                                    ships[j][num1] = "|6| ";
                                    ShipNumber[j][num1] =shipNum;
                                }
                                ++six;
                            }else{
                                break;
                            }
                            
                        }else if(check==0){
                            //checking that is isnt overwriting any other ships 
                            for (int j = numEnd; j < num2; j++) {
                                if(!"| | ".equals(ships[j][num1])){
                                    
                                breaking=true;
                                }
                            }
                            //-------------------------------------------------
                        
                            if(!breaking){
                                ++shipNum;
                                ShipNumber[num2][num1] =shipNum;
                                ships[num2][num1] = "|6| " ;
                                for (int j = numEnd; j < num2; j++) {
                                    ships[j][num1] = "|6| ";
                                    ShipNumber[j][num1] =shipNum;
                                }
                                ++six;
                            }else{
                                break;
                            }
                        }
                        break;
                    }
                
                }else if ( orientation == 1 ){
                 
                    ShipNumber[num2][num1] =shipNum;
                    int numEnd=num1+5;
                    int check = 1;
                    if(numEnd>9){
                        --check;
                        numEnd-=10;
                    }
                    if(numEnd>9 || numEnd<0){
                        num2--;
                    }else{
                        if(check==1){
                            //checking that is isnt overwriting any other ships 
                            for (int j = num1; j < numEnd+1; j++) {
                                if(!"| | ".equals(ships[num2][j])){
                                    
                                    breaking=true;
                                }
                            }
                            //--------------------------------------------------
                            
                            if (!breaking){
                                ++shipNum;
                               for (int j = num1; j < numEnd+1; j++) {
                                ships[num2][j] = "|6| ";
                                ShipNumber[num2][j] =shipNum;
                                } 
                               ++six;
                            }else{
                                break;
                            }
                        }else if(check==0){
                            //checking that is isnt overwriting any other ships 
                            for (int j = numEnd; j < num1+1; j++) {
                                if(!"| | ".equals(ships[num2][j])){
                                    
                                breaking=true;
                                }
                            }
                            //-------------------------------------------------
                            
                            if(!breaking){
                                ++shipNum;
                                for (int j = numEnd; j < num1+1; j++) {
                                    ships[num2][j] = "|6| ";
                                    ShipNumber[num2][j] =shipNum;
                                }
                                ++six;
                            }else{
                                break;
                            }
                            
                        }
                        break;
                    }
                    
                    
                }
            }
            
        }
        
        
        
        //---------------------------------------------------------------
        
        //num2 = down
        //num1 = across
        
        //creating 1 : 1x4 ----------------------------------------------
        int fourgoes = Difficulty*2;
        for (int i = 0; i < fourgoes; i++) {
            while (true){
                boolean breaking = false;
                int num2 = rand.nextInt(10);
                int num1 = rand.nextInt(10);
                int orientation  = rand.nextInt(2);
                if( orientation == 0 ){
                    int numEnd = num2+3;
                    int check = 1;
                    if(numEnd>9){
                        --check;
                        numEnd-=6;
                    }
                    
                    
                    if(numEnd>9 || numEnd<0){
                    }else{
                        if(check==1){
                            //checking that is isnt overwriting any other ships 
                            for (int j = num2; j < numEnd+1; j++) {
                                if(!"| | ".equals(ships[j][num1])){
                                    breaking=true;
                                }
                            }
                            //--------------------------------------------------
                            if(!breaking){
                                ++shipNum;
                                ShipNumber[num2][num1] =shipNum;
                                ships[num2][num1] = "|4| " ;
                                for (int j = num2+1; j < numEnd+1; j++) {
                                    ships[j][num1] = "|4| ";
                                    ShipNumber[j][num1] =shipNum;
                                }
                                ++four;
                            }else{
                                break;
                            }
                        
                        
                        
                        }else if(check==0){
                            //checking that is isnt overwriting any other ships 
                            for (int j = numEnd; j < num2; j++) {
                                if(!"| | ".equals(ships[j][num1])){
                                    
                                breaking=true;
                                }
                            }
                            
                            //-------------------------------------------------
                        
                            if(!breaking){
                                ++shipNum;
                                ShipNumber[num2][num1] =shipNum;
                                ships[num2][num1] = "|4| " ;
                                for (int j = numEnd; j < num2; j++) {
                                    ships[j][num1] = "|4| ";
                                    ShipNumber[j][num1] =shipNum;
                                }
                                ++four;
                            }else{
                                break;
                            }
                                
                            
                        }
                        
                        
                    }
                    break;
                    
                }else if ( orientation == 1 ){
                    int numEnd = num1+3;
                    int check = 1;
                    if(numEnd>9){
                        --check;
                        numEnd-=6;
                    }
                    if(numEnd>9 || numEnd<0){
                        num2--;
                    }else{
                        if(check==1){
                            //checking that is isnt overwriting any other ships 
                            for (int j = num1; j < numEnd+1; j++) {
                                if(!"| | ".equals(ships[num2][j])){
                                    
                                    breaking=true;
                                }
                            }
                            //--------------------------------------------------
                            
                            if (!breaking){
                                ++shipNum;
                               for (int j = num1; j < numEnd+1; j++) {
                                ships[num2][j] = "|4| ";
                                ShipNumber[num2][j] =shipNum;
                                } 
                               ++four;
                            }else{
                                break;
                            }
                            
                        }else if(check==0){
                            //checking that is isnt overwriting any other ships 
                            for (int j = numEnd; j < num1+1; j++) {
                                if(!"| | ".equals(ships[num2][j])){
                                    
                                breaking=true;
                                }
                            }
                            //-------------------------------------------------
                            
                            if(!breaking){
                                ++shipNum;
                                for (int j = numEnd; j < num1+1; j++) {
                                    ships[num2][j] = "|4| ";
                                    ShipNumber[num2][j] =shipNum;
                                }
                                ++four;
                            }else{
                                break;
                            }
                            
                        }
                    }
                    break;
                }
                
            }
            
        }
        
        
        //creating 2 - 1x3 ----------------------------------------------
        int threegoes = Difficulty*4;
        for (int i = 0; i < threegoes; i++) {
            while (true){
                boolean breaking = false;
                int num2 = rand.nextInt(10);
                int num1 = rand.nextInt(10);
                int orientation  = rand.nextInt(2);
                if( orientation == 0 ){
                    int numEnd = num2+2;
                    int check = 1;
                    if(numEnd>9){
                        --check;
                        numEnd-=4;
                    }
                    
                    if(numEnd>9 || numEnd<0){
                    }else{
                        if(check==1){
                            //checking that is isnt overwriting any other ships 
                            for (int j = num2; j < numEnd+1; j++) {
                                if(!"| | ".equals(ships[j][num1])){
                                    breaking=true;
                                }
                            }
                            //--------------------------------------------------
                            if(!breaking){
                                ++shipNum;
                                ShipNumber[num2][num1] =shipNum;
                                ships[num2][num1] = "|3| " ;
                                for (int j = num2+1; j < numEnd+1; j++) {
                                    ships[j][num1] = "|3| ";
                                    ShipNumber[j][num1] =shipNum;
                                }
                                ++three;
                            }else{
                                break;
                            }
                        
                        
                        
                        }else if(check==0){
                            //checking that is isnt overwriting any other ships 
                            for (int j = numEnd; j < num2; j++) {
                                if(!"| | ".equals(ships[j][num1])){
                                    
                                breaking=true;
                                }
                            }
                            //-------------------------------------------------
                        
                            if(!breaking){
                                ++shipNum;
                                ShipNumber[num2][num1] =shipNum;
                                ships[num2][num1] = "|3| " ;
                                for (int j = numEnd; j < num2; j++) {
                                    ships[j][num1] = "|3| ";
                                    ShipNumber[j][num1] =shipNum;
                                }
                                ++three;
                            }else{
                                break;
                            }
                                
                            
                        }
                        
                        
                    }
                    break;
                    
                }else if (orientation==1){
                    int numEnd = num1+2;
                    int check = 1;
                    if(numEnd>9){
                        --check;
                        numEnd-=4;
                    }
                    if(numEnd>9 || numEnd<0){
                        num2--;
                    }else{
                        if(check==1){
                            
                            //checking that is isnt overwriting any other ships 
                            for (int j = num1; j < numEnd+1; j++) {
                                if(!"| | ".equals(ships[num2][j])){
                                    
                                    breaking=true;
                                }
                            }
                            //--------------------------------------------------
                            
                            if (!breaking){
                                ++shipNum;
                               for (int j = num1; j < numEnd+1; j++) {
                                    ships[num2][j] = "|3| ";
                                    ShipNumber[num2][j] =shipNum;
                                } 
                               ++three;
                            }else{
                                break;
                            }
                            
                        }else if(check==0){
                            
                            //checking that is isnt overwriting any other ships 
                            for (int j = numEnd; j < num1+1; j++) {
                                if(!"| | ".equals(ships[num2][j])){
                                    
                                breaking=true;
                                }
                            }
                            //-------------------------------------------------
                            
                            if(!breaking){
                                ++shipNum;
                                for (int j = numEnd; j < num1+1; j++) {
                                    ships[num2][j] = "|3| ";
                                    ShipNumber[num2][j] =shipNum;
                                }
                                ++three;
                            }else{
                                break;
                            }
                            
                        }
                    }
                    break;
                    
                }
                
            }
            
        }
        //creating the 1x2 ------------------------------------------
        int twogoes = Difficulty*5;
        for (int i = 0; i < twogoes; i++) {
            while (true){
                  boolean breaking = false;
                int num2 = rand.nextInt(10);
                int num1 = rand.nextInt(10);
                int orientation  = rand.nextInt(2);
                if( orientation == 0 ){
                    int numEnd = num2+1;
                    int check = 1;
                    if(numEnd>9){
                        --check;
                        numEnd-=2;
                    }
                    
                    if(numEnd>9 || numEnd<0){
                    }else{
                        if(check==1){
                            //checking that is isnt overwriting any other ships 
                            for (int j = num2; j < numEnd+1; j++) {
                                if(!"| | ".equals(ships[j][num1])){
                                    breaking=true;
                                }
                            }
                            //--------------------------------------------------
                            if(!breaking){
                                ++shipNum;
                                ShipNumber[num2][num1] =shipNum;
                                ships[num2][num1] = "|2| " ;
                                for (int j = num2+1; j < numEnd+1; j++) {
                                    ships[j][num1] = "|2| ";
                                    ShipNumber[j][num1] =shipNum;
                                }
                                ++two;
                            }else{
                                break;
                            }
                        
                        
                        
                        }else if(check==0){
                            //checking that is isnt overwriting any other ships 
                            for (int j = numEnd; j < num2; j++) {
                                if(!"| | ".equals(ships[j][num1])){
                                    
                                breaking=true;
                                }
                            }
                            //-------------------------------------------------
                        
                            if(!breaking){
                                ++shipNum;
                                ShipNumber[num2][num1] =shipNum;
                                ships[num2][num1] = "|2| " ;
                                for (int j = numEnd; j < num2; j++) {
                                    ships[j][num1] = "|2| ";
                                    ShipNumber[j][num1] =shipNum;
                                }
                                ++two;
                            }else{
                                break;
                            }
                                
                            
                        }
                        
                        
                    }
                    break;
                    
                }else if (orientation==1){
                    int numEnd = num1+1;
                    int check = 1;
                    if(numEnd>9){
                        --check;
                        numEnd-=2;
                    }
                    if(numEnd>9 || numEnd<0){
                        num2--;
                    }else{
                        if(check==1){
                            
                            //checking that is isnt overwriting any other ships 
                            for (int j = num1; j < numEnd+1; j++) {
                                if(!"| | ".equals(ships[num2][j])){
                                    
                                    breaking=true;
                                }
                            }
                            //--------------------------------------------------
                            
                            if (!breaking){
                                ++shipNum;
                                ShipNumber[num2][num1] =shipNum;
                               for (int j = num1; j < numEnd+1; j++) {
                                    ships[num2][j] = "|2| ";
                                    ShipNumber[num2][j] =shipNum;
                                } 
                               ++two;
                            }else{
                                break;
                            }
                            
                        }else if(check==0){
                            
                            //checking that is isnt overwriting any other ships 
                            for (int j = numEnd; j < num1+1; j++) {
                                if(!"| | ".equals(ships[num2][j])){
                                    
                                breaking=true;
                                }
                            }
                            //-------------------------------------------------
                            
                            if(!breaking){
                                ++shipNum;
                                ShipNumber[num2][num1] =shipNum;
                                for (int j = numEnd; j < num1+1; j++) {
                                    ships[num2][j] = "|2| ";
                                    ShipNumber[num2][j] =shipNum;
                                }
                                ++two;
                            }else{
                                break;
                            }
                            
                        }
                    }
                    break;
                    
                }
                
                
            }
        }
        
        //-----------------------------------------------------------

        
//        System.out.println("(The ship board stop code when finished...)");
//        //printing the ships board--------------------------
//        for(int i = 0; i < 10; ++i) {
//            System.out.print(" " + i + "  ");
//        }
//
//        System.out.println();
//        
//        for(int i = 0; i < 10; ++i) {
//            for(int j = 0; j < 10; ++j) {
//                System.out.print(ships[i][j]);
//            }
//
//            System.out.print(" " + i);
//            System.out.println("");
//            
//        }
//        System.out.println("");
//        System.out.println("");
        //-----------------------------------------
        
        //printing the shipNumber board----------------
//        
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                System.out.print(ShipNumber[i][j]+" ");
//            }
//            
//            System.out.print(" "+i);
//            System.out.println("");
//        }
//        System.out.println("");
//        System.out.println("");
        
        
        

        //---------------------------------------------
        System.out.println("");
        PrintShipCount(two,three,four,six,shipNum);   
        System.out.println("Enter the first coordinates:");
        
        
        
        //13 turns for testing
        int turns = (two*2 + three*3 + four*4 + 6) + 20 ;
        
        int score =0;
        int AreAllShipsSunk = 0;
        for (int p = turns; p > 0; p--) {
            
            
            AreAllShipsSunk = 0;
            
            //add a try catch to repeat if its wrong :) ---------------------
            //-----------------------------------------------------------------------
            System.out.println("");
            int num2=0;
            int num1=0;
            while (true){
                try{
                    
                    System.out.print("num1 (across)= ");
                    num2 = input.nextInt();
                    System.out.println();
                    System.out.print("num2 (down)= ");
                    num1 = input.nextInt();
                    break;
                }catch(Exception e){
                    System.out.println("Incorrect input(s) try again...");
                    input.next();
                }
                
            }
            
            
            for (int i = 0; i < 50; i++) {
                System.out.println("");
            }
            PrintShipCount(two,three,four,six,shipNum);
            
            
            
            if (num2 <= 9 && num2 >= 0 && num1 >= 0 && num1 <= 9) {
                
                if(!"| | ".equals(board[num1][num2])){
                    System.out.println("You've already picked this one...");
                    ++p;
                    
                }else if (!"| | ".equals(ships[num1][num2])) {
                    
                    board[num1][num2]=ships[num1][num2];
                    ShipNumber[num1][num2] = 0;
                    
                    
                    for (int i = 1; i < shipNum+1; i++) {
                        int counter = 0;
                        for (int j = 0; j < 10; j++) {
                            for (int k = 0; k < 10; k++) {
                                if(ShipNumber[j][k]!=0){
                                    if(ShipNumber[j][k]==i){
                                        ++counter;
                        }}}}
                        
                        
                        if(counter>0){
                            AreAllShipsSunk++;
                            
                            
                        }else{
                            
                            String type= "";
                            
                            for (int j = 1; j <= six; j++) {
                                if(i==j){
                                    type="1x6";
                                }
                            }
                            
                            for (int j = six+1; j <= six+four; j++) {
                                if(i==j){
                                    type="1x4";
                                }
                            }
                            
                            for (int j = six+four+1; j <= six+four+three; j++) {
                                if(i==j){
                                    type="1x3";
                                }
                            }
                            
                            for (int j = six+four+three+1; j <= six+four+three+two; j++) {
                                if(i==j){
                                    type="1x2";
                                }
                            }
                            
                            
                            
                            System.out.println("You sank ship #"+i+" ("+type+")");
                        }
                    }
                    
                    System.out.println("");
                    System.out.println("                                                    Hit!");
                    score+=hit;
                    
                    
                }else{
                    board[num1][num2]="|X| ";
                    for (int i = 1; i < shipNum+1; i++) {
                        
                        int counter = 0;
                        
                        for (int j = 0; j < 10; j++) {
                            for (int k = 0; k < 10; k++) {
                                if(ShipNumber[j][k]!=0){
                                    if(ShipNumber[j][k]==i){
                                        ++counter;
                                    }
                                }
                            }
                        }
                        if(counter>0){
                            ++AreAllShipsSunk;
                        }else{
                            String type= "";
                            
                            for (int j = 1; j <= six; j++) {
                                if(i==j){
                                    type="1x6";
                                }
                            }
                            
                            for (int j = six+1; j <= six+four; j++) {
                                if(i==j){
                                    type="1x4";
                                }
                            }
                            
                            for (int j = six+four+1; j <= six+four+three; j++) {
                                if(i==j){
                                    type="1x3";
                                }
                            }
                            
                            for (int j = six+four+three+1; j <= six+four+three+two; j++) {
                                if(i==j){
                                    type="1x2";
                                }
                            }
                            
                            
                            
                            System.out.println("You sank ship #"+i+" ("+type+")");
                            
                        }
                    }
                    System.out.println("");
                    System.out.println("                                                Miss :(");

                }
            } else {
                System.out.println("Out of range co-ordinates");
                ++p;
            }
            
            
            System.out.println("You have " +p+ " pieces of ammo left");
            
            //drawing board--------------------------
            for(int i = 0; i < 10; ++i) {
                System.out.print(" " + i + "  ");
            }

            System.out.println();
        
           for(int i = 0; i < 10; ++i) {
                for(int j = 0; j < 10; ++j) {
                    System.out.print(board[i][j]);
                }

                System.out.print(" " + i);
                System.out.println("");
            }
            System.out.println("");
            System.out.println("");
            //-----------------------------------------
    
            
            
        }
        
        
        
        System.out.println("no more ammo...");
        System.out.println("1 hit = " +hit+" point(s)");
        System.out.println("1 sunken ship = "+sink+ " points");
        System.out.println("");
        
        
        
        
        
        if(AreAllShipsSunk==0){
            System.out.println("You sunk all ships!!");
            score+=(sink*10);
            System.out.println("+"+(sink*10)+" points");
        }
        for (int i = 1; i < shipNum+1; i++) {
            int counter = 0;
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    if(ShipNumber[j][k]!=0){
                        if(ShipNumber[j][k]==i){
                            ++counter;
                        }
                    }
                }
            }
            if(counter>0){
                score+=0;
            }else{
                score+=sink;
            }
        }
        
        System.out.println("Your final score was: "+score);
        System.out.println("well done ");
        
        for (int i = 0; i < 10; i++) {
            System.out.println("");
        }
        System.out.println("What is your name?:");
        String SaveName = input.next();
        
        Leaderboards.WriteToBoards(SaveName, score, pointsawarded);
        
        System.out.println("Your scores have been saved ! :) ");    
            
        }
        
    public static void PrintShipCount (int two, int three, int four, int six,int ship){
        System.out.print("(1x2 = "+two);
        System.out.print(" 1x3 = "+three);
        System.out.print(" 1x4 = "+four);
        System.out.print(" 1x6 = "+six+") (note this doesnt change)");
        System.out.println("");
        System.out.println("There are " + ship + " total ships...");
        System.out.println("");
        System.out.println("");
            
    }
        
    public static void printwithdelay (String data, TimeUnit unit, long delay) throws InterruptedException{
        for(char ch:data.toCharArray()){
            System.out.print(ch);
            unit.sleep(delay);
        }
        
        
    }
    
    }

    



    
    
    
    
    
    







