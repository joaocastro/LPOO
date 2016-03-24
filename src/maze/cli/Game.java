package maze.cli;

import java.util.Random;
import java.util.Scanner;

import Proj.Labirinto;
import java.util.Vector;
import Proj.hero;
import Proj.sword;
import Proj.dragon;

public class Game {
	
	protected Vector<dragon> dragons;
	
	public Game(){
	}
	
	public boolean isAvailable(dragon d, Labirinto lab) {

		boolean temp = true;

		for (int i = 0; i < dragons.size(); i++) {
			if (d.pos_x == dragons.elementAt(i).pos_x && d.pos_y == dragons.elementAt(i).pos_y) {
					temp = false;
			}
			if (lab.getTable()[d.pos_x][d.pos_y] != ' ')
				temp = false;
			
			else
				temp = true;
		}

		return temp;
	}

	public void playGame(){
		
		Labirinto lab1 = new Labirinto();
		hero heroi = new hero(1,1);
		sword espada = new sword(8,1);
		
		String index;
		String direction;
		int numberdragons;
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Numero de Dragoes desejado");
		numberdragons = scn.nextInt();
		
		dragons = new Vector<dragon>(numberdragons);					
		
		for (; numberdragons>0; numberdragons--)
		{
			Random rn = new Random();
			int rand, rand2;
			rand = rn.nextInt(10);
			rand2 = rn.nextInt(10);
			
			if (rand==0)
				rand++;
			else if (rand==9)
				rand--;
			
			if (rand2==0)
				rand2++;
			else if (rand2==9)
				rand2--;		
			
			dragon dragontemp= new dragon(rand,rand2);
			
			if(isAvailable(dragontemp, lab1)==true)
			{
				dragons.add(dragontemp);
			}
			
			
		}
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Selecione um modo de jogo:\n1 - Dragao parado;\n2 - Dragao com movimentacao aleatoria;\n3 - Dragao com posicao aleatoria intercalada com dormir;");
		index = scan.nextLine();
		
		
		while(true)
		{
			Labirinto lab = new Labirinto();
			lab.printHero(heroi);
			lab.printSword(espada);
			for (int i=0; i<dragons.size(); i++)
			{
				lab.printDragon(dragons.elementAt(i));
			}
			//lab.printDragon(dragao);
			lab.printBoard();
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Faca um movimento(N S E O):");
			String s = sc.nextLine();
			direction=s;
			
			heroi.moveHero(lab, direction, espada, dragons);
			
			if (win(heroi, lab)){
				Labirinto temp2 = new Labirinto();
				for (int i=0; i<dragons.size(); i++)
				{
					lab.printDragon(dragons.elementAt(i));
				}
				temp2.printHero(heroi);
				temp2.printSword(espada);
				temp2.printBoard();
				System.out.println("Parabens, ganhou o jogo!");
				break;
			}
			
			if (check(heroi) == false){
				Labirinto temp = new Labirinto();
				for (int i=0; i<dragons.size(); i++)
				{
					lab.printDragon(dragons.elementAt(i));
				}
				temp.printHero(heroi);
				temp.printSword(espada);
				temp.printBoard();
				System.out.println("Perdeu o jogo");
				break;
			}
			
			Strategy(index, espada);
			
			if (check(heroi) == false){
				Labirinto temp = new Labirinto();
				for (int i=0; i<dragons.size(); i++)
				{
					lab.printDragon(dragons.elementAt(i));
				}
				temp.printHero(heroi);
				temp.printSword(espada);
				temp.printBoard();
				System.out.println("Perdeu o jogo");
				break;
			}
		}

	}
	
	public boolean win(hero heroi, Labirinto lab){
		boolean temp = true;
		
		if (heroi.getPos_x() == lab.getExit_xPos() && heroi.getPos_y() == lab.getExit_yPos())
			temp = true;
		else
			return false;
		
		for (int i = 0; i< dragons.size(); i++)
		{
			dragon dragao = dragons.elementAt(i);
			if (dragao.getState() == true)
				temp = false;
		}
		
		return temp;
	}
	
	public boolean check(hero heroi)
	{
		boolean temp = true;
		
		for (int i = 0; i < dragons.size(); i++) {
			
			dragon dragao = dragons.elementAt(i);
			
			if ((heroi.getPos_x() + 1 == dragao.getPos_x() && heroi.getPos_y() == dragao.getPos_y())
					|| (heroi.getPos_x() - 1 == dragao.getPos_x() && heroi.getPos_y() == dragao.getPos_y())
					|| (heroi.getPos_y() + 1 == dragao.getPos_y() && heroi.getPos_x() == dragao.getPos_x())
					|| (heroi.getPos_y() - 1 == dragao.getPos_y() && heroi.getPos_x() == dragao.getPos_x()))
				if (heroi.getName() == 'H' && dragao.getName() != 'd')
					temp = false;
		}
		
		return temp;
	}
	
	public void Strategy(String index, sword espada){
		switch(index)
		{
		case "2":
			for (int i = 0; i< dragons.size(); i++)
			{
				dragons.elementAt(i).randomPosition(espada);
			}
			break;
		case "3":
			for (int i = 0; i< dragons.size(); i++)
			{
				dragons.elementAt(i).randomSleep();
				dragons.elementAt(i).randomPosition(espada);
			}
			break;
		default:
			break;
		}
	}
		
	public static void main(String[] args) {
		Game game1 = new Game();
		game1.playGame();
	}

	public Vector<dragon> getDragons(){
		return dragons;
	}
}
