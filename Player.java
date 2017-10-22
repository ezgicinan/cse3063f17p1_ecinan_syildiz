package monopolyGame;

public class Player {
	
	private final String name;
    private int sumOfDice;
    int position = 0;
    
 
    public Player(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    int getsumOfDice(){
        return sumOfDice;
    }
    
    void setsumOfDice(int sum){
    	sumOfDice = sum;
    }
    
    public int getCurrentPosition() {
		return position;
	}
    
    public void setPosition(int position) {
		this.position = position;
	}
}
