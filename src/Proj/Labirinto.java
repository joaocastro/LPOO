package Proj;

public class Labirinto extends character{
	
	private int lines;
	private int columns;
	private char table[][];
	char m1[][] = new char[][] {
	{'X','X','X','X', 'X', 'X', 'X', 'X', 'X', 'X'},
	{'X',' ',' ',' ', ' ', ' ', ' ', ' ', ' ', 'X'},
	{'X',' ','X','X', ' ', 'X', ' ', 'X', ' ', 'X'},
	{'X',' ','X','X', ' ', 'X', ' ', 'X', ' ', 'X'},
	{'X',' ','X','X', ' ', 'X', ' ', 'X', ' ', 'X'},
	{'X',' ',' ',' ', ' ', ' ', ' ', 'X', ' ', 'S'},
	{'X',' ','X','X', ' ', 'X', ' ', 'X', ' ', 'X'},
	{'X',' ','X','X', ' ', 'X', ' ', 'X', ' ', 'X'},
	{'X',' ','X','X', ' ', ' ', ' ', ' ', ' ', 'X'},
	{'X','X','X','X', 'X', 'X', 'X', 'X', 'X', 'X'}
	};
	
	public Labirinto(char maze[][], int nlin, int ncol){
		table = maze;
		lines = nlin;
		columns = ncol;
	}
	
	public Labirinto(){
		table = m1;
		lines = 10;
		columns = 10;
	}
	
	public char[][] getTable(){
		
		return table;
	}
	
	public void printBoard(){
		
		for (int i=0; i<lines; i++)
		{
			for(int j=0; j<columns; j++)
			{
				System.out.print(table[i][j]);
				System.out.print(' ');
			}
			System.out.println();
		}
	}
	
	public void printHero(hero heroi){
		table[heroi.getPos_x()][heroi.getPos_y()] = heroi.getName();
	}
	
	public void printSword(sword espada){
		if (espada.getState() == true)
			table[espada.getPos_x()][espada.getPos_y()] = espada.getName();
	}
	
	public void printDragon(dragon dragao) {
		if (dragao.getState() == true)
			table[dragao.getPos_x()][dragao.getPos_y()] = dragao.getName();
	}
	
	public int getExit_xPos(){
		int ret= -1;
		for (int i=0; i<lines; i++)
		{
			for(int j=0; j<columns; j++)
			{
				if(table[i][j] == 'S'){
					ret = i;
					break;
				}
			}
		}
		
		return ret;
	}
	
	public int getExit_yPos(){
		int ret = -1;
		for (int i=0; i<lines; i++)
		{
			for(int j=0; j<columns; j++)
			{
				if(table[i][j] == 'S'){
					ret = j;
					break;
				}
			}
		}
		
		return ret;
	}
}
