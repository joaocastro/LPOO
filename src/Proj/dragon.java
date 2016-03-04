package Proj;

public class dragon extends character{
	
	private boolean state = true;
	
	public dragon(int x, int y){
		pos_x = x;
		pos_y = y;
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
	
	public void changeState() {
		state = false;
	}
	
	public boolean getState() {	
		return state;
	}
	
}