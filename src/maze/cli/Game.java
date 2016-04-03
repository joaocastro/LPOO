package maze.cli;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

import maze.gui.Interface;
import maze.logic.Labirinto;
import maze.logic.MazeBuilder;
import maze.logic.dragon;
import maze.logic.hero;
import maze.logic.sword;

public class Game {
	
	private hero heroi;
	private sword espada;
	private Labirinto maze;
	private char m1[][];
	
	private ArrayList<dragon> dragons;
	
	public void genHero(){
		Random rand = new Random();
		int x;
		int y;
		
		while(true){
			x= rand.nextInt(maze.getLines());
			y = rand.nextInt(maze.getColumns());
			
			if (m1[x][y] == ' '){
				heroi = new hero(x,y);
				return;
			}
		}
	}
	
	public void genSword(){
		Random rand = new Random();
		int x;
		int y;
		
		while(true){
			x= rand.nextInt(maze.getLines());
			y = rand.nextInt(maze.getColumns());
			
			if (m1[x][y] == ' '){
				espada = new sword(x,y);
				return;
			}
		}
	}
	
	
	public Game(){}
	
	public void addMaze(int size){
		MazeBuilder m = new MazeBuilder(size);
		
		maze = m.buildMaze();
		m1 = m.getMaze();
		genHero();
		genSword();
		dragons = new ArrayList<dragon>();
		updateBoard();
	}
	
	
	public void createDragons(int number){
		while (number>0)
		{
			Random rn = new Random();
			int rand, rand2;
			rand = rn.nextInt(maze.getLines());
			rand2 = rn.nextInt(maze.getColumns());
			
			if (rand==0)
				rand++;
			else if (rand==maze.getLines() - 1)
				rand--;
			
			if (rand2==0)
				rand2++;
			else if (rand2==maze.getColumns() - 1)
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
		String index;
		String direction;
		int numberdragons;
		
		Scanner scn = new Scanner(System.in);
		
		int size;
		System.out.println("Tamanho do tabuleiro:");
		size = scn.nextInt();
		System.out.println("\nNumero de Dragoes desejado");
		numberdragons = scn.nextInt();
		
		addMaze(size);

		createDragons(numberdragons);
		updateBoard();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Selecione um modo de jogo:\n1 - Dragao parado;\n2 - Dragao com movimentacao aleatoria;\n3 - Dragao com posicao aleatoria intercalada com dormir;");
		index = scan.nextLine();
		
		
		while(true)
		{
			updateBoard();
			maze.printBoard();
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Faca um movimento(N S E O):");
			String s = sc.nextLine();
			direction=s;
			
			heroi.moveHero(maze, direction, espada, dragons);
			
			if (win(heroi, maze)){
				updateBoard();
				maze.printBoard();
				System.out.println("Parabens, ganhou o jogo!");
				break;
			}
			
			if (check(heroi) == false){
				updateBoard();
				maze.printBoard();
				System.out.println("Perdeu o jogo");
				break;
			}
			
			Strategy(index);
			
			if (check(heroi) == false){
				updateBoard();
				maze.printBoard();
				System.out.println("Perdeu o jogo");
				break;
			}
		}

	}
	
	public void makePlay(String direction){
		heroi.moveHero(maze, direction, espada, dragons);
	}
	
	public void updateBoard(){
		maze.resetMaze();
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
					|| (heroi.getPos_y() - 1 == dragao.getPos_y() && heroi.getPos_x() == dragao.getPos_x())){
				if (heroi.getName() == 'H' && dragao.getName() != 'd')
					temp = false;
				if (heroi.getName() == 'A')
					dragons.get(i).changeState();
			}
		}
		
		return temp;
	}
	
	public void Strategy(String index){
		switch(index)
		{
		case "2":
			for (int i = 0; i< dragons.size(); i++)
			{
				dragons.get(i).randomPosition(maze, espada);
			}
			break;
		case "3":
			for (int i = 0; i< dragons.size(); i++)
			{
				dragons.get(i).randomSleep();
				dragons.get(i).randomPosition(maze, espada);
			}
			break;
		default:
			break;
		}
	}
	
	public void printMaze(){
		updateBoard();
		maze.printBoard();
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
