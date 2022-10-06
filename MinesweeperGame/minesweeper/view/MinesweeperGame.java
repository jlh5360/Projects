package minesweeper.view;

import java.util.Collection;
import java.util.Scanner;
import minesweeper.model.GameState;
import minesweeper.model.Location;
import minesweeper.model.Minesweeper;
import minesweeper.model.MinesweeperException;
import minesweeper.model.MinesweeperSolver;


public class MinesweeperGame {
    public String userInput(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        return input;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Added the hint command description
        String helpCommand = " -  'help'- displays this list of commands.\n" +
                             " -  'pick <row> <col>'- selects a location on the board to uncover.\n" +
                             " -  'flag <row> <col>'- flags a suspected location on the board of being a mine\n" +
                             " -  'hint'- displays an available move.\n" +
                             " -  'reset <rows/ cols> <# of mines>'- resets to a new game.\n" +
                             " -  'solve'- makes a series of moves that solves the minesweeper puzzle\n" +
                             " -  'quit'- ends the game.\n";
        Boolean sentinel = true;
        Minesweeper minesweeper = new Minesweeper(4, 4, 4);

        System.out.println("Welcome to Minesweeper!!\n\nCommands:");
        System.out.println(helpCommand);
        // What I added for "Beyond The Project"
        // ===========================================================================================
        // System.out.print("Enter <row> <col> <mines>:  ");
        // int userInputRows = scanner.nextInt();
        // int userInputCols = scanner.nextInt();
        // int userInputMineCount = scanner.nextInt();
        // Minesweeper minesweeper = new Minesweeper(userInputRows, userInputCols, userInputMineCount);
        // ===========================================================================================

        System.out.println("\n" + minesweeper);
        System.out.print("Enter command:  ");
        String input = scanner.nextLine();
        while(sentinel){
            if(input.equals("help")){
                System.out.println(helpCommand);
                System.out.println();
                System.out.println(minesweeper + "\n");
                System.out.print("Enter command:  ");
                input = scanner.nextLine();
            }

            else if(input.contains("pick")){
                String[] pickString = input.split(" ");
                try {
                    minesweeper.makeSelection(new minesweeper.model.Location(Integer.parseInt(pickString[1]),Integer.parseInt(pickString[2]), 'i'));
                } catch(MinesweeperException e) {
                    System.out.println(e.getMessage());
                } catch(NumberFormatException e) {
                    System.out.println("Numbers must be used to specify your selection");
                } catch(IndexOutOfBoundsException e) {
                    System.out.println("Selection must be specified with a <row> <col> position");
                }

                if(minesweeper.getGameState().equals(GameState.LOST)){
                    System.out.println("You hit a Mine! You lose!");
                    scanner.close();
                    System.out.println(minesweeper);
                    System.out.println("\nMoves:  " + minesweeper.getMoveCount());
                    sentinel= false;
                }
                else if(minesweeper.getGameState().equals(GameState.WON)){
                    System.out.println("YOU WIN");
                    System.out.println(minesweeper);
                    System.out.println("\nMoves:  " + minesweeper.getMoveCount());
                    scanner.close();
                    sentinel = false;
                }
                else{
                    System.out.println(minesweeper);
                    System.out.println("\nMoves:  " + minesweeper.getMoveCount());
                    System.out.println();
                    System.out.print("Enter command:  ");
                    input = scanner.nextLine();  
                }
            }

            // What I added for "Beyond The Project"
            // ======================================================================================================================================
            else if(input.contains("flag")) {
                String[] pickString = input.split(" ");
                try {
                    minesweeper.flag(new minesweeper.model.Location(Integer.parseInt(pickString[1]),Integer.parseInt(pickString[2]), 'i'));
                } catch(MinesweeperException e) {
                    System.out.println(e.getMessage());
                } catch(NumberFormatException e) {
                    System.out.println("Numbers must be used to specify your selection");
                } catch(IndexOutOfBoundsException e) {
                    System.out.println("Selection must be specified with a <row> <col> position");
                }

                System.out.println(minesweeper);
                System.out.println("\nMoves:  " + minesweeper.getMoveCount());
                System.out.println();
                System.out.print("Enter command:  ");
                input = scanner.nextLine();  
                
            }
            // ======================================================================================================================================

            else if(input.equals("hint")){
                Collection<Location> possibleSelections = minesweeper.getPossibleSelections();
                Location hintLocation = possibleSelections.iterator().next();
                System.out.println("Hint: try (" + hintLocation.getRow() + ", " + hintLocation.getCol() + ")");
                System.out.println();
                System.out.println(minesweeper + "\n");
                System.out.print("Enter command:  ");
                input = scanner.nextLine();
            }

            else if(input.contains("reset")){
                String[] resetString = input.split(" ");
                try {
                    minesweeper = new Minesweeper(Integer.parseInt(resetString[1]), Integer.parseInt(resetString[2]), Integer.parseInt(resetString[3]));
                    System.out.println("*Game Reset*");
                } catch(IndexOutOfBoundsException e) {
                    System.out.println("Please enter <rows> <columns> <mines> for the reset command");
                } catch(NumberFormatException e) {
                    System.out.println("Numbers must be used to specify new game parameters");
                }
                
                System.out.println(minesweeper);
                System.out.print("Enter command:  ");
                input = scanner.nextLine();
            }

            else if(input.equals("quit")){
                System.out.println("Thank you for playing! Goodbye");
                minesweeper.setGameState(GameState.LOST);
                minesweeper.gameOver();
                scanner.close();
                System.out.println(minesweeper);
                sentinel = false;


            }
            
            else if(input.equals("solve")) {
                MinesweeperSolver solution = (MinesweeperSolver)MinesweeperSolver.createSolver(minesweeper);
                if(solution != null) {
                    for(Location location : solution.getSelections()) {
                        try {
                            System.out.println("(" + location.getRow() + ", " + location.getCol() + ")");
                            minesweeper.makeSelection(location);
                            System.out.println(minesweeper);
                            System.out.println();
                        } catch(MinesweeperException e) {
                            System.out.println(e.getMessage());
                            break;
                        }
                    }
                }
                System.out.println("Solved!");
                System.out.println(solution.toString());
                System.out.println();
                scanner.close();
                sentinel = false;
            }

            else{
                System.out.println("Please input a valid command");
                System.out.println();
                System.out.println(minesweeper);
                System.out.println();
                System.out.print("Enter command:  ");
                input = scanner.nextLine();
            }
        }
    }
}
