package monopolyGame;

import java.util.Random;
import java.util.Scanner;

public class Board {
	
	Square[] squares = new Square[40]; //Create a square object array with a specific size
	Player[] players; 
	
	int totalnumberOfPlayer = 0;
	int currentTurn = 0; //Turn of a player
//	int iteration=0; //A variable for adjusting iteration of the game loop
	String name; // a variable for assigning player's name
	int previousPosition;
	int cash=0;
	
	public Board(int totalnumberOfPlayer)
	{ 
		Scanner scan = new Scanner(System.in); 
	    System.out.print("Enter initial cash value: "); //take the names of players
	    cash = scan.nextInt();
		
		//Take the total number of players to be created
			
		players = new Player[totalnumberOfPlayer]; //Create a player object array with amount of totalnumberOfPlayer
		this.totalnumberOfPlayer = totalnumberOfPlayer;
		
		Scanner sc = new Scanner(System.in); 
	    System.out.print("Enter the names of players: "); //take the names of players
		
 	    //Create players
		for(int i=0; i<players.length; i++)
		{
			this.name = sc.nextLine(); //read the input value of name
			
			players[i] = new Player((i+1),name, cash);	
		}
		
	
		//Create squares
		for(int i=0; i<40; i++)
		{
			if(i == 0){
				squares[i] = new GoSquare("GO");  //Assign first square name as GO
			} else if (i == 4){
				squares[i] = new IncomeTaxSquare("INCOME TAX");
			} else if (i == 10){
				squares[i] = new JailSquare("JAIL");
			}else if (i == 20){
				squares[i] = new FreeParkingSquare("FREE PARKING");  //Assign first square name as GO
			} else if (i == 30){
				squares[i] = new GoToJailSquare("GO TO JAIL");
			} else if (i == 38){
				squares[i] = new LuxuryTaxSquare("LUXURY TAX");  //Assign first square name as GO
			} else if(i == 5){
				squares[i] = new RailRoads("RAIL ROADS1");			
			} else if(i == 15){
				squares[i] = new RailRoads("RAIL ROADS2");			
			} else if(i == 25){
				squares[i] = new RailRoads("RAIL ROADS3");			
			} else if(i == 35){
				squares[i] = new RailRoads("RAIL ROADS4");			
			} else if(i == 12){
				squares[i] = new UtilitySquare("ELECTRIC UTILITY");			
			} else if(i == 28){
				squares[i] = new UtilitySquare("WATER UTILITY");			
			} else if (i == 2 || i == 7 || i == 17 || i == 22 || i == 33 || i == 36) {
				squares[i] = new GeneralSquare("Square " + (i));
			} else {
				squares[i] = new LotSquare("Square " + (i));
			}
		}
		
	}
	
	public Square movePlayer(Player player, int faceValue)
	{
		if(player.isBrokeOut()){ 
			System.out.printf("%s has already been BROKE OUT\n", player.getName());
			return squares[player.getCurrentPosition()];
			}
		
		if(player.getMoney().isBrokeout()){
			
			System.out.printf("***  %s has been just broke out because has %d $  ***\n", player.getName(), player.getMoney().getMoney());
			player.setBrokeOut(true);
			
			return squares[player.getCurrentPosition()];
		}
		
		previousPosition = player.getCurrentPosition(); //assign current position before it changes with new one
		int newposition = player.getCurrentPosition() + faceValue; //adjust position by adding player's current position with sum face values
		
		
		if(newposition>=squares.length) //Enter loop when a player's position exceeds the square length
		{
			
			newposition=squarePositionConversion(newposition); //To prevent array out of bound error, take the mod of position according to square size
			player.setPosition(newposition); //Set the position of player
			squares[newposition].squareAction(player, this); //Do the action in the square
									
//			iteration=1;  //This variable provide complete one turn for one player
			              //and give a chance to next player to play
			
			return squares[newposition];
		}
		
		if(newposition<squares.length) //Enter loop when a player's position less than the square length
		{
			player.setPosition(newposition); //Set the position of player
			squares[newposition].squareAction(player, this); //Do the action in the square
		}
		
//		iteration=0;
		
		return squares[newposition];	
	}
	
	//Access the current player on the game
	public Player getCurrentPlayer() 
	{
		return players[currentTurn];
	}
	
	//Access the player array
	public Player [] getPlayers()
	{
		return players;
	}
	
	public void nextTurn() 
	{
	    //This is for providing all of player to play
		//When first player finish the travel whole squares one time
		//That players turn is finished and current turn is increased 
		//in order to pass the turn for next one 
		++currentTurn;
	}
	
	public int squarePositionConversion(int newposition) //Normalize the position number to prevent out of bound error
	{
		newposition=newposition % squares.length;
		return newposition;		
	}
	
	//Access the id of a player
	public Player getPlayer(int id){
		return players[id-1];
	}
	
}
		
		
	
	
	
	

