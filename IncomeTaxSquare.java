package monopolyGame;

public class IncomeTaxSquare extends Square {

	public IncomeTaxSquare(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void squareAction(Player player, Board board) {
		
		//Print where does the player go 
		System.out.printf("%s is in %s\n", player.getName(), this.name);
		System.out.printf("%s will lose 10 percent of all your cash\n", player.getName());
				
		int amount= player.getMoney().getMoney();
		amount=amount*10/100;
		player.getMoney().substractMoney(amount);
		
		
	}
	

}
