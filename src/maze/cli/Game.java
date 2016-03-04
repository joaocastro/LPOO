package maze.cli;

import java.io.Console;
import java.util.Scanner;

import Proj.Labirinto;
import Proj.hero;
import Proj.sword;
import Proj.dragon;

public class Game {
	
	public Game(){		
	}
	
	public boolean check(Labirinto lab, hero heroi, dragon dragao)
	{
		boolean temp = true;
		
		if (lab.getTable()[heroi.pos_x-1][heroi.pos_y]=='D')
			
			if (heroi.getName()=='A')
				temp = true;
			else if (heroi.getName()=='H')
				temp = false;
		
		if (lab.getTable()[heroi.pos_x+1][heroi.pos_y]=='D')
			
			if (heroi.getName()=='A')
				temp = true;
			else if (heroi.getName()=='H')
				temp = false;
		
		if (lab.getTable()[heroi.pos_x][heroi.pos_y-1]=='D')
			
			if (heroi.getName()=='A')
				temp = true;
			else if (heroi.getName()=='H')
				temp = false;
		
		if (lab.getTable()[heroi.pos_x][heroi.pos_y+1]=='D')
			
			if (heroi.getName()=='A')
				temp = true;
			else if (heroi.getName()=='H')
				temp = false;
				
		return temp;
	}
		
	public static void main(String[] args) {
		
		hero heroi = new hero(1,1);
		sword espada = new sword(8,1);
		dragon dragao = new dragon(3,1);
		
		String direction;
		
		
		while(true)
		{
			Labirinto lab = new Labirinto();
			lab.printHero(heroi);
			lab.printSword(espada);
			lab.printBoard();
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Insira as coordenadas:");
			String s = sc.nextLine();
			direction=s;
			
			heroi.moveHero(lab, direction, espada, dragao);

			
		}

	}

}
