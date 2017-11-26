package monopolyGame;

public class JailSquare extends Square {

	public JailSquare(String name) {
		super(name);
		
	}

	@Override
	public void squareAction(Player player, Board board) {
		
		
		if(board.previousPosition == 30 || board.getCurrentPlayer().getThreetimesDoubled() == 1){ 	//if player is sent from GoToJail square or 
																			                        //come here by rolling 3 times doubles enter loop 
			//Print where does the player go
			System.out.printf("You're come from Square 30 or you rolled 3 times Doubles.\n ");
			System.out.printf("%s is in %s\n", player.getName(), this.name);
			
			player.setInJail(true);
//			System.out.printf("three times doubled= %d\n", board.getCurrentPlayer().getThreetimesDoubled());
			
			System.out.printf("To get out from the Jail, %s paid 50$\n", player.getName());
			player.getMoney().substractMoney(50);
			board.getCurrentPlayer().setThreetimesDoubled(board.getCurrentPlayer().getThreetimesDoubled()-1);

		
		} else{
			
			//If the player comes any way except previous conditions, S/he is only a visitor
			System.out.printf("%s is in %s for Just Visiting\n", player.getName(), this.name);
		}
		
	}
}
