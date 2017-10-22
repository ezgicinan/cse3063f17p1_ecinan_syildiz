package monopolyGame;

import java.util.Scanner;

public class MonopolyGame {
	
	Dice dice1, dice2;
	static Player player1;
	static Player player2;
	private static int finishScore;
	Board board;
	
	public MonopolyGame() {
		board = new Board();
	}
	
	void showGameInstruction() {
        System.out.println("---INSTRUCTION---");
        System.out.println("# On a player's turn, he or she must roll the dice and "
        		+ "move his or her token forward the number of spaces as rolled on the dice.\n");
        System.out.println("# Two to eight players can play.\n");
        System.out.println("# A game is played as a series of rounds on a board comprised by 40 squares.\n");
        System.out.println("# During a round, each player takes one turn.\n");
        System.out.println("# In each turn, a player advances his/her piece clockwise around the board "
        		+ "a number of squares equal to the sum of the numbers rolled on two six-sided dice.\n");
        System.out.println("# After the dice are rolled, the name of the player and the roll are displayed,"
        		+ " as well as the target square's name.\n");

    }
	
	void startGame() {
		String p1Name;
	    String p2Name;

	    Scanner sc = new Scanner(System.in);
	    System.out.print("Please enter player one name: ");
	    p1Name = sc.nextLine();
	    System.out.print("Please enter player two name: ");
	    p2Name = sc.nextLine();
	    System.out.print("How many times do you want to roll dices? ");
        finishScore = sc.nextInt();

	   
	    player1 = new Player(p1Name);
	    player2 = new Player(p2Name);
	    dice1 = new Dice();
	    dice2 = new Dice();
	    
	    }
	
	void play(Player p) {
        
		int result;
		
		//Show which square player is on now 
		System.out.printf("%s now in %s square.\n", p.getName(), board.squares[p.getCurrentPosition()].getName());
		
        dice1.roll();
        dice2.roll();
        
        result= dice1.getFaceValue() + dice2.getFaceValue();
        
        p.setsumOfDice(result);
        
        System.out.printf("%s rolled %d and %d, "
                + "%s proceeded  %d squares.\n",
                p.getName(), dice1.getFaceValue(), dice2.getFaceValue(),
                p.getName(),p.getsumOfDice());
        
        board.movePlayer(p, p.getsumOfDice());
        
        System.out.printf("\n***\n%s now in %s square.\n***\n", p.getName(), board.squares[p.getCurrentPosition()].getName());
    }
	
	 
	public static void main(String []args){
		int counterOfGameRound=0;
		System.out.println("Welcome to MONOPOLY!\n");
		 
		MonopolyGame game =new MonopolyGame();
		game.showGameInstruction();
		System.out.println("Let's play the game!\n");
		game.startGame();
		 
		while(counterOfGameRound<finishScore){ 
		game.play(player1);
		game.play(player2);	
		System.out.println("");
		counterOfGameRound++;
		}
    }

}
