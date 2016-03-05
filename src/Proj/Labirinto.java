package Proj;

public class Labirinto extends character{
	
	private char table[][];
	
	public Labirinto(){
		
		table = new char[][] {
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
	}
	
	public char[][] getTable(){
		
		return table;
	}
	
	public void printBoard(){
		
		for (int i=0; i<10; i++)
		{
			for(int j=0; j<10; j++)
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
}
