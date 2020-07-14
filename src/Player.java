public class Player {
	
	 private final String name;
	 private static int counter = 0;
	 private int playerMove;

	 public Player(String name) {
	      	this.name = name;
	        this.counter++;
	        this.playerMove = counter;
	 }

     //Player name 
	 public String getName() {
    	 return name;
	 }

	 public int getplayerMove() {
	     return playerMove;
	 }

}
