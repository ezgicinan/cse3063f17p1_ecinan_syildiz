package monopolyGame;

public class FreeParkingSquare extends Square {

	public FreeParkingSquare(String name) {
		super(name);
		
	}

	@Override
	public void squareAction(Player player, Board board) {
		//Print where does the player go 
		System.out.printf("%s goes to %s\n", player.getName(), this.name);
		
	}

}
