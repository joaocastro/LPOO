package maze.logic;

import java.awt.Point;
import java.util.Random;
import java.util.Stack;

public class MazeBuilder {
	
	private Labirinto lab;
	private char[][] maze;
	private boolean[][] visitedCells;
	private Stack<Point> pathHistory;
	private Point guideCell;
	int size;
	
	public MazeBuilder(int siz){
		size = siz;
	}
	
	public void buildMaze(){
		lab = new Labirinto();
		maze = new char[size][size];
		
		for (int i = 0; i<size; i++){
			for (int j = 0;j<size;j++){
				maze[i][j] = 'X';
			}
		}
		
		for (int i = 0; i<size; i++){
			for (int j = 0;j<size;j++){
				if(i % 2 != 0 && j % 2 != 0)
					maze[i][j] = ' ';
			}
		}
		
		Random rand = new Random();
		
		int exit_x;
		int exit_y;
		int side;
		
		do{
			exit_x = rand.nextInt(size); 
		}while (exit_x % 2 == 0);
		
		do{
			exit_y = rand.nextInt(size);
		} while (exit_y % 2 == 0);
		
		side = rand.nextInt(4);
		
		guideCell = new Point();
		
		switch (side){
		case 0: // saida na esquerda
			maze[0][exit_y] = 'S';
			guideCell = new Point(0, (exit_y - 1) / 2);
			break;
		case 1: // saida na direita
			maze[size - 1][exit_y] = 'S';
			guideCell = new Point(((size - 2) - 1) / 2, (exit_y - 1) / 2);
			break;
		case 2: // saida em cima
			maze[exit_x][0] = 'S';
			guideCell = new Point((exit_x - 1) / 2, 0);
			break;
		case 3: // saida em baixo
			maze[exit_x][size - 1] = 'S';
			guideCell = new Point((exit_x - 1) / 2, ((size - 2) - 1) / 2);
			break;
		}
		
		visitedCells = new boolean[((size-1)/2)][((size-1)/2)];
		
		for (int i = 0; i < (size-1)/2; i++){
			for (int j = 0; j < (size-1)/2; j++){
				visitedCells[i][j] = false;
			}
		}
		
		visitedCells[guideCell.x][guideCell.y] = true;
		pathHistory.push(guideCell);
		
		while(!pathHistory.empty()){
			while (!guideCellCanGoSomewhere()){
				pathHistory.pop();
				
				if (pathHistory.empty())
					break;
				else
					guideCell = pathHistory.peek();
			}
			
			int dir;
			
			do {
				dir = rand.nextInt(4);
;			} while (!guideCellCanGoSomewhere());
			
			switch(dir){
			case 0://esquerda
				maze[guideCell.y * 2 + 1][guideCell.x * 2] = ' ';
				break;
			case 1://direita
				maze[guideCell.y * 2 + 1][(guideCell.x + 1) * 2] = ' ';
				break;
			case 2://cima
				maze[guideCell.y * 2][guideCell.x * 2 + 1] = ' ';
				break;
			case 3://baixo
				maze[(guideCell.y + 1) * 2][guideCell.x * 2 + 1] = ' ';
				break;
			}
			
			moveGuideCell(dir);
			visitedCells[guideCell.x][guideCell.y] = true;
			pathHistory.push(guideCell);
		}
		
	}
	
	public void moveGuideCell(int dir){
		switch(dir){
		case 0: //esquerda
			guideCell.setLocation(guideCell.x - 1, guideCell.y);
			break;
		case 1: //direita
			guideCell.setLocation(guideCell.x + 1, guideCell.y);
			break;
		case 2: //cima
			guideCell.setLocation(guideCell.x, guideCell.y - 1);
			break;
		case 3: //baixo
			guideCell.setLocation(guideCell.x, guideCell.y + 1);
			break;
		}
	}
	
	public boolean canMove(int dir){
		switch(dir){
		case 0: //esquerda
			if (guideCell.x - 1 >=0)
				return true;
			break;
		case 1: //direita
			if (guideCell.x + 1 >=0)
				return true;
			break;
		case 2: //cima
			if (guideCell.y - 1 >=0)
				return true;
			break;
		case 3: //baixo
			if (guideCell.y + 1 >=0)
				return true;
			break;
		}
		return false;
	}
	
	public boolean guideCellCanGoSomewhere() {
		boolean guideCellCanGoSomewhere = false;

		for (int i = 0; i < 4; i++)
			if (canMove(i))
				guideCellCanGoSomewhere = true;

		return guideCellCanGoSomewhere;
	}
	
	public char[][] getMaze(){
		return maze;
	}
}
