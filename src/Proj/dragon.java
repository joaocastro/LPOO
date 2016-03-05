package Proj;

import java.util.Random;

public class dragon extends character{
	
	private boolean state = true;
	private char tipo;
	
	public dragon(int x, int y){
		pos_x = x;
		pos_y = y;
		tipo='D';
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
		
		boolean temp = true; 
		
		if (lab.getTable()[x][y]!='X')
			temp = true;
		else
			temp = false;
		return temp;
	}
	
	public void moveDragon(int x, int y, sword espada){
		
		pos_x=x;
		pos_y=y;
		
		if (x == 8 && y == 1 && espada.getState() == true)
			tipo = 'F';
		else
			tipo = 'D';
	}
}