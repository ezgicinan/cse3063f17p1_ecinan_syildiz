package monopolyGame;

public class GoSquare extends Square {

	public GoSquare(String name) {
		super(name);
	}
	
	public void squareAction(Player player, Board board){
		System.out.printf("%s is in %s\n", player.getName(), this.name);
		
		System.out.printf("GO Square! So, %s earned 200$!\n", player.getName());
		player.getMoney().addMoney(200);
		
	}

	

}
