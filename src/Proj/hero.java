package Proj;

import java.util.ArrayList;

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
					findDragon(dragons, pos_x -1, pos_y).changeState();
					pos_x--;
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
					findDragon(dragons, pos_x + 1, pos_y).changeState();
					pos_x++;
				}
			}
			break;
		case "e":
		case "E":
			if ((pos_y + 1) >= lab.getColumns())
				return;
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
					findDragon(dragons, pos_x, pos_y - 1).changeState();
					pos_y--;
				}
			}
			break;
		}
	}
	
	public dragon findDragon(ArrayList<dragon> dragons, int x, int y){
		for (int i = 0; i< dragons.size(); i++){
			if (dragons.get(i).pos_x == x && dragons.get(i).pos_y == y)
				return dragons.get(i);
		}
		
		dragon d1 = new dragon(1000,1000);
		
		return d1;
	}

}
