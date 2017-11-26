package monopolyGame;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class MonopolyGame {
	
	Dice dice1, dice2; //Dice objects
	Board board; //Board object
	
	public MonopolyGame(int totalnumberOfPlayer) 
	{
		board = new Board(totalnumberOfPlayer); //Take the input and create board object
	}
	
	public void showGameInstruction() 
	{
        //Show the information about game
		System.out.println("\n---INSTRUCTION---");
        System.out.println("# On a player's turn, he or she must roll the dice and "
        		+ "move his or her token forward the number of spaces as rolled on the dice.\n");
        System.out.println("# Game is played with 2 to 8 players.\n");
        System.out.println("# Game is played as a series of rounds on a board comprised by 40 squares.\n");
        System.out.println("# During a round, each player takes one turn.\n");
        System.out.println("# In each turn, a player advances his/her piece clockwise around the board "
        		+ "a number of squares equal to the sum of the numbers rolled on two six-sided dice.\n");
        System.out.println("# After the dice are rolled, the name of the player and the roll are displayed,"
        		+ " as well as the target square's name, player's total cash, player's destination and simultaneous action.\n");
        System.out.println("# Until 1 player left, game will continue.\n");

	}
	
	public void startGame() 
	{	
		
		//Dice objects are created.
	    dice1 = new Dice();
	    dice2 = new Dice();	
	    
	    int iterationNumber; //Variable to hold iteration value which will be obtained from user.
	    
	    
	    Scanner sc = new Scanner(System.in);
	    System.out.print("Enter the iteration number: "); //ask user to determine number of iteration
	    iterationNumber = sc.nextInt(); //read input and assign it to the variable
	    
// 	    while (!isGameEnd()){
	    
	    for(int i=1; i <= iterationNumber; i++)
	    {	    
	   
	    	//Until the first player travel the whole squares one time, continue loop
	    	//Then increase turn, so it is time for next player 
	    	while(board.currentTurn < board.players.length)
	    	{
	    		System.out.printf("\n			** ITERATION: %d **	\n", i);
	    		
	    		if(!board.getCurrentPlayer().isBrokeOut())
	    		{
	    			
	    			int result; //Keep the value of sum of dices
	    			
	    			//Show which square player is on now 
	    			System.out.printf("%s now in %s square and has %d.\n", board.getCurrentPlayer().getName(), board.squares[board.getCurrentPlayer().getCurrentPosition()].getName(), board.getCurrentPlayer().getMoney().getMoney());
	           
	    			//Roll the dices
	    			dice1.roll();
	    			dice2.roll();
				
	    			
	    			
	    			//iterationnumb it-1 ve injail=1
	    	//		board.getCurrentPlayer().setIterationNumber(i);
	    	/*		
	    			if(i-board.getCurrentPlayer().getIterationNumber() == 1 && board.getCurrentPlayer().isInJail()) {
	    				board.getCurrentPlayer().setIterationNumber(i);
	    				//now player is in jail and wait
	    	//			board.getCurrentPlayer().setInJail(false);
	    				break;
	    			} else {
	    				board.getCurrentPlayer().setInJail(false);}
	    	*/		
	    			int count=0;
	    			
	    			while(dice1.getFaceValue() == dice2.getFaceValue() && count!=3)
	    			{
	    				System.out.printf("%s rolled %d and %d, "
			                + "then roll the dice again\n", board.getCurrentPlayer().getName(), dice1.getFaceValue(), dice2.getFaceValue());
			
	    				dice1.roll();
	    				dice2.roll();
	    				count++;
					
	    				if(count==3)
	    				{
	    					//Move player amount of total face value
	    					board.getCurrentPlayer().setThreetimesDoubled(board.getCurrentPlayer().getThreetimesDoubled()+1);
	    					board.movePlayer(board.getCurrentPlayer(), 10-board.getCurrentPlayer().getCurrentPosition());
					    
	    					//Print the current position of the player
	    					System.out.printf("3 times DOUBLES!!!!\n%s goes to %s\n", board.getCurrentPlayer().getName(), board.squares[board.getCurrentPlayer().getCurrentPosition()].getName());
//	    					System.out.printf("\n***\n%s now in %s square with $%d.\n***\n", board.getCurrentPlayer().getName(),board.squares[board.getCurrentPlayer().getCurrentPosition()].getName(), board.getCurrentPlayer().getMoney().money);
					 	
					    }
					
	    			}
				
	    			if(dice1.getFaceValue() != dice2.getFaceValue())
	    			{
					 
	    				result= dice1.getFaceValue() + dice2.getFaceValue(); //Summation of face values
				
				     
	    				board.getCurrentPlayer().setsumOfDice(result); //Assign the value of sum to player's sumOfDice
				
	    				//Show that which player roll the dice and amount of face values
	    				//Show how much square the player will proceed
	    				System.out.printf("%s rolled %d and %d, "
				    		 + "then will proceed  %d squares.\n", board.getCurrentPlayer().getName(), dice1.getFaceValue(), dice2.getFaceValue(), board.getCurrentPlayer().getsumOfDice());
			
				     
	    				board.movePlayer(board.getCurrentPlayer(), board.getCurrentPlayer().getsumOfDice()); //Move player amount of total face value
			    
	    				//Print the current position of the player
//	    				System.out.printf("\n***\n%s now in %s with $%d.\n***\n", board.getCurrentPlayer().getName(),board.squares[board.getCurrentPlayer().getCurrentPosition()].getName(), board.getCurrentPlayer().getMoney().money);
			    
	    			}
				 
	    			
	    		}
	    		
	    		//Show which square player is on now 
    			System.out.printf("Now, %s is in %s with $ %d.\n", board.getCurrentPlayer().getName(), board.squares[board.getCurrentPlayer().getCurrentPosition()].getName(), board.getCurrentPlayer().getMoney().getMoney());
           
		    
	    		board.nextTurn(); //increase current turn and change the player to next one
	    
	    	    if(isGameEnd()) //if all players has broken out, the game will be end
	    	    {
	    	    	System.out.println("      ---END---     \n");
	    	    	i=iterationNumber;
	    			System.out.printf("%s is the last player in the game, locates on %s with $ %d.\n", board.getCurrentPlayer().getName(), board.squares[board.getCurrentPlayer().getCurrentPosition()].getName(), board.getCurrentPlayer().getMoney().getMoney());

	    	   	    break;
	    	    }
	    	}
	    	
	    	board.currentTurn=0;
	    }
//	 }

		}
	
	
	public boolean isGameEnd() 
	{
		int total= board.totalnumberOfPlayer;
		
		while(total!=1) {
			
		for(int i=0; i<board.totalnumberOfPlayer; i++){ //used to iterate over Player array class
			
			if(board.players[i].isBrokeOut()) {
				total--;
				System.out.println(total);
			}
		}
		
		if(total != 1) return false; 
		}
		
		return true;
	}
	
	public static void main(String []args) throws FileNotFoundException
	{
		/*try {
			
		System.setOut(new PrintStream(new File("file.txt")));*/
		int totalnumberOfPlayer=0;
	
		System.out.println("Welcome to MONOPOLY!\n");
		
		Scanner sc = new Scanner(System.in);
	    System.out.print("Choose the number of players (2-8): "); //ask user to determine number of players
	    totalnumberOfPlayer = sc.nextInt(); //read input and assign it to the variable
	    
	    //Check the number of players if it is between 2 and 8
	    //If it is not valid, warn the user, and want to enter the number again 
	    while(totalnumberOfPlayer<2 || totalnumberOfPlayer>8)
	    {
	    	System.err.println("Invalid number of players.\n");
	    	System.out.println("Choose the number of players (2-8): ");
	 	    totalnumberOfPlayer = sc.nextInt();
	    }
	    
	  	MonopolyGame game =new MonopolyGame(totalnumberOfPlayer); //Create monopoly game object
	  	game.showGameInstruction(); //Show the instruction about game

		System.out.println("Let's play the game!\n");
		game.startGame(); //Start the game
		/*} catch (Exception e) {
		     System.out.println("****ERROR****\n");
		}*/
		
    }

}
