package maze.logic;

import java.util.Random;
import java.lang.Character;

public class dragon extends character{
	
	private boolean state = true;
	private char tipo;
	private boolean sleep;
	
	/**
	 * Dragon constructer
	 * @param x
	 * @param y
	 */
	public dragon(int x, int y){
		pos_x = x;
		pos_y = y;
		tipo='D';
		sleep = false;
	}
	
	/**
	 * Checks if the dragon is alive
	 * @return state
	 */
	public boolean isAlive() {
		return state;
	}
	
	/**
	 * Returns the x coordinate of the dragon
	 * @return pos_x
	 */
	public int getPos_x(){
		return pos_x;
	}
	
	/**
	 * Returns the y coordinate of the dragon
	 * @return pos_y
	 */
	public int getPos_y(){
		return pos_y;
	}
	
	/**
	 * Returns the type of the dragon
	 * @return tipo
	 */
	public char getName(){
		return tipo;
	}
	
	/**
	 * Changes the status of the dragon to false
	 */
	public void changeState() {
		state = false;
	}
	
	/**
	 * Returns the status of the dragon
	 * @return state
	 */
	public boolean getState() {	
		return state;
	}
	
	/**
	 * Generates a random move for the dragon
	 * @param lab
	 * @param espada
	 */
	public void randomPosition(Labirinto lab, sword espada) {
		
		Random rn = new Random();
		int x, y, rand;
		
		lab.getTable()[pos_x][pos_y] = ' ';
		
		rand = rn.nextInt(5);
		
		switch(rand){
		case 0:
			x = pos_x + 1;
			y = pos_y;
			break;
		case 1:
			x = pos_x - 1;
			y = pos_y;
			break;
		case 2:
			x = pos_x;
			y = pos_y + 1;
			break;
		case 3:
			x = pos_x;
			y = pos_y - 1;
		default:
			x = pos_x;
			y = pos_y;
			break;
		}
			
		if (checkmove(lab, x, y)==true)
			moveDragon(x, y, espada);
		else if(checkmove(lab, x, y)==false)
			randomPosition(lab, espada);
	}
	
	/**
	 * Checks if the dragon can make a specified move
	 * @param lab
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean checkmove(Labirinto lab, int x, int y) {
		
		if (lab.getTable()[x][y] != 'X' && lab.getTable()[x][y] != 'S')
			return true;
		else
			return false;
	}
	
	/**
	 * Moves the dragon
	 * @param x
	 * @param y
	 * @param espada
	 */
	public void moveDragon(int x, int y, sword espada){
		
		if (sleep == false) {
			pos_x = x;
			pos_y = y;

			if (x == espada.getPos_x() && y == espada.getPos_y() && espada.getState() == true)
				tipo = 'F';
			else
				tipo = 'D';
		}
	}
	
	/**
	 * Makes the dragon sleep
	 */
	public void Sleep(){
		sleep = true;
		tipo = Character.toLowerCase(tipo);
	}
	
	/**
	 * Makes the dragon wake up
	 */
	public void WakeUp(){
		sleep = false;
		tipo = Character.toUpperCase(tipo);
	}
	
	/**
	 * Makes the dragon sleep or wake up randomly
	 */
	public void randomSleep(){
		Random rn = new Random();
		int rand;
		rand = rn.nextInt(2);
		if(rand == 0)
			Sleep();
		else
			WakeUp();
	}
}