package monopolyGame;

import java.util.Random;

public class RailRoads extends Square {
	int owner = -1; //variable to check the square has an owner
	int price; //price of the square
	int rent = 0; //rent of the square
	
	Dice dice1 = new Dice();
    Dice dice2 = new Dice();
	
	public RailRoads(String name) {
		super(name);
		price = 200;
	}

	@Override
	public void squareAction(Player player, Board board) {
		
		System.out.printf("%s is in %s.\n", player.getName(), this.name);
		
		//If square has no owner
		if(owner < 0) {
			
			System.out.printf("%s, do you want to buy %s?\n",player.getName(), this.name);
			
			Random rand = new Random();
			if(rand.nextBoolean()) {//determine true or false randomly
				
				//If player has enough money and rolled facevalue greater than 4
				if(player.getMoney().money >= price && (dice1.roll()+dice2.roll())>4) {
					
					System.out.printf("%s buy %s by giving $ %d\n",player.getName(), this.name, price);
					owner = player.getId();
					player.getMoney().substractMoney(price);
					
				} else {
					
					if( (( dice1.roll() + dice2.roll()) > 4 ) && (player.getMoney().money < price) ) {
						
						System.out.printf("%s hasn't got enough money to buy %s.\n",player.getName(), this.name);
					} else if(player.getMoney().money >= price && ( dice1.roll() + dice2.roll() ) <= 4 ) {
						
						System.out.printf("%s hasn't got enough DICE VALUE to buy %s.\n",player.getName(), this.name);
					} else {			
					System.out.printf("%s CANNOT buy %s.\n",player.getName(), this.name);
					
					}
				}
			} else{
				
				System.out.printf("%s don't want to buy %s\n",player.getName(), this.name);
			}
			
		} else { //If square has an owner
			
			if(owner != player.getId()) {
				
				rent = 25 + (player.getsumOfDice() * 5);
				player.getMoney().substractMoney(rent);
				board.getPlayer(owner).getMoney().addMoney(rent);
				System.out.printf("%s pay $ %d as rent to %s \n",player.getName(), rent, board.getPlayer(owner).getName());
			}
		}
		
	}

}
