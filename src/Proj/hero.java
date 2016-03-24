package Proj;

import java.util.Vector;

public class hero extends character{

	private char tipo;
	private boolean state = true;
	
	public hero(int x, int y){
		pos_x = x;
		pos_y = y;
		tipo = 'H';
	}
	
	public int getPos_x(){
		return pos_x;
	}
	
	public int getPos_y(){
		return pos_y;
	}
	
	public char getName(){
		return tipo;
	}
	
	public void equipHero() {
		tipo = 'A';
	}
	
	public boolean isAlive() {
		return state;
	}
	
	public void moveHero(Labirinto lab, String direction, sword espada, Vector<dragon> dragons) {
		
		
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
					pos_x--;
				equipHero();
				espada.changeState();
				findDragon(dragons, pos_x -1, pos_y).changeState();
				}
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
					pos_x++;
				equipHero();
				espada.changeState();
				findDragon(dragons, pos_x + 1, pos_y).changeState();
				}
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
					pos_y++;
				equipHero();
				espada.changeState();
				findDragon(dragons, pos_x, pos_y + 1).changeState();
				}
			}
			else if (lab.getTable()[pos_x][pos_y + 1] == 'S' && tipo == 'A')
			{
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
					pos_y--;
				equipHero();
				espada.changeState();
				findDragon(dragons, pos_x, pos_y - 1).changeState();
				}
			}
			break;
		}
	}
	
	public dragon findDragon(Vector<dragon> dragons, int x, int y){
		for (int i = 0; i< dragons.size(); i++){
			if (dragons.elementAt(i).pos_x == x && dragons.elementAt(i).pos_y == y)
				return dragons.elementAt(i);
		}
		
		dragon d1 = new dragon(1000,1000);
		
		return d1;
	}

}
