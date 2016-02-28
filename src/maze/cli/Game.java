package maze.cli;

import Proj.Labirinto;

public class Game {
	
	public Game(){
		
	}
		
	public static void printBoard(){
		
		Labirinto lab = new Labirinto();
		char[][] board = lab.getTable();
		
		for (int i=0; i<10; i++)
		{
			for(int j=0; j<10; j++)
			{
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	
	public boolean move(char direction){
		
		Labirinto lab = new Labirinto();
		char[][] board = new char[10][10];
		board=lab.getTable();
		int pos[] = lab.getPos();
		int line = pos[0];
		int col = pos[1];
		boolean move2 = true;
		
		switch(direction) {
		
		case('N'):
		{
			if (board[line-1][col]=='X')
				move2 = false;
			else
				move2 = true;
		}
		case('S'):
		{
			if (board[line+1][col]=='X')
				move2 = false;
			else
				move2 = true;
		}
		case('E'):
		{
			if (board[line][col+1]=='X')
				move2 = false;
			else
				move2 = true;
		}
		case('O'):
		{
			if (board[line][col-1]=='X')
				move2 = false;
			else
				move2 = true;
		}
		}
		return move2;
	}

	public static void main(String[] args) {
		
		printBoard();
		//test commit
	}

}
