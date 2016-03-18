package Proj;

import java.util.Random;
import java.util.Vector;
import java.lang.Character;

public class dragon extends character{
	
	private boolean state = true;
	private char tipo;
	private boolean sleep;
	private Vector<dragon> dragons;
	
	public dragon(int x, int y){
		pos_x = x;
		pos_y = y;
		tipo='D';
		sleep = false;
		dragons = new Vector<dragon>();
		//dragons.add(this);
	}
	
	public boolean isAlive() {
		return state;
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
	
	public void changeState() {
		state = false;
	}
	
	public boolean getState() {	
		return state;
	}
	
	public void randomPosition(sword espada) {
		
		Labirinto lab = new Labirinto();
		Random rn = new Random();
		int x, y, rand;
		
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
			randomPosition(espada);
	}
	
	public boolean checkmove(Labirinto lab, int x, int y) {
		
		if (lab.getTable()[x][y] != 'X')
			return true;
		else
			return false;
	}
	
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
	
	public void Sleep(){
		sleep = true;
		tipo = Character.toLowerCase(tipo);
	}
	
	public void WakeUp(){
		sleep = false;
		tipo = Character.toUpperCase(tipo);
	}
	
	public void randomSleep(){
		Random rn = new Random();
		int rand;
		rand = rn.nextInt(2);
		if(rand == 0)
			Sleep();
		else
			WakeUp();
	}
	
	public Vector<dragon> getDragons(){
		
		return dragons;
	}
	
	public boolean isAvailable(dragon d){
		
		boolean temp=true;
		
		for (int i=0; i<dragons.size(); i++)
		{
			if (d.pos_x==dragons.elementAt(i).pos_x)
			{
				if (d.pos_y==dragons.elementAt(i).pos_y)
					temp=false;
				else
					temp=true;
			}
			else
				temp=true;
		}
		
		return temp;
	}
	
	public void addDragon(dragon d){
		
		dragons.add(d);
	}
}