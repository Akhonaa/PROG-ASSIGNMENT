
package question2app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Question2App {

    static ArrayList<Integer> playerPosistions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPosistions = new ArrayList<Integer>();
    
    public static void main(String[] args) {
        
        //created gameboard
        char[][] gameBoard = {{' ','|', ' ', '|', ' '}, 
            
            {'-','+', '-', '+', '-'}, 
            {' ','|', ' ', '|', ' '}, 
            {'-','+', '-', '+', '-'},
            {' ','|', ' ', '|', ' '}};
        
        gameboardPrint(gameBoard);
        
       
        
        while(true){
            
            //created scanner to receive user input
             Scanner scan = new Scanner(System.in);
            System.out.println("Choose your placement (1-9):");
        int playerPos = scan.nextInt();
        //While loop that ensures that the player and cpu play in a free spot
        while(playerPosistions.contains(playerPos) || playerPosistions.contains(playerPosistions) ){
            
            System.out.println("You Cannot Play There, Play somewhere else.");
            playerPos = scan.nextInt();
        }
        
        
        placement(gameBoard, playerPos, "player");
        
        Random rand = new Random();
        int cpuPos = rand.nextInt(9) + 1;
        //While loop that ensures that the player and cpu play in a free spot
        while(playerPosistions.contains(cpuPos) || playerPosistions.contains(cpuPos) ){
            
            
          cpuPos = rand.nextInt(9) + 1;
        }
        
        placement(gameBoard, cpuPos, "cpu");
        
        gameboardPrint(gameBoard);
        
        String winner = winnerCheck();
        System.out.println(winner);
        }
        
    }
    
    //method that prints the gameboard
    public static void gameboardPrint(char[][] gameBoard){
    for(char[] row : gameBoard){
            for(char i : row){
            System.out.print(i);
            }
            System.out.println();
        }
    }
    
    //method that controls where the player and cpu play
    public static void placement(char[][] gameBoard, int pos, String player){
        
        
        char symbol = ' ';
        
        
        if(player.equals("player")){
            symbol = 'X';
            playerPosistions.add(pos);
        } 
        
        else if(player.equals("cpu")){
        symbol = 'O'; 
        cpuPosistions.add(pos);
        }
        
        
        switch(pos) {
            case 1:
               gameBoard[0][0] = symbol;
               break;
                
            case 2:
               gameBoard[0][2] = symbol;
               break;
                
            case 3:
               gameBoard[0][4] = symbol;
               break;
               
            case 4:
               gameBoard[2][0] = symbol;
               break;
               
            case 5:
               gameBoard[2][2] = symbol;
               break;
                
            case 6:
               gameBoard[2][4] = symbol;
               break;
                case 7:
               gameBoard[4][0] = symbol;
               break;
                
                case 8:
               gameBoard[4][0] = symbol;
               break;
                
                case 9:
               gameBoard[4][4] = symbol;
               break;
               
                default:
                    break;
        }
    }
    
    public static String winnerCheck(){
        
        //all possible win positions
        List topRow = Arrays.asList(1, 2, 3);
       List middleRow = Arrays.asList(4, 5, 6);
       List bottomRow = Arrays.asList(7, 8, 9);
       List leftColumn = Arrays.asList(1, 4, 7);
       List midColumn = Arrays.asList(2, 5, 8);
       List rightColumn = Arrays.asList(3, 6, 9);
       List diagonalOne = Arrays.asList(1, 5, 9);
       List diagonalTwo = Arrays.asList(7, 5, 3);
       
       
       
       List<List> winConditions = new ArrayList<List>();
       //all possible win conditions
       winConditions.add(topRow);
       winConditions.add(middleRow);
       winConditions.add(bottomRow);
       winConditions.add(leftColumn);
       winConditions.add(midColumn);
       winConditions.add(rightColumn);
       winConditions.add(diagonalOne);
       winConditions.add(diagonalTwo);
       
       for(List l : winConditions) {
           if(playerPosistions.containsAll(l)){
                return "You Win!!";
           }
           else if(cpuPosistions.containsAll(l)){
               return "CPU wins :(";
           }
           else if(playerPosistions.size() + cpuPosistions.size() == 9){
               
               return "TIE";
           }
       }
        return "";
    }
    
    
}
