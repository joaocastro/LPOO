package maze.cli;

import java.util.Random;
import java.util.Scanner;

import Proj.Labirinto;
import java.util.ArrayList;
import Proj.hero;
import Proj.sword;
import Proj.dragon;

import maze.gui.Interface;

public class Game {
	
	private hero heroi;
	private sword espada;
	private Labirinto maze;
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
	
	private ArrayList<dragon> dragons;
	
	public Game(){
		heroi = new hero(1,1);
		espada = new sword(8,1);
		maze = new Labirinto();
		dragons = new ArrayList<dragon>();
	}
	
	public void createDragons(int number){
		while (number>0)
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
			
			if(isAvailable(dragontemp, maze)==true)
			{
				dragons.add(dragontemp);
				maze.printDragon(dragontemp);
				number--;
			}
		}
	}
	
	public boolean isAvailable(dragon d, Labirinto lab) {

		boolean temp;

		for (int i = 0; i < dragons.size(); i++) {
			if (d.getPos_x() == dragons.get(i).getPos_x() && d.getPos_y() == dragons.get(i).getPos_y())
					return false;
		}
		
		if (lab.getTable()[d.getPos_x()][d.getPos_y()] == ' ')
			temp = true;
		
		else
			temp = false;

		return temp;
	}

	public void playGame(){
		
		Labirinto lab1 = new Labirinto();
		hero heroi = new hero(1,1);
		sword espada = new sword(8,1);
		lab1.printHero(heroi);
		lab1.printSword(espada);
		
		String index;
		String direction;
		int numberdragons;
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Numero de Dragoes desejado");
		numberdragons = scn.nextInt();	
		
		createDragons(numberdragons);
		
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
				lab.printDragon(dragons.get(i));
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
					lab.printDragon(dragons.get(i));
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
					temp.printDragon(dragons.get(i));
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
					temp.printDragon(dragons.get(i));
				}
				temp.printHero(heroi);
				temp.printSword(espada);
				temp.printBoard();
				System.out.println("Perdeu o jogo");
				break;
			}
		}

	}
	
	public void makePlay(String direction){
		heroi.moveHero(maze, direction, espada, dragons);
	}
	
	public void updateBoard(){
		maze.setTable(m1);
		for (int i=0; i<dragons.size(); i++)
		{
			maze.printDragon(dragons.get(i));
		}
		maze.printHero(heroi);
		maze.printSword(espada);
	}
	
	public boolean win(){		
		if (heroi.getPos_x() == maze.getExit_xPos() && heroi.getPos_y() == maze.getExit_yPos())
			return true;
		else
			return false;
	}
	
	public boolean win(hero heroi, Labirinto lab){
		boolean temp = true;
		
		if (heroi.getPos_x() == lab.getExit_xPos() && heroi.getPos_y() == lab.getExit_yPos())
			temp = true;
		else
			return false;
		
		for (int i = 0; i< dragons.size(); i++)
		{
			dragon dragao = dragons.get(i);
			if (dragao.getState() == true)
				temp = false;
		}
		
		return temp;
	}
	
	public boolean check(){
		boolean temp = true;
		
		for (int i = 0; i < dragons.size(); i++) {
			
			dragon dragao = dragons.get(i);
			
			if ((heroi.getPos_x() + 1 == dragao.getPos_x() && heroi.getPos_y() == dragao.getPos_y())
					|| (heroi.getPos_x() - 1 == dragao.getPos_x() && heroi.getPos_y() == dragao.getPos_y())
					|| (heroi.getPos_y() + 1 == dragao.getPos_y() && heroi.getPos_x() == dragao.getPos_x())
					|| (heroi.getPos_y() - 1 == dragao.getPos_y() && heroi.getPos_x() == dragao.getPos_x()))
				if (heroi.getName() == 'H' && dragao.getName() != 'd')
					temp = false;
		}
		
		return temp;
	}
	
	public boolean check(hero heroi)
	{
		boolean temp = true;
		
		for (int i = 0; i < dragons.size(); i++) {
			
			dragon dragao = dragons.get(i);
			
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
				dragons.get(i).randomPosition(espada);
			}
			break;
		case "3":
			for (int i = 0; i< dragons.size(); i++)
			{
				dragons.get(i).randomSleep();
				dragons.get(i).randomPosition(espada);
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

	public ArrayList<dragon> getDragons(){
		return dragons;
	}
	
	public Labirinto getMaze(){
		return maze;
	}
}
