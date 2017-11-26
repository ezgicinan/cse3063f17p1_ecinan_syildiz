package monopolyGame;

//Square object
public abstract class Square {
	
	String name;

	public Square(String name)
	{
		this.name = name;
	}
    
	//Provide access the name of Square object
	public String getName() 
	{
		return name;
	}
	
	public abstract void squareAction(Player player, Board board);
	
	
	
}
