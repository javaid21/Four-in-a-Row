 import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
      
        System.out.println("FOUR in a ROW!");
        System.out.println("Get four R or Y in a row horizontally, vertically or diagonally to win.");
        
        //Entering player data
        System.out.println("Player 1, please enter your name: ");
        String player1_name = scanner.nextLine();
        System.out.println("Player 2, please enter your name: ");
        String player2_name = scanner.nextLine();
        
        Player playerOne = new Player(player1_name);
        Player playerTwo = new Player(player2_name);
        
        System.out.println(playerOne.getName() + " will be Red (R on the board)");
        System.out.println(playerTwo.getName() + " will be Yellow (Y on the board)\n");
        
        //Starting game
        Board connectFour = new Board(playerOne,playerTwo);
        connectFour.printGameBoard();
        System.out.println("\n");
        
        boolean hasWon = false;
        while(hasWon == false){
            System.out.println(playerOne.getName() + ", Please enter a column to make your move");
            int turn =  scanner.nextInt();
            
            while (connectFour.makeMove(playerOne, turn) == false){
                System.out.println("Please try again: ");
                turn =scanner.nextInt();
           }
            
            //Update Game Board
            connectFour.printGameBoard();
            
            int winner = connectFour.validateGameBoard();
            whoWon(winner);
            if(winner != -1){
                hasWon = false;
                break;
            }
            
            System.out.println(playerTwo.getName() + ", Please enter a column to make your move: ");
            turn =  scanner.nextInt();
            while(connectFour.makeMove(playerTwo, turn) == false){
                System.out.println("Please try again: ");
                turn =scanner.nextInt();
            }
            
            connectFour.printGameBoard();
            winner = connectFour.validateGameBoard();
            whoWon(winner);
            
            if (winner != -1){
                hasWon = false;
                break;
            }
        }
    }

   
    //Determining game position and displaying result
    private static void whoWon(int winner){
        
    	if (winner == 0){
        System.out.println("It's a tie!");
        }

       else if (winner == 1){
           System.out.println("Player One wins!");
       }

       else if (winner == 2){
           System.out.println("Player Two wins!");
       }

       else {
           System.out.println("No winner yet!\n");
       }

   }

}