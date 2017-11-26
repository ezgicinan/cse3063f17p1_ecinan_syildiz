package monopolyGame;

import java.util.Random;

public class LotSquare extends Square {
	
	public int price; //price of the square
	public int rent; //rent of the square
	public int owner = -1; //variable to check the square has an owner
	
	Dice dice1 = new Dice();
    Dice dice2 = new Dice();
  
	
	public LotSquare(String name) {
		super(name);
	}
	
	public void setOwner(int owner) {
		this.owner = owner;
	}
	/*public boolean isOwned() {
		return isOwned;
	}

	public void setOwned(boolean isOwned) {
		this.isOwned = isOwned;
	}*/
	
	public void squareAction(Player player, Board board)
	{
		
		//Adjust the price and rent values of all Lot Squares
		if (player.getCurrentPosition() == 1) {
			this.price = 60;
			this.rent = 2;
		} else if(player.getCurrentPosition() == 3) {
			this.price = 60;
			this.rent = 4;
		} else if(player.getCurrentPosition() == 6 || player.getCurrentPosition() == 8) {
			this.price = 100;
			this.rent = 6;
		} else if(player.getCurrentPosition() == 9) {
			this.price = 120;
			this.rent = 8;
		} else if(player.getCurrentPosition() == 11 || player.getCurrentPosition() == 13) {
			this.price = 140;
			this.rent = 10;
		} else if(player.getCurrentPosition() == 14) {
			this.price = 160;
			this.rent = 12;
		} else if(player.getCurrentPosition() == 16 || player.getCurrentPosition() == 18) {
			this.price = 180;
			this.rent = 14;
		} else if(player.getCurrentPosition() == 19) {
			this.price = 200;
			this.rent = 16;
		} else if(player.getCurrentPosition() == 21 || player.getCurrentPosition() == 23) {
			this.price = 220;
			this.rent = 18;
		} else if(player.getCurrentPosition() == 24) {
			this.price = 240;
			this.rent = 20;
		} else if(player.getCurrentPosition() == 26 || player.getCurrentPosition() == 27){
			this.price = 260;
			this.rent = 22;
		} else if(player.getCurrentPosition() == 29) {
			this.price = 280;
			this.rent = 24;
		} else if(player.getCurrentPosition() == 31 || player.getCurrentPosition() == 32) {
			this.price = 300;
			this.rent = 26;
		} else if(player.getCurrentPosition() == 34) {
			this.price = 320;
			this.rent = 28;
		} else if(player.getCurrentPosition() == 37) {
			this.price = 350;
			this.rent = 35;
		} else if(player.getCurrentPosition() == 39) {
			this.price = 400;
			this.rent = 50;
		}
		
		System.out.printf("%s is in %s.\n", player.getName(), this.name);
	    
		//If square has no owner
		if(owner < 0) {
			System.out.printf("%s, do you want to buy %s?\n",player.getName(), this.name);
			
			Random rand = new Random();
			
			if( rand.nextBoolean() ) { //determine true or false randomly
				
				//If player has enough money and rolled facevalue greater than 4
				if( player.getMoney().money >= price  && (dice1.roll()+dice2.roll())>4 ) {
					
					System.out.printf("%s buy %s by giving $ %d.\n",player.getName(), this.name, price);
					owner = player.getId();
					player.getMoney().substractMoney(price);
					
				} else {
					
					if( (( dice1.roll() + dice2.roll()) > 4 ) && (player.getMoney().money < price) ) {
						
						System.out.printf("%s hasn't got enough money to buy %s.\n",player.getName(), this.name);
						
					} else if((player.getMoney().money >= price) && ( dice1.roll() + dice2.roll() ) <= 4 ) {
						
						System.out.printf("%s hasn't got enough DICE VALUE to buy %s.\n",player.getName(), this.name);
					} else {
						
					System.out.printf("%s CANNOT buy %s.\n",player.getName(), this.name);
					
					}
				}
				
			 } else{
				
				System.out.printf("%s don't want to buy %s.\n",player.getName(), this.name);
				
			}
			
		} else { //If square has an owner
			
			if( owner != player.getId() ) {
				
				player.getMoney().substractMoney(rent);
				board.getPlayer(owner).getMoney().addMoney(rent);
				
				System.out.printf("%s pay $ %d as a rent to %s.\n",player.getName(), rent, board.getPlayer(owner).getName());
			}
		}
		
	}



	

}
