package monopolyGame;
//Player object
public class Player {
	
	private String name;
	private int id; //id of player
	private int sumOfDice; //To keep the value of sum of dice faces
	public int position = 0;
	boolean brokeOut = false; //a variable to check player in the game or not
	private int threetimesDoubled = 0;
	private boolean inJail=false; //variable to  check in jail or not
	private int iterationNumber=0;
  
 // Money money=new Money(500); //Initial amount of money
  
	Money money; //money object
  
 /* public Player() 
  {
  
  }*/
  
  public Player(int id, String name, int initialCash)
  {
      this.name = name;
      this.id=id;
      money=new Money(initialCash); //Assign all players' initial cash 
  }

	public String getName()
  {
      return name;
  }
  
	public void setName(String name)
  {
		this.name = name;
  }
	
  //Provide access the value of sum of two faces
  public int getsumOfDice()
  {
      return sumOfDice;
  }
  
  //Provide assigning the sum value to a variable of Player object
  public void setsumOfDice(int sum)
  {
  	sumOfDice = sum;
  }
  
  //Provide access the value of money
  public Money getMoney()
  {
      return money;
  }
      
  //Provide access the value of position
  public int getCurrentPosition() 
  {
		return position;
	}
  
  //Assign the position value to the position of Player object
  public void setPosition(int position) {
		this.position = position;
	}

  //Provide access the value of player id
	public int getId() {
		return id;
	}
	
	//Is player exit(brokeout: true) from the game or still in (brokeout: false) the game? 
	//Set and Check this with following methods
	public void setBrokeOut(boolean brokeout) {
		this.brokeOut = brokeout;
	}
	
	public boolean isBrokeOut() {
		return brokeOut;
	}

	public int getThreetimesDoubled() {
		return threetimesDoubled;
	}

	public void setThreetimesDoubled(int threetimesDoubled) {
		this.threetimesDoubled = threetimesDoubled;
	}

	public boolean isInJail() {
		return inJail;
	}

	public void setInJail(boolean inJail) {
		this.inJail = inJail;
	}

	public int getIterationNumber() {
		return iterationNumber;
	}

	public void setIterationNumber(int iterationNumber) {
		this.iterationNumber = iterationNumber;
	}
}
