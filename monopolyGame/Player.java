package monopolyGame;

//Player object
public class Player {
	
	private final String name;
    private int sumOfDice; //To keep the value of sum of dice faces
    public int position = 0;
    
 
    public Player(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
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
    
    //Provide access the value of position
    public int getCurrentPosition() 
    {
		return position;
	}
    
    //Assign the position value to the position of Player object
    public void setPosition(int position) {
		this.position = position;
	}
}
