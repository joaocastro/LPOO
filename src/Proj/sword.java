package Proj;

public class sword {
	
	private int pos_x;
	private int pos_y;
	private boolean state = true; // pode não ser necessário
	
	public sword(int x, int y){
		pos_x = x;
		pos_y = y;
	}
	
	public boolean isAlive() {
		return state;
	}
	
}