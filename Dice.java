package monopolyGame;

public class Dice {
	
	public final int max=6; //maximum face value
	private int faceValue; //current value showing top of the dice
	
	//constructor: sets the initial face value.
	public Dice()
	{
		faceValue = 1;
	}
	
	//Rolls the dice and return the result.
	public int roll()
	{
		faceValue = (int)(Math.random()*max)+1;
		return faceValue;
	}
	
	//face value mutator.
	public void setFaceValue(int value)
	{
		faceValue = value;
	}
	
	//Face value accessor.
	public int getFaceValue()
	{
		return faceValue;
	}

	//Returns a string representation of this dice.
	public String toString()
	{
		String result = Integer.toString(faceValue);
		return result;
	}
}
