package util;

import java.util.Scanner;

public interface TwoPersonPlay <C>{
    public static final Scanner sc = new Scanner(System.in);

    public boolean isGameOver(C state);

    public C makeMove(C state, int[] action);
    
    public C getInitialState(boolean maximizeForWhite);

    /**
     * 
     * @param state
     * @return null if input is empty.
     */
    public int[] scanMoveNumber(C state);

    /** Scan, parse and validate whether the player wants to be player 1. */
    public static boolean inputWhiteIsMax(){
    
        int inputNumber = 1;
        boolean validInput = false;
        while(!validInput){
            validInput = true;

            // Ask for input.
            System.out.print("Enter `1` to be player 1, `2` to be player 2: ");
            String line = sc.nextLine();

            // Parse the input.
            try{
                inputNumber = Integer.parseInt(line);
            }
            catch(NumberFormatException e){
                System.out.println("[ERROR] Input must be 1 of 2");
                validInput = false;
            }
            
            // inputNumber should be 1 or 2.
            if(!(inputNumber == 1 || inputNumber == 2)){
                System.out.println("[ERROR] Player number must be 1 or 2");
                validInput = false;
            }
        }
        return inputNumber == 1;
    }
    
    /** Returns winner's name. Assumes game is over. */
    public String getWinnersName(C state);
}