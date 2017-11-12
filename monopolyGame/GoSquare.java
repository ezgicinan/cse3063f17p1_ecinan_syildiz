package monopolyGame;

public class GoSquare extends Square {

	public GoSquare(String name) {
		super(name);
	}
	
	public void squareAction(Player player, Board board){
		//Print where does the player go
		System.out.printf("%s goes to %s\n", player.getName(), this.name);
		System.out.printf("Now, GO Square so %s earn 200$!\n", player.getName());
		
		//Add 200$ to player's wallet
		player.getMoney().addMoney(200);
		
	}

	

}
