package maze.logic;

public class sword extends character{
	
	private char tipo;
	private boolean state = true;
	
	public sword(int x, int y){
		pos_x = x;
		pos_y = y;
		tipo = 'E';
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
	
	public void changeState(){
		state = false;
	}
	
	public boolean getState(){
		return state;
	}
}