package Proj;

public class hero {
	
	private int pos_x;
	private int pos_y;
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
	
	public void equipHero() {
		tipo = 'A';
	}
	
	public boolean isAlive() {
		return state;
	}
	
	public void moveHero(Labirinto lab, String direction) {
		
		
		switch(direction)
		{
		case "n":
		case "N":
			if (lab.getTable()[pos_x][pos_y - 1] == ' ')
			{
				pos_y--;
			}
			if (lab.getTable()[pos_x][pos_y - 1] == 'E')
			{
				pos_y--;
				equipHero();
			}
			break;
		case "s":
		case "S":
			if (lab.getTable()[pos_x][pos_y + 1] == ' ')
			{
				pos_y--;
			}
			if (lab.getTable()[pos_x][pos_y + 1] == 'E')
			{
				pos_y++;
				equipHero();
			}
			break;
		case "e":
		case "E":
			if (lab.getTable()[pos_x + 1][pos_y] == ' ')
			{
				pos_x++;
			}
			if (lab.getTable()[pos_x + 1][pos_y] == 'E')
			{
				pos_x++;
				equipHero();
			}
			break;
		case "o":
		case "O":
			if (lab.getTable()[pos_x - 1][pos_y] == ' ')
			{
				pos_y--;
			}
			if (lab.getTable()[pos_x - 1][pos_y] == 'E')
			{
				pos_x--;
				equipHero();
			}
			break;
		}
	}

}
