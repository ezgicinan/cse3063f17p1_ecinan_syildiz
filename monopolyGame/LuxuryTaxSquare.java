package monopolyGame;

public class LuxuryTaxSquare extends Square {

	public LuxuryTaxSquare(String name) {
		super(name);
	}

	@Override
	public void squareAction(Player player, Board board) {
		//Print where does the player go 
		System.out.printf("%s goes to %s\n", player.getName(), this.name);
	    System.out.printf("%s will lose 75$\n", player.getName(), this.name);
	    player.getMoney().substractMoney(75); //In this square, player has to pay 75$
	}
	
	

}
