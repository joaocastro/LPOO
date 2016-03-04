package Proj;

import java.util.ArrayList;

import maze.cli.Game;

public class Labirinto {
	
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
		{'X',' ','X','X', ' ', 'X', ' ', 'X', ' ', 'X'},
		{'X','X','X','X', 'X', 'X', 'X', 'X', 'X', 'X'}
		};
	}
	
	public char[][] getTable(){
		
		return table;
	}
}
