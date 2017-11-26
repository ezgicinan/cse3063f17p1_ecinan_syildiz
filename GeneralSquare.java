package monopolyGame;

public class GeneralSquare extends Square {

	public GeneralSquare(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void squareAction(Player player, Board board) {
		// TODO Auto-generated method stub
		
		System.out.printf("%s is in %s\n", player.getName(), this.name);
		
	}

}
