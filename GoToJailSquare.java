package monopolyGame;

public class GoToJailSquare extends Square {

	public GoToJailSquare(String name) {
		super(name);
		
	}

	@Override
	public void squareAction(Player player, Board board) {
		
		System.out.printf("%s is in %s\n", player.getName(), this.name);
		board.movePlayer(board.getCurrentPlayer(), (-20));

	}

}
