package monopolyGame;

public class GeneralSquare extends Square {

	public GeneralSquare(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	

	public void squareAction(Player player, Board board)
	{
		//Print where does the player go 
		System.out.printf("%s goes to %s\n", player.getName(), this.name);
	}

}
