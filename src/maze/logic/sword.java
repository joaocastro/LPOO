package maze.logic;

public class sword extends character{
	
	private char tipo;
	private boolean state = true;
	
	/**
	 * Sword constructor
	 * @param x
	 * @param y
	 */
	public sword(int x, int y){
		pos_x = x;
		pos_y = y;
		tipo = 'E';
	}
	
	/**
	 * Checks if the hero hasn't pick the sword yet
	 * @return
	 */
	public boolean isAlive() {
		return state;
	}
	
	/**
	 * Returns the x coordinate of he sword position
	 * @return pos_x
	 */
	public int getPos_x(){
		return pos_x;
	}
	
	/**
	 * Returns the y coordinate of he sword position
	 * @return pos_y
	 */
	public int getPos_y(){
		return pos_y;
	}
	
	/**
	 * Returns the type of the sword
	 * @return tipo
	 */
	public char getName(){
		return tipo;
	}
	
	/**
	 * Changes the state of the sword t false (meaning that the hero is now equiped)
	 */
	public void changeState(){
		state = false;
	}
	
	/**
	 * Returns the state of the sword
	 * @return state
	 */
	public boolean getState(){
		return state;
	}
}