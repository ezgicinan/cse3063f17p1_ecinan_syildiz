package monopolyGame;

public class Board {
	
	Square[] squares = new Square[40]; //Create a square object array with a specific size
	Player[] players; 
	
	int totalnumberOfPlayer = 0;
	int currentTurn = 0; //Turn of a player
	int iteration=0; //A variable for adjusting iteration of the game loop
	
	
	public Board(int totalnumberOfPlayer)
	{ 
		//Take the total number of players to be created
		
		//Create a player object array 
        //with amount of totalnumberOfPlayer
		players = new Player[totalnumberOfPlayer]; 
		
		this.totalnumberOfPlayer = totalnumberOfPlayer;
		
		//Create players
		for(int i=0; i<players.length; i++)
		{
			players[i] = new Player("Player " + (i + 1)); 
		}
	
		//Create squares
		for(int i=0; i<40; i++)
		{
			if(i == 0){
				squares[i] = new Square("GO");  //Assign first square name as GO
			} else {			
				squares[i] = new Square("Square " + (i));
			}
		}
	}
	
	public Square movePlayer(Player player, int faceValue)
	{
		faceValue=player.getsumOfDice(); //assign the sum of face values to the variable
		
		//adjust position by adding player's current position with sum face values
		int newposition = player.getCurrentPosition() + faceValue; 
		
		//Enter loop when a player's position exceeds the square length
		if(newposition>=squares.length)
		{
			//To prevent array out of bound error, take the mod of position according to square size
			newposition=newposition % squares.length;
			
			//Set the position of player
			player.setPosition(newposition);
			
			System.out.printf("%s goes to %s\n", player.getName(), squares[player.getCurrentPosition()].getName());
			
			//If a player enter this loop, S/He complete one turn
			//So inform the user about changing of player turn
			System.out.println("Now this is the time for next player!\n");
			
			//This variable provide complete one turn for one player
			//and give a chance to next player to play
			iteration=1;
			
			return squares[newposition];
		}
		

		//Enter loop when a player's position less than the square length
		if(newposition<squares.length)
		{
	    
	    //Set the position of player
		player.setPosition(newposition);
		
		//Print where does the player go 
		System.out.printf("%s goes to %s\n", player.getName(), squares[player.getCurrentPosition()].getName());
		}
		
		iteration=0;
		
		return squares[newposition];	
	}
	
	//Access the current player on the game
	public Player getCurrentPlayer() 
	{
		return players[currentTurn];
	}
	
	public void nextTurn() 
	{
	    //This is for providing all of player to play
		//When first player finish the travel whole squares one time
		//That players turn is finished and current turn is increased 
		//in order to pass the turn for next one 
		++currentTurn;
	}
	
}
		
	
	
	
	

