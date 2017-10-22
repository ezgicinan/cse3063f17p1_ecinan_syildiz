package monopolyGame;

public class Board {
	
	Square[] squares = new Square[40];
	
	public Board(){
		
		for (int i=0; i<40; i++){
			if(i == 0){
				squares[i] = new Square("GO");
			} else {			
				squares[i] = new Square("Square " + (i));
			}
		}
	}
	
	public Square movePlayer(Player player, int faceValue){
		
		faceValue=player.getsumOfDice();
		int newposition = player.getCurrentPosition() + faceValue;
		player.setPosition(newposition);
		System.out.printf("%s goes to %s\n", player.getName(), squares[player.getCurrentPosition()].getName());
		return squares[newposition];
		
	}
	
}
		
	
	
	
	

