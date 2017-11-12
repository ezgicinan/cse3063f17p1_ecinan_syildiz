package monopolyGame;

public class GoToJailSquare extends Square {

	public GoToJailSquare(String name) {
		super(name);
		
	}

	@Override
	public void squareAction(Player player, Board board) {
		//Print where does the player go
		System.out.printf("%s is in %s\n", player.getName(), this.name);
		//player is sent back to JAIL
		board.movePlayer(board.getCurrentPlayer(), (-20));

	}

}
