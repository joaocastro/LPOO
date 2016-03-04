package maze.cli;

import java.io.Console;
import java.util.Scanner;

import Proj.Labirinto;
import Proj.hero;

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
	

	public static void main(String[] args) {
		
		Labirinto lab = new Labirinto();
		hero heroi = new hero(1,1);
		
		String direction;
		
		
		while(true)
		{
			printBoard();
			Scanner sc = new Scanner(System.in);
			System.out.println("Insira as coordenadas:");
			String s = sc.nextLine();
			direction=s;
			
			heroi.moveHero(lab, direction);

			
		}
		//printBoard();
		//test commit
	}

}
