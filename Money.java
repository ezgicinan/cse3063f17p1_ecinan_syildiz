package monopolyGame;

public class Money {
	
	int money;
	
	public Money() //Constructor
	{
		this.money=0;
	}

	
	public Money(int money)
	{
		this.money=money;
	}
	
	//Provide access the value of money
	public int getMoney() 
	{
		return this.money;
	}
	
	//Provide assigning the money amount to a variable of Money object
	public void setMoney(int money)
	{
		this.money=money;
	}
	
	//Provide increase the amount of money as much as player earned
	public void addMoney(int moneyEarned)
	{
		this.money+=moneyEarned;
	}
	
	//Provide decrease the amount of money as much as player lost
	public void substractMoney(int moneyLosted ) {
		this.money-=moneyLosted;
	}
	
	//If a player has 0 or less money, S/He will be broken out. 
	public boolean isBrokeout(){
		
		return money <= 0;
		
	}

}
