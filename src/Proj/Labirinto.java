package Proj;

import java.util.ArrayList;

public class Labirinto extends character{
	
	private int lines;
	private int columns;
	private int exit_x;
	private int exit_y;
	private char table[][];
	private char m1[][] = new char[][] {
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
		
		for (int i=0; i<lines; i++)
		{
			for(int j=0; j<columns; j++)
			{
				if(table[i][j] == 'S'){
					exit_x = i;
					exit_y = j;
					break;
				}
			}
		}
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
		return exit_x;
	}
	
	public int getExit_yPos(){
		return exit_y;
	}

	@Override
	public String toString() {
		
		String builder = new String();
	    for(int i = 0; i < lines; i++)
	    {
	        for(int j = 0; j < columns; j++)
	        {
	            builder+=(table[i][j]);
	            
	        }
	        builder+="\n";
	    }    
	    return builder;
	}
	
	public int getLines(){
		return lines;
	}
	
	public int getColumns(){
		return columns;
	}
	
	public void setTable(char[][] tab){
		table = tab;
	}
}
