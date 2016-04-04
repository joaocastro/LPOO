package maze.logic;

import java.util.ArrayList;

public class hero extends character{

	private char tipo;
	private boolean state = true;
	
	public hero(int x, int y){
		pos_x = x;
		pos_y = y;
		tipo = 'H';
	}
	
	/**
	 * Returns the x coordinate of the hero
	 * @return pos_x
	 */
	public int getPos_x(){
		return pos_x;
	}
	
	/**
	 * Returns the y coordinate of the hero
	 * @return pos_y
	 */
	public int getPos_y(){
		return pos_y;
	}
	
	/**
	 * Returns the type of the hero
	 * @return tipo
	 */
	public char getName(){
		return tipo;
	}
	
	/**
	 * Equips the hero with the sword
	 */
	public void equipHero() {
		tipo = 'A';
	}
	
	/**
	 * Checks if the dragon is alive
	 * @return state
	 */
	public boolean isAlive() {
		return state;
	}
	
	/**
	 * Makes the hero move on the maze
	 * @param lab
	 * @param direction
	 * @param espada
	 * @param dragons
	 */
	public void moveHero(Labirinto lab, String direction, sword espada, ArrayList<dragon> dragons) {
		lab.getTable()[pos_x][pos_y] = ' ';
		switch(direction)
		{
		case "n":
		case "N":
			if (lab.getTable()[pos_x - 1][pos_y] == ' ')
			{
				pos_x--;
			}
			else if (lab.getTable()[pos_x - 1][pos_y] == 'E')
			{
				pos_x--;
				equipHero();
				espada.changeState();
			}
			else if (lab.getTable()[pos_x - 1][pos_y] == 'D' || lab.getTable()[pos_x - 1][pos_y] == 'd')
			{
				if(tipo == 'A'){
					findDragon(dragons, pos_x - 1, pos_y).changeState();
					pos_x--;
					killDragonsAround(dragons);
				}
			}
			else if (lab.getTable()[pos_x - 1][pos_y] == 'S' && tipo == 'A')
			{
				boolean dead = true;
				for(int i = 0;i < dragons.size(); i++){
					if (dragons.get(i).getState() == true)
						dead = false;
				}
				if (dead)
					pos_x--;
			}
			break;
		case "s":
		case "S":
			if (lab.getTable()[pos_x + 1][pos_y] == ' ')
			{
				pos_x++;
			}
			else if (lab.getTable()[pos_x + 1][pos_y] == 'E')
			{
				pos_x++;
				equipHero();
				espada.changeState();
			}
			else if (lab.getTable()[pos_x + 1][pos_y] == 'D' || lab.getTable()[pos_x + 1][pos_y] == 'd')
			{
				if(tipo == 'A'){
					findDragon(dragons, pos_x + 1, pos_y).changeState();
					pos_x++;
					killDragonsAround(dragons);
				}
			}
			else if (lab.getTable()[pos_x + 1][pos_y] == 'S' && tipo == 'A')
			{
				boolean dead = true;
				for(int i = 0;i < dragons.size(); i++){
					if (dragons.get(i).getState() == true)
						dead = false;
				}
				if (dead)
					pos_x++;
			}
			break;
		case "e":
		case "E":
			if (lab.getTable()[pos_x][pos_y + 1] == ' ')
			{
				pos_y++;
			}
			else if (lab.getTable()[pos_x][pos_y + 1] == 'E')
			{
				pos_y++;
				equipHero();
				espada.changeState();
			}
			else if (lab.getTable()[pos_x][pos_y + 1] == 'D' || lab.getTable()[pos_x][pos_y + 1] == 'd')
			{
				if(tipo == 'A'){
					findDragon(dragons, pos_x, pos_y + 1).changeState();
					pos_y++;
					killDragonsAround(dragons);
				}
			}
			else if (lab.getTable()[pos_x][pos_y + 1] == 'S' && tipo == 'A')
			{
				boolean dead = true;
				for(int i = 0;i < dragons.size(); i++){
					if (dragons.get(i).getState() == true)
						dead = false;
				}
				if (dead)
					pos_y++;
			}
			break;
		case "o":
		case "O":
			if (lab.getTable()[pos_x][pos_y - 1] == ' ')
			{
				pos_y--;
			}
			else if (lab.getTable()[pos_x][pos_y - 1] == 'E')
			{
				pos_y--;
				equipHero();
				espada.changeState();
			}
			else if (lab.getTable()[pos_x][pos_y - 1] == 'D' || lab.getTable()[pos_x][pos_y - 1] == 'd')
			{
				if(tipo == 'A'){
					findDragon(dragons, pos_x, pos_y - 1).changeState();
					pos_y--;
					killDragonsAround(dragons);
				}
			}
			else if (lab.getTable()[pos_x][pos_y - 1] == 'S' && tipo == 'A')
			{
				boolean dead = true;
				for(int i = 0;i < dragons.size(); i++){
					if (dragons.get(i).getState() == true)
						dead = false;
				}
				if (dead)
					pos_y--;
			}
			break;
		}
	}
	
	/**
	 * Finds a dragon in specified position
	 * @param dragons
	 * @param x
	 * @param y
	 * @return d1
	 */
	public dragon findDragon(ArrayList<dragon> dragons, int x, int y){
		for (int i = 0; i< dragons.size(); i++){
			if (dragons.get(i).pos_x == x && dragons.get(i).pos_y == y)
				return dragons.get(i);
		}
		
		dragon d1 = new dragon(1000,1000);
		
		return d1;
	}
	
	/**
	 * Kills any dragon that is near the hero, but only if the hero is equiped
	 * @param dragons
	 */
	public void killDragonsAround(ArrayList<dragon> dragons){
		for (int i = 0;i < dragons.size(); i++){
			dragon dragao = dragons.get(i);
			
			if ((pos_x + 1 == dragao.getPos_x() && pos_y == dragao.getPos_y())
					|| (pos_x - 1 == dragao.getPos_x() && pos_y == dragao.getPos_y())
					|| (pos_y + 1 == dragao.getPos_y() && pos_y == dragao.getPos_x())
					|| (pos_y - 1 == dragao.getPos_y() && pos_x == dragao.getPos_x()))
				dragons.get(i).changeState();
		}
	}

}
