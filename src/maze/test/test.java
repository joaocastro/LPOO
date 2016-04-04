package maze.test;


import static org.junit.Assert.*;

import org.junit.Test;

import maze.cli.*;
import maze.logic.*;

public class test {
	
	char [][] m1 = {
			{'X', 'X', 'X', 'X', 'X'},
			{'X', ' ', ' ', ' ', 'S'},
			{'X', ' ', 'X', ' ', 'X'},
			{'X', ' ', ' ', ' ', 'X'},
			{'X', 'X', 'X', 'X', 'X'}
			};
	
	char [][] m2 = {
			{'X', 'X', 'X', 'S', 'X'},
			{'X', ' ', ' ', ' ', 'X'},
			{'X', ' ', 'X', ' ', 'X'},
			{'X', ' ', ' ', ' ', 'X'},
			{'X', 'X', 'X', 'X', 'X'}
			};
	
	char [][] m3 = {
			{'X', 'X', 'X', 'X', 'X'},
			{'X', ' ', ' ', ' ', 'X'},
			{'X', ' ', 'X', ' ', 'X'},
			{'X', ' ', ' ', ' ', 'X'},
			{'X', 'X', 'X', 'S', 'X'}
			};
	
	char [][] m4 = {
			{'X', 'X', 'X', 'X', 'X'},
			{'S', ' ', ' ', ' ', 'X'},
			{'X', ' ', 'X', ' ', 'X'},
			{'X', ' ', ' ', ' ', 'X'},
			{'X', 'X', 'X', 'X', 'X'}
			};

	@Test
	public void testMoveHerotoFreeCell_a() {
		Game g1 = new Game();
		Labirinto lab = new Labirinto(m1, 5, 5);
		hero heroi = new hero(1,3);
		sword espada = new sword(3,1);
		dragon dragao = new dragon(3,3);
		
		assertEquals(1, heroi.getPos_x());
		assertEquals(3, heroi.getPos_y());
		
		heroi.moveHero(lab, "O", espada, g1.getDragons());
		
		assertEquals(1, heroi.getPos_x());
		assertEquals(2, heroi.getPos_y());
		assertEquals(true,heroi.isAlive());
	}
	
	@Test
	public void testMoveHero(){
		Game g1 = new Game();
		Labirinto lab = new Labirinto(m1, 5, 5);
		hero heroi = new hero(3,1);
		String[] dir = {"E","E","N","N","O","O","S","S"};
		
		g1.setHero(heroi);
		g1.setMaze(lab);
		for (int i = 0; i<dir.length;i++)
			g1.makePlay(dir[i]);
		
		assertEquals(3, heroi.getPos_x());
		assertEquals(1, heroi.getPos_y());
	}
	
	@Test
	public void testMoveHeroAgainstWall_b(){
		Game g1 = new Game();
		Labirinto lab = new Labirinto(m1, 5, 5);
		hero heroi = new hero(1,3);
		sword espada = new sword(3,1);
		dragon dragao = new dragon(3,3);
		
		assertEquals(1, heroi.getPos_x());
		assertEquals(3, heroi.getPos_y());
		
		heroi.moveHero(lab, "N", espada, g1.getDragons());
		
		assertEquals(1, heroi.getPos_x());
		assertEquals(3, heroi.getPos_y());
	}

	@Test
	public void testHerogetsSword_c(){
		Game g1 = new Game();
		Labirinto lab = new Labirinto(m1, 5, 5);
		hero heroi = new hero(1,3);
		sword espada = new sword(1,2);
		lab.printSword(espada);
		heroi.moveHero(lab, "O", espada, g1.getDragons());
		
		Game g2 = new Game();
		Labirinto lab2 = new Labirinto(m1, 5, 5);
		hero heroi2 = new hero(1,3);
		sword espada2 = new sword(2,3);
		lab2.printSword(espada2);
		heroi2.moveHero(lab2, "S", espada2, g2.getDragons());
		
		Game g3 = new Game();
		Labirinto lab3 = new Labirinto(m1, 5, 5);
		hero heroi3 = new hero(1,2);
		sword espada3 = new sword(1,3);
		lab3.printSword(espada3);
		heroi3.moveHero(lab3, "E", espada3, g3.getDragons());
		
		Game g4 = new Game();
		Labirinto lab4 = new Labirinto(m1, 5, 5);
		hero heroi4 = new hero(2,3);
		sword espada4 = new sword(1,3);
		lab4.printSword(espada4);
		heroi4.moveHero(lab4, "N", espada4, g4.getDragons());
		
		assertEquals('A', heroi.getName());
		assertEquals('A', heroi2.getName());
		assertEquals('A', heroi3.getName());
		assertEquals('A', heroi4.getName());
	}
	
	@Test
	public void testHerogetsKilledbyDragon_d(){
		Game g1 = new Game();
		Labirinto lab = new Labirinto(m1, 5, 5);
		hero heroi = new hero(1,3);
		sword espada = new sword(1,2);
		dragon dragao = new dragon(3,3);
		g1.addDragon(dragao);
		g1.setMaze(lab);
		g1.setHero(heroi);
		g1.setSword(espada);
		
		lab.printDragon(dragao);
		lab.printSword(espada);
		lab.printHero(heroi);
		
		g1.makePlay("S");
		
		assertEquals(false, g1.check(heroi));
	}
	
	@Test
	public void testHeroKillsDragon_e(){
		Game g1 = new Game();
		Labirinto lab = new Labirinto(m1, 5, 5);
		hero heroi = new hero(1,3);
		dragon dragao = new dragon(3,3);
		g1.addDragon(dragao);
		g1.setMaze(lab);
		g1.setHero(heroi);
		
		lab.printDragon(dragao);
		lab.printHero(heroi);
		heroi.equipHero();
		
		g1.makePlay("S");
		g1.makePlay("S");
		
		Game g2 = new Game();
		Labirinto lab2 = new Labirinto(m1, 5, 5);
		hero heroi2 = new hero(3,3);
		dragon dragao2 = new dragon(1,3);
		g2.addDragon(dragao2);
		g2.setMaze(lab2);
		g2.setHero(heroi2);
		
		lab2.printDragon(dragao2);
		lab2.printHero(heroi2);
		heroi2.equipHero();
		
		g2.makePlay("N");
		g2.makePlay("N");
		
		Game g3 = new Game();
		Labirinto lab3 = new Labirinto(m1, 5, 5);
		hero heroi3 = new hero(1,1);
		dragon dragao3 = new dragon(1,3);
		g3.addDragon(dragao3);
		g3.setMaze(lab3);
		g3.setHero(heroi3);
		
		lab3.printDragon(dragao3);
		lab3.printHero(heroi3);
		heroi3.equipHero();
		
		g3.makePlay("E");
		g3.makePlay("E");
		
		Game g4 = new Game();
		Labirinto lab4 = new Labirinto(m1, 5, 5);
		hero heroi4 = new hero(1,3);
		dragon dragao4 = new dragon(1,1);
		g4.addDragon(dragao4);
		g4.setMaze(lab4);
		g4.setHero(heroi4);
		
		lab4.printDragon(dragao4);
		lab4.printHero(heroi4);
		heroi4.equipHero();
		
		g4.makePlay("O");
		g4.makePlay("O");
		
		assertEquals(false, dragao.isAlive());
		assertEquals(false, dragao2.isAlive());
		assertEquals(false, dragao3.isAlive());
		assertEquals(false, dragao4.isAlive());
	}
	
	@Test
	public void testHerogetsToExitandWins_f(){
		Game g1 = new Game();
		Labirinto lab = new Labirinto(m1, 5, 5);
		hero heroi = new hero(1,3);
		sword espada = new sword(1,2);
		dragon dragao = new dragon(2,2);
		dragao.changeState();
		g1.addDragon(dragao);
		
		heroi.equipHero();
		heroi.moveHero(lab, "E", espada, g1.getDragons());
		
		Game g2 = new Game();
		Labirinto lab2 = new Labirinto(m2, 5, 5);
		hero heroi2 = new hero(1,3);
		sword espada2 = new sword(1,2);
		g1.addDragon(dragao);
		
		heroi2.equipHero();
		heroi2.moveHero(lab2, "N", espada2, g2.getDragons());
		
		Game g3 = new Game();
		Labirinto lab3 = new Labirinto(m3, 5, 5);
		hero heroi3 = new hero(1,3);
		sword espada3 = new sword(1,2);
		g1.addDragon(dragao);
		
		heroi3.equipHero();
		heroi3.moveHero(lab3, "S", espada3, g3.getDragons());
		heroi3.moveHero(lab3, "S", espada3, g3.getDragons());
		heroi3.moveHero(lab3, "S", espada3, g3.getDragons());
		
		
		Game g4 = new Game();
		Labirinto lab4 = new Labirinto(m4, 5, 5);
		hero heroi4 = new hero(1,3);
		sword espada4 = new sword(1,2);
		g1.addDragon(dragao);
		
		heroi4.equipHero();
		heroi4.moveHero(lab4, "O", espada4, g4.getDragons());
		heroi4.moveHero(lab4, "O", espada4, g4.getDragons());
		heroi4.moveHero(lab4, "O", espada4, g4.getDragons());
		
		assertEquals(true, g1.win(heroi, lab));
		assertEquals(true, g2.win(heroi2, lab2));
		assertEquals(true, g3.win(heroi3, lab3));
		assertEquals(true, g4.win(heroi4, lab4));
	}
	
	@Test
	public void testHerogetsToExitbutCantWin_g(){
		Game g1 = new Game();
		Labirinto lab = new Labirinto(m1, 5, 5);
		hero heroi = new hero(1,3);
		sword espada = new sword(1,2);
		dragon dragao = new dragon(3,3);
		g1.addDragon(dragao);
		g1.setMaze(lab);
		g1.setHero(heroi);
		g1.setSword(espada);
		
		lab.printDragon(dragao);
		lab.printSword(espada);
		lab.printHero(heroi);
		
		heroi.equipHero();
		
		heroi.moveHero(lab, "E", espada, g1.getDragons());
		
		Game g2 = new Game();
		Labirinto lab2 = new Labirinto(m2, 5, 5);
		hero heroi2 = new hero(1,3);
		sword espada2 = new sword(1,2);
		dragon dragao2 = new dragon(3,3);
		g2.addDragon(dragao2);
		g2.setMaze(lab2);
		g2.setHero(heroi2);
		g2.setSword(espada2);
		
		lab2.printDragon(dragao2);
		lab2.printSword(espada2);
		lab2.printHero(heroi2);
		
		heroi2.equipHero();
		
		heroi2.moveHero(lab2, "N", espada2, g2.getDragons());
		
		Game g3 = new Game();
		Labirinto lab3 = new Labirinto(m3, 5, 5);
		hero heroi3 = new hero(3,3);
		sword espada3 = new sword(1,2);
		dragon dragao3 = new dragon(1,1);
		g3.addDragon(dragao3);
		g3.setMaze(lab3);
		g3.setHero(heroi3);
		g3.setSword(espada3);
		
		lab3.printDragon(dragao3);
		lab3.printSword(espada3);
		lab3.printHero(heroi3);
		
		heroi3.equipHero();
		
		heroi3.moveHero(lab3, "S", espada3, g3.getDragons());
		
		Game g4 = new Game();
		Labirinto lab4 = new Labirinto(m4, 5, 5);
		hero heroi4 = new hero(1,1);
		sword espada4 = new sword(1,2);
		dragon dragao4 = new dragon(3,3);
		g4.addDragon(dragao4);
		g4.setMaze(lab4);
		g4.setHero(heroi4);
		g4.setSword(espada4);
		
		lab4.printDragon(dragao4);
		lab4.printSword(espada4);
		lab4.printHero(heroi4);
		
		heroi4.equipHero();
		
		heroi4.moveHero(lab4, "O", espada4, g4.getDragons());
		
		assertEquals(false, g1.win(heroi, lab));
		assertEquals(false, g2.win(heroi2, lab2));
		assertEquals(false, g3.win(heroi3, lab3));
		assertEquals(false, g4.win(heroi4, lab4));
	}
	
	@Test (timeout = 10000)
	public void testSomeRandomBehaviour(){
		boolean dragonsleeps = false, dragonwakesup = false, dragonmoves = false, dragoninsword = false;
		
		Game g1 = new Game();
		Labirinto lab = new Labirinto(m1, 5, 5);
		hero heroi = new hero(1,1);
		sword espada = new sword(2,3);
		dragon dragao = new dragon(3,3);
		g1.addDragon(dragao);
		g1.setMaze(lab);
		g1.setHero(heroi);
		g1.setSword(espada);
		
		lab.printDragon(dragao);
		lab.printSword(espada);
		lab.printHero(heroi);
		
		while(!dragonsleeps || !dragonwakesup || !dragonmoves || !dragoninsword){
			dragao.randomSleep();
			dragao.randomPosition(lab, espada);
			g1.updateBoard();
			
			if (dragao.getName() == 'd')
			{
				dragonsleeps = true;
				assertEquals(true, dragonsleeps);
			}
			
			else if(dragao.getName() == 'D')
			{
				dragonwakesup = true;
				assertEquals(true, dragonwakesup);
			}
			
			else if (dragao.getPos_x() != 3 || dragao.getPos_y() != 3)
			{
				dragonmoves = true;
				assertEquals(true, dragonmoves);
			}
			
			if (dragao.getName() == 'F')
			{
				dragoninsword = true;
				assertEquals(true, dragoninsword);
			}
		}
	}
	
	@Test
	public void testMaze(){
		Game g1 = new Game();
		Labirinto lab = new Labirinto();
		lab.setTable(m1);
		assertEquals(m1, lab.getTable());
	}
	
	@Test
	public void testMazeBuilder(){
		
		for (int i = 0; i< 30;i++) {
			Game g1 = new Game();
			MazeBuilder mb = new MazeBuilder(9);
			Labirinto lab = mb.buildMaze();
			g1.setMaze(lab);
			assertEquals(9, mb.getSize());
		}
	}
}
