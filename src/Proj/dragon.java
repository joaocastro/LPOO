package Proj;

public class dragon {
	
	private int pos_x;
	private int pos_y;
	private boolean state = true;
	
	public dragon(int x, int y){
		pos_x = x;
		pos_y = y;
	}
	
	public boolean isAlive() {
		return state;
	}
	
}