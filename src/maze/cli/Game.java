package maze.cli;

import java.io.Console;
import java.util.Scanner;

import Proj.Labirinto;
import Proj.hero;

public class Game {
	
	public Game(){
		
	}
		
	public static void main(String[] args) {
		
		hero heroi = new hero(1,1);
		
		String direction;
		
		
		while(true)
		{
			Labirinto lab = new Labirinto();
			lab.printHero(heroi);
			lab.printBoard();
			
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
