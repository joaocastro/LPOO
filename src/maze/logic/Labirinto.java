package maze.logic;

import java.util.ArrayList;
import java.util.Random;
import java.awt.Point;

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
	
	/**
	 * Labirinto constructor
	 * @param maze
	 * @param nlin
	 * @param ncol
	 */
	public Labirinto(char maze[][], int nlin, int ncol){
		table = new char[][]{};
		table = maze;
		lines = nlin;
		columns = ncol;
		
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
	
	/**
	 * Labirinto constructor
	 */
	public Labirinto(){
		table = new char[][]{};
		table = m1;
		lines = table[0].length;
		columns = table[0].length;
		
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
	
	/**
	 * Returns the 2D array(maze)
	 * @return table
	 */
	public char[][] getTable(){
		
		return table;
	}
	
	/**
	 * Prints the maze
	 */
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
	
	/**
	 * Prints the hero on the maze
	 * @param heroi
	 */
	public void printHero(hero heroi){
		table[heroi.getPos_x()][heroi.getPos_y()] = heroi.getName();
	}
	
	/**
	 * Prints the sword on the maze
	 * @param espada
	 */
	public void printSword(sword espada){
		if (espada.getState() == true)
			table[espada.getPos_x()][espada.getPos_y()] = espada.getName();
	}
	
	/**
	 * Prints a dragon on the maze
	 * @param dragao
	 */
	public void printDragon(dragon dragao) {
		if (dragao.getState() == true)
			table[dragao.getPos_x()][dragao.getPos_y()] = dragao.getName();
	}
	
	/**
	 * Returns the x coordinate of the maze exit
	 * @return exit_x
	 */
	public int getExit_xPos(){
		return exit_x;
	}
	
	/**
	 * Returns the y coordinate of the maze exit
	 * @return exit_y
	 */
	public int getExit_yPos(){
		return exit_y;
	}
	
	/**
	 * Overload of the toString function. Returns the maze as a string
	 */
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
	
	/**
	 * Returns the number of lines of the maze
	 * @return lines
	 */
	public int getLines(){
		return lines;
	}
	
	/**
	 * Returns the number of columns of the maze
	 * @return columns
	 */
	public int getColumns(){
		return columns;
	}
	
	
	/**
	 * Substitutes the maze with another one
	 * @param tab
	 */
	public void setTable(char[][] tab){
		table = tab;
	}
	
	
	/**
	 * Resets the maze. Deletes everything except the walls and the exit
	 */
	public void resetMaze(){
		for (int i = 0; i < lines; i++)
			for(int j = 0; j<columns; j++){
				if(table[i][j] != ' ' && table[i][j] != 'S' && table[i][j] != 'X')
					table[i][j] = ' ';
			}
	}
}
