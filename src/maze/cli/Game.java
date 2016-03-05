package maze.cli;

import java.util.Scanner;

import Proj.Labirinto;
import Proj.hero;
import Proj.sword;
import Proj.dragon;

public class Game {
	
	public Game(){		
	}
	
	public static boolean win(hero heroi, dragon dragao){
		if (heroi.getPos_x() == 5 && heroi.getPos_y() == 9 && dragao.getState() == false)
			return true;
		else
			return false;
	}
	
	public static boolean check(hero heroi, dragon dragao)
	{
		if(		(heroi.getPos_x() + 1 == dragao.getPos_x() && heroi.getPos_y() == dragao.getPos_y()) ||
				(heroi.getPos_x() - 1 == dragao.getPos_x() && heroi.getPos_y() == dragao.getPos_y()) ||
				(heroi.getPos_y() + 1 == dragao.getPos_y() && heroi.getPos_x() == dragao.getPos_x()) ||
				(heroi.getPos_y() - 1 == dragao.getPos_y() && heroi.getPos_x() == dragao.getPos_x()))
			if(heroi.getName() == 'H')
				return false;
		return true;
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
			lab.printDragon(dragao);
			lab.printBoard();
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Faca um movimento(NSEO):");
			String s = sc.nextLine();
			direction=s;
			
			heroi.moveHero(lab, direction, espada, dragao);
			
			if (win(heroi, dragao)){
				Labirinto temp2 = new Labirinto();
				temp2.printDragon(dragao);
				temp2.printHero(heroi);
				temp2.printSword(espada);
				temp2.printBoard();
				System.out.println("Parabens, ganhou o jogo!");
				break;
			}
			
			if (check(heroi, dragao) == false){
				Labirinto temp = new Labirinto();
				temp.printDragon(dragao);
				temp.printHero(heroi);
				temp.printSword(espada);
				temp.printBoard();
				System.out.println("Perdeu o jogo");
				break;
			}
			
			dragao.randomPosition(espada);
			
			if (check(heroi, dragao) == false){
				Labirinto temp = new Labirinto();
				temp.printDragon(dragao);
				temp.printHero(heroi);
				temp.printSword(espada);
				temp.printBoard();
				System.out.println("Perdeu o jogo");
				break;
			}
		}

	}

}
