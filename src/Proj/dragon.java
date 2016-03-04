package Proj;

public class dragon extends character{
	
	private boolean state = true;
	private char tipo;
	
	public dragon(int x, int y){
		pos_x = x;
		pos_y = y;
		tipo = 'D';
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
	
}